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
 * Provides a wrapper for {@link AMFEventLogLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventLogLocalService
 * @generated
 */
public class AMFEventLogLocalServiceWrapper
	implements AMFEventLogLocalService,
			   ServiceWrapper<AMFEventLogLocalService> {

	public AMFEventLogLocalServiceWrapper(
		AMFEventLogLocalService amfEventLogLocalService) {

		_amfEventLogLocalService = amfEventLogLocalService;
	}

	/**
	 * Adds the amf event log to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFEventLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfEventLog the amf event log
	 * @return the amf event log that was added
	 */
	@Override
	public com.amf.registration.model.AMFEventLog addAMFEventLog(
		com.amf.registration.model.AMFEventLog amfEventLog) {

		return _amfEventLogLocalService.addAMFEventLog(amfEventLog);
	}

	/**
	 * @param loggedInUser
	 * @return
	 */
	@Override
	public com.amf.registration.model.AMFEventLog addAMFEventLog(
		com.liferay.portal.kernel.model.User loggedInUser) {

		return _amfEventLogLocalService.addAMFEventLog(loggedInUser);
	}

	@Override
	public void addAMFUserAMFEventLog(
		long amfUserId, com.amf.registration.model.AMFEventLog amfEventLog) {

		_amfEventLogLocalService.addAMFUserAMFEventLog(amfUserId, amfEventLog);
	}

	@Override
	public void addAMFUserAMFEventLog(long amfUserId, long amfEventLogId) {
		_amfEventLogLocalService.addAMFUserAMFEventLog(
			amfUserId, amfEventLogId);
	}

	@Override
	public void addAMFUserAMFEventLogs(
		long amfUserId,
		java.util.List<com.amf.registration.model.AMFEventLog> amfEventLogs) {

		_amfEventLogLocalService.addAMFUserAMFEventLogs(
			amfUserId, amfEventLogs);
	}

	@Override
	public void addAMFUserAMFEventLogs(long amfUserId, long[] amfEventLogIds) {
		_amfEventLogLocalService.addAMFUserAMFEventLogs(
			amfUserId, amfEventLogIds);
	}

	@Override
	public void clearAMFUserAMFEventLogs(long amfUserId) {
		_amfEventLogLocalService.clearAMFUserAMFEventLogs(amfUserId);
	}

	/**
	 * Creates a new amf event log with the primary key. Does not add the amf event log to the database.
	 *
	 * @param amfEventLogId the primary key for the new amf event log
	 * @return the new amf event log
	 */
	@Override
	public com.amf.registration.model.AMFEventLog createAMFEventLog(
		long amfEventLogId) {

		return _amfEventLogLocalService.createAMFEventLog(amfEventLogId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfEventLogLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the amf event log from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFEventLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfEventLog the amf event log
	 * @return the amf event log that was removed
	 */
	@Override
	public com.amf.registration.model.AMFEventLog deleteAMFEventLog(
		com.amf.registration.model.AMFEventLog amfEventLog) {

		return _amfEventLogLocalService.deleteAMFEventLog(amfEventLog);
	}

	/**
	 * Deletes the amf event log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFEventLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfEventLogId the primary key of the amf event log
	 * @return the amf event log that was removed
	 * @throws PortalException if a amf event log with the primary key could not be found
	 */
	@Override
	public com.amf.registration.model.AMFEventLog deleteAMFEventLog(
			long amfEventLogId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfEventLogLocalService.deleteAMFEventLog(amfEventLogId);
	}

	@Override
	public void deleteAMFUserAMFEventLog(
		long amfUserId, com.amf.registration.model.AMFEventLog amfEventLog) {

		_amfEventLogLocalService.deleteAMFUserAMFEventLog(
			amfUserId, amfEventLog);
	}

	@Override
	public void deleteAMFUserAMFEventLog(long amfUserId, long amfEventLogId) {
		_amfEventLogLocalService.deleteAMFUserAMFEventLog(
			amfUserId, amfEventLogId);
	}

	@Override
	public void deleteAMFUserAMFEventLogs(
		long amfUserId,
		java.util.List<com.amf.registration.model.AMFEventLog> amfEventLogs) {

		_amfEventLogLocalService.deleteAMFUserAMFEventLogs(
			amfUserId, amfEventLogs);
	}

	@Override
	public void deleteAMFUserAMFEventLogs(
		long amfUserId, long[] amfEventLogIds) {

		_amfEventLogLocalService.deleteAMFUserAMFEventLogs(
			amfUserId, amfEventLogIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfEventLogLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _amfEventLogLocalService.dynamicQuery();
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

		return _amfEventLogLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.registration.model.impl.AMFEventLogModelImpl</code>.
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

		return _amfEventLogLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.registration.model.impl.AMFEventLogModelImpl</code>.
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

		return _amfEventLogLocalService.dynamicQuery(
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

		return _amfEventLogLocalService.dynamicQueryCount(dynamicQuery);
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

		return _amfEventLogLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.amf.registration.model.AMFEventLog fetchAMFEventLog(
		long amfEventLogId) {

		return _amfEventLogLocalService.fetchAMFEventLog(amfEventLogId);
	}

	/**
	 * Returns the amf event log matching the UUID and group.
	 *
	 * @param uuid the amf event log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	@Override
	public com.amf.registration.model.AMFEventLog
		fetchAMFEventLogByUuidAndGroupId(String uuid, long groupId) {

		return _amfEventLogLocalService.fetchAMFEventLogByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _amfEventLogLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the amf event log with the primary key.
	 *
	 * @param amfEventLogId the primary key of the amf event log
	 * @return the amf event log
	 * @throws PortalException if a amf event log with the primary key could not be found
	 */
	@Override
	public com.amf.registration.model.AMFEventLog getAMFEventLog(
			long amfEventLogId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfEventLogLocalService.getAMFEventLog(amfEventLogId);
	}

	/**
	 * @param userId
	 * @param status
	 * @return
	 */
	@Override
	public java.util.List<com.amf.registration.model.AMFEventLog>
		getAMFEventLogBy(
			long groupId, long userId, String status, int start, int end) {

		return _amfEventLogLocalService.getAMFEventLogBy(
			groupId, userId, status, start, end);
	}

	/**
	 * @param groupId
	 * @param status
	 * @param start
	 * @param end
	 * @return
	 */
	@Override
	public java.util.List<com.amf.registration.model.AMFEventLog>
		getAMFEventLogBy(long groupId, String status, int start, int end) {

		return _amfEventLogLocalService.getAMFEventLogBy(
			groupId, status, start, end);
	}

	/**
	 * @param groupId
	 * @param userId
	 * @return
	 */
	@Override
	public com.amf.registration.model.AMFEventLog getAmfEventLogByGroupAndUser(
		long groupId, long userId) {

		return _amfEventLogLocalService.getAmfEventLogByGroupAndUser(
			groupId, userId);
	}

	/**
	 * Returns the amf event log matching the UUID and group.
	 *
	 * @param uuid the amf event log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amf event log
	 * @throws PortalException if a matching amf event log could not be found
	 */
	@Override
	public com.amf.registration.model.AMFEventLog
			getAMFEventLogByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfEventLogLocalService.getAMFEventLogByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the amf event logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.registration.model.impl.AMFEventLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf event logs
	 * @param end the upper bound of the range of amf event logs (not inclusive)
	 * @return the range of amf event logs
	 */
	@Override
	public java.util.List<com.amf.registration.model.AMFEventLog>
		getAMFEventLogs(int start, int end) {

		return _amfEventLogLocalService.getAMFEventLogs(start, end);
	}

	/**
	 * Returns all the amf event logs matching the UUID and company.
	 *
	 * @param uuid the UUID of the amf event logs
	 * @param companyId the primary key of the company
	 * @return the matching amf event logs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.amf.registration.model.AMFEventLog>
		getAMFEventLogsByUuidAndCompanyId(String uuid, long companyId) {

		return _amfEventLogLocalService.getAMFEventLogsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of amf event logs matching the UUID and company.
	 *
	 * @param uuid the UUID of the amf event logs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of amf event logs
	 * @param end the upper bound of the range of amf event logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching amf event logs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.amf.registration.model.AMFEventLog>
		getAMFEventLogsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.amf.registration.model.AMFEventLog> orderByComparator) {

		return _amfEventLogLocalService.getAMFEventLogsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of amf event logs.
	 *
	 * @return the number of amf event logs
	 */
	@Override
	public int getAMFEventLogsCount() {
		return _amfEventLogLocalService.getAMFEventLogsCount();
	}

	@Override
	public java.util.List<com.amf.registration.model.AMFEventLog>
		getAMFUserAMFEventLogs(long amfUserId) {

		return _amfEventLogLocalService.getAMFUserAMFEventLogs(amfUserId);
	}

	@Override
	public java.util.List<com.amf.registration.model.AMFEventLog>
		getAMFUserAMFEventLogs(long amfUserId, int start, int end) {

		return _amfEventLogLocalService.getAMFUserAMFEventLogs(
			amfUserId, start, end);
	}

	@Override
	public java.util.List<com.amf.registration.model.AMFEventLog>
		getAMFUserAMFEventLogs(
			long amfUserId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.amf.registration.model.AMFEventLog> orderByComparator) {

		return _amfEventLogLocalService.getAMFUserAMFEventLogs(
			amfUserId, start, end, orderByComparator);
	}

	@Override
	public int getAMFUserAMFEventLogsCount(long amfUserId) {
		return _amfEventLogLocalService.getAMFUserAMFEventLogsCount(amfUserId);
	}

	/**
	 * Returns the amfUserIds of the amf users associated with the amf event log.
	 *
	 * @param amfEventLogId the amfEventLogId of the amf event log
	 * @return long[] the amfUserIds of amf users associated with the amf event log
	 */
	@Override
	public long[] getAMFUserPrimaryKeys(long amfEventLogId) {
		return _amfEventLogLocalService.getAMFUserPrimaryKeys(amfEventLogId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _amfEventLogLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _amfEventLogLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amfEventLogLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfEventLogLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasAMFUserAMFEventLog(long amfUserId, long amfEventLogId) {
		return _amfEventLogLocalService.hasAMFUserAMFEventLog(
			amfUserId, amfEventLogId);
	}

	@Override
	public boolean hasAMFUserAMFEventLogs(long amfUserId) {
		return _amfEventLogLocalService.hasAMFUserAMFEventLogs(amfUserId);
	}

	@Override
	public void setAMFUserAMFEventLogs(long amfUserId, long[] amfEventLogIds) {
		_amfEventLogLocalService.setAMFUserAMFEventLogs(
			amfUserId, amfEventLogIds);
	}

	/**
	 * Updates the amf event log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFEventLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfEventLog the amf event log
	 * @return the amf event log that was updated
	 */
	@Override
	public com.amf.registration.model.AMFEventLog updateAMFEventLog(
		com.amf.registration.model.AMFEventLog amfEventLog) {

		return _amfEventLogLocalService.updateAMFEventLog(amfEventLog);
	}

	@Override
	public AMFEventLogLocalService getWrappedService() {
		return _amfEventLogLocalService;
	}

	@Override
	public void setWrappedService(
		AMFEventLogLocalService amfEventLogLocalService) {

		_amfEventLogLocalService = amfEventLogLocalService;
	}

	private AMFEventLogLocalService _amfEventLogLocalService;

}