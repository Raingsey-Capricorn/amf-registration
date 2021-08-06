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
 * Provides a wrapper for {@link AMFArticleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AMFArticleLocalService
 * @generated
 */
public class AMFArticleLocalServiceWrapper
	implements AMFArticleLocalService, ServiceWrapper<AMFArticleLocalService> {

	public AMFArticleLocalServiceWrapper(
		AMFArticleLocalService amfArticleLocalService) {

		_amfArticleLocalService = amfArticleLocalService;
	}

	/**
	 * Adds the amf article to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfArticle the amf article
	 * @return the amf article that was added
	 */
	@Override
	public com.amf.newsletter.model.AMFArticle addAMFArticle(
		com.amf.newsletter.model.AMFArticle amfArticle) {

		return _amfArticleLocalService.addAMFArticle(amfArticle);
	}

	@Override
	public void addAMFIssueAMFArticle(
		long amfIssueId, com.amf.newsletter.model.AMFArticle amfArticle) {

		_amfArticleLocalService.addAMFIssueAMFArticle(amfIssueId, amfArticle);
	}

	@Override
	public void addAMFIssueAMFArticle(long amfIssueId, long amfArticleId) {
		_amfArticleLocalService.addAMFIssueAMFArticle(amfIssueId, amfArticleId);
	}

	@Override
	public void addAMFIssueAMFArticles(
		long amfIssueId,
		java.util.List<com.amf.newsletter.model.AMFArticle> amfArticles) {

		_amfArticleLocalService.addAMFIssueAMFArticles(amfIssueId, amfArticles);
	}

	@Override
	public void addAMFIssueAMFArticles(long amfIssueId, long[] amfArticleIds) {
		_amfArticleLocalService.addAMFIssueAMFArticles(
			amfIssueId, amfArticleIds);
	}

	@Override
	public void clearAMFIssueAMFArticles(long amfIssueId) {
		_amfArticleLocalService.clearAMFIssueAMFArticles(amfIssueId);
	}

	/**
	 * Creates a new amf article with the primary key. Does not add the amf article to the database.
	 *
	 * @param amfArticleId the primary key for the new amf article
	 * @return the new amf article
	 */
	@Override
	public com.amf.newsletter.model.AMFArticle createAMFArticle(
		long amfArticleId) {

		return _amfArticleLocalService.createAMFArticle(amfArticleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfArticleLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the amf article from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfArticle the amf article
	 * @return the amf article that was removed
	 */
	@Override
	public com.amf.newsletter.model.AMFArticle deleteAMFArticle(
		com.amf.newsletter.model.AMFArticle amfArticle) {

		return _amfArticleLocalService.deleteAMFArticle(amfArticle);
	}

	/**
	 * Deletes the amf article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfArticleId the primary key of the amf article
	 * @return the amf article that was removed
	 * @throws PortalException if a amf article with the primary key could not be found
	 */
	@Override
	public com.amf.newsletter.model.AMFArticle deleteAMFArticle(
			long amfArticleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfArticleLocalService.deleteAMFArticle(amfArticleId);
	}

	@Override
	public void deleteAMFIssueAMFArticle(
		long amfIssueId, com.amf.newsletter.model.AMFArticle amfArticle) {

		_amfArticleLocalService.deleteAMFIssueAMFArticle(
			amfIssueId, amfArticle);
	}

	@Override
	public void deleteAMFIssueAMFArticle(long amfIssueId, long amfArticleId) {
		_amfArticleLocalService.deleteAMFIssueAMFArticle(
			amfIssueId, amfArticleId);
	}

	@Override
	public void deleteAMFIssueAMFArticles(
		long amfIssueId,
		java.util.List<com.amf.newsletter.model.AMFArticle> amfArticles) {

		_amfArticleLocalService.deleteAMFIssueAMFArticles(
			amfIssueId, amfArticles);
	}

	@Override
	public void deleteAMFIssueAMFArticles(
		long amfIssueId, long[] amfArticleIds) {

		_amfArticleLocalService.deleteAMFIssueAMFArticles(
			amfIssueId, amfArticleIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfArticleLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _amfArticleLocalService.dynamicQuery();
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

		return _amfArticleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletter.model.impl.AMFArticleModelImpl</code>.
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

		return _amfArticleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletter.model.impl.AMFArticleModelImpl</code>.
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

		return _amfArticleLocalService.dynamicQuery(
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

		return _amfArticleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _amfArticleLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.amf.newsletter.model.AMFArticle fetchAMFArticle(
		long amfArticleId) {

		return _amfArticleLocalService.fetchAMFArticle(amfArticleId);
	}

	/**
	 * Returns the amf article with the matching UUID and company.
	 *
	 * @param uuid the amf article's UUID
	 * @param companyId the primary key of the company
	 * @return the matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	@Override
	public com.amf.newsletter.model.AMFArticle
		fetchAMFArticleByUuidAndCompanyId(String uuid, long companyId) {

		return _amfArticleLocalService.fetchAMFArticleByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _amfArticleLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the amf article with the primary key.
	 *
	 * @param amfArticleId the primary key of the amf article
	 * @return the amf article
	 * @throws PortalException if a amf article with the primary key could not be found
	 */
	@Override
	public com.amf.newsletter.model.AMFArticle getAMFArticle(long amfArticleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfArticleLocalService.getAMFArticle(amfArticleId);
	}

	/**
	 * Returns the amf article with the matching UUID and company.
	 *
	 * @param uuid the amf article's UUID
	 * @param companyId the primary key of the company
	 * @return the matching amf article
	 * @throws PortalException if a matching amf article could not be found
	 */
	@Override
	public com.amf.newsletter.model.AMFArticle getAMFArticleByUuidAndCompanyId(
			String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfArticleLocalService.getAMFArticleByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the amf articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletter.model.impl.AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @return the range of amf articles
	 */
	@Override
	public java.util.List<com.amf.newsletter.model.AMFArticle> getAMFArticles(
		int start, int end) {

		return _amfArticleLocalService.getAMFArticles(start, end);
	}

	/**
	 * @param issueNumber
	 * @param date
	 * @return
	 */
	@Override
	public java.util.List<com.amf.newsletter.model.AMFArticle>
		getAMFArticlesByIssueNumberWithinMonth(
			int issueNumber, java.util.Date date) {

		return _amfArticleLocalService.getAMFArticlesByIssueNumberWithinMonth(
			issueNumber, date);
	}

	/**
	 * Returns the number of amf articles.
	 *
	 * @return the number of amf articles
	 */
	@Override
	public int getAMFArticlesCount() {
		return _amfArticleLocalService.getAMFArticlesCount();
	}

	@Override
	public java.util.List<com.amf.newsletter.model.AMFArticle>
		getAMFIssueAMFArticles(long amfIssueId) {

		return _amfArticleLocalService.getAMFIssueAMFArticles(amfIssueId);
	}

	@Override
	public java.util.List<com.amf.newsletter.model.AMFArticle>
		getAMFIssueAMFArticles(long amfIssueId, int start, int end) {

		return _amfArticleLocalService.getAMFIssueAMFArticles(
			amfIssueId, start, end);
	}

	@Override
	public java.util.List<com.amf.newsletter.model.AMFArticle>
		getAMFIssueAMFArticles(
			long amfIssueId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.amf.newsletter.model.AMFArticle> orderByComparator) {

		return _amfArticleLocalService.getAMFIssueAMFArticles(
			amfIssueId, start, end, orderByComparator);
	}

	@Override
	public int getAMFIssueAMFArticlesCount(long amfIssueId) {
		return _amfArticleLocalService.getAMFIssueAMFArticlesCount(amfIssueId);
	}

	/**
	 * Returns the amfIssueIds of the amf issues associated with the amf article.
	 *
	 * @param amfArticleId the amfArticleId of the amf article
	 * @return long[] the amfIssueIds of amf issues associated with the amf article
	 */
	@Override
	public long[] getAMFIssuePrimaryKeys(long amfArticleId) {
		return _amfArticleLocalService.getAMFIssuePrimaryKeys(amfArticleId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _amfArticleLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _amfArticleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amfArticleLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amfArticleLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasAMFIssueAMFArticle(long amfIssueId, long amfArticleId) {
		return _amfArticleLocalService.hasAMFIssueAMFArticle(
			amfIssueId, amfArticleId);
	}

	@Override
	public boolean hasAMFIssueAMFArticles(long amfIssueId) {
		return _amfArticleLocalService.hasAMFIssueAMFArticles(amfIssueId);
	}

	@Override
	public void setAMFIssueAMFArticles(long amfIssueId, long[] amfArticleIds) {
		_amfArticleLocalService.setAMFIssueAMFArticles(
			amfIssueId, amfArticleIds);
	}

	/**
	 * Updates the amf article in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfArticle the amf article
	 * @return the amf article that was updated
	 */
	@Override
	public com.amf.newsletter.model.AMFArticle updateAMFArticle(
		com.amf.newsletter.model.AMFArticle amfArticle) {

		return _amfArticleLocalService.updateAMFArticle(amfArticle);
	}

	@Override
	public AMFArticleLocalService getWrappedService() {
		return _amfArticleLocalService;
	}

	@Override
	public void setWrappedService(
		AMFArticleLocalService amfArticleLocalService) {

		_amfArticleLocalService = amfArticleLocalService;
	}

	private AMFArticleLocalService _amfArticleLocalService;

}