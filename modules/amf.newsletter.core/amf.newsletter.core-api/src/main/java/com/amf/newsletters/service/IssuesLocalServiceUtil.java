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

package com.amf.newsletters.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Issues. This utility wraps
 * <code>com.amf.newsletters.service.impl.IssuesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see IssuesLocalService
 * @generated
 */
public class IssuesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.amf.newsletters.service.impl.IssuesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the issues to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IssuesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param issues the issues
	 * @return the issues that was added
	 */
	public static com.amf.newsletters.model.Issues addIssues(
		com.amf.newsletters.model.Issues issues) {

		return getService().addIssues(issues);
	}

	/**
	 * Creates a new issues with the primary key. Does not add the issues to the database.
	 *
	 * @param issueId the primary key for the new issues
	 * @return the new issues
	 */
	public static com.amf.newsletters.model.Issues createIssues(long issueId) {
		return getService().createIssues(issueId);
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
	 * Deletes the issues from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IssuesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param issues the issues
	 * @return the issues that was removed
	 */
	public static com.amf.newsletters.model.Issues deleteIssues(
		com.amf.newsletters.model.Issues issues) {

		return getService().deleteIssues(issues);
	}

	/**
	 * Deletes the issues with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IssuesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param issueId the primary key of the issues
	 * @return the issues that was removed
	 * @throws PortalException if a issues with the primary key could not be found
	 */
	public static com.amf.newsletters.model.Issues deleteIssues(long issueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteIssues(issueId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletters.model.impl.IssuesModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletters.model.impl.IssuesModelImpl</code>.
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

	public static com.amf.newsletters.model.Issues fetchIssues(long issueId) {
		return getService().fetchIssues(issueId);
	}

	/**
	 * Returns the issues matching the UUID and group.
	 *
	 * @param uuid the issues's UUID
	 * @param groupId the primary key of the group
	 * @return the matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public static com.amf.newsletters.model.Issues fetchIssuesByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchIssuesByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the issues with the primary key.
	 *
	 * @param issueId the primary key of the issues
	 * @return the issues
	 * @throws PortalException if a issues with the primary key could not be found
	 */
	public static com.amf.newsletters.model.Issues getIssues(long issueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getIssues(issueId);
	}

	/**
	 * Returns the issues matching the UUID and group.
	 *
	 * @param uuid the issues's UUID
	 * @param groupId the primary key of the group
	 * @return the matching issues
	 * @throws PortalException if a matching issues could not be found
	 */
	public static com.amf.newsletters.model.Issues getIssuesByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getIssuesByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the issueses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletters.model.impl.IssuesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issueses
	 * @param end the upper bound of the range of issueses (not inclusive)
	 * @return the range of issueses
	 */
	public static java.util.List<com.amf.newsletters.model.Issues> getIssueses(
		int start, int end) {

		return getService().getIssueses(start, end);
	}

	/**
	 * Returns all the issueses matching the UUID and company.
	 *
	 * @param uuid the UUID of the issueses
	 * @param companyId the primary key of the company
	 * @return the matching issueses, or an empty list if no matches were found
	 */
	public static java.util.List<com.amf.newsletters.model.Issues>
		getIssuesesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getIssuesesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of issueses matching the UUID and company.
	 *
	 * @param uuid the UUID of the issueses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of issueses
	 * @param end the upper bound of the range of issueses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching issueses, or an empty list if no matches were found
	 */
	public static java.util.List<com.amf.newsletters.model.Issues>
		getIssuesesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.amf.newsletters.model.Issues> orderByComparator) {

		return getService().getIssuesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of issueses.
	 *
	 * @return the number of issueses
	 */
	public static int getIssuesesCount() {
		return getService().getIssuesesCount();
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

	/**
	 * Updates the issues in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IssuesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param issues the issues
	 * @return the issues that was updated
	 */
	public static com.amf.newsletters.model.Issues updateIssues(
		com.amf.newsletters.model.Issues issues) {

		return getService().updateIssues(issues);
	}

	public static IssuesLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<IssuesLocalService, IssuesLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(IssuesLocalService.class);

		ServiceTracker<IssuesLocalService, IssuesLocalService> serviceTracker =
			new ServiceTracker<IssuesLocalService, IssuesLocalService>(
				bundle.getBundleContext(), IssuesLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}