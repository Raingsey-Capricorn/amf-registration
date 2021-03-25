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

import com.amf.registration.exception.NoSuchAMFUserException;
import com.amf.registration.model.AMFUser;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the amf user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFUserUtil
 * @generated
 */
@ProviderType
public interface AMFUserPersistence extends BasePersistence<AMFUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AMFUserUtil} to access the amf user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the amf users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amf users
	 */
	public java.util.List<AMFUser> findByUuid(String uuid);

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
	public java.util.List<AMFUser> findByUuid(String uuid, int start, int end);

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
	public java.util.List<AMFUser> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
			orderByComparator);

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
	public java.util.List<AMFUser> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public AMFUser findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
				orderByComparator)
		throws NoSuchAMFUserException;

	/**
	 * Returns the first amf user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public AMFUser fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
			orderByComparator);

	/**
	 * Returns the last amf user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public AMFUser findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
				orderByComparator)
		throws NoSuchAMFUserException;

	/**
	 * Returns the last amf user in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public AMFUser fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
			orderByComparator);

	/**
	 * Returns the amf users before and after the current amf user in the ordered set where uuid = &#63;.
	 *
	 * @param amfUserId the primary key of the current amf user
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf user
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	public AMFUser[] findByUuid_PrevAndNext(
			long amfUserId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
				orderByComparator)
		throws NoSuchAMFUserException;

	/**
	 * Removes all the amf users where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of amf users where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amf users
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the amf user where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAMFUserException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public AMFUser findByUUID_G(String uuid, long groupId)
		throws NoSuchAMFUserException;

	/**
	 * Returns the amf user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public AMFUser fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the amf user where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public AMFUser fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the amf user where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the amf user that was removed
	 */
	public AMFUser removeByUUID_G(String uuid, long groupId)
		throws NoSuchAMFUserException;

	/**
	 * Returns the number of amf users where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching amf users
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the amf users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching amf users
	 */
	public java.util.List<AMFUser> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<AMFUser> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AMFUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
			orderByComparator);

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
	public java.util.List<AMFUser> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public AMFUser findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
				orderByComparator)
		throws NoSuchAMFUserException;

	/**
	 * Returns the first amf user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public AMFUser fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
			orderByComparator);

	/**
	 * Returns the last amf user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public AMFUser findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
				orderByComparator)
		throws NoSuchAMFUserException;

	/**
	 * Returns the last amf user in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public AMFUser fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
			orderByComparator);

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
	public AMFUser[] findByUuid_C_PrevAndNext(
			long amfUserId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
				orderByComparator)
		throws NoSuchAMFUserException;

	/**
	 * Removes all the amf users where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of amf users where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching amf users
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the amf users where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching amf users
	 */
	public java.util.List<AMFUser> findByGroupId(long groupId);

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
	public java.util.List<AMFUser> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<AMFUser> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
			orderByComparator);

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
	public java.util.List<AMFUser> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public AMFUser findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
				orderByComparator)
		throws NoSuchAMFUserException;

	/**
	 * Returns the first amf user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public AMFUser fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
			orderByComparator);

	/**
	 * Returns the last amf user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user
	 * @throws NoSuchAMFUserException if a matching amf user could not be found
	 */
	public AMFUser findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
				orderByComparator)
		throws NoSuchAMFUserException;

	/**
	 * Returns the last amf user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf user, or <code>null</code> if a matching amf user could not be found
	 */
	public AMFUser fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
			orderByComparator);

	/**
	 * Returns the amf users before and after the current amf user in the ordered set where groupId = &#63;.
	 *
	 * @param amfUserId the primary key of the current amf user
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf user
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	public AMFUser[] findByGroupId_PrevAndNext(
			long amfUserId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
				orderByComparator)
		throws NoSuchAMFUserException;

	/**
	 * Removes all the amf users where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of amf users where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching amf users
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the amf user in the entity cache if it is enabled.
	 *
	 * @param amfUser the amf user
	 */
	public void cacheResult(AMFUser amfUser);

	/**
	 * Caches the amf users in the entity cache if it is enabled.
	 *
	 * @param amfUsers the amf users
	 */
	public void cacheResult(java.util.List<AMFUser> amfUsers);

	/**
	 * Creates a new amf user with the primary key. Does not add the amf user to the database.
	 *
	 * @param amfUserId the primary key for the new amf user
	 * @return the new amf user
	 */
	public AMFUser create(long amfUserId);

	/**
	 * Removes the amf user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfUserId the primary key of the amf user
	 * @return the amf user that was removed
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	public AMFUser remove(long amfUserId) throws NoSuchAMFUserException;

	public AMFUser updateImpl(AMFUser amfUser);

	/**
	 * Returns the amf user with the primary key or throws a <code>NoSuchAMFUserException</code> if it could not be found.
	 *
	 * @param amfUserId the primary key of the amf user
	 * @return the amf user
	 * @throws NoSuchAMFUserException if a amf user with the primary key could not be found
	 */
	public AMFUser findByPrimaryKey(long amfUserId)
		throws NoSuchAMFUserException;

	/**
	 * Returns the amf user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfUserId the primary key of the amf user
	 * @return the amf user, or <code>null</code> if a amf user with the primary key could not be found
	 */
	public AMFUser fetchByPrimaryKey(long amfUserId);

	/**
	 * Returns all the amf users.
	 *
	 * @return the amf users
	 */
	public java.util.List<AMFUser> findAll();

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
	public java.util.List<AMFUser> findAll(int start, int end);

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
	public java.util.List<AMFUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
			orderByComparator);

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
	public java.util.List<AMFUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the amf users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of amf users.
	 *
	 * @return the number of amf users
	 */
	public int countAll();

}