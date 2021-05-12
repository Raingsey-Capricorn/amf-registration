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
	 * @param amfarticleId the primary key of the current amf article
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf article
	 * @throws NoSuchAMFArticleException if a amf article with the primary key could not be found
	 */
	public AMFArticle[] findByUuid_PrevAndNext(
			long amfarticleId, String uuid,
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
	 * @param amfarticleId the primary key of the current amf article
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf article
	 * @throws NoSuchAMFArticleException if a amf article with the primary key could not be found
	 */
	public AMFArticle[] findByUuid_C_PrevAndNext(
			long amfarticleId, String uuid, long companyId,
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
	 * Returns all the amf articles where amfarticleId = &#63;.
	 *
	 * @param amfarticleId the amfarticle ID
	 * @return the matching amf articles
	 */
	public java.util.List<AMFArticle> findByArticleId(long amfarticleId);

	/**
	 * Returns a range of all the amf articles where amfarticleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param amfarticleId the amfarticle ID
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @return the range of matching amf articles
	 */
	public java.util.List<AMFArticle> findByArticleId(
		long amfarticleId, int start, int end);

	/**
	 * Returns an ordered range of all the amf articles where amfarticleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param amfarticleId the amfarticle ID
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf articles
	 */
	public java.util.List<AMFArticle> findByArticleId(
		long amfarticleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator);

	/**
	 * Returns an ordered range of all the amf articles where amfarticleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFArticleModelImpl</code>.
	 * </p>
	 *
	 * @param amfarticleId the amfarticle ID
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf articles
	 */
	public java.util.List<AMFArticle> findByArticleId(
		long amfarticleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf article in the ordered set where amfarticleId = &#63;.
	 *
	 * @param amfarticleId the amfarticle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf article
	 * @throws NoSuchAMFArticleException if a matching amf article could not be found
	 */
	public AMFArticle findByArticleId_First(
			long amfarticleId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
				orderByComparator)
		throws NoSuchAMFArticleException;

	/**
	 * Returns the first amf article in the ordered set where amfarticleId = &#63;.
	 *
	 * @param amfarticleId the amfarticle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	public AMFArticle fetchByArticleId_First(
		long amfarticleId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator);

	/**
	 * Returns the last amf article in the ordered set where amfarticleId = &#63;.
	 *
	 * @param amfarticleId the amfarticle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf article
	 * @throws NoSuchAMFArticleException if a matching amf article could not be found
	 */
	public AMFArticle findByArticleId_Last(
			long amfarticleId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
				orderByComparator)
		throws NoSuchAMFArticleException;

	/**
	 * Returns the last amf article in the ordered set where amfarticleId = &#63;.
	 *
	 * @param amfarticleId the amfarticle ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	public AMFArticle fetchByArticleId_Last(
		long amfarticleId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFArticle>
			orderByComparator);

	/**
	 * Removes all the amf articles where amfarticleId = &#63; from the database.
	 *
	 * @param amfarticleId the amfarticle ID
	 */
	public void removeByArticleId(long amfarticleId);

	/**
	 * Returns the number of amf articles where amfarticleId = &#63;.
	 *
	 * @param amfarticleId the amfarticle ID
	 * @return the number of matching amf articles
	 */
	public int countByArticleId(long amfarticleId);

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
	 * @param amfarticleId the primary key for the new amf article
	 * @return the new amf article
	 */
	public AMFArticle create(long amfarticleId);

	/**
	 * Removes the amf article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfarticleId the primary key of the amf article
	 * @return the amf article that was removed
	 * @throws NoSuchAMFArticleException if a amf article with the primary key could not be found
	 */
	public AMFArticle remove(long amfarticleId)
		throws NoSuchAMFArticleException;

	public AMFArticle updateImpl(AMFArticle amfArticle);

	/**
	 * Returns the amf article with the primary key or throws a <code>NoSuchAMFArticleException</code> if it could not be found.
	 *
	 * @param amfarticleId the primary key of the amf article
	 * @return the amf article
	 * @throws NoSuchAMFArticleException if a amf article with the primary key could not be found
	 */
	public AMFArticle findByPrimaryKey(long amfarticleId)
		throws NoSuchAMFArticleException;

	/**
	 * Returns the amf article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfarticleId the primary key of the amf article
	 * @return the amf article, or <code>null</code> if a amf article with the primary key could not be found
	 */
	public AMFArticle fetchByPrimaryKey(long amfarticleId);

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

}