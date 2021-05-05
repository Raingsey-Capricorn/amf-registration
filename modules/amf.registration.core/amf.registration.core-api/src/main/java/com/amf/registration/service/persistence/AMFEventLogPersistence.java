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

import com.amf.registration.exception.NoSuchAMFEventLogException;
import com.amf.registration.model.AMFEventLog;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the amf event log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventLogUtil
 * @generated
 */
@ProviderType
public interface AMFEventLogPersistence extends BasePersistence<AMFEventLog> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AMFEventLogUtil} to access the amf event log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the amf event logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amf event logs
	 */
	public java.util.List<AMFEventLog> findByUuid(String uuid);

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
	public java.util.List<AMFEventLog> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AMFEventLog> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
			orderByComparator);

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
	public java.util.List<AMFEventLog> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf event log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event log
	 * @throws NoSuchAMFEventLogException if a matching amf event log could not be found
	 */
	public AMFEventLog findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
				orderByComparator)
		throws NoSuchAMFEventLogException;

	/**
	 * Returns the first amf event log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	public AMFEventLog fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
			orderByComparator);

	/**
	 * Returns the last amf event log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event log
	 * @throws NoSuchAMFEventLogException if a matching amf event log could not be found
	 */
	public AMFEventLog findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
				orderByComparator)
		throws NoSuchAMFEventLogException;

	/**
	 * Returns the last amf event log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	public AMFEventLog fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
			orderByComparator);

	/**
	 * Returns the amf event logs before and after the current amf event log in the ordered set where uuid = &#63;.
	 *
	 * @param amfEventLogId the primary key of the current amf event log
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf event log
	 * @throws NoSuchAMFEventLogException if a amf event log with the primary key could not be found
	 */
	public AMFEventLog[] findByUuid_PrevAndNext(
			long amfEventLogId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
				orderByComparator)
		throws NoSuchAMFEventLogException;

	/**
	 * Removes all the amf event logs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of amf event logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amf event logs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the amf event log where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAMFEventLogException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amf event log
	 * @throws NoSuchAMFEventLogException if a matching amf event log could not be found
	 */
	public AMFEventLog findByUUID_G(String uuid, long groupId)
		throws NoSuchAMFEventLogException;

	/**
	 * Returns the amf event log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	public AMFEventLog fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the amf event log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	public AMFEventLog fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the amf event log where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the amf event log that was removed
	 */
	public AMFEventLog removeByUUID_G(String uuid, long groupId)
		throws NoSuchAMFEventLogException;

	/**
	 * Returns the number of amf event logs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching amf event logs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the amf event logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching amf event logs
	 */
	public java.util.List<AMFEventLog> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<AMFEventLog> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AMFEventLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
			orderByComparator);

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
	public java.util.List<AMFEventLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf event log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event log
	 * @throws NoSuchAMFEventLogException if a matching amf event log could not be found
	 */
	public AMFEventLog findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
				orderByComparator)
		throws NoSuchAMFEventLogException;

	/**
	 * Returns the first amf event log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	public AMFEventLog fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
			orderByComparator);

	/**
	 * Returns the last amf event log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event log
	 * @throws NoSuchAMFEventLogException if a matching amf event log could not be found
	 */
	public AMFEventLog findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
				orderByComparator)
		throws NoSuchAMFEventLogException;

	/**
	 * Returns the last amf event log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	public AMFEventLog fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
			orderByComparator);

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
	public AMFEventLog[] findByUuid_C_PrevAndNext(
			long amfEventLogId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
				orderByComparator)
		throws NoSuchAMFEventLogException;

	/**
	 * Removes all the amf event logs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of amf event logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching amf event logs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the amf event log in the entity cache if it is enabled.
	 *
	 * @param amfEventLog the amf event log
	 */
	public void cacheResult(AMFEventLog amfEventLog);

	/**
	 * Caches the amf event logs in the entity cache if it is enabled.
	 *
	 * @param amfEventLogs the amf event logs
	 */
	public void cacheResult(java.util.List<AMFEventLog> amfEventLogs);

	/**
	 * Creates a new amf event log with the primary key. Does not add the amf event log to the database.
	 *
	 * @param amfEventLogId the primary key for the new amf event log
	 * @return the new amf event log
	 */
	public AMFEventLog create(long amfEventLogId);

	/**
	 * Removes the amf event log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfEventLogId the primary key of the amf event log
	 * @return the amf event log that was removed
	 * @throws NoSuchAMFEventLogException if a amf event log with the primary key could not be found
	 */
	public AMFEventLog remove(long amfEventLogId)
		throws NoSuchAMFEventLogException;

	public AMFEventLog updateImpl(AMFEventLog amfEventLog);

	/**
	 * Returns the amf event log with the primary key or throws a <code>NoSuchAMFEventLogException</code> if it could not be found.
	 *
	 * @param amfEventLogId the primary key of the amf event log
	 * @return the amf event log
	 * @throws NoSuchAMFEventLogException if a amf event log with the primary key could not be found
	 */
	public AMFEventLog findByPrimaryKey(long amfEventLogId)
		throws NoSuchAMFEventLogException;

	/**
	 * Returns the amf event log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfEventLogId the primary key of the amf event log
	 * @return the amf event log, or <code>null</code> if a amf event log with the primary key could not be found
	 */
	public AMFEventLog fetchByPrimaryKey(long amfEventLogId);

	/**
	 * Returns all the amf event logs.
	 *
	 * @return the amf event logs
	 */
	public java.util.List<AMFEventLog> findAll();

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
	public java.util.List<AMFEventLog> findAll(int start, int end);

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
	public java.util.List<AMFEventLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
			orderByComparator);

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
	public java.util.List<AMFEventLog> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the amf event logs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of amf event logs.
	 *
	 * @return the number of amf event logs
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of amf users associated with the amf event log.
	 *
	 * @param pk the primary key of the amf event log
	 * @return long[] of the primaryKeys of amf users associated with the amf event log
	 */
	public long[] getAMFUserPrimaryKeys(long pk);

	/**
	 * Returns all the amf event log associated with the amf user.
	 *
	 * @param pk the primary key of the amf user
	 * @return the amf event logs associated with the amf user
	 */
	public java.util.List<AMFEventLog> getAMFUserAMFEventLogs(long pk);

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
	public java.util.List<AMFEventLog> getAMFUserAMFEventLogs(
		long pk, int start, int end);

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
	public java.util.List<AMFEventLog> getAMFUserAMFEventLogs(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFEventLog>
			orderByComparator);

	/**
	 * Returns the number of amf users associated with the amf event log.
	 *
	 * @param pk the primary key of the amf event log
	 * @return the number of amf users associated with the amf event log
	 */
	public int getAMFUsersSize(long pk);

	/**
	 * Returns <code>true</code> if the amf user is associated with the amf event log.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPK the primary key of the amf user
	 * @return <code>true</code> if the amf user is associated with the amf event log; <code>false</code> otherwise
	 */
	public boolean containsAMFUser(long pk, long amfUserPK);

	/**
	 * Returns <code>true</code> if the amf event log has any amf users associated with it.
	 *
	 * @param pk the primary key of the amf event log to check for associations with amf users
	 * @return <code>true</code> if the amf event log has any amf users associated with it; <code>false</code> otherwise
	 */
	public boolean containsAMFUsers(long pk);

	/**
	 * Adds an association between the amf event log and the amf user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPK the primary key of the amf user
	 */
	public void addAMFUser(long pk, long amfUserPK);

	/**
	 * Adds an association between the amf event log and the amf user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUser the amf user
	 */
	public void addAMFUser(long pk, com.amf.registration.model.AMFUser amfUser);

	/**
	 * Adds an association between the amf event log and the amf users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPKs the primary keys of the amf users
	 */
	public void addAMFUsers(long pk, long[] amfUserPKs);

	/**
	 * Adds an association between the amf event log and the amf users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUsers the amf users
	 */
	public void addAMFUsers(
		long pk, java.util.List<com.amf.registration.model.AMFUser> amfUsers);

	/**
	 * Clears all associations between the amf event log and its amf users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log to clear the associated amf users from
	 */
	public void clearAMFUsers(long pk);

	/**
	 * Removes the association between the amf event log and the amf user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPK the primary key of the amf user
	 */
	public void removeAMFUser(long pk, long amfUserPK);

	/**
	 * Removes the association between the amf event log and the amf user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUser the amf user
	 */
	public void removeAMFUser(
		long pk, com.amf.registration.model.AMFUser amfUser);

	/**
	 * Removes the association between the amf event log and the amf users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPKs the primary keys of the amf users
	 */
	public void removeAMFUsers(long pk, long[] amfUserPKs);

	/**
	 * Removes the association between the amf event log and the amf users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUsers the amf users
	 */
	public void removeAMFUsers(
		long pk, java.util.List<com.amf.registration.model.AMFUser> amfUsers);

	/**
	 * Sets the amf users associated with the amf event log, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPKs the primary keys of the amf users to be associated with the amf event log
	 */
	public void setAMFUsers(long pk, long[] amfUserPKs);

	/**
	 * Sets the amf users associated with the amf event log, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUsers the amf users to be associated with the amf event log
	 */
	public void setAMFUsers(
		long pk, java.util.List<com.amf.registration.model.AMFUser> amfUsers);

}