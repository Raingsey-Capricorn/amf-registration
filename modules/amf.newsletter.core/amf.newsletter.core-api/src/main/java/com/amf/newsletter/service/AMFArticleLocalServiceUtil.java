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
 * Provides the local service utility for AMFArticle. This utility wraps
 * <code>com.amf.newsletter.service.impl.AMFArticleLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AMFArticleLocalService
 * @generated
 */
public class AMFArticleLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.amf.newsletter.service.impl.AMFArticleLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.amf.newsletter.model.AMFArticle addAMFArticle(
		com.amf.newsletter.model.AMFArticle amfArticle) {

		return getService().addAMFArticle(amfArticle);
	}

	/**
	 * Creates a new amf article with the primary key. Does not add the amf article to the database.
	 *
	 * @param amfarticleId the primary key for the new amf article
	 * @return the new amf article
	 */
	public static com.amf.newsletter.model.AMFArticle createAMFArticle(
		long amfarticleId) {

		return getService().createAMFArticle(amfarticleId);
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
	 * Deletes the amf article from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfArticle the amf article
	 * @return the amf article that was removed
	 */
	public static com.amf.newsletter.model.AMFArticle deleteAMFArticle(
		com.amf.newsletter.model.AMFArticle amfArticle) {

		return getService().deleteAMFArticle(amfArticle);
	}

	/**
	 * Deletes the amf article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFArticleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfarticleId the primary key of the amf article
	 * @return the amf article that was removed
	 * @throws PortalException if a amf article with the primary key could not be found
	 */
	public static com.amf.newsletter.model.AMFArticle deleteAMFArticle(
			long amfarticleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAMFArticle(amfarticleId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletter.model.impl.AMFArticleModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.newsletter.model.impl.AMFArticleModelImpl</code>.
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

	public static com.amf.newsletter.model.AMFArticle fetchAMFArticle(
		long amfarticleId) {

		return getService().fetchAMFArticle(amfarticleId);
	}

	/**
	 * Returns the amf article with the matching UUID and company.
	 *
	 * @param uuid the amf article's UUID
	 * @param companyId the primary key of the company
	 * @return the matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	public static com.amf.newsletter.model.AMFArticle
		fetchAMFArticleByUuidAndCompanyId(String uuid, long companyId) {

		return getService().fetchAMFArticleByUuidAndCompanyId(uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the amf article with the primary key.
	 *
	 * @param amfarticleId the primary key of the amf article
	 * @return the amf article
	 * @throws PortalException if a amf article with the primary key could not be found
	 */
	public static com.amf.newsletter.model.AMFArticle getAMFArticle(
			long amfarticleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAMFArticle(amfarticleId);
	}

	/**
	 * Returns the amf article with the matching UUID and company.
	 *
	 * @param uuid the amf article's UUID
	 * @param companyId the primary key of the company
	 * @return the matching amf article
	 * @throws PortalException if a matching amf article could not be found
	 */
	public static com.amf.newsletter.model.AMFArticle
			getAMFArticleByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAMFArticleByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<com.amf.newsletter.model.AMFArticle>
		getAMFArticles(int start, int end) {

		return getService().getAMFArticles(start, end);
	}

	/**
	 * Returns the number of amf articles.
	 *
	 * @return the number of amf articles
	 */
	public static int getAMFArticlesCount() {
		return getService().getAMFArticlesCount();
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

	public static java.util.List<com.amf.newsletter.model.AMFArticle>
		getSampleAMFArticles() {

		return getService().getSampleAMFArticles();
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
	public static com.amf.newsletter.model.AMFArticle updateAMFArticle(
		com.amf.newsletter.model.AMFArticle amfArticle) {

		return getService().updateAMFArticle(amfArticle);
	}

	public static AMFArticleLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AMFArticleLocalService, AMFArticleLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AMFArticleLocalService.class);

		ServiceTracker<AMFArticleLocalService, AMFArticleLocalService>
			serviceTracker =
				new ServiceTracker
					<AMFArticleLocalService, AMFArticleLocalService>(
						bundle.getBundleContext(), AMFArticleLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}