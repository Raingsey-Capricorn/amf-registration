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

package com.amf.registration.model.impl;

import com.amf.registration.model.AMFEventLog;
import com.amf.registration.model.AMFUser;
import com.amf.registration.service.AMFEventLogLocalServiceUtil;
import com.amf.registration.service.AMFUserLocalService;
import com.amf.registration.utilities.EventStatus;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Reference;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

/**
 * The extended model implementation for the AMFUser service. Represents a row in the &quot;amfuser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.amf.registration.model.AMFUser</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class AMFUserImpl extends AMFUserBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a amf user model instance should use the {@link com.amf.registration.model.AMFUser} interface instead.
     */
    public AMFUserImpl() {
    }

    /**
     * This method return a list of AMFEventLog which retrieve all the AMFEventLog which contain the AMFUserID
     *
     * @return
     */
    @Override
    public List<AMFEventLog> getAMFEventLogs() {
        return AMFEventLogLocalServiceUtil.getAMFUserAMFEventLogs(getAmfUserId());
    }

    /**
     * @return
     */
    @Override
    public AMFEventLog getAMFEventLog() {
        Optional<AMFEventLog> eventLog = AMFEventLogLocalServiceUtil.getAMFUserAMFEventLogs(getAmfUserId()).stream().findFirst();
        return eventLog.get();
    }

    @Override
    public java.lang.String getLastLoginDate() {
        Optional<AMFEventLog> eventLog = AMFEventLogLocalServiceUtil.getAMFUserAMFEventLogs(getAmfUserId()).stream().findFirst();
        return eventLog.get().getLastLoginDate() == null ? "No Data" : new SimpleDateFormat("YYYY-MM-DD HH:MM:SS").format(eventLog.get().getLastLoginDate());

    }

    /**
     * @return
     */
    @Override
    public String getEventStatus() {
        try {
            if (UserLocalServiceUtil.getUserById(getUserId()).getLastLoginDate() != null) {
                return EventStatus.LOGIN;
            }
        } catch (PortalException e) {
            return EventStatus.REGISTER;
        }
        return EventStatus.REGISTER;
    }

    /**
     * @return String value of screen-name and user-ID in one String formatted value
     * @throws com.liferay.portal.kernel.exception.PortalException
     */

    @Override
    public String getCombinedUserInfo() {
        try {
            User userInfo = UserLocalServiceUtil.getUser(getUserId());
            return String.format("%s (%s)", userInfo.getScreenName(), userInfo.getUserId());
        } catch (PortalException e) {
            return "No Data";
        }
    }

    /**
     * @return
     * @throws com.liferay.portal.kernel.exception.PortalException
     */
    @Override
    public String getLastLoginIP() {
        try {
            return UserLocalServiceUtil.getUser(getUserId()).getLastLoginIP().isEmpty() ? "No Data" : UserLocalServiceUtil.getUser(getUserId()).getLastLoginIP();
        } catch (PortalException e) {
            return null;
        }
    }

    /**
     * @param contactId
     * @return
     */
    @Override
    public String getEmailAddress(long contactId) {
        try {
            return ContactLocalServiceUtil.getContact(contactId).getEmailAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return "No-Data";
        }
    }

    /**
     * @param addressId
     * @return
     */
    @Override
    public String getAddress(long addressId) {
        try {
            Address address = AddressLocalServiceUtil.getAddress(addressId);
            return String.format("%s - %s -%s",
                    new StringBuilder().append(address.getStreet1()).append(address.getStreet2()).append(address.getStreet3()),
                    address.getCity(),
                    address.getRegion().getName()
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}