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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AMFUserService}.
 *
 * @author Brian Wing Shun Chan
 * @see AMFUserService
 * @generated
 */
public class AMFUserServiceWrapper
	implements AMFUserService, ServiceWrapper<AMFUserService> {

	public AMFUserServiceWrapper(AMFUserService amfUserService) {
		_amfUserService = amfUserService;
	}

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
	@Override
	public com.amf.registration.model.AMFUser addAMFUser(
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
			String userName, String firstName, String lastName,
			String emailAddress, String gender, java.util.Date birthDate,
			String password, String confirmedPassword, String homePhone,
			String mobilePhone, String address, String address2, String city,
			String state, String zip, String securityQuestion,
			String securityAnswer, String acceptedTOU,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfUserService.addAMFUser(
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
	@Override
	public com.amf.registration.model.AMFUser getAmfUser(long amdUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfUserService.getAmfUser(amdUserId);
	}

	@Override
	public java.util.List<com.amf.registration.model.AMFUser>
		getAMFUsersByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.amf.registration.model.AMFUser> orderByComparator) {

		return _amfUserService.getAMFUsersByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	/**
	 * @param groupId
	 * @param keywords
	 * @return
	 */
	@Override
	public long getAMFUsersCountByKeywords(long groupId, String keywords) {
		return _amfUserService.getAMFUsersCountByKeywords(groupId, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amfUserService.getOSGiServiceIdentifier();
	}

	@Override
	public AMFUserService getWrappedService() {
		return _amfUserService;
	}

	@Override
	public void setWrappedService(AMFUserService amfUserService) {
		_amfUserService = amfUserService;
	}

	private AMFUserService _amfUserService;

}