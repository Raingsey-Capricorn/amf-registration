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
 * Provides a wrapper for {@link ArticlesLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ArticlesLocalService
 * @generated
 */
public class ArticlesLocalServiceWrapper
	implements ArticlesLocalService, ServiceWrapper<ArticlesLocalService> {

	public ArticlesLocalServiceWrapper(
		ArticlesLocalService articlesLocalService) {

		_articlesLocalService = articlesLocalService;
	}

	/**
	 * Adds the articles to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ArticlesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param articles the articles
	 * @return the articles that was added
	 */
	@Override
	public com.amf.newsletters.core.model.Articles addArticles(
		com.amf.newsletters.core.model.Articles articles) {

		return _articlesLocalService.addArticles(articles);
	}

	/**
	 * Creates a new articles with the primary key. Does not add the articles to the database.
	 *
	 * @param articleId the primary key for the new articles
	 * @return the new articles
	 */
	@Override
	public com.amf.newsletters.core.model.Articles createArticles(
		long articleId) {

		return _articlesLocalService.createArticles(articleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articlesLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the articles from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ArticlesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param articles the articles
	 * @return the articles that was removed
	 */
	@Override
	public com.amf.newsletters.core.model.Articles deleteArticles(
		com.amf.newsletters.core.model.Articles articles) {

		return _articlesLocalService.deleteArticles(articles);
	}

	/**
	 * Deletes the articles with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ArticlesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param articleId the primary key of the articles
	 * @return the articles that was removed
	 * @throws PortalException if a articles with the primary key could not be found
	 */
	@Override
	public com.amf.newsletters.core.model.Articles deleteArticles(
			long articleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articlesLocalService.deleteArticles(articleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articlesLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _articlesLocalService.dynamicQuery();
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

		return _articlesLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletters.core.model.impl.ArticlesModelImpl</code>.
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

		return _articlesLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletters.core.model.impl.ArticlesModelImpl</code>.
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

		return _articlesLocalService.dynamicQuery(
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

		return _articlesLocalService.dynamicQueryCount(dynamicQuery);
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

		return _articlesLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.amf.newsletters.core.model.Articles fetchArticles(
		long articleId) {

		return _articlesLocalService.fetchArticles(articleId);
	}

	/**
	 * Returns the articles with the matching UUID and company.
	 *
	 * @param uuid the articles's UUID
	 * @param companyId the primary key of the company
	 * @return the matching articles, or <code>null</code> if a matching articles could not be found
	 */
	@Override
	public com.amf.newsletters.core.model.Articles
		fetchArticlesByUuidAndCompanyId(String uuid, long companyId) {

		return _articlesLocalService.fetchArticlesByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _articlesLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the articles with the primary key.
	 *
	 * @param articleId the primary key of the articles
	 * @return the articles
	 * @throws PortalException if a articles with the primary key could not be found
	 */
	@Override
	public com.amf.newsletters.core.model.Articles getArticles(long articleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articlesLocalService.getArticles(articleId);
	}

	/**
	 * Returns the articles with the matching UUID and company.
	 *
	 * @param uuid the articles's UUID
	 * @param companyId the primary key of the company
	 * @return the matching articles
	 * @throws PortalException if a matching articles could not be found
	 */
	@Override
	public com.amf.newsletters.core.model.Articles
			getArticlesByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articlesLocalService.getArticlesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the articleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletters.core.model.impl.ArticlesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articleses
	 * @param end the upper bound of the range of articleses (not inclusive)
	 * @return the range of articleses
	 */
	@Override
	public java.util.List<com.amf.newsletters.core.model.Articles>
		getArticleses(int start, int end) {

		return _articlesLocalService.getArticleses(start, end);
	}

	/**
	 * Returns the number of articleses.
	 *
	 * @return the number of articleses
	 */
	@Override
	public int getArticlesesCount() {
		return _articlesLocalService.getArticlesesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _articlesLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _articlesLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _articlesLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _articlesLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the articles in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ArticlesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param articles the articles
	 * @return the articles that was updated
	 */
	@Override
	public com.amf.newsletters.core.model.Articles updateArticles(
		com.amf.newsletters.core.model.Articles articles) {

		return _articlesLocalService.updateArticles(articles);
	}

	@Override
	public ArticlesLocalService getWrappedService() {
		return _articlesLocalService;
	}

	@Override
	public void setWrappedService(ArticlesLocalService articlesLocalService) {
		_articlesLocalService = articlesLocalService;
	}

	private ArticlesLocalService _articlesLocalService;

}