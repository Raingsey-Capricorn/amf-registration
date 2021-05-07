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

package com.amf.newsletters.service.persistence;

import com.amf.newsletters.model.Articles;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the articles service. This utility wraps <code>com.amf.newsletters.service.persistence.impl.ArticlesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticlesPersistence
 * @generated
 */
public class ArticlesUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Articles articles) {
		getPersistence().clearCache(articles);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Articles> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Articles> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Articles> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Articles> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Articles> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Articles update(Articles articles) {
		return getPersistence().update(articles);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Articles update(
		Articles articles, ServiceContext serviceContext) {

		return getPersistence().update(articles, serviceContext);
	}

	/**
	 * Returns all the articleses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching articleses
	 */
	public static List<Articles> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Articles> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Articles> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Articles> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Articles> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Articles> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first articles in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching articles
	 * @throws NoSuchArticlesException if a matching articles could not be found
	 */
	public static Articles findByUuid_First(
			String uuid, OrderByComparator<Articles> orderByComparator)
		throws com.amf.newsletters.exception.NoSuchArticlesException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first articles in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching articles, or <code>null</code> if a matching articles could not be found
	 */
	public static Articles fetchByUuid_First(
		String uuid, OrderByComparator<Articles> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last articles in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching articles
	 * @throws NoSuchArticlesException if a matching articles could not be found
	 */
	public static Articles findByUuid_Last(
			String uuid, OrderByComparator<Articles> orderByComparator)
		throws com.amf.newsletters.exception.NoSuchArticlesException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last articles in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching articles, or <code>null</code> if a matching articles could not be found
	 */
	public static Articles fetchByUuid_Last(
		String uuid, OrderByComparator<Articles> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the articleses before and after the current articles in the ordered set where uuid = &#63;.
	 *
	 * @param articleId the primary key of the current articles
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next articles
	 * @throws NoSuchArticlesException if a articles with the primary key could not be found
	 */
	public static Articles[] findByUuid_PrevAndNext(
			long articleId, String uuid,
			OrderByComparator<Articles> orderByComparator)
		throws com.amf.newsletters.exception.NoSuchArticlesException {

		return getPersistence().findByUuid_PrevAndNext(
			articleId, uuid, orderByComparator);
	}

	/**
	 * Removes all the articleses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of articleses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching articleses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the articleses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching articleses
	 */
	public static List<Articles> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Articles> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Articles> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Articles> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Articles> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Articles> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first articles in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching articles
	 * @throws NoSuchArticlesException if a matching articles could not be found
	 */
	public static Articles findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Articles> orderByComparator)
		throws com.amf.newsletters.exception.NoSuchArticlesException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first articles in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching articles, or <code>null</code> if a matching articles could not be found
	 */
	public static Articles fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Articles> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last articles in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching articles
	 * @throws NoSuchArticlesException if a matching articles could not be found
	 */
	public static Articles findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Articles> orderByComparator)
		throws com.amf.newsletters.exception.NoSuchArticlesException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last articles in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching articles, or <code>null</code> if a matching articles could not be found
	 */
	public static Articles fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Articles> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static Articles[] findByUuid_C_PrevAndNext(
			long articleId, String uuid, long companyId,
			OrderByComparator<Articles> orderByComparator)
		throws com.amf.newsletters.exception.NoSuchArticlesException {

		return getPersistence().findByUuid_C_PrevAndNext(
			articleId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the articleses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of articleses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching articleses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the articleses where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the matching articleses
	 */
	public static List<Articles> findByArticleId(long articleId) {
		return getPersistence().findByArticleId(articleId);
	}

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
	public static List<Articles> findByArticleId(
		long articleId, int start, int end) {

		return getPersistence().findByArticleId(articleId, start, end);
	}

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
	public static List<Articles> findByArticleId(
		long articleId, int start, int end,
		OrderByComparator<Articles> orderByComparator) {

		return getPersistence().findByArticleId(
			articleId, start, end, orderByComparator);
	}

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
	public static List<Articles> findByArticleId(
		long articleId, int start, int end,
		OrderByComparator<Articles> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByArticleId(
			articleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first articles in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching articles
	 * @throws NoSuchArticlesException if a matching articles could not be found
	 */
	public static Articles findByArticleId_First(
			long articleId, OrderByComparator<Articles> orderByComparator)
		throws com.amf.newsletters.exception.NoSuchArticlesException {

		return getPersistence().findByArticleId_First(
			articleId, orderByComparator);
	}

	/**
	 * Returns the first articles in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching articles, or <code>null</code> if a matching articles could not be found
	 */
	public static Articles fetchByArticleId_First(
		long articleId, OrderByComparator<Articles> orderByComparator) {

		return getPersistence().fetchByArticleId_First(
			articleId, orderByComparator);
	}

	/**
	 * Returns the last articles in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching articles
	 * @throws NoSuchArticlesException if a matching articles could not be found
	 */
	public static Articles findByArticleId_Last(
			long articleId, OrderByComparator<Articles> orderByComparator)
		throws com.amf.newsletters.exception.NoSuchArticlesException {

		return getPersistence().findByArticleId_Last(
			articleId, orderByComparator);
	}

	/**
	 * Returns the last articles in the ordered set where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching articles, or <code>null</code> if a matching articles could not be found
	 */
	public static Articles fetchByArticleId_Last(
		long articleId, OrderByComparator<Articles> orderByComparator) {

		return getPersistence().fetchByArticleId_Last(
			articleId, orderByComparator);
	}

	/**
	 * Removes all the articleses where articleId = &#63; from the database.
	 *
	 * @param articleId the article ID
	 */
	public static void removeByArticleId(long articleId) {
		getPersistence().removeByArticleId(articleId);
	}

	/**
	 * Returns the number of articleses where articleId = &#63;.
	 *
	 * @param articleId the article ID
	 * @return the number of matching articleses
	 */
	public static int countByArticleId(long articleId) {
		return getPersistence().countByArticleId(articleId);
	}

	/**
	 * Caches the articles in the entity cache if it is enabled.
	 *
	 * @param articles the articles
	 */
	public static void cacheResult(Articles articles) {
		getPersistence().cacheResult(articles);
	}

	/**
	 * Caches the articleses in the entity cache if it is enabled.
	 *
	 * @param articleses the articleses
	 */
	public static void cacheResult(List<Articles> articleses) {
		getPersistence().cacheResult(articleses);
	}

	/**
	 * Creates a new articles with the primary key. Does not add the articles to the database.
	 *
	 * @param articleId the primary key for the new articles
	 * @return the new articles
	 */
	public static Articles create(long articleId) {
		return getPersistence().create(articleId);
	}

	/**
	 * Removes the articles with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleId the primary key of the articles
	 * @return the articles that was removed
	 * @throws NoSuchArticlesException if a articles with the primary key could not be found
	 */
	public static Articles remove(long articleId)
		throws com.amf.newsletters.exception.NoSuchArticlesException {

		return getPersistence().remove(articleId);
	}

	public static Articles updateImpl(Articles articles) {
		return getPersistence().updateImpl(articles);
	}

	/**
	 * Returns the articles with the primary key or throws a <code>NoSuchArticlesException</code> if it could not be found.
	 *
	 * @param articleId the primary key of the articles
	 * @return the articles
	 * @throws NoSuchArticlesException if a articles with the primary key could not be found
	 */
	public static Articles findByPrimaryKey(long articleId)
		throws com.amf.newsletters.exception.NoSuchArticlesException {

		return getPersistence().findByPrimaryKey(articleId);
	}

	/**
	 * Returns the articles with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articleId the primary key of the articles
	 * @return the articles, or <code>null</code> if a articles with the primary key could not be found
	 */
	public static Articles fetchByPrimaryKey(long articleId) {
		return getPersistence().fetchByPrimaryKey(articleId);
	}

	/**
	 * Returns all the articleses.
	 *
	 * @return the articleses
	 */
	public static List<Articles> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Articles> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Articles> findAll(
		int start, int end, OrderByComparator<Articles> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Articles> findAll(
		int start, int end, OrderByComparator<Articles> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the articleses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of articleses.
	 *
	 * @return the number of articleses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ArticlesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ArticlesPersistence, ArticlesPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ArticlesPersistence.class);

		ServiceTracker<ArticlesPersistence, ArticlesPersistence>
			serviceTracker =
				new ServiceTracker<ArticlesPersistence, ArticlesPersistence>(
					bundle.getBundleContext(), ArticlesPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}