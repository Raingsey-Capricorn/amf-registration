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

import com.amf.newsletter.model.AMFIssue;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the amf issue service. This utility wraps <code>com.amf.newsletter.service.persistence.impl.AMFIssuePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFIssuePersistence
 * @generated
 */
public class AMFIssueUtil {

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
	public static void clearCache(AMFIssue amfIssue) {
		getPersistence().clearCache(amfIssue);
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
	public static Map<Serializable, AMFIssue> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AMFIssue> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AMFIssue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AMFIssue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AMFIssue update(AMFIssue amfIssue) {
		return getPersistence().update(amfIssue);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AMFIssue update(
		AMFIssue amfIssue, ServiceContext serviceContext) {

		return getPersistence().update(amfIssue, serviceContext);
	}

	/**
	 * Returns all the amf issues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amf issues
	 */
	public static List<AMFIssue> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the amf issues where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @return the range of matching amf issues
	 */
	public static List<AMFIssue> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the amf issues where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf issues
	 */
	public static List<AMFIssue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf issues where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf issues
	 */
	public static List<AMFIssue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public static AMFIssue findByUuid_First(
			String uuid, OrderByComparator<AMFIssue> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first amf issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public static AMFIssue fetchByUuid_First(
		String uuid, OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last amf issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public static AMFIssue findByUuid_Last(
			String uuid, OrderByComparator<AMFIssue> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last amf issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public static AMFIssue fetchByUuid_Last(
		String uuid, OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the amf issues before and after the current amf issue in the ordered set where uuid = &#63;.
	 *
	 * @param amfIssueId the primary key of the current amf issue
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public static AMFIssue[] findByUuid_PrevAndNext(
			long amfIssueId, String uuid,
			OrderByComparator<AMFIssue> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByUuid_PrevAndNext(
			amfIssueId, uuid, orderByComparator);
	}

	/**
	 * Removes all the amf issues where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of amf issues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amf issues
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the amf issue where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAMFIssueException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public static AMFIssue findByUUID_G(String uuid, long groupId)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the amf issue where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public static AMFIssue fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the amf issue where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public static AMFIssue fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the amf issue where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the amf issue that was removed
	 */
	public static AMFIssue removeByUUID_G(String uuid, long groupId)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of amf issues where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching amf issues
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the amf issues where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching amf issues
	 */
	public static List<AMFIssue> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the amf issues where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @return the range of matching amf issues
	 */
	public static List<AMFIssue> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the amf issues where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf issues
	 */
	public static List<AMFIssue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf issues where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf issues
	 */
	public static List<AMFIssue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public static AMFIssue findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AMFIssue> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first amf issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public static AMFIssue fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last amf issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public static AMFIssue findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AMFIssue> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last amf issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public static AMFIssue fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the amf issues before and after the current amf issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param amfIssueId the primary key of the current amf issue
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public static AMFIssue[] findByUuid_C_PrevAndNext(
			long amfIssueId, String uuid, long companyId,
			OrderByComparator<AMFIssue> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByUuid_C_PrevAndNext(
			amfIssueId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the amf issues where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of amf issues where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching amf issues
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the amf issues where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @return the matching amf issues
	 */
	public static List<AMFIssue> findByAMFIssueId(long amfIssueId) {
		return getPersistence().findByAMFIssueId(amfIssueId);
	}

	/**
	 * Returns a range of all the amf issues where amfIssueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param amfIssueId the amf issue ID
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @return the range of matching amf issues
	 */
	public static List<AMFIssue> findByAMFIssueId(
		long amfIssueId, int start, int end) {

		return getPersistence().findByAMFIssueId(amfIssueId, start, end);
	}

	/**
	 * Returns an ordered range of all the amf issues where amfIssueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param amfIssueId the amf issue ID
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf issues
	 */
	public static List<AMFIssue> findByAMFIssueId(
		long amfIssueId, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().findByAMFIssueId(
			amfIssueId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf issues where amfIssueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param amfIssueId the amf issue ID
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf issues
	 */
	public static List<AMFIssue> findByAMFIssueId(
		long amfIssueId, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByAMFIssueId(
			amfIssueId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf issue in the ordered set where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public static AMFIssue findByAMFIssueId_First(
			long amfIssueId, OrderByComparator<AMFIssue> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByAMFIssueId_First(
			amfIssueId, orderByComparator);
	}

	/**
	 * Returns the first amf issue in the ordered set where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public static AMFIssue fetchByAMFIssueId_First(
		long amfIssueId, OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().fetchByAMFIssueId_First(
			amfIssueId, orderByComparator);
	}

	/**
	 * Returns the last amf issue in the ordered set where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public static AMFIssue findByAMFIssueId_Last(
			long amfIssueId, OrderByComparator<AMFIssue> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByAMFIssueId_Last(
			amfIssueId, orderByComparator);
	}

	/**
	 * Returns the last amf issue in the ordered set where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public static AMFIssue fetchByAMFIssueId_Last(
		long amfIssueId, OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().fetchByAMFIssueId_Last(
			amfIssueId, orderByComparator);
	}

	/**
	 * Removes all the amf issues where amfIssueId = &#63; from the database.
	 *
	 * @param amfIssueId the amf issue ID
	 */
	public static void removeByAMFIssueId(long amfIssueId) {
		getPersistence().removeByAMFIssueId(amfIssueId);
	}

	/**
	 * Returns the number of amf issues where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @return the number of matching amf issues
	 */
	public static int countByAMFIssueId(long amfIssueId) {
		return getPersistence().countByAMFIssueId(amfIssueId);
	}

	/**
	 * Returns all the amf issues where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @return the matching amf issues
	 */
	public static List<AMFIssue> findByAMFIssueDate(Date issueDate) {
		return getPersistence().findByAMFIssueDate(issueDate);
	}

	/**
	 * Returns a range of all the amf issues where issueDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param issueDate the issue date
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @return the range of matching amf issues
	 */
	public static List<AMFIssue> findByAMFIssueDate(
		Date issueDate, int start, int end) {

		return getPersistence().findByAMFIssueDate(issueDate, start, end);
	}

	/**
	 * Returns an ordered range of all the amf issues where issueDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param issueDate the issue date
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf issues
	 */
	public static List<AMFIssue> findByAMFIssueDate(
		Date issueDate, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().findByAMFIssueDate(
			issueDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf issues where issueDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param issueDate the issue date
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf issues
	 */
	public static List<AMFIssue> findByAMFIssueDate(
		Date issueDate, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByAMFIssueDate(
			issueDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf issue in the ordered set where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public static AMFIssue findByAMFIssueDate_First(
			Date issueDate, OrderByComparator<AMFIssue> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByAMFIssueDate_First(
			issueDate, orderByComparator);
	}

	/**
	 * Returns the first amf issue in the ordered set where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public static AMFIssue fetchByAMFIssueDate_First(
		Date issueDate, OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().fetchByAMFIssueDate_First(
			issueDate, orderByComparator);
	}

	/**
	 * Returns the last amf issue in the ordered set where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public static AMFIssue findByAMFIssueDate_Last(
			Date issueDate, OrderByComparator<AMFIssue> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByAMFIssueDate_Last(
			issueDate, orderByComparator);
	}

	/**
	 * Returns the last amf issue in the ordered set where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public static AMFIssue fetchByAMFIssueDate_Last(
		Date issueDate, OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().fetchByAMFIssueDate_Last(
			issueDate, orderByComparator);
	}

	/**
	 * Returns the amf issues before and after the current amf issue in the ordered set where issueDate = &#63;.
	 *
	 * @param amfIssueId the primary key of the current amf issue
	 * @param issueDate the issue date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public static AMFIssue[] findByAMFIssueDate_PrevAndNext(
			long amfIssueId, Date issueDate,
			OrderByComparator<AMFIssue> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByAMFIssueDate_PrevAndNext(
			amfIssueId, issueDate, orderByComparator);
	}

	/**
	 * Removes all the amf issues where issueDate = &#63; from the database.
	 *
	 * @param issueDate the issue date
	 */
	public static void removeByAMFIssueDate(Date issueDate) {
		getPersistence().removeByAMFIssueDate(issueDate);
	}

	/**
	 * Returns the number of amf issues where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @return the number of matching amf issues
	 */
	public static int countByAMFIssueDate(Date issueDate) {
		return getPersistence().countByAMFIssueDate(issueDate);
	}

	/**
	 * Caches the amf issue in the entity cache if it is enabled.
	 *
	 * @param amfIssue the amf issue
	 */
	public static void cacheResult(AMFIssue amfIssue) {
		getPersistence().cacheResult(amfIssue);
	}

	/**
	 * Caches the amf issues in the entity cache if it is enabled.
	 *
	 * @param amfIssues the amf issues
	 */
	public static void cacheResult(List<AMFIssue> amfIssues) {
		getPersistence().cacheResult(amfIssues);
	}

	/**
	 * Creates a new amf issue with the primary key. Does not add the amf issue to the database.
	 *
	 * @param amfIssueId the primary key for the new amf issue
	 * @return the new amf issue
	 */
	public static AMFIssue create(long amfIssueId) {
		return getPersistence().create(amfIssueId);
	}

	/**
	 * Removes the amf issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfIssueId the primary key of the amf issue
	 * @return the amf issue that was removed
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public static AMFIssue remove(long amfIssueId)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().remove(amfIssueId);
	}

	public static AMFIssue updateImpl(AMFIssue amfIssue) {
		return getPersistence().updateImpl(amfIssue);
	}

	/**
	 * Returns the amf issue with the primary key or throws a <code>NoSuchAMFIssueException</code> if it could not be found.
	 *
	 * @param amfIssueId the primary key of the amf issue
	 * @return the amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public static AMFIssue findByPrimaryKey(long amfIssueId)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByPrimaryKey(amfIssueId);
	}

	/**
	 * Returns the amf issue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfIssueId the primary key of the amf issue
	 * @return the amf issue, or <code>null</code> if a amf issue with the primary key could not be found
	 */
	public static AMFIssue fetchByPrimaryKey(long amfIssueId) {
		return getPersistence().fetchByPrimaryKey(amfIssueId);
	}

	/**
	 * Returns all the amf issues.
	 *
	 * @return the amf issues
	 */
	public static List<AMFIssue> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the amf issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @return the range of amf issues
	 */
	public static List<AMFIssue> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the amf issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amf issues
	 */
	public static List<AMFIssue> findAll(
		int start, int end, OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of amf issues
	 */
	public static List<AMFIssue> findAll(
		int start, int end, OrderByComparator<AMFIssue> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the amf issues from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of amf issues.
	 *
	 * @return the number of amf issues
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of amf articles associated with the amf issue.
	 *
	 * @param pk the primary key of the amf issue
	 * @return long[] of the primaryKeys of amf articles associated with the amf issue
	 */
	public static long[] getAMFArticlePrimaryKeys(long pk) {
		return getPersistence().getAMFArticlePrimaryKeys(pk);
	}

	/**
	 * Returns all the amf issue associated with the amf article.
	 *
	 * @param pk the primary key of the amf article
	 * @return the amf issues associated with the amf article
	 */
	public static List<AMFIssue> getAMFArticleAMFIssues(long pk) {
		return getPersistence().getAMFArticleAMFIssues(pk);
	}

	/**
	 * Returns all the amf issue associated with the amf article.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the amf article
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @return the range of amf issues associated with the amf article
	 */
	public static List<AMFIssue> getAMFArticleAMFIssues(
		long pk, int start, int end) {

		return getPersistence().getAMFArticleAMFIssues(pk, start, end);
	}

	/**
	 * Returns all the amf issue associated with the amf article.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the amf article
	 * @param start the lower bound of the range of amf articles
	 * @param end the upper bound of the range of amf articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amf issues associated with the amf article
	 */
	public static List<AMFIssue> getAMFArticleAMFIssues(
		long pk, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().getAMFArticleAMFIssues(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of amf articles associated with the amf issue.
	 *
	 * @param pk the primary key of the amf issue
	 * @return the number of amf articles associated with the amf issue
	 */
	public static int getAMFArticlesSize(long pk) {
		return getPersistence().getAMFArticlesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the amf article is associated with the amf issue.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePK the primary key of the amf article
	 * @return <code>true</code> if the amf article is associated with the amf issue; <code>false</code> otherwise
	 */
	public static boolean containsAMFArticle(long pk, long amfArticlePK) {
		return getPersistence().containsAMFArticle(pk, amfArticlePK);
	}

	/**
	 * Returns <code>true</code> if the amf issue has any amf articles associated with it.
	 *
	 * @param pk the primary key of the amf issue to check for associations with amf articles
	 * @return <code>true</code> if the amf issue has any amf articles associated with it; <code>false</code> otherwise
	 */
	public static boolean containsAMFArticles(long pk) {
		return getPersistence().containsAMFArticles(pk);
	}

	/**
	 * Adds an association between the amf issue and the amf article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePK the primary key of the amf article
	 */
	public static void addAMFArticle(long pk, long amfArticlePK) {
		getPersistence().addAMFArticle(pk, amfArticlePK);
	}

	/**
	 * Adds an association between the amf issue and the amf article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticle the amf article
	 */
	public static void addAMFArticle(
		long pk, com.amf.newsletter.model.AMFArticle amfArticle) {

		getPersistence().addAMFArticle(pk, amfArticle);
	}

	/**
	 * Adds an association between the amf issue and the amf articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePKs the primary keys of the amf articles
	 */
	public static void addAMFArticles(long pk, long[] amfArticlePKs) {
		getPersistence().addAMFArticles(pk, amfArticlePKs);
	}

	/**
	 * Adds an association between the amf issue and the amf articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticles the amf articles
	 */
	public static void addAMFArticles(
		long pk, List<com.amf.newsletter.model.AMFArticle> amfArticles) {

		getPersistence().addAMFArticles(pk, amfArticles);
	}

	/**
	 * Clears all associations between the amf issue and its amf articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue to clear the associated amf articles from
	 */
	public static void clearAMFArticles(long pk) {
		getPersistence().clearAMFArticles(pk);
	}

	/**
	 * Removes the association between the amf issue and the amf article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePK the primary key of the amf article
	 */
	public static void removeAMFArticle(long pk, long amfArticlePK) {
		getPersistence().removeAMFArticle(pk, amfArticlePK);
	}

	/**
	 * Removes the association between the amf issue and the amf article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticle the amf article
	 */
	public static void removeAMFArticle(
		long pk, com.amf.newsletter.model.AMFArticle amfArticle) {

		getPersistence().removeAMFArticle(pk, amfArticle);
	}

	/**
	 * Removes the association between the amf issue and the amf articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePKs the primary keys of the amf articles
	 */
	public static void removeAMFArticles(long pk, long[] amfArticlePKs) {
		getPersistence().removeAMFArticles(pk, amfArticlePKs);
	}

	/**
	 * Removes the association between the amf issue and the amf articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticles the amf articles
	 */
	public static void removeAMFArticles(
		long pk, List<com.amf.newsletter.model.AMFArticle> amfArticles) {

		getPersistence().removeAMFArticles(pk, amfArticles);
	}

	/**
	 * Sets the amf articles associated with the amf issue, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePKs the primary keys of the amf articles to be associated with the amf issue
	 */
	public static void setAMFArticles(long pk, long[] amfArticlePKs) {
		getPersistence().setAMFArticles(pk, amfArticlePKs);
	}

	/**
	 * Sets the amf articles associated with the amf issue, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticles the amf articles to be associated with the amf issue
	 */
	public static void setAMFArticles(
		long pk, List<com.amf.newsletter.model.AMFArticle> amfArticles) {

		getPersistence().setAMFArticles(pk, amfArticles);
	}

	public static AMFIssuePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AMFIssuePersistence, AMFIssuePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AMFIssuePersistence.class);

		ServiceTracker<AMFIssuePersistence, AMFIssuePersistence>
			serviceTracker =
				new ServiceTracker<AMFIssuePersistence, AMFIssuePersistence>(
					bundle.getBundleContext(), AMFIssuePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}