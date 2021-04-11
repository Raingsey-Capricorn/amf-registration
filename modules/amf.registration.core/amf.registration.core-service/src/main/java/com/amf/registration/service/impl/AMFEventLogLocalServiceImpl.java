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
import com.amf.registration.service.AMFEventLogLocalService;
import com.amf.registration.service.base.AMFEventLogLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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


}