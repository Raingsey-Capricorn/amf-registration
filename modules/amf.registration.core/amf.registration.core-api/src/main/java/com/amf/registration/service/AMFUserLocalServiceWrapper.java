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
 * Provides a wrapper for {@link AMFUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AMFUserLocalService
 * @generated
 */
public class AMFUserLocalServiceWrapper
	implements AMFUserLocalService, ServiceWrapper<AMFUserLocalService> {

	public AMFUserLocalServiceWrapper(AMFUserLocalService amfUserLocalService) {
		_amfUserLocalService = amfUserLocalService;
	}

	@Override
	public void addAMFEventLogAMFUser(
		long amfEventLogId, com.amf.registration.model.AMFUser amfUser) {

		_amfUserLocalService.addAMFEventLogAMFUser(amfEventLogId, amfUser);
	}

	@Override
	public void addAMFEventLogAMFUser(long amfEventLogId, long amfUserId) {
		_amfUserLocalService.addAMFEventLogAMFUser(amfEventLogId, amfUserId);
	}

	@Override
	public void addAMFEventLogAMFUsers(
		long amfEventLogId,
		java.util.List<com.amf.registration.model.AMFUser> amfUsers) {

		_amfUserLocalService.addAMFEventLogAMFUsers(amfEventLogId, amfUsers);
	}

	@Override
	public void addAMFEventLogAMFUsers(long amfEventLogId, long[] amfUserIds) {
		_amfUserLocalService.addAMFEventLogAMFUsers(amfEventLogId, amfUserIds);
	}

	/**
	 * Adds the amf user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfUser the amf user
	 * @return the amf user that was added
	 */
	@Override
	public com.amf.registration.model.AMFUser addAMFUser(
		com.amf.registration.model.AMFUser amfUser) {

		return _amfUserLocalService.addAMFUser(amfUser);
	}

	/**
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
	 * @param addressLineOne
	 * @param addressLineTwo
	 * @param city
	 * @param regionId
	 * @param zip
	 * @param securityQuestion
	 * @param securityAnswer
	 * @param acceptedTOU
	 * @return
	 * @throws PortalException
	 */
	@Override
	public com.amf.registration.model.AMFUser addAMFUser(
			com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
			String userName, String firstName, String lastName,
			String emailAddress, String gender, java.util.Date birthDate,
			String password, String confirmedPassword, String homePhone,
			String mobilePhone, String addressLineOne, String addressLineTwo,
			String city, String regionId, String zip, String securityQuestion,
			String securityAnswer, String acceptedTOU,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfUserLocalService.addAMFUser(
			themeDisplay, userName, firstName, lastName, emailAddress, gender,
			birthDate, password, confirmedPassword, homePhone, mobilePhone,
			addressLineOne, addressLineTwo, city, regionId, zip,
			securityQuestion, securityAnswer, acceptedTOU, serviceContext);
	}

	@Override
	public void clearAMFEventLogAMFUsers(long amfEventLogId) {
		_amfUserLocalService.clearAMFEventLogAMFUsers(amfEventLogId);
	}

	/**
	 * Creates a new amf user with the primary key. Does not add the amf user to the database.
	 *
	 * @param amfUserId the primary key for the new amf user
	 * @return the new amf user
	 */
	@Override
	public com.amf.registration.model.AMFUser createAMFUser(long amfUserId) {
		return _amfUserLocalService.createAMFUser(amfUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfUserLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteAMFEventLogAMFUser(
		long amfEventLogId, com.amf.registration.model.AMFUser amfUser) {

		_amfUserLocalService.deleteAMFEventLogAMFUser(amfEventLogId, amfUser);
	}

	@Override
	public void deleteAMFEventLogAMFUser(long amfEventLogId, long amfUserId) {
		_amfUserLocalService.deleteAMFEventLogAMFUser(amfEventLogId, amfUserId);
	}

	@Override
	public void deleteAMFEventLogAMFUsers(
		long amfEventLogId,
		java.util.List<com.amf.registration.model.AMFUser> amfUsers) {

		_amfUserLocalService.deleteAMFEventLogAMFUsers(amfEventLogId, amfUsers);
	}

	@Override
	public void deleteAMFEventLogAMFUsers(
		long amfEventLogId, long[] amfUserIds) {

		_amfUserLocalService.deleteAMFEventLogAMFUsers(
			amfEventLogId, amfUserIds);
	}

	/**
	 * Deletes the amf user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfUser the amf user
	 * @return the amf user that was removed
	 */
	@Override
	public com.amf.registration.model.AMFUser deleteAMFUser(
		com.amf.registration.model.AMFUser amfUser) {

		return _amfUserLocalService.deleteAMFUser(amfUser);
	}

	/**
	 * Deletes the amf user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfUserId the primary key of the amf user
	 * @return the amf user that was removed
	 * @throws PortalException if a amf user with the primary key could not be found
	 */
	@Override
	public com.amf.registration.model.AMFUser deleteAMFUser(long amfUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfUserLocalService.deleteAMFUser(amfUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfUserLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _amfUserLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _amfUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.registration.model.impl.AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _amfUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.registration.model.impl.AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _amfUserLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _amfUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _amfUserLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.amf.registration.model.AMFUser fetchAMFUser(long amfUserId) {
		return _amfUserLocalService.fetchAMFUser(amfUserId);
	}

	/**
	 * Returns the amf user matching the UUID and group.
	 *
	 * @param uuid the amf user's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	@Override
	public com.amf.registration.model.AMFUser fetchAMFUserByUuidAndGroupId(
		String uuid, long groupId) {

		return _amfUserLocalService.fetchAMFUserByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _amfUserLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.amf.registration.model.AMFUser>
		getAMFEventLogAMFUsers(long amfEventLogId) {

		return _amfUserLocalService.getAMFEventLogAMFUsers(amfEventLogId);
	}

	@Override
	public java.util.List<com.amf.registration.model.AMFUser>
		getAMFEventLogAMFUsers(long amfEventLogId, int start, int end) {

		return _amfUserLocalService.getAMFEventLogAMFUsers(
			amfEventLogId, start, end);
	}

	@Override
	public java.util.List<com.amf.registration.model.AMFUser>
		getAMFEventLogAMFUsers(
			long amfEventLogId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.amf.registration.model.AMFUser> orderByComparator) {

		return _amfUserLocalService.getAMFEventLogAMFUsers(
			amfEventLogId, start, end, orderByComparator);
	}

	@Override
	public int getAMFEventLogAMFUsersCount(long amfEventLogId) {
		return _amfUserLocalService.getAMFEventLogAMFUsersCount(amfEventLogId);
	}

	/**
	 * Returns the amfEventLogIds of the amf event logs associated with the amf user.
	 *
	 * @param amfUserId the amfUserId of the amf user
	 * @return long[] the amfEventLogIds of amf event logs associated with the amf user
	 */
	@Override
	public long[] getAMFEventLogPrimaryKeys(long amfUserId) {
		return _amfUserLocalService.getAMFEventLogPrimaryKeys(amfUserId);
	}

	/**
	 * Returns the amf user with the primary key.
	 *
	 * @param amfUserId the primary key of the amf user
	 * @return the amf user
	 * @throws PortalException if a amf user with the primary key could not be found
	 */
	@Override
	public com.amf.registration.model.AMFUser getAMFUser(long amfUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfUserLocalService.getAMFUser(amfUserId);
	}

	/**
	 * @param groupId
	 * @param userName
	 * @return
	 */
	@Override
	public long getAMFUserByUserName(long groupId, String userName) {
		return _amfUserLocalService.getAMFUserByUserName(groupId, userName);
	}

	/**
	 * Returns the amf user matching the UUID and group.
	 *
	 * @param uuid the amf user's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amf user
	 * @throws PortalException if a matching amf user could not be found
	 */
	@Override
	public com.amf.registration.model.AMFUser getAMFUserByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfUserLocalService.getAMFUserByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the amf users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.registration.model.impl.AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @return the range of amf users
	 */
	@Override
	public java.util.List<com.amf.registration.model.AMFUser> getAMFUsers(
		int start, int end) {

		return _amfUserLocalService.getAMFUsers(start, end);
	}

	/**
	 * @param groupId
	 * @param keywords
	 * @param start
	 * @param end
	 * @param orderByComparator
	 * @return
	 */
	@Override
	public java.util.List<com.amf.registration.model.AMFUser>
		getAMFUsersByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.amf.registration.model.AMFUser> orderByComparator) {

		return _amfUserLocalService.getAMFUsersByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	/**
	 * Returns all the amf users matching the UUID and company.
	 *
	 * @param uuid the UUID of the amf users
	 * @param companyId the primary key of the company
	 * @return the matching amf users, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.amf.registration.model.AMFUser>
		getAMFUsersByUuidAndCompanyId(String uuid, long companyId) {

		return _amfUserLocalService.getAMFUsersByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of amf users matching the UUID and company.
	 *
	 * @param uuid the UUID of the amf users
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching amf users, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.amf.registration.model.AMFUser>
		getAMFUsersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.amf.registration.model.AMFUser> orderByComparator) {

		return _amfUserLocalService.getAMFUsersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of amf users.
	 *
	 * @return the number of amf users
	 */
	@Override
	public int getAMFUsersCount() {
		return _amfUserLocalService.getAMFUsersCount();
	}

	/**
	 * @param groupId
	 * @param userName
	 * @return
	 */
	@Override
	public long getAMFUsersCountByKeywords(long groupId, String userName) {
		return _amfUserLocalService.getAMFUsersCountByKeywords(
			groupId, userName);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _amfUserLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _amfUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amfUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfUserLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasAMFEventLogAMFUser(long amfEventLogId, long amfUserId) {
		return _amfUserLocalService.hasAMFEventLogAMFUser(
			amfEventLogId, amfUserId);
	}

	@Override
	public boolean hasAMFEventLogAMFUsers(long amfEventLogId) {
		return _amfUserLocalService.hasAMFEventLogAMFUsers(amfEventLogId);
	}

	@Override
	public boolean isUserNameUnique() {
		return _amfUserLocalService.isUserNameUnique();
	}

	@Override
	public void setAMFEventLogAMFUsers(long amfEventLogId, long[] amfUserIds) {
		_amfUserLocalService.setAMFEventLogAMFUsers(amfEventLogId, amfUserIds);
	}

	/**
	 * Updates the amf user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfUser the amf user
	 * @return the amf user that was updated
	 */
	@Override
	public com.amf.registration.model.AMFUser updateAMFUser(
		com.amf.registration.model.AMFUser amfUser) {

		return _amfUserLocalService.updateAMFUser(amfUser);
	}

	@Override
	public AMFUserLocalService getWrappedService() {
		return _amfUserLocalService;
	}

	@Override
	public void setWrappedService(AMFUserLocalService amfUserLocalService) {
		_amfUserLocalService = amfUserLocalService;
	}

	private AMFUserLocalService _amfUserLocalService;

}