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

import com.amf.registration.model.AMFUser;
import com.amf.registration.service.base.AMFUserServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the amf user remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.amf.registration.service.AMFUserService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFUserServiceBaseImpl
 */
@Component(
        property = {
                "json.web.service.context.name=amfregistration",
                "json.web.service.context.path=AMFUser"
        },
        service = AopService.class
)
public class AMFUserServiceImpl extends AMFUserServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use <code>com.amf.registration.service.AMFUserServiceUtil</code> to access the amf user remote service.
     */

    /**
     * @param themeDisplay
     * @param userName
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param gender
     * @param birthDate
     * @param password
     * @param confirmedPassword
     * @param homePhone
     * @param mobilePhone
     * @param address
     * @param address2
     * @param city
     * @param state
     * @param zip
     * @param securityQuestion
     * @param securityAnswer
     * @param acceptedTOU
     * @param serviceContext
     * @return
     * @throws PortalException
     */
    public AMFUser addAMFUser(
            ThemeDisplay themeDisplay,
            String userName,
            String firstName,
            String lastName,
            String emailAddress,
            String gender,
            Date birthDate,
            String password,
            String confirmedPassword,
            String homePhone,
            String mobilePhone,
            String address,
            String address2,
            String city,
            String state,
            String zip,
            String securityQuestion,
            String securityAnswer,
            String acceptedTOU,
            ServiceContext serviceContext) throws PortalException {

        return amfUserLocalService.addAMFUser(
                themeDisplay,
                userName,
                firstName,
                lastName,
                emailAddress,
                gender,
                birthDate,
                password,
                confirmedPassword,
                homePhone,
                mobilePhone,
                address,
                address2,
                city,
                state,
                zip,
                securityQuestion,
                securityAnswer,
                acceptedTOU,
                serviceContext);
    }

    public List<AMFUser> getAMFUsersByKeywords(
            final long groupId,
            final String keywords,
            final int start,
            final int end,
            final OrderByComparator<AMFUser> orderByComparator
    ) {
        return amfUserLocalService.getAMFUsersByKeywords(groupId, keywords, start, end, orderByComparator);
    }

    /**
     * @param groupId
     * @param keywords
     * @return
     */
    public long getAMFUsersCountByKeywords(long groupId, String keywords) {
        return amfUserLocalService.getAMFUsersCountByKeywords(
                groupId, keywords);
    }

    /**
     * @param amdUserId
     * @return
     * @throws PortalException
     */
    public AMFUser getAmfUser(long amdUserId) throws PortalException {
        return amfUserLocalService.getAMFUser(amdUserId);
    }

}