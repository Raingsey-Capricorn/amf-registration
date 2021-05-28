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

package com.amf.newsletter.service.persistence;

import com.amf.newsletter.exception.NoSuchAMFArticleException;
import com.amf.newsletter.model.AMFArticle;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the amf article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFArticleUtil
 * @generated
 */
@ProviderType
public interface AMFArticlePersistence extends BasePersistence<AMFArticle> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AMFArticleUtil} to access the amf article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the amf articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amf articles
	 */
	public java.util.List<AMFArticle> findByUuid(String uuid);

	/**
	 * Returns a range of all the amf articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @return the range of matching amf articles
	 */
	public java.util.List<AMFArticle> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the amf articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf articles
	 */
	public java.util.List<AMFArticle> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator);

	/**
	 * Returns an ordered range of all the amf articles where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf articles
	 */
	public java.util.List<AMFArticle> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf article
	 * @throws NoSuchAMFArticleException if a matching amf article could not be found
	 */
	public AMFArticle findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
				orderByComparator)
		throws NoSuchAMFArticleException;

	/**
	 * Returns the first amf article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	public AMFArticle fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator);

	/**
	 * Returns the last amf article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf article
	 * @throws NoSuchAMFArticleException if a matching amf article could not be found
	 */
	public AMFArticle findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
				orderByComparator)
		throws NoSuchAMFArticleException;

	/**
	 * Returns the last amf article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	public AMFArticle fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator);

	/**
	 * Returns the amf articles before and after the current amf article in the ordered set where uuid = &#63;.
	 *
	 * @param amfArticleId the primary key of the current amf article
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf article
	 * @throws NoSuchAMFArticleException if a amf article with the primary key could not be found
	 */
	public AMFArticle[] findByUuid_PrevAndNext(
			long amfArticleId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
				orderByComparator)
		throws NoSuchAMFArticleException;

	/**
	 * Removes all the amf articles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of amf articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amf articles
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the amf articles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching amf articles
	 */
	public java.util.List<AMFArticle> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the amf articles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @return the range of matching amf articles
	 */
	public java.util.List<AMFArticle> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the amf articles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf articles
	 */
	public java.util.List<AMFArticle> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator);

	/**
	 * Returns an ordered range of all the amf articles where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf articles
	 */
	public java.util.List<AMFArticle> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf article
	 * @throws NoSuchAMFArticleException if a matching amf article could not be found
	 */
	public AMFArticle findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
				orderByComparator)
		throws NoSuchAMFArticleException;

	/**
	 * Returns the first amf article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	public AMFArticle fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator);

	/**
	 * Returns the last amf article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf article
	 * @throws NoSuchAMFArticleException if a matching amf article could not be found
	 */
	public AMFArticle findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
				orderByComparator)
		throws NoSuchAMFArticleException;

	/**
	 * Returns the last amf article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	public AMFArticle fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator);

	/**
	 * Returns the amf articles before and after the current amf article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param amfArticleId the primary key of the current amf article
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf article
	 * @throws NoSuchAMFArticleException if a amf article with the primary key could not be found
	 */
	public AMFArticle[] findByUuid_C_PrevAndNext(
			long amfArticleId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
				orderByComparator)
		throws NoSuchAMFArticleException;

	/**
	 * Removes all the amf articles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of amf articles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching amf articles
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the amf articles where amfArticleId = &#63;.
	 *
	 * @param amfArticleId the amf article ID
	 * @return the matching amf articles
	 */
	public java.util.List<AMFArticle> findByArticleId(long amfArticleId);

	/**
	 * Returns a range of all the amf articles where amfArticleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param amfArticleId the amf article ID
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @return the range of matching amf articles
	 */
	public java.util.List<AMFArticle> findByArticleId(
		long amfArticleId, int start, int end);

	/**
	 * Returns an ordered range of all the amf articles where amfArticleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param amfArticleId the amf article ID
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf articles
	 */
	public java.util.List<AMFArticle> findByArticleId(
		long amfArticleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator);

	/**
	 * Returns an ordered range of all the amf articles where amfArticleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param amfArticleId the amf article ID
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf articles
	 */
	public java.util.List<AMFArticle> findByArticleId(
		long amfArticleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf article in the ordered set where amfArticleId = &#63;.
	 *
	 * @param amfArticleId the amf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf article
	 * @throws NoSuchAMFArticleException if a matching amf article could not be found
	 */
	public AMFArticle findByArticleId_First(
			long amfArticleId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
				orderByComparator)
		throws NoSuchAMFArticleException;

	/**
	 * Returns the first amf article in the ordered set where amfArticleId = &#63;.
	 *
	 * @param amfArticleId the amf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	public AMFArticle fetchByArticleId_First(
		long amfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator);

	/**
	 * Returns the last amf article in the ordered set where amfArticleId = &#63;.
	 *
	 * @param amfArticleId the amf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf article
	 * @throws NoSuchAMFArticleException if a matching amf article could not be found
	 */
	public AMFArticle findByArticleId_Last(
			long amfArticleId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
				orderByComparator)
		throws NoSuchAMFArticleException;

	/**
	 * Returns the last amf article in the ordered set where amfArticleId = &#63;.
	 *
	 * @param amfArticleId the amf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	public AMFArticle fetchByArticleId_Last(
		long amfArticleId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator);

	/**
	 * Removes all the amf articles where amfArticleId = &#63; from the database.
	 *
	 * @param amfArticleId the amf article ID
	 */
	public void removeByArticleId(long amfArticleId);

	/**
	 * Returns the number of amf articles where amfArticleId = &#63;.
	 *
	 * @param amfArticleId the amf article ID
	 * @return the number of matching amf articles
	 */
	public int countByArticleId(long amfArticleId);

	/**
	 * Caches the amf article in the entity cache if it is enabled.
	 *
	 * @param amfArticle the amf article
	 */
	public void cacheResult(AMFArticle amfArticle);

	/**
	 * Caches the amf articles in the entity cache if it is enabled.
	 *
	 * @param amfArticles the amf articles
	 */
	public void cacheResult(java.util.List<AMFArticle> amfArticles);

	/**
	 * Creates a new amf article with the primary key. Does not add the amf article to the database.
	 *
	 * @param amfArticleId the primary key for the new amf article
	 * @return the new amf article
	 */
	public AMFArticle create(long amfArticleId);

	/**
	 * Removes the amf article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfArticleId the primary key of the amf article
	 * @return the amf article that was removed
	 * @throws NoSuchAMFArticleException if a amf article with the primary key could not be found
	 */
	public AMFArticle remove(long amfArticleId)
		throws NoSuchAMFArticleException;

	public AMFArticle updateImpl(AMFArticle amfArticle);

	/**
	 * Returns the amf article with the primary key or throws a <code>NoSuchAMFArticleException</code> if it could not be found.
	 *
	 * @param amfArticleId the primary key of the amf article
	 * @return the amf article
	 * @throws NoSuchAMFArticleException if a amf article with the primary key could not be found
	 */
	public AMFArticle findByPrimaryKey(long amfArticleId)
		throws NoSuchAMFArticleException;

	/**
	 * Returns the amf article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfArticleId the primary key of the amf article
	 * @return the amf article, or <code>null</code> if a amf article with the primary key could not be found
	 */
	public AMFArticle fetchByPrimaryKey(long amfArticleId);

	/**
	 * Returns all the amf articles.
	 *
	 * @return the amf articles
	 */
	public java.util.List<AMFArticle> findAll();

	/**
	 * Returns a range of all the amf articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @return the range of amf articles
	 */
	public java.util.List<AMFArticle> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the amf articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amf articles
	 */
	public java.util.List<AMFArticle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator);

	/**
	 * Returns an ordered range of all the amf articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of amf articles
	 */
	public java.util.List<AMFArticle> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the amf articles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of amf articles.
	 *
	 * @return the number of amf articles
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of amf issues associated with the amf article.
	 *
	 * @param pk the primary key of the amf article
	 * @return long[] of the primaryKeys of amf issues associated with the amf article
	 */
	public long[] getAMFIssuePrimaryKeys(long pk);

	/**
	 * Returns all the amf article associated with the amf issue.
	 *
	 * @param pk the primary key of the amf issue
	 * @return the amf articles associated with the amf issue
	 */
	public java.util.List<AMFArticle> getAMFIssueAMFArticles(long pk);

	/**
	 * Returns all the amf article associated with the amf issue.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the amf issue
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @return the range of amf articles associated with the amf issue
	 */
	public java.util.List<AMFArticle> getAMFIssueAMFArticles(
		long pk, int start, int end);

	/**
	 * Returns all the amf article associated with the amf issue.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the amf issue
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amf articles associated with the amf issue
	 */
	public java.util.List<AMFArticle> getAMFIssueAMFArticles(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator);

	/**
	 * Returns the number of amf issues associated with the amf article.
	 *
	 * @param pk the primary key of the amf article
	 * @return the number of amf issues associated with the amf article
	 */
	public int getAMFIssuesSize(long pk);

	/**
	 * Returns <code>true</code> if the amf issue is associated with the amf article.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssuePK the primary key of the amf issue
	 * @return <code>true</code> if the amf issue is associated with the amf article; <code>false</code> otherwise
	 */
	public boolean containsAMFIssue(long pk, long amfIssuePK);

	/**
	 * Returns <code>true</code> if the amf article has any amf issues associated with it.
	 *
	 * @param pk the primary key of the amf article to check for associations with amf issues
	 * @return <code>true</code> if the amf article has any amf issues associated with it; <code>false</code> otherwise
	 */
	public boolean containsAMFIssues(long pk);

	/**
	 * Adds an association between the amf article and the amf issue. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssuePK the primary key of the amf issue
	 */
	public void addAMFIssue(long pk, long amfIssuePK);

	/**
	 * Adds an association between the amf article and the amf issue. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssue the amf issue
	 */
	public void addAMFIssue(
		long pk, com.amf.newsletter.model.AMFIssue amfIssue);

	/**
	 * Adds an association between the amf article and the amf issues. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssuePKs the primary keys of the amf issues
	 */
	public void addAMFIssues(long pk, long[] amfIssuePKs);

	/**
	 * Adds an association between the amf article and the amf issues. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssues the amf issues
	 */
	public void addAMFIssues(
		long pk, java.util.List<com.amf.newsletter.model.AMFIssue> amfIssues);

	/**
	 * Clears all associations between the amf article and its amf issues. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article to clear the associated amf issues from
	 */
	public void clearAMFIssues(long pk);

	/**
	 * Removes the association between the amf article and the amf issue. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssuePK the primary key of the amf issue
	 */
	public void removeAMFIssue(long pk, long amfIssuePK);

	/**
	 * Removes the association between the amf article and the amf issue. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssue the amf issue
	 */
	public void removeAMFIssue(
		long pk, com.amf.newsletter.model.AMFIssue amfIssue);

	/**
	 * Removes the association between the amf article and the amf issues. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssuePKs the primary keys of the amf issues
	 */
	public void removeAMFIssues(long pk, long[] amfIssuePKs);

	/**
	 * Removes the association between the amf article and the amf issues. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssues the amf issues
	 */
	public void removeAMFIssues(
		long pk, java.util.List<com.amf.newsletter.model.AMFIssue> amfIssues);

	/**
	 * Sets the amf issues associated with the amf article, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssuePKs the primary keys of the amf issues to be associated with the amf article
	 */
	public void setAMFIssues(long pk, long[] amfIssuePKs);

	/**
	 * Sets the amf issues associated with the amf article, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssues the amf issues to be associated with the amf article
	 */
	public void setAMFIssues(
		long pk, java.util.List<com.amf.newsletter.model.AMFIssue> amfIssues);

}