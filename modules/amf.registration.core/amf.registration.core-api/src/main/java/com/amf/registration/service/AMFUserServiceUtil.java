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

package com.amf.registration.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for AMFUser. This utility wraps
 * <code>com.amf.registration.service.impl.AMFUserServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @generated
 * @see AMFUserService
 */
public class AMFUserServiceUtil {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to <code>com.amf.registration.service.impl.AMFUserServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
     * @throws com.liferay.portal.kernel.exception.PortalException
     */
    public static com.amf.registration.model.AMFUser addAMFUser(
            com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
            String userName, String firstName, String lastName,
            String emailAddress, String gender, java.util.Date birthDate,
            String password, String confirmedPassword, String homePhone,
            String mobilePhone, String address, String address2, String city,
            String state, String zip, String securityQuestion,
            String securityAnswer, String acceptedTOU,
            com.liferay.portal.kernel.service.ServiceContext serviceContext)
            throws com.liferay.portal.kernel.exception.PortalException {

        return getService().addAMFUser(
                themeDisplay, userName, firstName, lastName, emailAddress, gender,
                birthDate, password, confirmedPassword, homePhone, mobilePhone,
                address, address2, city, state, zip, securityQuestion,
                securityAnswer, acceptedTOU, serviceContext);
    }

    /**
     * @param amdUserId
     * @return
     * @throws com.liferay.portal.kernel.exception.PortalException
     */
    public static com.amf.registration.model.AMFUser getAmfUser(long amdUserId)
            throws com.liferay.portal.kernel.exception.PortalException {

        return getService().getAmfUser(amdUserId);
    }

    public static java.util.List<com.amf.registration.model.AMFUser>
    getAMFUsersByKeywords(
            long groupId, String keywords, int start, int end,
            com.liferay.portal.kernel.util.OrderByComparator
                    <com.amf.registration.model.AMFUser> orderByComparator) {

        return getService().getAMFUsersByKeywords(
                groupId, keywords, start, end, orderByComparator);
    }

    /**
     * @param groupId
     * @param keywords
     * @return
     */
    public static long getAMFUsersCountByKeywords(
            long groupId, String keywords) {

        return getService().getAMFUsersCountByKeywords(groupId, keywords);
    }

    /**
     * Returns the OSGi service identifier.
     *
     * @return the OSGi service identifier
     */
    public static String getOSGiServiceIdentifier() {
        return getService().getOSGiServiceIdentifier();
    }

    public static AMFUserService getService() {
        return _serviceTracker.getService();
    }

    private static ServiceTracker<AMFUserService, AMFUserService>
            _serviceTracker;

    static {
        Bundle bundle = FrameworkUtil.getBundle(AMFUserService.class);

        ServiceTracker<AMFUserService, AMFUserService> serviceTracker =
                new ServiceTracker<AMFUserService, AMFUserService>(
                        bundle.getBundleContext(), AMFUserService.class, null);

        serviceTracker.open();

        _serviceTracker = serviceTracker;
    }

}