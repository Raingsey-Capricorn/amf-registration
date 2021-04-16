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

import com.amf.registration.model.AMFEventLog;
import com.amf.registration.service.AMFEventLogLocalServiceUtil;
import com.amf.registration.service.base.AMFEventLogLocalServiceBaseImpl;
import com.amf.registration.utilities.EventStatus;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
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
     * @param userId
     * @return
     */
    public AMFEventLog getAmfEventLogByGroupAndUser(long groupId, long userId) {
        return (AMFEventLog) amfEventLogLocalService.dynamicQuery(
                getUserNameSearchDynamicQuery(groupId, userId)).stream().findFirst().get();
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
     * @param userId
     * @param status
     * @return
     */
    @Override
    public List<AMFEventLog> getAMFEventLogBy(long groupId, long userId, String status, int start, int end) {
        return amfEventLogLocalService.dynamicQuery(getUserBaseOnGroupUserIdAndStatusSearchDynamicQuery(groupId, userId, status, start, end));
    }

    /**
     * @param groupId
     * @param status
     * @param start
     * @param end
     * @return
     */
    @Override
    public List<AMFEventLog> getAMFEventLogBy(long groupId, String status, int start, int end) {
        List<Long> allUserIds = amfEventLogLocalService.dynamicQuery(getDistinctEventLogByStatusSearchDynamicQuery(groupId, status, start, end));
        return allUserIds.stream().map(this::getLatestAMFEventLogByUserId).collect(Collectors.toList());
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

        DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
        if (Validator.isNotNull(eventStatus) && userId > 0) {
            Conjunction conjunctionQuery = RestrictionsFactoryUtil.conjunction();
            conjunctionQuery.add(RestrictionsFactoryUtil.eq("userId", userId));
            conjunctionQuery.add(RestrictionsFactoryUtil.eq("status", eventStatus));
            dynamicQuery.add(conjunctionQuery);
        }
        dynamicQuery.setLimit(start, end);
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
            int start,
            int end
    ) {

        DynamicQuery dynamicQuery = dynamicQuery();
        if (eventStatus.equals(EventStatus.ALL)) {
            dynamicQuery.setProjection(ProjectionFactoryUtil.groupProperty("userId"));
        } else if (Validator.isNotNull(eventStatus)) {
            Conjunction conjunctionQuery = RestrictionsFactoryUtil.conjunction();
            conjunctionQuery.add(RestrictionsFactoryUtil.eq("status", eventStatus));
            dynamicQuery.add(conjunctionQuery);
            dynamicQuery.setProjection(ProjectionFactoryUtil.groupProperty("userId"));
        }
        dynamicQuery.setLimit(start, end);
        return dynamicQuery;
    }

    /**
     * @return
     */
    private AMFEventLog getLatestAMFEventLogByUserId(long userId) {

        DynamicQuery query = dynamicQuery();
        query.add(
                RestrictionsFactoryUtil.conjunction()
                        .add(RestrictionsFactoryUtil.eq("userId", userId)))
                .addOrder(OrderFactoryUtil.desc("lastLoginDate")).setLimit(0, 1);
        return (AMFEventLog) amfEventLogLocalService.dynamicQuery(query).stream().findFirst().get();
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
        amfEventLog.setStatus(EventStatus.LOGIN);
        amfEventLog.setCreateDate(new Date());
        amfEventLog.setLastLoginDate(loggedInUser.getLastLoginDate());
        amfEventLog.setLastLoginIP(loggedInUser.getLastLoginIP());
        amfEventLog.setNew(false);
        return AMFEventLogLocalServiceUtil.addAMFEventLog(amfEventLog);
    }

}