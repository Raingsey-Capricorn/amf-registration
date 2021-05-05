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

import com.amf.newsletters.core.model.Issues;

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
 * The persistence utility for the issues service. This utility wraps <code>com.amf.newsletters.core.service.persistence.impl.IssuesPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssuesPersistence
 * @generated
 */
public class IssuesUtil {

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
	public static void clearCache(Issues issues) {
		getPersistence().clearCache(issues);
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
	public static Map<Serializable, Issues> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Issues> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Issues> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Issues> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Issues> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Issues update(Issues issues) {
		return getPersistence().update(issues);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Issues update(Issues issues, ServiceContext serviceContext) {
		return getPersistence().update(issues, serviceContext);
	}

	/**
	 * Returns all the issueses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching issueses
	 */
	public static List<Issues> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the issueses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssuesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of issueses
	 * @param end the upper bound of the range of issueses (not inclusive)
	 * @return the range of matching issueses
	 */
	public static List<Issues> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the issueses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssuesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of issueses
	 * @param end the upper bound of the range of issueses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching issueses
	 */
	public static List<Issues> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Issues> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the issueses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssuesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of issueses
	 * @param end the upper bound of the range of issueses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching issueses
	 */
	public static List<Issues> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Issues> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first issues in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	public static Issues findByUuid_First(
			String uuid, OrderByComparator<Issues> orderByComparator)
		throws com.amf.newsletters.core.exception.NoSuchIssuesException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first issues in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public static Issues fetchByUuid_First(
		String uuid, OrderByComparator<Issues> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last issues in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	public static Issues findByUuid_Last(
			String uuid, OrderByComparator<Issues> orderByComparator)
		throws com.amf.newsletters.core.exception.NoSuchIssuesException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last issues in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public static Issues fetchByUuid_Last(
		String uuid, OrderByComparator<Issues> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the issueses before and after the current issues in the ordered set where uuid = &#63;.
	 *
	 * @param issueId the primary key of the current issues
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next issues
	 * @throws NoSuchIssuesException if a issues with the primary key could not be found
	 */
	public static Issues[] findByUuid_PrevAndNext(
			long issueId, String uuid,
			OrderByComparator<Issues> orderByComparator)
		throws com.amf.newsletters.core.exception.NoSuchIssuesException {

		return getPersistence().findByUuid_PrevAndNext(
			issueId, uuid, orderByComparator);
	}

	/**
	 * Removes all the issueses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of issueses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching issueses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the issues where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchIssuesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	public static Issues findByUUID_G(String uuid, long groupId)
		throws com.amf.newsletters.core.exception.NoSuchIssuesException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the issues where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public static Issues fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the issues where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public static Issues fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the issues where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the issues that was removed
	 */
	public static Issues removeByUUID_G(String uuid, long groupId)
		throws com.amf.newsletters.core.exception.NoSuchIssuesException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of issueses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching issueses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the issueses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching issueses
	 */
	public static List<Issues> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the issueses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssuesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of issueses
	 * @param end the upper bound of the range of issueses (not inclusive)
	 * @return the range of matching issueses
	 */
	public static List<Issues> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the issueses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssuesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of issueses
	 * @param end the upper bound of the range of issueses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching issueses
	 */
	public static List<Issues> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Issues> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the issueses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssuesModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of issueses
	 * @param end the upper bound of the range of issueses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching issueses
	 */
	public static List<Issues> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Issues> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first issues in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	public static Issues findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Issues> orderByComparator)
		throws com.amf.newsletters.core.exception.NoSuchIssuesException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first issues in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public static Issues fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Issues> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last issues in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	public static Issues findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Issues> orderByComparator)
		throws com.amf.newsletters.core.exception.NoSuchIssuesException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last issues in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public static Issues fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Issues> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the issueses before and after the current issues in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param issueId the primary key of the current issues
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next issues
	 * @throws NoSuchIssuesException if a issues with the primary key could not be found
	 */
	public static Issues[] findByUuid_C_PrevAndNext(
			long issueId, String uuid, long companyId,
			OrderByComparator<Issues> orderByComparator)
		throws com.amf.newsletters.core.exception.NoSuchIssuesException {

		return getPersistence().findByUuid_C_PrevAndNext(
			issueId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the issueses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of issueses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching issueses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the issueses where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @return the matching issueses
	 */
	public static List<Issues> findByIssuedDate(Date issuedDate) {
		return getPersistence().findByIssuedDate(issuedDate);
	}

	/**
	 * Returns a range of all the issueses where issuedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssuesModelImpl</code>.
	 * </p>
	 *
	 * @param issuedDate the issued date
	 * @param start the lower bound of the range of issueses
	 * @param end the upper bound of the range of issueses (not inclusive)
	 * @return the range of matching issueses
	 */
	public static List<Issues> findByIssuedDate(
		Date issuedDate, int start, int end) {

		return getPersistence().findByIssuedDate(issuedDate, start, end);
	}

	/**
	 * Returns an ordered range of all the issueses where issuedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssuesModelImpl</code>.
	 * </p>
	 *
	 * @param issuedDate the issued date
	 * @param start the lower bound of the range of issueses
	 * @param end the upper bound of the range of issueses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching issueses
	 */
	public static List<Issues> findByIssuedDate(
		Date issuedDate, int start, int end,
		OrderByComparator<Issues> orderByComparator) {

		return getPersistence().findByIssuedDate(
			issuedDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the issueses where issuedDate = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssuesModelImpl</code>.
	 * </p>
	 *
	 * @param issuedDate the issued date
	 * @param start the lower bound of the range of issueses
	 * @param end the upper bound of the range of issueses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching issueses
	 */
	public static List<Issues> findByIssuedDate(
		Date issuedDate, int start, int end,
		OrderByComparator<Issues> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByIssuedDate(
			issuedDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first issues in the ordered set where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	public static Issues findByIssuedDate_First(
			Date issuedDate, OrderByComparator<Issues> orderByComparator)
		throws com.amf.newsletters.core.exception.NoSuchIssuesException {

		return getPersistence().findByIssuedDate_First(
			issuedDate, orderByComparator);
	}

	/**
	 * Returns the first issues in the ordered set where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public static Issues fetchByIssuedDate_First(
		Date issuedDate, OrderByComparator<Issues> orderByComparator) {

		return getPersistence().fetchByIssuedDate_First(
			issuedDate, orderByComparator);
	}

	/**
	 * Returns the last issues in the ordered set where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	public static Issues findByIssuedDate_Last(
			Date issuedDate, OrderByComparator<Issues> orderByComparator)
		throws com.amf.newsletters.core.exception.NoSuchIssuesException {

		return getPersistence().findByIssuedDate_Last(
			issuedDate, orderByComparator);
	}

	/**
	 * Returns the last issues in the ordered set where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public static Issues fetchByIssuedDate_Last(
		Date issuedDate, OrderByComparator<Issues> orderByComparator) {

		return getPersistence().fetchByIssuedDate_Last(
			issuedDate, orderByComparator);
	}

	/**
	 * Returns the issueses before and after the current issues in the ordered set where issuedDate = &#63;.
	 *
	 * @param issueId the primary key of the current issues
	 * @param issuedDate the issued date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next issues
	 * @throws NoSuchIssuesException if a issues with the primary key could not be found
	 */
	public static Issues[] findByIssuedDate_PrevAndNext(
			long issueId, Date issuedDate,
			OrderByComparator<Issues> orderByComparator)
		throws com.amf.newsletters.core.exception.NoSuchIssuesException {

		return getPersistence().findByIssuedDate_PrevAndNext(
			issueId, issuedDate, orderByComparator);
	}

	/**
	 * Removes all the issueses where issuedDate = &#63; from the database.
	 *
	 * @param issuedDate the issued date
	 */
	public static void removeByIssuedDate(Date issuedDate) {
		getPersistence().removeByIssuedDate(issuedDate);
	}

	/**
	 * Returns the number of issueses where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @return the number of matching issueses
	 */
	public static int countByIssuedDate(Date issuedDate) {
		return getPersistence().countByIssuedDate(issuedDate);
	}

	/**
	 * Caches the issues in the entity cache if it is enabled.
	 *
	 * @param issues the issues
	 */
	public static void cacheResult(Issues issues) {
		getPersistence().cacheResult(issues);
	}

	/**
	 * Caches the issueses in the entity cache if it is enabled.
	 *
	 * @param issueses the issueses
	 */
	public static void cacheResult(List<Issues> issueses) {
		getPersistence().cacheResult(issueses);
	}

	/**
	 * Creates a new issues with the primary key. Does not add the issues to the database.
	 *
	 * @param issueId the primary key for the new issues
	 * @return the new issues
	 */
	public static Issues create(long issueId) {
		return getPersistence().create(issueId);
	}

	/**
	 * Removes the issues with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param issueId the primary key of the issues
	 * @return the issues that was removed
	 * @throws NoSuchIssuesException if a issues with the primary key could not be found
	 */
	public static Issues remove(long issueId)
		throws com.amf.newsletters.core.exception.NoSuchIssuesException {

		return getPersistence().remove(issueId);
	}

	public static Issues updateImpl(Issues issues) {
		return getPersistence().updateImpl(issues);
	}

	/**
	 * Returns the issues with the primary key or throws a <code>NoSuchIssuesException</code> if it could not be found.
	 *
	 * @param issueId the primary key of the issues
	 * @return the issues
	 * @throws NoSuchIssuesException if a issues with the primary key could not be found
	 */
	public static Issues findByPrimaryKey(long issueId)
		throws com.amf.newsletters.core.exception.NoSuchIssuesException {

		return getPersistence().findByPrimaryKey(issueId);
	}

	/**
	 * Returns the issues with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param issueId the primary key of the issues
	 * @return the issues, or <code>null</code> if a issues with the primary key could not be found
	 */
	public static Issues fetchByPrimaryKey(long issueId) {
		return getPersistence().fetchByPrimaryKey(issueId);
	}

	/**
	 * Returns all the issueses.
	 *
	 * @return the issueses
	 */
	public static List<Issues> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the issueses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssuesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issueses
	 * @param end the upper bound of the range of issueses (not inclusive)
	 * @return the range of issueses
	 */
	public static List<Issues> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the issueses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssuesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issueses
	 * @param end the upper bound of the range of issueses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of issueses
	 */
	public static List<Issues> findAll(
		int start, int end, OrderByComparator<Issues> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the issueses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssuesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issueses
	 * @param end the upper bound of the range of issueses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of issueses
	 */
	public static List<Issues> findAll(
		int start, int end, OrderByComparator<Issues> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the issueses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of issueses.
	 *
	 * @return the number of issueses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static IssuesPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<IssuesPersistence, IssuesPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(IssuesPersistence.class);

		ServiceTracker<IssuesPersistence, IssuesPersistence> serviceTracker =
			new ServiceTracker<IssuesPersistence, IssuesPersistence>(
				bundle.getBundleContext(), IssuesPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}