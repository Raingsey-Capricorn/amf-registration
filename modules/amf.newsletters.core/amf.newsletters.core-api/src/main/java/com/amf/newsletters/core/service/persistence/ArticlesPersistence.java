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

package com.amf.newsletters.core.service.persistence;

import com.amf.newsletters.core.exception.NoSuchArticlesException;
import com.amf.newsletters.core.model.Articles;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the articles service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticlesUtil
 * @generated
 */
@ProviderType
public interface ArticlesPersistence extends BasePersistence<Articles> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ArticlesUtil} to access the articles persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the articleses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching articleses
	 */
	public java.util.List<Articles> findByUuid(String uuid);

	/**
	 * Returns a range of all the articleses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticlesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of articleses
	 * @param end the upper bound of the range of articleses (not inclusive)
	 * @return the range of matching articleses
	 */
	public java.util.List<Articles> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the articleses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticlesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of articleses
	 * @param end the upper bound of the range of articleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articleses
	 */
	public java.util.List<Articles> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Articles>
			orderByComparator);

	/**
	 * Returns an ordered range of all the articleses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticlesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of articleses
	 * @param end the upper bound of the range of articleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching articleses
	 */
	public java.util.List<Articles> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Articles>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first articles in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching articles
	 * @throws NoSuchArticlesException if a matching articles could not be found
	 */
	public Articles findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Articles>
				orderByComparator)
		throws NoSuchArticlesException;

	/**
	 * Returns the first articles in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching articles, or <code>null</code> if a matching articles could not be found
	 */
	public Articles fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Articles>
			orderByComparator);

	/**
	 * Returns the last articles in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching articles
	 * @throws NoSuchArticlesException if a matching articles could not be found
	 */
	public Articles findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Articles>
				orderByComparator)
		throws NoSuchArticlesException;

	/**
	 * Returns the last articles in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching articles, or <code>null</code> if a matching articles could not be found
	 */
	public Articles fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Articles>
			orderByComparator);

	/**
	 * Returns the articleses before and after the current articles in the ordered set where uuid = &#63;.
	 *
	 * @param articleId the primary key of the current articles
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next articles
	 * @throws NoSuchArticlesException if a articles with the primary key could not be found
	 */
	public Articles[] findByUuid_PrevAndNext(
			long articleId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Articles>
				orderByComparator)
		throws NoSuchArticlesException;

	/**
	 * Removes all the articleses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of articleses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching articleses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the articleses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching articleses
	 */
	public java.util.List<Articles> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the articleses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticlesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of articleses
	 * @param end the upper bound of the range of articleses (not inclusive)
	 * @return the range of matching articleses
	 */
	public java.util.List<Articles> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the articleses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticlesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of articleses
	 * @param end the upper bound of the range of articleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articleses
	 */
	public java.util.List<Articles> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Articles>
			orderByComparator);

	/**
	 * Returns an ordered range of all the articleses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticlesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of articleses
	 * @param end the upper bound of the range of articleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching articleses
	 */
	public java.util.List<Articles> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Articles>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first articles in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching articles
	 * @throws NoSuchArticlesException if a matching articles could not be found
	 */
	public Articles findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Articles>
				orderByComparator)
		throws NoSuchArticlesException;

	/**
	 * Returns the first articles in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching articles, or <code>null</code> if a matching articles could not be found
	 */
	public Articles fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Articles>
			orderByComparator);

	/**
	 * Returns the last articles in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching articles
	 * @throws NoSuchArticlesException if a matching articles could not be found
	 */
	public Articles findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Articles>
				orderByComparator)
		throws NoSuchArticlesException;

	/**
	 * Returns the last articles in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching articles, or <code>null</code> if a matching articles could not be found
	 */
	public Articles fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Articles>
			orderByComparator);

	/**
	 * Returns the articleses before and after the current articles in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param articleId the primary key of the current articles
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next articles
	 * @throws NoSuchArticlesException if a articles with the primary key could not be found
	 */
	public Articles[] findByUuid_C_PrevAndNext(
			long articleId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Articles>
				orderByComparator)
		throws NoSuchArticlesException;

	/**
	 * Removes all the articleses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of articleses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching articleses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the articleses where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching articleses
	 */
	public java.util.List<Articles> findByArticleId(long articleId);

	/**
	 * Returns a range of all the articleses where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticlesModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of articleses
	 * @param end the upper bound of the range of articleses (not inclusive)
	 * @return the range of matching articleses
	 */
	public java.util.List<Articles> findByArticleId(
		long articleId, int start, int end);

	/**
	 * Returns an ordered range of all the articleses where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticlesModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of articleses
	 * @param end the upper bound of the range of articleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching articleses
	 */
	public java.util.List<Articles> findByArticleId(
		long articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Articles>
			orderByComparator);

	/**
	 * Returns an ordered range of all the articleses where articleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticlesModelImpl</code>.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param start the lower bound of the range of articleses
	 * @param end the upper bound of the range of articleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching articleses
	 */
	public java.util.List<Articles> findByArticleId(
		long articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Articles>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first articles in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching articles
	 * @throws NoSuchArticlesException if a matching articles could not be found
	 */
	public Articles findByArticleId_First(
			long articleId,
			com.liferay.portal.kernel.util.OrderByComparator<Articles>
				orderByComparator)
		throws NoSuchArticlesException;

	/**
	 * Returns the first articles in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching articles, or <code>null</code> if a matching articles could not be found
	 */
	public Articles fetchByArticleId_First(
		long articleId,
		com.liferay.portal.kernel.util.OrderByComparator<Articles>
			orderByComparator);

	/**
	 * Returns the last articles in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching articles
	 * @throws NoSuchArticlesException if a matching articles could not be found
	 */
	public Articles findByArticleId_Last(
			long articleId,
			com.liferay.portal.kernel.util.OrderByComparator<Articles>
				orderByComparator)
		throws NoSuchArticlesException;

	/**
	 * Returns the last articles in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching articles, or <code>null</code> if a matching articles could not be found
	 */
	public Articles fetchByArticleId_Last(
		long articleId,
		com.liferay.portal.kernel.util.OrderByComparator<Articles>
			orderByComparator);

	/**
	 * Removes all the articleses where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 */
	public void removeByArticleId(long articleId);

	/**
	 * Returns the number of articleses where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching articleses
	 */
	public int countByArticleId(long articleId);

	/**
	 * Caches the articles in the entity cache if it is enabled.
	 *
	 * @param articles the articles
	 */
	public void cacheResult(Articles articles);

	/**
	 * Caches the articleses in the entity cache if it is enabled.
	 *
	 * @param articleses the articleses
	 */
	public void cacheResult(java.util.List<Articles> articleses);

	/**
	 * Creates a new articles with the primary key. Does not add the articles to the database.
	 *
	 * @param articleId the primary key for the new articles
	 * @return the new articles
	 */
	public Articles create(long articleId);

	/**
	 * Removes the articles with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleId the primary key of the articles
	 * @return the articles that was removed
	 * @throws NoSuchArticlesException if a articles with the primary key could not be found
	 */
	public Articles remove(long articleId) throws NoSuchArticlesException;

	public Articles updateImpl(Articles articles);

	/**
	 * Returns the articles with the primary key or throws a <code>NoSuchArticlesException</code> if it could not be found.
	 *
	 * @param articleId the primary key of the articles
	 * @return the articles
	 * @throws NoSuchArticlesException if a articles with the primary key could not be found
	 */
	public Articles findByPrimaryKey(long articleId)
		throws NoSuchArticlesException;

	/**
	 * Returns the articles with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articleId the primary key of the articles
	 * @return the articles, or <code>null</code> if a articles with the primary key could not be found
	 */
	public Articles fetchByPrimaryKey(long articleId);

	/**
	 * Returns all the articleses.
	 *
	 * @return the articleses
	 */
	public java.util.List<Articles> findAll();

	/**
	 * Returns a range of all the articleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticlesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articleses
	 * @param end the upper bound of the range of articleses (not inclusive)
	 * @return the range of articleses
	 */
	public java.util.List<Articles> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the articleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticlesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articleses
	 * @param end the upper bound of the range of articleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of articleses
	 */
	public java.util.List<Articles> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Articles>
			orderByComparator);

	/**
	 * Returns an ordered range of all the articleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArticlesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of articleses
	 * @param end the upper bound of the range of articleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of articleses
	 */
	public java.util.List<Articles> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Articles>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the articleses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of articleses.
	 *
	 * @return the number of articleses
	 */
	public int countAll();

}