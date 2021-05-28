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

import com.amf.newsletter.model.AMFArticle;

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
 * The persistence utility for the amf article service. This utility wraps <code>com.amf.newsletter.service.persistence.impl.AMFArticlePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFArticlePersistence
 * @generated
 */
public class AMFArticleUtil {

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
	public static void clearCache(AMFArticle amfArticle) {
		getPersistence().clearCache(amfArticle);
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
	public static Map<Serializable, AMFArticle> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AMFArticle> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AMFArticle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AMFArticle> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AMFArticle> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AMFArticle update(AMFArticle amfArticle) {
		return getPersistence().update(amfArticle);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AMFArticle update(
		AMFArticle amfArticle, ServiceContext serviceContext) {

		return getPersistence().update(amfArticle, serviceContext);
	}

	/**
	 * Returns all the amf articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amf articles
	 */
	public static List<AMFArticle> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<AMFArticle> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<AMFArticle> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFArticle> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<AMFArticle> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFArticle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf article
	 * @throws NoSuchAMFArticleException if a matching amf article could not be found
	 */
	public static AMFArticle findByUuid_First(
			String uuid, OrderByComparator<AMFArticle> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFArticleException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first amf article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	public static AMFArticle fetchByUuid_First(
		String uuid, OrderByComparator<AMFArticle> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last amf article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf article
	 * @throws NoSuchAMFArticleException if a matching amf article could not be found
	 */
	public static AMFArticle findByUuid_Last(
			String uuid, OrderByComparator<AMFArticle> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFArticleException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last amf article in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	public static AMFArticle fetchByUuid_Last(
		String uuid, OrderByComparator<AMFArticle> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the amf articles before and after the current amf article in the ordered set where uuid = &#63;.
	 *
	 * @param amfArticleId the primary key of the current amf article
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf article
	 * @throws NoSuchAMFArticleException if a amf article with the primary key could not be found
	 */
	public static AMFArticle[] findByUuid_PrevAndNext(
			long amfArticleId, String uuid,
			OrderByComparator<AMFArticle> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFArticleException {

		return getPersistence().findByUuid_PrevAndNext(
			amfArticleId, uuid, orderByComparator);
	}

	/**
	 * Removes all the amf articles where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of amf articles where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amf articles
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the amf articles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching amf articles
	 */
	public static List<AMFArticle> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<AMFArticle> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<AMFArticle> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AMFArticle> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<AMFArticle> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AMFArticle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf article
	 * @throws NoSuchAMFArticleException if a matching amf article could not be found
	 */
	public static AMFArticle findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AMFArticle> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFArticleException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first amf article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	public static AMFArticle fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AMFArticle> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last amf article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf article
	 * @throws NoSuchAMFArticleException if a matching amf article could not be found
	 */
	public static AMFArticle findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AMFArticle> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFArticleException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last amf article in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	public static AMFArticle fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AMFArticle> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static AMFArticle[] findByUuid_C_PrevAndNext(
			long amfArticleId, String uuid, long companyId,
			OrderByComparator<AMFArticle> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFArticleException {

		return getPersistence().findByUuid_C_PrevAndNext(
			amfArticleId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the amf articles where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of amf articles where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching amf articles
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the amf articles where amfArticleId = &#63;.
	 *
	 * @param amfArticleId the amf article ID
	 * @return the matching amf articles
	 */
	public static List<AMFArticle> findByArticleId(long amfArticleId) {
		return getPersistence().findByArticleId(amfArticleId);
	}

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
	public static List<AMFArticle> findByArticleId(
		long amfArticleId, int start, int end) {

		return getPersistence().findByArticleId(amfArticleId, start, end);
	}

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
	public static List<AMFArticle> findByArticleId(
		long amfArticleId, int start, int end,
		OrderByComparator<AMFArticle> orderByComparator) {

		return getPersistence().findByArticleId(
			amfArticleId, start, end, orderByComparator);
	}

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
	public static List<AMFArticle> findByArticleId(
		long amfArticleId, int start, int end,
		OrderByComparator<AMFArticle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByArticleId(
			amfArticleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf article in the ordered set where amfArticleId = &#63;.
	 *
	 * @param amfArticleId the amf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf article
	 * @throws NoSuchAMFArticleException if a matching amf article could not be found
	 */
	public static AMFArticle findByArticleId_First(
			long amfArticleId, OrderByComparator<AMFArticle> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFArticleException {

		return getPersistence().findByArticleId_First(
			amfArticleId, orderByComparator);
	}

	/**
	 * Returns the first amf article in the ordered set where amfArticleId = &#63;.
	 *
	 * @param amfArticleId the amf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	public static AMFArticle fetchByArticleId_First(
		long amfArticleId, OrderByComparator<AMFArticle> orderByComparator) {

		return getPersistence().fetchByArticleId_First(
			amfArticleId, orderByComparator);
	}

	/**
	 * Returns the last amf article in the ordered set where amfArticleId = &#63;.
	 *
	 * @param amfArticleId the amf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf article
	 * @throws NoSuchAMFArticleException if a matching amf article could not be found
	 */
	public static AMFArticle findByArticleId_Last(
			long amfArticleId, OrderByComparator<AMFArticle> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFArticleException {

		return getPersistence().findByArticleId_Last(
			amfArticleId, orderByComparator);
	}

	/**
	 * Returns the last amf article in the ordered set where amfArticleId = &#63;.
	 *
	 * @param amfArticleId the amf article ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf article, or <code>null</code> if a matching amf article could not be found
	 */
	public static AMFArticle fetchByArticleId_Last(
		long amfArticleId, OrderByComparator<AMFArticle> orderByComparator) {

		return getPersistence().fetchByArticleId_Last(
			amfArticleId, orderByComparator);
	}

	/**
	 * Removes all the amf articles where amfArticleId = &#63; from the database.
	 *
	 * @param amfArticleId the amf article ID
	 */
	public static void removeByArticleId(long amfArticleId) {
		getPersistence().removeByArticleId(amfArticleId);
	}

	/**
	 * Returns the number of amf articles where amfArticleId = &#63;.
	 *
	 * @param amfArticleId the amf article ID
	 * @return the number of matching amf articles
	 */
	public static int countByArticleId(long amfArticleId) {
		return getPersistence().countByArticleId(amfArticleId);
	}

	/**
	 * Caches the amf article in the entity cache if it is enabled.
	 *
	 * @param amfArticle the amf article
	 */
	public static void cacheResult(AMFArticle amfArticle) {
		getPersistence().cacheResult(amfArticle);
	}

	/**
	 * Caches the amf articles in the entity cache if it is enabled.
	 *
	 * @param amfArticles the amf articles
	 */
	public static void cacheResult(List<AMFArticle> amfArticles) {
		getPersistence().cacheResult(amfArticles);
	}

	/**
	 * Creates a new amf article with the primary key. Does not add the amf article to the database.
	 *
	 * @param amfArticleId the primary key for the new amf article
	 * @return the new amf article
	 */
	public static AMFArticle create(long amfArticleId) {
		return getPersistence().create(amfArticleId);
	}

	/**
	 * Removes the amf article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfArticleId the primary key of the amf article
	 * @return the amf article that was removed
	 * @throws NoSuchAMFArticleException if a amf article with the primary key could not be found
	 */
	public static AMFArticle remove(long amfArticleId)
		throws com.amf.newsletter.exception.NoSuchAMFArticleException {

		return getPersistence().remove(amfArticleId);
	}

	public static AMFArticle updateImpl(AMFArticle amfArticle) {
		return getPersistence().updateImpl(amfArticle);
	}

	/**
	 * Returns the amf article with the primary key or throws a <code>NoSuchAMFArticleException</code> if it could not be found.
	 *
	 * @param amfArticleId the primary key of the amf article
	 * @return the amf article
	 * @throws NoSuchAMFArticleException if a amf article with the primary key could not be found
	 */
	public static AMFArticle findByPrimaryKey(long amfArticleId)
		throws com.amf.newsletter.exception.NoSuchAMFArticleException {

		return getPersistence().findByPrimaryKey(amfArticleId);
	}

	/**
	 * Returns the amf article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfArticleId the primary key of the amf article
	 * @return the amf article, or <code>null</code> if a amf article with the primary key could not be found
	 */
	public static AMFArticle fetchByPrimaryKey(long amfArticleId) {
		return getPersistence().fetchByPrimaryKey(amfArticleId);
	}

	/**
	 * Returns all the amf articles.
	 *
	 * @return the amf articles
	 */
	public static List<AMFArticle> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<AMFArticle> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<AMFArticle> findAll(
		int start, int end, OrderByComparator<AMFArticle> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<AMFArticle> findAll(
		int start, int end, OrderByComparator<AMFArticle> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the amf articles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of amf articles.
	 *
	 * @return the number of amf articles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of amf issues associated with the amf article.
	 *
	 * @param pk the primary key of the amf article
	 * @return long[] of the primaryKeys of amf issues associated with the amf article
	 */
	public static long[] getAMFIssuePrimaryKeys(long pk) {
		return getPersistence().getAMFIssuePrimaryKeys(pk);
	}

	/**
	 * Returns all the amf article associated with the amf issue.
	 *
	 * @param pk the primary key of the amf issue
	 * @return the amf articles associated with the amf issue
	 */
	public static List<AMFArticle> getAMFIssueAMFArticles(long pk) {
		return getPersistence().getAMFIssueAMFArticles(pk);
	}

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
	public static List<AMFArticle> getAMFIssueAMFArticles(
		long pk, int start, int end) {

		return getPersistence().getAMFIssueAMFArticles(pk, start, end);
	}

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
	public static List<AMFArticle> getAMFIssueAMFArticles(
		long pk, int start, int end,
		OrderByComparator<AMFArticle> orderByComparator) {

		return getPersistence().getAMFIssueAMFArticles(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of amf issues associated with the amf article.
	 *
	 * @param pk the primary key of the amf article
	 * @return the number of amf issues associated with the amf article
	 */
	public static int getAMFIssuesSize(long pk) {
		return getPersistence().getAMFIssuesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the amf issue is associated with the amf article.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssuePK the primary key of the amf issue
	 * @return <code>true</code> if the amf issue is associated with the amf article; <code>false</code> otherwise
	 */
	public static boolean containsAMFIssue(long pk, long amfIssuePK) {
		return getPersistence().containsAMFIssue(pk, amfIssuePK);
	}

	/**
	 * Returns <code>true</code> if the amf article has any amf issues associated with it.
	 *
	 * @param pk the primary key of the amf article to check for associations with amf issues
	 * @return <code>true</code> if the amf article has any amf issues associated with it; <code>false</code> otherwise
	 */
	public static boolean containsAMFIssues(long pk) {
		return getPersistence().containsAMFIssues(pk);
	}

	/**
	 * Adds an association between the amf article and the amf issue. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssuePK the primary key of the amf issue
	 */
	public static void addAMFIssue(long pk, long amfIssuePK) {
		getPersistence().addAMFIssue(pk, amfIssuePK);
	}

	/**
	 * Adds an association between the amf article and the amf issue. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssue the amf issue
	 */
	public static void addAMFIssue(
		long pk, com.amf.newsletter.model.AMFIssue amfIssue) {

		getPersistence().addAMFIssue(pk, amfIssue);
	}

	/**
	 * Adds an association between the amf article and the amf issues. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssuePKs the primary keys of the amf issues
	 */
	public static void addAMFIssues(long pk, long[] amfIssuePKs) {
		getPersistence().addAMFIssues(pk, amfIssuePKs);
	}

	/**
	 * Adds an association between the amf article and the amf issues. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssues the amf issues
	 */
	public static void addAMFIssues(
		long pk, List<com.amf.newsletter.model.AMFIssue> amfIssues) {

		getPersistence().addAMFIssues(pk, amfIssues);
	}

	/**
	 * Clears all associations between the amf article and its amf issues. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article to clear the associated amf issues from
	 */
	public static void clearAMFIssues(long pk) {
		getPersistence().clearAMFIssues(pk);
	}

	/**
	 * Removes the association between the amf article and the amf issue. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssuePK the primary key of the amf issue
	 */
	public static void removeAMFIssue(long pk, long amfIssuePK) {
		getPersistence().removeAMFIssue(pk, amfIssuePK);
	}

	/**
	 * Removes the association between the amf article and the amf issue. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssue the amf issue
	 */
	public static void removeAMFIssue(
		long pk, com.amf.newsletter.model.AMFIssue amfIssue) {

		getPersistence().removeAMFIssue(pk, amfIssue);
	}

	/**
	 * Removes the association between the amf article and the amf issues. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssuePKs the primary keys of the amf issues
	 */
	public static void removeAMFIssues(long pk, long[] amfIssuePKs) {
		getPersistence().removeAMFIssues(pk, amfIssuePKs);
	}

	/**
	 * Removes the association between the amf article and the amf issues. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssues the amf issues
	 */
	public static void removeAMFIssues(
		long pk, List<com.amf.newsletter.model.AMFIssue> amfIssues) {

		getPersistence().removeAMFIssues(pk, amfIssues);
	}

	/**
	 * Sets the amf issues associated with the amf article, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssuePKs the primary keys of the amf issues to be associated with the amf article
	 */
	public static void setAMFIssues(long pk, long[] amfIssuePKs) {
		getPersistence().setAMFIssues(pk, amfIssuePKs);
	}

	/**
	 * Sets the amf issues associated with the amf article, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf article
	 * @param amfIssues the amf issues to be associated with the amf article
	 */
	public static void setAMFIssues(
		long pk, List<com.amf.newsletter.model.AMFIssue> amfIssues) {

		getPersistence().setAMFIssues(pk, amfIssues);
	}

	public static AMFArticlePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AMFArticlePersistence, AMFArticlePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AMFArticlePersistence.class);

		ServiceTracker<AMFArticlePersistence, AMFArticlePersistence>
			serviceTracker =
				new ServiceTracker
					<AMFArticlePersistence, AMFArticlePersistence>(
						bundle.getBundleContext(), AMFArticlePersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}