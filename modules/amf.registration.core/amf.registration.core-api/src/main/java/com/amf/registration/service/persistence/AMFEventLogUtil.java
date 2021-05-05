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

package com.amf.registration.service.persistence;

import com.amf.registration.model.AMFEventLog;

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
 * The persistence utility for the amf event log service. This utility wraps <code>com.amf.registration.service.persistence.impl.AMFEventLogPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventLogPersistence
 * @generated
 */
public class AMFEventLogUtil {

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
	public static void clearCache(AMFEventLog amfEventLog) {
		getPersistence().clearCache(amfEventLog);
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
	public static Map<Serializable, AMFEventLog> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AMFEventLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AMFEventLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AMFEventLog> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AMFEventLog> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AMFEventLog update(AMFEventLog amfEventLog) {
		return getPersistence().update(amfEventLog);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AMFEventLog update(
		AMFEventLog amfEventLog, ServiceContext serviceContext) {

		return getPersistence().update(amfEventLog, serviceContext);
	}

	/**
	 * Returns all the amf event logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amf event logs
	 */
	public static List<AMFEventLog> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the amf event logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFEventLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf event logs
	 * @param end the upper bound of the range of amf event logs (not inclusive)
	 * @return the range of matching amf event logs
	 */
	public static List<AMFEventLog> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the amf event logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFEventLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf event logs
	 * @param end the upper bound of the range of amf event logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf event logs
	 */
	public static List<AMFEventLog> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFEventLog> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf event logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFEventLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf event logs
	 * @param end the upper bound of the range of amf event logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf event logs
	 */
	public static List<AMFEventLog> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFEventLog> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf event log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event log
	 * @throws NoSuchAMFEventLogException if a matching amf event log could not be found
	 */
	public static AMFEventLog findByUuid_First(
			String uuid, OrderByComparator<AMFEventLog> orderByComparator)
		throws com.amf.registration.exception.NoSuchAMFEventLogException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first amf event log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	public static AMFEventLog fetchByUuid_First(
		String uuid, OrderByComparator<AMFEventLog> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last amf event log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event log
	 * @throws NoSuchAMFEventLogException if a matching amf event log could not be found
	 */
	public static AMFEventLog findByUuid_Last(
			String uuid, OrderByComparator<AMFEventLog> orderByComparator)
		throws com.amf.registration.exception.NoSuchAMFEventLogException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last amf event log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	public static AMFEventLog fetchByUuid_Last(
		String uuid, OrderByComparator<AMFEventLog> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the amf event logs before and after the current amf event log in the ordered set where uuid = &#63;.
	 *
	 * @param amfEventLogId the primary key of the current amf event log
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf event log
	 * @throws NoSuchAMFEventLogException if a amf event log with the primary key could not be found
	 */
	public static AMFEventLog[] findByUuid_PrevAndNext(
			long amfEventLogId, String uuid,
			OrderByComparator<AMFEventLog> orderByComparator)
		throws com.amf.registration.exception.NoSuchAMFEventLogException {

		return getPersistence().findByUuid_PrevAndNext(
			amfEventLogId, uuid, orderByComparator);
	}

	/**
	 * Removes all the amf event logs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of amf event logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amf event logs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the amf event log where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAMFEventLogException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amf event log
	 * @throws NoSuchAMFEventLogException if a matching amf event log could not be found
	 */
	public static AMFEventLog findByUUID_G(String uuid, long groupId)
		throws com.amf.registration.exception.NoSuchAMFEventLogException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the amf event log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	public static AMFEventLog fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the amf event log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	public static AMFEventLog fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the amf event log where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the amf event log that was removed
	 */
	public static AMFEventLog removeByUUID_G(String uuid, long groupId)
		throws com.amf.registration.exception.NoSuchAMFEventLogException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of amf event logs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching amf event logs
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the amf event logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching amf event logs
	 */
	public static List<AMFEventLog> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the amf event logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFEventLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amf event logs
	 * @param end the upper bound of the range of amf event logs (not inclusive)
	 * @return the range of matching amf event logs
	 */
	public static List<AMFEventLog> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the amf event logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFEventLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amf event logs
	 * @param end the upper bound of the range of amf event logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf event logs
	 */
	public static List<AMFEventLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AMFEventLog> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf event logs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFEventLogModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amf event logs
	 * @param end the upper bound of the range of amf event logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf event logs
	 */
	public static List<AMFEventLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AMFEventLog> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf event log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event log
	 * @throws NoSuchAMFEventLogException if a matching amf event log could not be found
	 */
	public static AMFEventLog findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AMFEventLog> orderByComparator)
		throws com.amf.registration.exception.NoSuchAMFEventLogException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first amf event log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	public static AMFEventLog fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AMFEventLog> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last amf event log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event log
	 * @throws NoSuchAMFEventLogException if a matching amf event log could not be found
	 */
	public static AMFEventLog findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AMFEventLog> orderByComparator)
		throws com.amf.registration.exception.NoSuchAMFEventLogException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last amf event log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	public static AMFEventLog fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AMFEventLog> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the amf event logs before and after the current amf event log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param amfEventLogId the primary key of the current amf event log
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf event log
	 * @throws NoSuchAMFEventLogException if a amf event log with the primary key could not be found
	 */
	public static AMFEventLog[] findByUuid_C_PrevAndNext(
			long amfEventLogId, String uuid, long companyId,
			OrderByComparator<AMFEventLog> orderByComparator)
		throws com.amf.registration.exception.NoSuchAMFEventLogException {

		return getPersistence().findByUuid_C_PrevAndNext(
			amfEventLogId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the amf event logs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of amf event logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching amf event logs
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the amf event log in the entity cache if it is enabled.
	 *
	 * @param amfEventLog the amf event log
	 */
	public static void cacheResult(AMFEventLog amfEventLog) {
		getPersistence().cacheResult(amfEventLog);
	}

	/**
	 * Caches the amf event logs in the entity cache if it is enabled.
	 *
	 * @param amfEventLogs the amf event logs
	 */
	public static void cacheResult(List<AMFEventLog> amfEventLogs) {
		getPersistence().cacheResult(amfEventLogs);
	}

	/**
	 * Creates a new amf event log with the primary key. Does not add the amf event log to the database.
	 *
	 * @param amfEventLogId the primary key for the new amf event log
	 * @return the new amf event log
	 */
	public static AMFEventLog create(long amfEventLogId) {
		return getPersistence().create(amfEventLogId);
	}

	/**
	 * Removes the amf event log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfEventLogId the primary key of the amf event log
	 * @return the amf event log that was removed
	 * @throws NoSuchAMFEventLogException if a amf event log with the primary key could not be found
	 */
	public static AMFEventLog remove(long amfEventLogId)
		throws com.amf.registration.exception.NoSuchAMFEventLogException {

		return getPersistence().remove(amfEventLogId);
	}

	public static AMFEventLog updateImpl(AMFEventLog amfEventLog) {
		return getPersistence().updateImpl(amfEventLog);
	}

	/**
	 * Returns the amf event log with the primary key or throws a <code>NoSuchAMFEventLogException</code> if it could not be found.
	 *
	 * @param amfEventLogId the primary key of the amf event log
	 * @return the amf event log
	 * @throws NoSuchAMFEventLogException if a amf event log with the primary key could not be found
	 */
	public static AMFEventLog findByPrimaryKey(long amfEventLogId)
		throws com.amf.registration.exception.NoSuchAMFEventLogException {

		return getPersistence().findByPrimaryKey(amfEventLogId);
	}

	/**
	 * Returns the amf event log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfEventLogId the primary key of the amf event log
	 * @return the amf event log, or <code>null</code> if a amf event log with the primary key could not be found
	 */
	public static AMFEventLog fetchByPrimaryKey(long amfEventLogId) {
		return getPersistence().fetchByPrimaryKey(amfEventLogId);
	}

	/**
	 * Returns all the amf event logs.
	 *
	 * @return the amf event logs
	 */
	public static List<AMFEventLog> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the amf event logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFEventLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf event logs
	 * @param end the upper bound of the range of amf event logs (not inclusive)
	 * @return the range of amf event logs
	 */
	public static List<AMFEventLog> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the amf event logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFEventLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf event logs
	 * @param end the upper bound of the range of amf event logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amf event logs
	 */
	public static List<AMFEventLog> findAll(
		int start, int end, OrderByComparator<AMFEventLog> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf event logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFEventLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf event logs
	 * @param end the upper bound of the range of amf event logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of amf event logs
	 */
	public static List<AMFEventLog> findAll(
		int start, int end, OrderByComparator<AMFEventLog> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the amf event logs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of amf event logs.
	 *
	 * @return the number of amf event logs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of amf users associated with the amf event log.
	 *
	 * @param pk the primary key of the amf event log
	 * @return long[] of the primaryKeys of amf users associated with the amf event log
	 */
	public static long[] getAMFUserPrimaryKeys(long pk) {
		return getPersistence().getAMFUserPrimaryKeys(pk);
	}

	/**
	 * Returns all the amf event log associated with the amf user.
	 *
	 * @param pk the primary key of the amf user
	 * @return the amf event logs associated with the amf user
	 */
	public static List<AMFEventLog> getAMFUserAMFEventLogs(long pk) {
		return getPersistence().getAMFUserAMFEventLogs(pk);
	}

	/**
	 * Returns all the amf event log associated with the amf user.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFEventLogModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the amf user
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @return the range of amf event logs associated with the amf user
	 */
	public static List<AMFEventLog> getAMFUserAMFEventLogs(
		long pk, int start, int end) {

		return getPersistence().getAMFUserAMFEventLogs(pk, start, end);
	}

	/**
	 * Returns all the amf event log associated with the amf user.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFEventLogModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the amf user
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amf event logs associated with the amf user
	 */
	public static List<AMFEventLog> getAMFUserAMFEventLogs(
		long pk, int start, int end,
		OrderByComparator<AMFEventLog> orderByComparator) {

		return getPersistence().getAMFUserAMFEventLogs(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of amf users associated with the amf event log.
	 *
	 * @param pk the primary key of the amf event log
	 * @return the number of amf users associated with the amf event log
	 */
	public static int getAMFUsersSize(long pk) {
		return getPersistence().getAMFUsersSize(pk);
	}

	/**
	 * Returns <code>true</code> if the amf user is associated with the amf event log.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPK the primary key of the amf user
	 * @return <code>true</code> if the amf user is associated with the amf event log; <code>false</code> otherwise
	 */
	public static boolean containsAMFUser(long pk, long amfUserPK) {
		return getPersistence().containsAMFUser(pk, amfUserPK);
	}

	/**
	 * Returns <code>true</code> if the amf event log has any amf users associated with it.
	 *
	 * @param pk the primary key of the amf event log to check for associations with amf users
	 * @return <code>true</code> if the amf event log has any amf users associated with it; <code>false</code> otherwise
	 */
	public static boolean containsAMFUsers(long pk) {
		return getPersistence().containsAMFUsers(pk);
	}

	/**
	 * Adds an association between the amf event log and the amf user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPK the primary key of the amf user
	 */
	public static void addAMFUser(long pk, long amfUserPK) {
		getPersistence().addAMFUser(pk, amfUserPK);
	}

	/**
	 * Adds an association between the amf event log and the amf user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUser the amf user
	 */
	public static void addAMFUser(
		long pk, com.amf.registration.model.AMFUser amfUser) {

		getPersistence().addAMFUser(pk, amfUser);
	}

	/**
	 * Adds an association between the amf event log and the amf users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPKs the primary keys of the amf users
	 */
	public static void addAMFUsers(long pk, long[] amfUserPKs) {
		getPersistence().addAMFUsers(pk, amfUserPKs);
	}

	/**
	 * Adds an association between the amf event log and the amf users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUsers the amf users
	 */
	public static void addAMFUsers(
		long pk, List<com.amf.registration.model.AMFUser> amfUsers) {

		getPersistence().addAMFUsers(pk, amfUsers);
	}

	/**
	 * Clears all associations between the amf event log and its amf users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log to clear the associated amf users from
	 */
	public static void clearAMFUsers(long pk) {
		getPersistence().clearAMFUsers(pk);
	}

	/**
	 * Removes the association between the amf event log and the amf user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPK the primary key of the amf user
	 */
	public static void removeAMFUser(long pk, long amfUserPK) {
		getPersistence().removeAMFUser(pk, amfUserPK);
	}

	/**
	 * Removes the association between the amf event log and the amf user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUser the amf user
	 */
	public static void removeAMFUser(
		long pk, com.amf.registration.model.AMFUser amfUser) {

		getPersistence().removeAMFUser(pk, amfUser);
	}

	/**
	 * Removes the association between the amf event log and the amf users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPKs the primary keys of the amf users
	 */
	public static void removeAMFUsers(long pk, long[] amfUserPKs) {
		getPersistence().removeAMFUsers(pk, amfUserPKs);
	}

	/**
	 * Removes the association between the amf event log and the amf users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUsers the amf users
	 */
	public static void removeAMFUsers(
		long pk, List<com.amf.registration.model.AMFUser> amfUsers) {

		getPersistence().removeAMFUsers(pk, amfUsers);
	}

	/**
	 * Sets the amf users associated with the amf event log, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPKs the primary keys of the amf users to be associated with the amf event log
	 */
	public static void setAMFUsers(long pk, long[] amfUserPKs) {
		getPersistence().setAMFUsers(pk, amfUserPKs);
	}

	/**
	 * Sets the amf users associated with the amf event log, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUsers the amf users to be associated with the amf event log
	 */
	public static void setAMFUsers(
		long pk, List<com.amf.registration.model.AMFUser> amfUsers) {

		getPersistence().setAMFUsers(pk, amfUsers);
	}

	public static AMFEventLogPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AMFEventLogPersistence, AMFEventLogPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AMFEventLogPersistence.class);

		ServiceTracker<AMFEventLogPersistence, AMFEventLogPersistence>
			serviceTracker =
				new ServiceTracker
					<AMFEventLogPersistence, AMFEventLogPersistence>(
						bundle.getBundleContext(), AMFEventLogPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}