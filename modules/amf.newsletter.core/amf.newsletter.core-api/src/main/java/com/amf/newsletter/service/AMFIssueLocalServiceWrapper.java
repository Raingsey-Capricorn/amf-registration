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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AMFIssueLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AMFIssueLocalService
 * @generated
 */
public class AMFIssueLocalServiceWrapper
	implements AMFIssueLocalService, ServiceWrapper<AMFIssueLocalService> {

	public AMFIssueLocalServiceWrapper(
		AMFIssueLocalService amfIssueLocalService) {

		_amfIssueLocalService = amfIssueLocalService;
	}

	@Override
	public void addAMFArticleAMFIssue(
		long amfArticleId, com.amf.newsletter.model.AMFIssue amfIssue) {

		_amfIssueLocalService.addAMFArticleAMFIssue(amfArticleId, amfIssue);
	}

	@Override
	public void addAMFArticleAMFIssue(long amfArticleId, long amfIssueId) {
		_amfIssueLocalService.addAMFArticleAMFIssue(amfArticleId, amfIssueId);
	}

	@Override
	public void addAMFArticleAMFIssues(
		long amfArticleId,
		java.util.List<com.amf.newsletter.model.AMFIssue> amfIssues) {

		_amfIssueLocalService.addAMFArticleAMFIssues(amfArticleId, amfIssues);
	}

	@Override
	public void addAMFArticleAMFIssues(long amfArticleId, long[] amfIssueIds) {
		_amfIssueLocalService.addAMFArticleAMFIssues(amfArticleId, amfIssueIds);
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
	@Override
	public com.amf.newsletter.model.AMFIssue addAMFIssue(
		com.amf.newsletter.model.AMFIssue amfIssue) {

		return _amfIssueLocalService.addAMFIssue(amfIssue);
	}

	@Override
	public void clearAMFArticleAMFIssues(long amfArticleId) {
		_amfIssueLocalService.clearAMFArticleAMFIssues(amfArticleId);
	}

	/**
	 * Creates a new amf issue with the primary key. Does not add the amf issue to the database.
	 *
	 * @param amfIssueId the primary key for the new amf issue
	 * @return the new amf issue
	 */
	@Override
	public com.amf.newsletter.model.AMFIssue createAMFIssue(long amfIssueId) {
		return _amfIssueLocalService.createAMFIssue(amfIssueId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfIssueLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteAMFArticleAMFIssue(
		long amfArticleId, com.amf.newsletter.model.AMFIssue amfIssue) {

		_amfIssueLocalService.deleteAMFArticleAMFIssue(amfArticleId, amfIssue);
	}

	@Override
	public void deleteAMFArticleAMFIssue(long amfArticleId, long amfIssueId) {
		_amfIssueLocalService.deleteAMFArticleAMFIssue(
			amfArticleId, amfIssueId);
	}

	@Override
	public void deleteAMFArticleAMFIssues(
		long amfArticleId,
		java.util.List<com.amf.newsletter.model.AMFIssue> amfIssues) {

		_amfIssueLocalService.deleteAMFArticleAMFIssues(
			amfArticleId, amfIssues);
	}

	@Override
	public void deleteAMFArticleAMFIssues(
		long amfArticleId, long[] amfIssueIds) {

		_amfIssueLocalService.deleteAMFArticleAMFIssues(
			amfArticleId, amfIssueIds);
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
	@Override
	public com.amf.newsletter.model.AMFIssue deleteAMFIssue(
		com.amf.newsletter.model.AMFIssue amfIssue) {

		return _amfIssueLocalService.deleteAMFIssue(amfIssue);
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
	@Override
	public com.amf.newsletter.model.AMFIssue deleteAMFIssue(long amfIssueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfIssueLocalService.deleteAMFIssue(amfIssueId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfIssueLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _amfIssueLocalService.dynamicQuery();
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

		return _amfIssueLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _amfIssueLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _amfIssueLocalService.dynamicQuery(
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

		return _amfIssueLocalService.dynamicQueryCount(dynamicQuery);
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

		return _amfIssueLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.amf.newsletter.model.AMFIssue fetchAMFIssue(long amfIssueId) {
		return _amfIssueLocalService.fetchAMFIssue(amfIssueId);
	}

	/**
	 * Returns the amf issue matching the UUID and group.
	 *
	 * @param uuid the amf issue's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	@Override
	public com.amf.newsletter.model.AMFIssue fetchAMFIssueByUuidAndGroupId(
		String uuid, long groupId) {

		return _amfIssueLocalService.fetchAMFIssueByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * @param issueDate
	 * @return
	 */
	@Override
	public java.util.List<com.amf.newsletter.model.AMFIssue> findByAMFIssueDate(
		java.util.Date issueDate) {

		return _amfIssueLocalService.findByAMFIssueDate(issueDate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _amfIssueLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.amf.newsletter.model.AMFIssue>
		getAMFArticleAMFIssues(long amfArticleId) {

		return _amfIssueLocalService.getAMFArticleAMFIssues(amfArticleId);
	}

	@Override
	public java.util.List<com.amf.newsletter.model.AMFIssue>
		getAMFArticleAMFIssues(long amfArticleId, int start, int end) {

		return _amfIssueLocalService.getAMFArticleAMFIssues(
			amfArticleId, start, end);
	}

	@Override
	public java.util.List<com.amf.newsletter.model.AMFIssue>
		getAMFArticleAMFIssues(
			long amfArticleId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.amf.newsletter.model.AMFIssue> orderByComparator) {

		return _amfIssueLocalService.getAMFArticleAMFIssues(
			amfArticleId, start, end, orderByComparator);
	}

	@Override
	public int getAMFArticleAMFIssuesCount(long amfArticleId) {
		return _amfIssueLocalService.getAMFArticleAMFIssuesCount(amfArticleId);
	}

	/**
	 * Returns the amfArticleIds of the amf articles associated with the amf issue.
	 *
	 * @param amfIssueId the amfIssueId of the amf issue
	 * @return long[] the amfArticleIds of amf articles associated with the amf issue
	 */
	@Override
	public long[] getAMFArticlePrimaryKeys(long amfIssueId) {
		return _amfIssueLocalService.getAMFArticlePrimaryKeys(amfIssueId);
	}

	/**
	 * Returns the amf issue with the primary key.
	 *
	 * @param amfIssueId the primary key of the amf issue
	 * @return the amf issue
	 * @throws PortalException if a amf issue with the primary key could not be found
	 */
	@Override
	public com.amf.newsletter.model.AMFIssue getAMFIssue(long amfIssueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfIssueLocalService.getAMFIssue(amfIssueId);
	}

	/**
	 * Returns the amf issue matching the UUID and group.
	 *
	 * @param uuid the amf issue's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amf issue
	 * @throws PortalException if a matching amf issue could not be found
	 */
	@Override
	public com.amf.newsletter.model.AMFIssue getAMFIssueByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfIssueLocalService.getAMFIssueByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.amf.newsletter.model.AMFIssue> getAMFIssues(
		int start, int end) {

		return _amfIssueLocalService.getAMFIssues(start, end);
	}

	/**
	 * Returns all the amf issues matching the UUID and company.
	 *
	 * @param uuid the UUID of the amf issues
	 * @param companyId the primary key of the company
	 * @return the matching amf issues, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.amf.newsletter.model.AMFIssue>
		getAMFIssuesByUuidAndCompanyId(String uuid, long companyId) {

		return _amfIssueLocalService.getAMFIssuesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.amf.newsletter.model.AMFIssue>
		getAMFIssuesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.amf.newsletter.model.AMFIssue> orderByComparator) {

		return _amfIssueLocalService.getAMFIssuesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of amf issues.
	 *
	 * @return the number of amf issues
	 */
	@Override
	public int getAMFIssuesCount() {
		return _amfIssueLocalService.getAMFIssuesCount();
	}

	/**
	 * @param date
	 * @return
	 */
	@Override
	public java.util.List<com.amf.newsletter.model.AMFIssue>
		getAMFIssuesWithinMonth(java.util.Date date) {

		return _amfIssueLocalService.getAMFIssuesWithinMonth(date);
	}

	/**
	 * @param date
	 * @param issueNumber
	 * @return
	 */
	@Override
	public java.util.List<com.amf.newsletter.model.AMFIssue>
		getAMFIssuesWithinMonth(java.util.Date date, int issueNumber) {

		return _amfIssueLocalService.getAMFIssuesWithinMonth(date, issueNumber);
	}

	/**
	 * @param date
	 * @return
	 */
	@Override
	public java.util.List<com.amf.newsletter.model.AMFIssue>
		getAMFIssuesWithinYear(java.util.Date date) {

		return _amfIssueLocalService.getAMFIssuesWithinYear(date);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _amfIssueLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _amfIssueLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amfIssueLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfIssueLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasAMFArticleAMFIssue(long amfArticleId, long amfIssueId) {
		return _amfIssueLocalService.hasAMFArticleAMFIssue(
			amfArticleId, amfIssueId);
	}

	@Override
	public boolean hasAMFArticleAMFIssues(long amfArticleId) {
		return _amfIssueLocalService.hasAMFArticleAMFIssues(amfArticleId);
	}

	@Override
	public void setAMFArticleAMFIssues(long amfArticleId, long[] amfIssueIds) {
		_amfIssueLocalService.setAMFArticleAMFIssues(amfArticleId, amfIssueIds);
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
	@Override
	public com.amf.newsletter.model.AMFIssue updateAMFIssue(
		com.amf.newsletter.model.AMFIssue amfIssue) {

		return _amfIssueLocalService.updateAMFIssue(amfIssue);
	}

	@Override
	public AMFIssueLocalService getWrappedService() {
		return _amfIssueLocalService;
	}

	@Override
	public void setWrappedService(AMFIssueLocalService amfIssueLocalService) {
		_amfIssueLocalService = amfIssueLocalService;
	}

	private AMFIssueLocalService _amfIssueLocalService;

}