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

import com.amf.newsletter.exception.NoSuchAMFIssueException;
import com.amf.newsletter.model.AMFIssue;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the amf issue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFIssueUtil
 * @generated
 */
@ProviderType
public interface AMFIssuePersistence extends BasePersistence<AMFIssue> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AMFIssueUtil} to access the amf issue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the amf issues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amf issues
	 */
	public java.util.List<AMFIssue> findByUuid(String uuid);

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
	public java.util.List<AMFIssue> findByUuid(String uuid, int start, int end);

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
	public java.util.List<AMFIssue> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

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
	public java.util.List<AMFIssue> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public AMFIssue findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
				orderByComparator)
		throws NoSuchAMFIssueException;

	/**
	 * Returns the first amf issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public AMFIssue fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

	/**
	 * Returns the last amf issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public AMFIssue findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
				orderByComparator)
		throws NoSuchAMFIssueException;

	/**
	 * Returns the last amf issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public AMFIssue fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

	/**
	 * Returns the amf issues before and after the current amf issue in the ordered set where uuid = &#63;.
	 *
	 * @param amfissueId the primary key of the current amf issue
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public AMFIssue[] findByUuid_PrevAndNext(
			long amfissueId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
				orderByComparator)
		throws NoSuchAMFIssueException;

	/**
	 * Removes all the amf issues where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of amf issues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amf issues
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the amf issue where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAMFIssueException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public AMFIssue findByUUID_G(String uuid, long groupId)
		throws NoSuchAMFIssueException;

	/**
	 * Returns the amf issue where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public AMFIssue fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the amf issue where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public AMFIssue fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the amf issue where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the amf issue that was removed
	 */
	public AMFIssue removeByUUID_G(String uuid, long groupId)
		throws NoSuchAMFIssueException;

	/**
	 * Returns the number of amf issues where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching amf issues
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the amf issues where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching amf issues
	 */
	public java.util.List<AMFIssue> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<AMFIssue> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AMFIssue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

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
	public java.util.List<AMFIssue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public AMFIssue findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
				orderByComparator)
		throws NoSuchAMFIssueException;

	/**
	 * Returns the first amf issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public AMFIssue fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

	/**
	 * Returns the last amf issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public AMFIssue findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
				orderByComparator)
		throws NoSuchAMFIssueException;

	/**
	 * Returns the last amf issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public AMFIssue fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

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
	public AMFIssue[] findByUuid_C_PrevAndNext(
			long amfissueId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
				orderByComparator)
		throws NoSuchAMFIssueException;

	/**
	 * Removes all the amf issues where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of amf issues where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching amf issues
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the amf issues where amfissueId = &#63;.
	 *
	 * @param amfissueId the amfissue ID
	 * @return the matching amf issues
	 */
	public java.util.List<AMFIssue> findByAMFIssueId(long amfissueId);

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
	public java.util.List<AMFIssue> findByAMFIssueId(
		long amfissueId, int start, int end);

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
	public java.util.List<AMFIssue> findByAMFIssueId(
		long amfissueId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

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
	public java.util.List<AMFIssue> findByAMFIssueId(
		long amfissueId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf issue in the ordered set where amfissueId = &#63;.
	 *
	 * @param amfissueId the amfissue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public AMFIssue findByAMFIssueId_First(
			long amfissueId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
				orderByComparator)
		throws NoSuchAMFIssueException;

	/**
	 * Returns the first amf issue in the ordered set where amfissueId = &#63;.
	 *
	 * @param amfissueId the amfissue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public AMFIssue fetchByAMFIssueId_First(
		long amfissueId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

	/**
	 * Returns the last amf issue in the ordered set where amfissueId = &#63;.
	 *
	 * @param amfissueId the amfissue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public AMFIssue findByAMFIssueId_Last(
			long amfissueId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
				orderByComparator)
		throws NoSuchAMFIssueException;

	/**
	 * Returns the last amf issue in the ordered set where amfissueId = &#63;.
	 *
	 * @param amfissueId the amfissue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public AMFIssue fetchByAMFIssueId_Last(
		long amfissueId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

	/**
	 * Removes all the amf issues where amfissueId = &#63; from the database.
	 *
	 * @param amfissueId the amfissue ID
	 */
	public void removeByAMFIssueId(long amfissueId);

	/**
	 * Returns the number of amf issues where amfissueId = &#63;.
	 *
	 * @param amfissueId the amfissue ID
	 * @return the number of matching amf issues
	 */
	public int countByAMFIssueId(long amfissueId);

	/**
	 * Caches the amf issue in the entity cache if it is enabled.
	 *
	 * @param amfIssue the amf issue
	 */
	public void cacheResult(AMFIssue amfIssue);

	/**
	 * Caches the amf issues in the entity cache if it is enabled.
	 *
	 * @param amfIssues the amf issues
	 */
	public void cacheResult(java.util.List<AMFIssue> amfIssues);

	/**
	 * Creates a new amf issue with the primary key. Does not add the amf issue to the database.
	 *
	 * @param amfissueId the primary key for the new amf issue
	 * @return the new amf issue
	 */
	public AMFIssue create(long amfissueId);

	/**
	 * Removes the amf issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfissueId the primary key of the amf issue
	 * @return the amf issue that was removed
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public AMFIssue remove(long amfissueId) throws NoSuchAMFIssueException;

	public AMFIssue updateImpl(AMFIssue amfIssue);

	/**
	 * Returns the amf issue with the primary key or throws a <code>NoSuchAMFIssueException</code> if it could not be found.
	 *
	 * @param amfissueId the primary key of the amf issue
	 * @return the amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public AMFIssue findByPrimaryKey(long amfissueId)
		throws NoSuchAMFIssueException;

	/**
	 * Returns the amf issue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfissueId the primary key of the amf issue
	 * @return the amf issue, or <code>null</code> if a amf issue with the primary key could not be found
	 */
	public AMFIssue fetchByPrimaryKey(long amfissueId);

	/**
	 * Returns all the amf issues.
	 *
	 * @return the amf issues
	 */
	public java.util.List<AMFIssue> findAll();

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
	public java.util.List<AMFIssue> findAll(int start, int end);

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
	public java.util.List<AMFIssue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

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
	public java.util.List<AMFIssue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the amf issues from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of amf issues.
	 *
	 * @return the number of amf issues
	 */
	public int countAll();

}