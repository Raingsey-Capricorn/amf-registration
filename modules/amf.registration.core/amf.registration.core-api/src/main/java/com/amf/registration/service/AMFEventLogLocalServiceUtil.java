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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AMFEventLog. This utility wraps
 * <code>com.amf.registration.service.impl.AMFEventLogLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventLogLocalService
 * @generated
 */
public class AMFEventLogLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.amf.registration.service.impl.AMFEventLogLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.amf.registration.model.AMFEventLog addAMFEventLog(
		com.amf.registration.model.AMFEventLog amfEventLog) {

		return getService().addAMFEventLog(amfEventLog);
	}

	public static void addAMFUserAMFEventLog(
		long amfUserId, com.amf.registration.model.AMFEventLog amfEventLog) {

		getService().addAMFUserAMFEventLog(amfUserId, amfEventLog);
	}

	public static void addAMFUserAMFEventLog(
		long amfUserId, long amfEventLogId) {

		getService().addAMFUserAMFEventLog(amfUserId, amfEventLogId);
	}

	public static void addAMFUserAMFEventLogs(
		long amfUserId,
		java.util.List<com.amf.registration.model.AMFEventLog> amfEventLogs) {

		getService().addAMFUserAMFEventLogs(amfUserId, amfEventLogs);
	}

	public static void addAMFUserAMFEventLogs(
		long amfUserId, long[] amfEventLogIds) {

		getService().addAMFUserAMFEventLogs(amfUserId, amfEventLogIds);
	}

	public static void clearAMFUserAMFEventLogs(long amfUserId) {
		getService().clearAMFUserAMFEventLogs(amfUserId);
	}

	/**
	 * Creates a new amf event log with the primary key. Does not add the amf event log to the database.
	 *
	 * @param amfEventLogId the primary key for the new amf event log
	 * @return the new amf event log
	 */
	public static com.amf.registration.model.AMFEventLog createAMFEventLog(
		long amfEventLogId) {

		return getService().createAMFEventLog(amfEventLogId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static com.amf.registration.model.AMFEventLog deleteAMFEventLog(
		com.amf.registration.model.AMFEventLog amfEventLog) {

		return getService().deleteAMFEventLog(amfEventLog);
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
	public static com.amf.registration.model.AMFEventLog deleteAMFEventLog(
			long amfEventLogId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAMFEventLog(amfEventLogId);
	}

	public static void deleteAMFUserAMFEventLog(
		long amfUserId, com.amf.registration.model.AMFEventLog amfEventLog) {

		getService().deleteAMFUserAMFEventLog(amfUserId, amfEventLog);
	}

	public static void deleteAMFUserAMFEventLog(
		long amfUserId, long amfEventLogId) {

		getService().deleteAMFUserAMFEventLog(amfUserId, amfEventLogId);
	}

	public static void deleteAMFUserAMFEventLogs(
		long amfUserId,
		java.util.List<com.amf.registration.model.AMFEventLog> amfEventLogs) {

		getService().deleteAMFUserAMFEventLogs(amfUserId, amfEventLogs);
	}

	public static void deleteAMFUserAMFEventLogs(
		long amfUserId, long[] amfEventLogIds) {

		getService().deleteAMFUserAMFEventLogs(amfUserId, amfEventLogIds);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.amf.registration.model.AMFEventLog fetchAMFEventLog(
		long amfEventLogId) {

		return getService().fetchAMFEventLog(amfEventLogId);
	}

	/**
	 * Returns the amf event log matching the UUID and group.
	 *
	 * @param uuid the amf event log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	public static com.amf.registration.model.AMFEventLog
		fetchAMFEventLogByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchAMFEventLogByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the amf event log with the primary key.
	 *
	 * @param amfEventLogId the primary key of the amf event log
	 * @return the amf event log
	 * @throws PortalException if a amf event log with the primary key could not be found
	 */
	public static com.amf.registration.model.AMFEventLog getAMFEventLog(
			long amfEventLogId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAMFEventLog(amfEventLogId);
	}

	/**
	 * @param groupId
	 * @param userId
	 * @return
	 */
	public static com.amf.registration.model.AMFEventLog
		getAmfEventLogByGroupAndUser(long groupId, long userId) {

		return getService().getAmfEventLogByGroupAndUser(groupId, userId);
	}

	/**
	 * Returns the amf event log matching the UUID and group.
	 *
	 * @param uuid the amf event log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amf event log
	 * @throws PortalException if a matching amf event log could not be found
	 */
	public static com.amf.registration.model.AMFEventLog
			getAMFEventLogByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAMFEventLogByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<com.amf.registration.model.AMFEventLog>
		getAMFEventLogs(int start, int end) {

		return getService().getAMFEventLogs(start, end);
	}

	/**
	 * Returns all the amf event logs matching the UUID and company.
	 *
	 * @param uuid the UUID of the amf event logs
	 * @param companyId the primary key of the company
	 * @return the matching amf event logs, or an empty list if no matches were found
	 */
	public static java.util.List<com.amf.registration.model.AMFEventLog>
		getAMFEventLogsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getAMFEventLogsByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<com.amf.registration.model.AMFEventLog>
		getAMFEventLogsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.amf.registration.model.AMFEventLog> orderByComparator) {

		return getService().getAMFEventLogsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of amf event logs.
	 *
	 * @return the number of amf event logs
	 */
	public static int getAMFEventLogsCount() {
		return getService().getAMFEventLogsCount();
	}

	public static java.util.List<com.amf.registration.model.AMFEventLog>
		getAMFUserAMFEventLogs(long amfUserId) {

		return getService().getAMFUserAMFEventLogs(amfUserId);
	}

	public static java.util.List<com.amf.registration.model.AMFEventLog>
		getAMFUserAMFEventLogs(long amfUserId, int start, int end) {

		return getService().getAMFUserAMFEventLogs(amfUserId, start, end);
	}

	public static java.util.List<com.amf.registration.model.AMFEventLog>
		getAMFUserAMFEventLogs(
			long amfUserId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.amf.registration.model.AMFEventLog> orderByComparator) {

		return getService().getAMFUserAMFEventLogs(
			amfUserId, start, end, orderByComparator);
	}

	public static int getAMFUserAMFEventLogsCount(long amfUserId) {
		return getService().getAMFUserAMFEventLogsCount(amfUserId);
	}

	/**
	 * Returns the amfUserIds of the amf users associated with the amf event log.
	 *
	 * @param amfEventLogId the amfEventLogId of the amf event log
	 * @return long[] the amfUserIds of amf users associated with the amf event log
	 */
	public static long[] getAMFUserPrimaryKeys(long amfEventLogId) {
		return getService().getAMFUserPrimaryKeys(amfEventLogId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static boolean hasAMFUserAMFEventLog(
		long amfUserId, long amfEventLogId) {

		return getService().hasAMFUserAMFEventLog(amfUserId, amfEventLogId);
	}

	public static boolean hasAMFUserAMFEventLogs(long amfUserId) {
		return getService().hasAMFUserAMFEventLogs(amfUserId);
	}

	public static void setAMFUserAMFEventLogs(
		long amfUserId, long[] amfEventLogIds) {

		getService().setAMFUserAMFEventLogs(amfUserId, amfEventLogIds);
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
	public static com.amf.registration.model.AMFEventLog updateAMFEventLog(
		com.amf.registration.model.AMFEventLog amfEventLog) {

		return getService().updateAMFEventLog(amfEventLog);
	}

	public static AMFEventLogLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AMFEventLogLocalService, AMFEventLogLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AMFEventLogLocalService.class);

		ServiceTracker<AMFEventLogLocalService, AMFEventLogLocalService>
			serviceTracker =
				new ServiceTracker
					<AMFEventLogLocalService, AMFEventLogLocalService>(
						bundle.getBundleContext(),
						AMFEventLogLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}