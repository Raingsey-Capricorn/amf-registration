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

import com.amf.registration.model.AMFUser;

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
 * The persistence utility for the amf user service. This utility wraps <code>com.amf.registration.service.persistence.impl.AMFUserPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFUserPersistence
 * @generated
 */
public class AMFUserUtil {

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
	public static void clearCache(AMFUser amfUser) {
		getPersistence().clearCache(amfUser);
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
	public static Map<Serializable, AMFUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AMFUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AMFUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AMFUser> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AMFUser update(AMFUser amfUser) {
		return getPersistence().update(amfUser);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AMFUser update(
		AMFUser amfUser, ServiceContext serviceContext) {

		return getPersistence().update(amfUser, serviceContext);
	}

	/**
	 * Returns all the amf users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amf users
	 */
	public static List<AMFUser> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the amf users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @return the range of matching amf users
	 */
	public static List<AMFUser> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the amf users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf users
	 */
	public static List<AMFUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf users where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf users
	 */
	public static List<AMFUser> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFUser> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public static AMFUser findByUuid_First(
			String uuid, OrderByComparator<AMFUser> orderByComparator)
		throws com.amf.registration.exception.NoSuchAMFUserException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first amf user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public static AMFUser fetchByUuid_First(
		String uuid, OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last amf user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public static AMFUser findByUuid_Last(
			String uuid, OrderByComparator<AMFUser> orderByComparator)
		throws com.amf.registration.exception.NoSuchAMFUserException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last amf user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public static AMFUser fetchByUuid_Last(
		String uuid, OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the amf users before and after the current amf user in the ordered set where uuid = &#63;.
	 *
	 * @param amfUserId the primary key of the current amf user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf user
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	public static AMFUser[] findByUuid_PrevAndNext(
			long amfUserId, String uuid,
			OrderByComparator<AMFUser> orderByComparator)
		throws com.amf.registration.exception.NoSuchAMFUserException {

		return getPersistence().findByUuid_PrevAndNext(
			amfUserId, uuid, orderByComparator);
	}

	/**
	 * Removes all the amf users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of amf users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amf users
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the amf user where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAMFUserException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public static AMFUser findByUUID_G(String uuid, long groupId)
		throws com.amf.registration.exception.NoSuchAMFUserException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the amf user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public static AMFUser fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the amf user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public static AMFUser fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the amf user where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the amf user that was removed
	 */
	public static AMFUser removeByUUID_G(String uuid, long groupId)
		throws com.amf.registration.exception.NoSuchAMFUserException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of amf users where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching amf users
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the amf users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching amf users
	 */
	public static List<AMFUser> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the amf users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @return the range of matching amf users
	 */
	public static List<AMFUser> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the amf users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf users
	 */
	public static List<AMFUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf users where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf users
	 */
	public static List<AMFUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AMFUser> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public static AMFUser findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AMFUser> orderByComparator)
		throws com.amf.registration.exception.NoSuchAMFUserException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first amf user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public static AMFUser fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last amf user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public static AMFUser findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AMFUser> orderByComparator)
		throws com.amf.registration.exception.NoSuchAMFUserException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last amf user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public static AMFUser fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the amf users before and after the current amf user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param amfUserId the primary key of the current amf user
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf user
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	public static AMFUser[] findByUuid_C_PrevAndNext(
			long amfUserId, String uuid, long companyId,
			OrderByComparator<AMFUser> orderByComparator)
		throws com.amf.registration.exception.NoSuchAMFUserException {

		return getPersistence().findByUuid_C_PrevAndNext(
			amfUserId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the amf users where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of amf users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching amf users
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the amf users where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching amf users
	 */
	public static List<AMFUser> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the amf users where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @return the range of matching amf users
	 */
	public static List<AMFUser> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the amf users where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amf users
	 */
	public static List<AMFUser> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf users where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amf users
	 */
	public static List<AMFUser> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AMFUser> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amf user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public static AMFUser findByGroupId_First(
			long groupId, OrderByComparator<AMFUser> orderByComparator)
		throws com.amf.registration.exception.NoSuchAMFUserException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first amf user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public static AMFUser fetchByGroupId_First(
		long groupId, OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last amf user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public static AMFUser findByGroupId_Last(
			long groupId, OrderByComparator<AMFUser> orderByComparator)
		throws com.amf.registration.exception.NoSuchAMFUserException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last amf user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public static AMFUser fetchByGroupId_Last(
		long groupId, OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the amf users before and after the current amf user in the ordered set where groupId = &#63;.
	 *
	 * @param amfUserId the primary key of the current amf user
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf user
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	public static AMFUser[] findByGroupId_PrevAndNext(
			long amfUserId, long groupId,
			OrderByComparator<AMFUser> orderByComparator)
		throws com.amf.registration.exception.NoSuchAMFUserException {

		return getPersistence().findByGroupId_PrevAndNext(
			amfUserId, groupId, orderByComparator);
	}

	/**
	 * Removes all the amf users where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of amf users where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching amf users
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the amf user in the entity cache if it is enabled.
	 *
	 * @param amfUser the amf user
	 */
	public static void cacheResult(AMFUser amfUser) {
		getPersistence().cacheResult(amfUser);
	}

	/**
	 * Caches the amf users in the entity cache if it is enabled.
	 *
	 * @param amfUsers the amf users
	 */
	public static void cacheResult(List<AMFUser> amfUsers) {
		getPersistence().cacheResult(amfUsers);
	}

	/**
	 * Creates a new amf user with the primary key. Does not add the amf user to the database.
	 *
	 * @param amfUserId the primary key for the new amf user
	 * @return the new amf user
	 */
	public static AMFUser create(long amfUserId) {
		return getPersistence().create(amfUserId);
	}

	/**
	 * Removes the amf user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfUserId the primary key of the amf user
	 * @return the amf user that was removed
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	public static AMFUser remove(long amfUserId)
		throws com.amf.registration.exception.NoSuchAMFUserException {

		return getPersistence().remove(amfUserId);
	}

	public static AMFUser updateImpl(AMFUser amfUser) {
		return getPersistence().updateImpl(amfUser);
	}

	/**
	 * Returns the amf user with the primary key or throws a <code>NoSuchAMFUserException</code> if it could not be found.
	 *
	 * @param amfUserId the primary key of the amf user
	 * @return the amf user
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	public static AMFUser findByPrimaryKey(long amfUserId)
		throws com.amf.registration.exception.NoSuchAMFUserException {

		return getPersistence().findByPrimaryKey(amfUserId);
	}

	/**
	 * Returns the amf user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfUserId the primary key of the amf user
	 * @return the amf user, or <code>null</code> if a amf user with the primary key could not be found
	 */
	public static AMFUser fetchByPrimaryKey(long amfUserId) {
		return getPersistence().fetchByPrimaryKey(amfUserId);
	}

	/**
	 * Returns all the amf users.
	 *
	 * @return the amf users
	 */
	public static List<AMFUser> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the amf users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @return the range of amf users
	 */
	public static List<AMFUser> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the amf users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amf users
	 */
	public static List<AMFUser> findAll(
		int start, int end, OrderByComparator<AMFUser> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amf users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AMFUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf users
	 * @param end the upper bound of the range of amf users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of amf users
	 */
	public static List<AMFUser> findAll(
		int start, int end, OrderByComparator<AMFUser> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the amf users from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of amf users.
	 *
	 * @return the number of amf users
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AMFUserPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AMFUserPersistence, AMFUserPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(AMFUserPersistence.class);

		ServiceTracker<AMFUserPersistence, AMFUserPersistence> serviceTracker =
			new ServiceTracker<AMFUserPersistence, AMFUserPersistence>(
				bundle.getBundleContext(), AMFUserPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}