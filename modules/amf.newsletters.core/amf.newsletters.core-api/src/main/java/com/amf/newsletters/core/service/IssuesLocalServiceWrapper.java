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

package com.amf.newsletters.core.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IssuesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see IssuesLocalService
 * @generated
 */
public class IssuesLocalServiceWrapper
	implements IssuesLocalService, ServiceWrapper<IssuesLocalService> {

	public IssuesLocalServiceWrapper(IssuesLocalService issuesLocalService) {
		_issuesLocalService = issuesLocalService;
	}

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
	@Override
	public com.amf.newsletters.core.model.Issues addIssues(
		com.amf.newsletters.core.model.Issues issues) {

		return _issuesLocalService.addIssues(issues);
	}

	/**
	 * Creates a new issues with the primary key. Does not add the issues to the database.
	 *
	 * @param issueId the primary key for the new issues
	 * @return the new issues
	 */
	@Override
	public com.amf.newsletters.core.model.Issues createIssues(long issueId) {
		return _issuesLocalService.createIssues(issueId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _issuesLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.amf.newsletters.core.model.Issues deleteIssues(
		com.amf.newsletters.core.model.Issues issues) {

		return _issuesLocalService.deleteIssues(issues);
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
	@Override
	public com.amf.newsletters.core.model.Issues deleteIssues(long issueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _issuesLocalService.deleteIssues(issueId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _issuesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _issuesLocalService.dynamicQuery();
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

		return _issuesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletters.core.model.impl.IssuesModelImpl</code>.
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

		return _issuesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletters.core.model.impl.IssuesModelImpl</code>.
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

		return _issuesLocalService.dynamicQuery(
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

		return _issuesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _issuesLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.amf.newsletters.core.model.Issues fetchIssues(long issueId) {
		return _issuesLocalService.fetchIssues(issueId);
	}

	/**
	 * Returns the issues matching the UUID and group.
	 *
	 * @param uuid the issues's UUID
	 * @param groupId the primary key of the group
	 * @return the matching issues, or <code>null</code> if a matching issues could not be found
	 */
	@Override
	public com.amf.newsletters.core.model.Issues fetchIssuesByUuidAndGroupId(
		String uuid, long groupId) {

		return _issuesLocalService.fetchIssuesByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _issuesLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _issuesLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _issuesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the issues with the primary key.
	 *
	 * @param issueId the primary key of the issues
	 * @return the issues
	 * @throws PortalException if a issues with the primary key could not be found
	 */
	@Override
	public com.amf.newsletters.core.model.Issues getIssues(long issueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _issuesLocalService.getIssues(issueId);
	}

	/**
	 * Returns the issues matching the UUID and group.
	 *
	 * @param uuid the issues's UUID
	 * @param groupId the primary key of the group
	 * @return the matching issues
	 * @throws PortalException if a matching issues could not be found
	 */
	@Override
	public com.amf.newsletters.core.model.Issues getIssuesByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _issuesLocalService.getIssuesByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the issueses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletters.core.model.impl.IssuesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issueses
	 * @param end the upper bound of the range of issueses (not inclusive)
	 * @return the range of issueses
	 */
	@Override
	public java.util.List<com.amf.newsletters.core.model.Issues> getIssueses(
		int start, int end) {

		return _issuesLocalService.getIssueses(start, end);
	}

	/**
	 * Returns all the issueses matching the UUID and company.
	 *
	 * @param uuid the UUID of the issueses
	 * @param companyId the primary key of the company
	 * @return the matching issueses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.amf.newsletters.core.model.Issues>
		getIssuesesByUuidAndCompanyId(String uuid, long companyId) {

		return _issuesLocalService.getIssuesesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.amf.newsletters.core.model.Issues>
		getIssuesesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.amf.newsletters.core.model.Issues> orderByComparator) {

		return _issuesLocalService.getIssuesesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of issueses.
	 *
	 * @return the number of issueses
	 */
	@Override
	public int getIssuesesCount() {
		return _issuesLocalService.getIssuesesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _issuesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _issuesLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.amf.newsletters.core.model.Issues updateIssues(
		com.amf.newsletters.core.model.Issues issues) {

		return _issuesLocalService.updateIssues(issues);
	}

	@Override
	public IssuesLocalService getWrappedService() {
		return _issuesLocalService;
	}

	@Override
	public void setWrappedService(IssuesLocalService issuesLocalService) {
		_issuesLocalService = issuesLocalService;
	}

	private IssuesLocalService _issuesLocalService;

}