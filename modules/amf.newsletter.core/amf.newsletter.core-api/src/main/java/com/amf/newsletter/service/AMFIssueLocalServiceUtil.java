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

package com.amf.newsletter.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AMFIssue. This utility wraps
 * <code>com.amf.newsletter.service.impl.AMFIssueLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AMFIssueLocalService
 * @generated
 */
public class AMFIssueLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.amf.newsletter.service.impl.AMFIssueLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addAMFArticleAMFIssue(
		long amfArticleId, com.amf.newsletter.model.AMFIssue amfIssue) {

		getService().addAMFArticleAMFIssue(amfArticleId, amfIssue);
	}

	public static void addAMFArticleAMFIssue(
		long amfArticleId, long amfIssueId) {

		getService().addAMFArticleAMFIssue(amfArticleId, amfIssueId);
	}

	public static void addAMFArticleAMFIssues(
		long amfArticleId,
		java.util.List<com.amf.newsletter.model.AMFIssue> amfIssues) {

		getService().addAMFArticleAMFIssues(amfArticleId, amfIssues);
	}

	public static void addAMFArticleAMFIssues(
		long amfArticleId, long[] amfIssueIds) {

		getService().addAMFArticleAMFIssues(amfArticleId, amfIssueIds);
	}

	/**
	 * Adds the amf issue to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFIssueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfIssue the amf issue
	 * @return the amf issue that was added
	 */
	public static com.amf.newsletter.model.AMFIssue addAMFIssue(
		com.amf.newsletter.model.AMFIssue amfIssue) {

		return getService().addAMFIssue(amfIssue);
	}

	public static void clearAMFArticleAMFIssues(long amfArticleId) {
		getService().clearAMFArticleAMFIssues(amfArticleId);
	}

	/**
	 * Creates a new amf issue with the primary key. Does not add the amf issue to the database.
	 *
	 * @param amfIssueId the primary key for the new amf issue
	 * @return the new amf issue
	 */
	public static com.amf.newsletter.model.AMFIssue createAMFIssue(
		long amfIssueId) {

		return getService().createAMFIssue(amfIssueId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteAMFArticleAMFIssue(
		long amfArticleId, com.amf.newsletter.model.AMFIssue amfIssue) {

		getService().deleteAMFArticleAMFIssue(amfArticleId, amfIssue);
	}

	public static void deleteAMFArticleAMFIssue(
		long amfArticleId, long amfIssueId) {

		getService().deleteAMFArticleAMFIssue(amfArticleId, amfIssueId);
	}

	public static void deleteAMFArticleAMFIssues(
		long amfArticleId,
		java.util.List<com.amf.newsletter.model.AMFIssue> amfIssues) {

		getService().deleteAMFArticleAMFIssues(amfArticleId, amfIssues);
	}

	public static void deleteAMFArticleAMFIssues(
		long amfArticleId, long[] amfIssueIds) {

		getService().deleteAMFArticleAMFIssues(amfArticleId, amfIssueIds);
	}

	/**
	 * Deletes the amf issue from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFIssueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfIssue the amf issue
	 * @return the amf issue that was removed
	 */
	public static com.amf.newsletter.model.AMFIssue deleteAMFIssue(
		com.amf.newsletter.model.AMFIssue amfIssue) {

		return getService().deleteAMFIssue(amfIssue);
	}

	/**
	 * Deletes the amf issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFIssueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfIssueId the primary key of the amf issue
	 * @return the amf issue that was removed
	 * @throws PortalException if a amf issue with the primary key could not be found
	 */
	public static com.amf.newsletter.model.AMFIssue deleteAMFIssue(
			long amfIssueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAMFIssue(amfIssueId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletter.model.impl.AMFIssueModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletter.model.impl.AMFIssueModelImpl</code>.
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

	public static com.amf.newsletter.model.AMFIssue fetchAMFIssue(
		long amfIssueId) {

		return getService().fetchAMFIssue(amfIssueId);
	}

	/**
	 * Returns the amf issue matching the UUID and group.
	 *
	 * @param uuid the amf issue's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public static com.amf.newsletter.model.AMFIssue
		fetchAMFIssueByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchAMFIssueByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.amf.newsletter.model.AMFIssue>
		getAMFArticleAMFIssues(long amfArticleId) {

		return getService().getAMFArticleAMFIssues(amfArticleId);
	}

	public static java.util.List<com.amf.newsletter.model.AMFIssue>
		getAMFArticleAMFIssues(long amfArticleId, int start, int end) {

		return getService().getAMFArticleAMFIssues(amfArticleId, start, end);
	}

	public static java.util.List<com.amf.newsletter.model.AMFIssue>
		getAMFArticleAMFIssues(
			long amfArticleId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.amf.newsletter.model.AMFIssue> orderByComparator) {

		return getService().getAMFArticleAMFIssues(
			amfArticleId, start, end, orderByComparator);
	}

	public static int getAMFArticleAMFIssuesCount(long amfArticleId) {
		return getService().getAMFArticleAMFIssuesCount(amfArticleId);
	}

	/**
	 * Returns the amfArticleIds of the amf articles associated with the amf issue.
	 *
	 * @param amfIssueId the amfIssueId of the amf issue
	 * @return long[] the amfArticleIds of amf articles associated with the amf issue
	 */
	public static long[] getAMFArticlePrimaryKeys(long amfIssueId) {
		return getService().getAMFArticlePrimaryKeys(amfIssueId);
	}

	/**
	 * Returns the amf issue with the primary key.
	 *
	 * @param amfIssueId the primary key of the amf issue
	 * @return the amf issue
	 * @throws PortalException if a amf issue with the primary key could not be found
	 */
	public static com.amf.newsletter.model.AMFIssue getAMFIssue(long amfIssueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAMFIssue(amfIssueId);
	}

	/**
	 * Returns the amf issue matching the UUID and group.
	 *
	 * @param uuid the amf issue's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amf issue
	 * @throws PortalException if a matching amf issue could not be found
	 */
	public static com.amf.newsletter.model.AMFIssue getAMFIssueByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAMFIssueByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the amf issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletter.model.impl.AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @return the range of amf issues
	 */
	public static java.util.List<com.amf.newsletter.model.AMFIssue>
		getAMFIssues(int start, int end) {

		return getService().getAMFIssues(start, end);
	}

	/**
	 * Returns all the amf issues matching the UUID and company.
	 *
	 * @param uuid the UUID of the amf issues
	 * @param companyId the primary key of the company
	 * @return the matching amf issues, or an empty list if no matches were found
	 */
	public static java.util.List<com.amf.newsletter.model.AMFIssue>
		getAMFIssuesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getAMFIssuesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of amf issues matching the UUID and company.
	 *
	 * @param uuid the UUID of the amf issues
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching amf issues, or an empty list if no matches were found
	 */
	public static java.util.List<com.amf.newsletter.model.AMFIssue>
		getAMFIssuesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.amf.newsletter.model.AMFIssue> orderByComparator) {

		return getService().getAMFIssuesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of amf issues.
	 *
	 * @return the number of amf issues
	 */
	public static int getAMFIssuesCount() {
		return getService().getAMFIssuesCount();
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

	public static java.util.List<com.amf.newsletter.model.AMFIssue>
		getSampleAMFAmfIssues() {

		return getService().getSampleAMFAmfIssues();
	}

	public static boolean hasAMFArticleAMFIssue(
		long amfArticleId, long amfIssueId) {

		return getService().hasAMFArticleAMFIssue(amfArticleId, amfIssueId);
	}

	public static boolean hasAMFArticleAMFIssues(long amfArticleId) {
		return getService().hasAMFArticleAMFIssues(amfArticleId);
	}

	public static void setAMFArticleAMFIssues(
		long amfArticleId, long[] amfIssueIds) {

		getService().setAMFArticleAMFIssues(amfArticleId, amfIssueIds);
	}

	/**
	 * Updates the amf issue in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFIssueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfIssue the amf issue
	 * @return the amf issue that was updated
	 */
	public static com.amf.newsletter.model.AMFIssue updateAMFIssue(
		com.amf.newsletter.model.AMFIssue amfIssue) {

		return getService().updateAMFIssue(amfIssue);
	}

	public static AMFIssueLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AMFIssueLocalService, AMFIssueLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AMFIssueLocalService.class);

		ServiceTracker<AMFIssueLocalService, AMFIssueLocalService>
			serviceTracker =
				new ServiceTracker<AMFIssueLocalService, AMFIssueLocalService>(
					bundle.getBundleContext(), AMFIssueLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}