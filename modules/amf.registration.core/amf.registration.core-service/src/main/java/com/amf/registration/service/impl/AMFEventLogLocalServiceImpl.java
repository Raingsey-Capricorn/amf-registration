/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.amf.registration.service.impl;

import com.amf.registration.exception.NoSuchAMFEventLogException;
import com.amf.registration.model.AMFEventLog;
import com.amf.registration.service.AMFEventLogLocalServiceUtil;
import com.amf.registration.service.AMFUserGroupServiceUtil;
import com.amf.registration.service.base.AMFEventLogLocalServiceBaseImpl;
import com.amf.registration.utilities.EventStatus;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.NoSuchUserGroupException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;
import lombok.SneakyThrows;
import org.osgi.service.component.annotations.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The implementation of the amf event log local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.amf.registration.service.AMFEventLogLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventLogLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=com.amf.registration.model.AMFEventLog",
        service = AopService.class
)
public class AMFEventLogLocalServiceImpl
        extends AMFEventLogLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Use <code>com.amf.registration.service.AMFEventLogLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.amf.registration.service.AMFEventLogLocalServiceUtil</code>.
     */

    /**
     * @param groupId
     * @param start
     * @param end
     * @return
     */
    @Override
    public HashMap<String, Object> getAMFEventLogs(long groupId, int start, int end) throws NoSuchAMFEventLogException {
        return new HashMap() {{
            try {
                put("eventLogs", amfEventLogLocalService.dynamicQuery(getAMFMembersUserNameSearchDynamicQuery(start, end)));
                put("total", amfEventLogLocalService.dynamicQueryCount(getAMFMembersUserNameSearchDynamicQuery(0, 0)));
            } catch (NoSuchUserGroupException e) {
                throw new NoSuchAMFEventLogException(e.getMessage());
            }
        }};
    }

    /**
     * @param groupId
     * @param userId
     * @param status
     * @param start
     * @param end
     * @return
     */
    @Override
    public HashMap<String, Object> getAMFEventLogBy(long groupId, long userId, String status, int start, int end) {

        return new HashMap() {{
            put("eventLogs", amfEventLogLocalService.dynamicQuery(getUserBaseOnGroupUserIdAndStatusSearchDynamicQuery(groupId, userId, status, start, end)));
            put("total", amfEventLogLocalService.dynamicQueryCount(getUserBaseOnGroupUserIdAndStatusSearchDynamicQuery(groupId, userId, status, 0, 0)));
        }};
    }

    /**
     * @param groupId
     * @param status
     * @param start
     * @param end
     * @return
     */
    @Override
    public HashMap<String, Object> getAMFEventLogBy(long groupId, String status, int start, int end) throws NoSuchAMFEventLogException {

        List<Long> allUserIds = amfEventLogLocalService.dynamicQuery(getDistinctEventLogByStatusSearchDynamicQuery(groupId, status, start, end));
        List<AMFEventLog> amfEventLogs = allUserIds.stream().map(ids -> getLatestAMFEventLogByUserId(ids, status)).collect(Collectors.toList());
        return new HashMap() {{
            put("eventLogs", amfEventLogs);
            put("total", amfEventLogLocalService.dynamicQueryCount(getDistinctEventLogByStatusSearchDynamicQuery(groupId, status, 0, 0)));
        }};
    }


    /**
     * @param groupId
     * @param userId
     * @return
     */
    @Override
    public AMFEventLog getAmfEventLogByGroupAndUser(long groupId, long userId) throws NoSuchAMFEventLogException {

        return (AMFEventLog) amfEventLogLocalService.dynamicQuery(
                getUserNameSearchDynamicQuery(groupId, userId)).stream().findFirst().orElseThrow(NoSuchAMFEventLogException::new);
    }

    /**
     * @param loggedInUser
     * @return
     */
    @Override
    public AMFEventLog addAMFEventLog(User loggedInUser) {

        long amfEvenLogId = counterLocalService.increment(AMFEventLog.class.getName());
        AMFEventLog amfEventLog = AMFEventLogLocalServiceUtil.createAMFEventLog(amfEvenLogId);
        amfEventLog.setUserId(loggedInUser.getUserId());
        amfEventLog.setGroupId(loggedInUser.getGroupId());
        amfEventLog.setUserGroupId(Arrays.stream(loggedInUser.getUserGroupIds()).findFirst().orElse(0));
        amfEventLog.setStatus(EventStatus.LOGIN);
        amfEventLog.setCreateDate(new Date());
        amfEventLog.setLastLoginDate(loggedInUser.getLastLoginDate());
        amfEventLog.setLastLoginIP(loggedInUser.getLastLoginIP());
        amfEventLog.setNew(false);
        return AMFEventLogLocalServiceUtil.addAMFEventLog(amfEventLog);
    }

    /**
     * @param groupId
     * @param userId
     * @return
     */
    private DynamicQuery getUserNameSearchDynamicQuery(
            final long groupId,
            final long userId) {

        DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
        if (Validator.isNotNull(userId)) {
            Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
            disjunctionQuery.add(RestrictionsFactoryUtil.eq("userId", userId));
            dynamicQuery.add(disjunctionQuery);
        }
        return dynamicQuery;
    }


    /**
     * @param groupId
     * @param userId
     * @param eventStatus
     * @param start
     * @param end
     * @return
     */
    private DynamicQuery getUserBaseOnGroupUserIdAndStatusSearchDynamicQuery(
            final long groupId,
            final long userId,
            final String eventStatus,
            final int start,
            final int end
    ) {

        DynamicQuery dynamicQuery = dynamicQuery();
        Conjunction conjunctionQuery = RestrictionsFactoryUtil.conjunction();
        if (eventStatus.equals(EventStatus.ALL)) {
            conjunctionQuery.add(RestrictionsFactoryUtil.eq("userId", userId));
        } else if (Validator.isNotNull(eventStatus) && userId > 0) {
            dynamicQuery.add(RestrictionsFactoryUtil.eq("groupId", groupId));
            conjunctionQuery.add(RestrictionsFactoryUtil.eq("userId", userId));
            conjunctionQuery.add(RestrictionsFactoryUtil.eq("status", eventStatus));
        }
        dynamicQuery.add(conjunctionQuery);
        if (start >= 0 && end > 0) {
            dynamicQuery.setLimit(start, end);
        }
        return dynamicQuery;
    }

    /**
     * @param groupId
     * @param eventStatus
     * @param start
     * @param end
     * @return
     */
    private DynamicQuery getDistinctEventLogByStatusSearchDynamicQuery(
            final long groupId,
            final String eventStatus,
            final int start,
            final int end
    ) {

        DynamicQuery dynamicQuery = dynamicQuery();
        if (eventStatus.equals(EventStatus.ALL)) {
            dynamicQuery.setProjection(ProjectionFactoryUtil.groupProperty("userId"));
        } else if (Validator.isNotNull(eventStatus)) {
            dynamicQuery.setProjection(ProjectionFactoryUtil.groupProperty("userId"))
                    .add(RestrictionsFactoryUtil.conjunction()
                            .add(RestrictionsFactoryUtil.eq("status", eventStatus))
                    );
        }
        if (start >= 0 && end > 0) {
            dynamicQuery.setLimit(start, end);
        }
        return dynamicQuery;
    }

    /**
     * @param userId
     * @return
     */
    @SneakyThrows
    private AMFEventLog getLatestAMFEventLogByUserId(long userId, String eventStatus) {

        DynamicQuery query = dynamicQuery();
        query.add(
                RestrictionsFactoryUtil.conjunction()
                        .add(RestrictionsFactoryUtil.eq("userId", userId)))
                .add(RestrictionsFactoryUtil.eq("status", eventStatus))

                .addOrder(OrderFactoryUtil.desc("lastLoginDate")).setLimit(0, 1);
        return (AMFEventLog) amfEventLogLocalService.dynamicQuery(query).stream().findFirst().orElseThrow(NoSuchAMFEventLogException::new);
    }

    /**
     * @param start
     * @param end
     * @return
     */
    private DynamicQuery getAMFMembersUserNameSearchDynamicQuery(
            final int start,
            final int end) throws NoSuchUserGroupException {

        DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("userGroupId", AMFUserGroupServiceUtil.getAMFUserGroupId()));
        if (start >= 0 && end > 0) {
            dynamicQuery.setLimit(start, end);
        }
        return dynamicQuery;
    }

}