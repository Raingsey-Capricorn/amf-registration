/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.amf.registration.service;

import com.amf.registration.model.AMFUser;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for AMFUser. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AMFUserServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AMFUserService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.amf.registration.service.impl.AMFUserServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the amf user remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AMFUserServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * @param groupId
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
	 * @param zip
	 * @param securityQuestion
	 * @param securityAnswer
	 * @param acceptedTOU
	 * @return
	 */
	public AMFUser addAMFUser(
			ThemeDisplay themeDisplay, String userName, String firstName,
			String lastName, String emailAddress, String gender, Date birthDate,
			String password, String confirmedPassword, String homePhone,
			String mobilePhone, String address, String address2, String city,
			String state, String zip, String securityQuestion,
			String securityAnswer, String acceptedTOU,
			ServiceContext serviceContext)
		throws PortalException;

	/**
	 * @param amdUserId
	 * @return
	 * @throws PortalException
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AMFUser getAmfUser(long amdUserId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AMFUser> getAMFUsersByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<AMFUser> orderByComparator);

	/**
	 * @param groupId
	 * @param keywords
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getAMFUsersCountByKeywords(long groupId, String keywords);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

}