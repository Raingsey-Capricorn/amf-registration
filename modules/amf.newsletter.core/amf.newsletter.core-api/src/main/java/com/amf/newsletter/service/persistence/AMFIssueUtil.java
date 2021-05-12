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
	 * @param amfissueId the primary key of the current amf issue
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public static AMFIssue[] findByUuid_PrevAndNext(
			long amfissueId, String uuid,
			OrderByComparator<AMFIssue> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByUuid_PrevAndNext(
			amfissueId, uuid, orderByComparator);
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
	 * @param amfissueId the primary key of the current amf issue
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public static AMFIssue[] findByUuid_C_PrevAndNext(
			long amfissueId, String uuid, long companyId,
			OrderByComparator<AMFIssue> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByUuid_C_PrevAndNext(
			amfissueId, uuid, companyId, orderByComparator);
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
	 * Returns all the amf issues where amfissueId = &#63;.
	 *
	 * @param amfissueId the amfissue ID
	 * @return the matching amf issues
	 */
	public static List<AMFIssue> findByAMFIssueId(long amfissueId) {
		return getPersistence().findByAMFIssueId(amfissueId);
	}

	/**
	 * Returns a range of all the amf issues where amfissueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param amfissueId the amfissue ID
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @return the range of matching amf issues
	 */
	public static List<AMFIssue> findByAMFIssueId(
		long amfissueId, int start, int end) {

		return getPersistence().findByAMFIssueId(amfissueId, start, end);
	}

	/**
	 * Returns an ordered range of all the amf issues where amfissueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param amfissueId the amfissue ID
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf issues
	 */
	public static List<AMFIssue> findByAMFIssueId(
		long amfissueId, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().findByAMFIssueId(
			amfissueId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf issues where amfissueId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFIssueModelImpl</code>.
	 * </p>
	 *
	 * @param amfissueId the amfissue ID
	 * @param start the lower bound of the range of amf issues
	 * @param end the upper bound of the range of amf issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf issues
	 */
	public static List<AMFIssue> findByAMFIssueId(
		long amfissueId, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByAMFIssueId(
			amfissueId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf issue in the ordered set where amfissueId = &#63;.
	 *
	 * @param amfissueId the amfissue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public static AMFIssue findByAMFIssueId_First(
			long amfissueId, OrderByComparator<AMFIssue> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByAMFIssueId_First(
			amfissueId, orderByComparator);
	}

	/**
	 * Returns the first amf issue in the ordered set where amfissueId = &#63;.
	 *
	 * @param amfissueId the amfissue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public static AMFIssue fetchByAMFIssueId_First(
		long amfissueId, OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().fetchByAMFIssueId_First(
			amfissueId, orderByComparator);
	}

	/**
	 * Returns the last amf issue in the ordered set where amfissueId = &#63;.
	 *
	 * @param amfissueId the amfissue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public static AMFIssue findByAMFIssueId_Last(
			long amfissueId, OrderByComparator<AMFIssue> orderByComparator)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByAMFIssueId_Last(
			amfissueId, orderByComparator);
	}

	/**
	 * Returns the last amf issue in the ordered set where amfissueId = &#63;.
	 *
	 * @param amfissueId the amfissue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public static AMFIssue fetchByAMFIssueId_Last(
		long amfissueId, OrderByComparator<AMFIssue> orderByComparator) {

		return getPersistence().fetchByAMFIssueId_Last(
			amfissueId, orderByComparator);
	}

	/**
	 * Removes all the amf issues where amfissueId = &#63; from the database.
	 *
	 * @param amfissueId the amfissue ID
	 */
	public static void removeByAMFIssueId(long amfissueId) {
		getPersistence().removeByAMFIssueId(amfissueId);
	}

	/**
	 * Returns the number of amf issues where amfissueId = &#63;.
	 *
	 * @param amfissueId the amfissue ID
	 * @return the number of matching amf issues
	 */
	public static int countByAMFIssueId(long amfissueId) {
		return getPersistence().countByAMFIssueId(amfissueId);
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
	 * @param amfissueId the primary key for the new amf issue
	 * @return the new amf issue
	 */
	public static AMFIssue create(long amfissueId) {
		return getPersistence().create(amfissueId);
	}

	/**
	 * Removes the amf issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfissueId the primary key of the amf issue
	 * @return the amf issue that was removed
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public static AMFIssue remove(long amfissueId)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().remove(amfissueId);
	}

	public static AMFIssue updateImpl(AMFIssue amfIssue) {
		return getPersistence().updateImpl(amfIssue);
	}

	/**
	 * Returns the amf issue with the primary key or throws a <code>NoSuchAMFIssueException</code> if it could not be found.
	 *
	 * @param amfissueId the primary key of the amf issue
	 * @return the amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public static AMFIssue findByPrimaryKey(long amfissueId)
		throws com.amf.newsletter.exception.NoSuchAMFIssueException {

		return getPersistence().findByPrimaryKey(amfissueId);
	}

	/**
	 * Returns the amf issue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfissueId the primary key of the amf issue
	 * @return the amf issue, or <code>null</code> if a amf issue with the primary key could not be found
	 */
	public static AMFIssue fetchByPrimaryKey(long amfissueId) {
		return getPersistence().fetchByPrimaryKey(amfissueId);
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