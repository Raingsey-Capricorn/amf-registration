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

import com.amf.newsletter.model.AMFArticle;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for AMFArticle. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AMFArticleLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AMFArticleLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.amf.newsletter.service.impl.AMFArticleLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the amf article local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AMFArticleLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public AMFArticle addAMFArticle(AMFArticle amfArticle);

	public void addAMFIssueAMFArticle(long amfIssueId, AMFArticle amfArticle);

	public void addAMFIssueAMFArticle(long amfIssueId, long amfArticleId);

	public void addAMFIssueAMFArticles(
		long amfIssueId, List<AMFArticle> amfArticles);

	public void addAMFIssueAMFArticles(long amfIssueId, long[] amfArticleIds);

	public void clearAMFIssueAMFArticles(long amfIssueId);

	/**
	 * Creates a new amf article with the primary key. Does not add the amf article to the database.
	 *
	 * @param amfArticleId the primary key for the new amf article
	 * @return the new amf article
	 */
	@Transactional(enabled = false)
	public AMFArticle createAMFArticle(long amfArticleId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public AMFArticle deleteAMFArticle(AMFArticle amfArticle);

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
	@Indexable(type = IndexableType.DELETE)
	public AMFArticle deleteAMFArticle(long amfArticleId)
		throws PortalException;

	public void deleteAMFIssueAMFArticle(
		long amfIssueId, AMFArticle amfArticle);

	public void deleteAMFIssueAMFArticle(long amfIssueId, long amfArticleId);

	public void deleteAMFIssueAMFArticles(
		long amfIssueId, List<AMFArticle> amfArticles);

	public void deleteAMFIssueAMFArticles(
		long amfIssueId, long[] amfArticleIds);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AMFArticle fetchAMFArticle(long amfArticleId);

	/**
	 * Returns the amf article with the matching UUID and company.
	 *
	 * @param uuid the amf article's UUID
	 * @param companyId the primary key of the company
	 * @return the matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AMFArticle fetchAMFArticleByUuidAndCompanyId(
		String uuid, long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the amf article with the primary key.
	 *
	 * @param amfArticleId the primary key of the amf article
	 * @return the amf article
	 * @throws PortalException if a amf article with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AMFArticle getAMFArticle(long amfArticleId) throws PortalException;

	/**
	 * Returns the amf article with the matching UUID and company.
	 *
	 * @param uuid the amf article's UUID
	 * @param companyId the primary key of the company
	 * @return the matching amf article
	 * @throws PortalException if a matching amf article could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AMFArticle getAMFArticleByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AMFArticle> getAMFArticles(int start, int end);

	/**
	 * Returns the number of amf articles.
	 *
	 * @return the number of amf articles
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAMFArticlesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AMFArticle> getAMFIssueAMFArticles(long amfIssueId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AMFArticle> getAMFIssueAMFArticles(
		long amfIssueId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AMFArticle> getAMFIssueAMFArticles(
		long amfIssueId, int start, int end,
		OrderByComparator<AMFArticle> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAMFIssueAMFArticlesCount(long amfIssueId);

	/**
	 * Returns the amfIssueIds of the amf issues associated with the amf article.
	 *
	 * @param amfArticleId the amfArticleId of the amf article
	 * @return long[] the amfIssueIds of amf issues associated with the amf article
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getAMFIssuePrimaryKeys(long amfArticleId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasAMFIssueAMFArticle(long amfIssueId, long amfArticleId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasAMFIssueAMFArticles(long amfIssueId);

	public void setAMFIssueAMFArticles(long amfIssueId, long[] amfArticleIds);

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
	@Indexable(type = IndexableType.REINDEX)
	public AMFArticle updateAMFArticle(AMFArticle amfArticle);

}