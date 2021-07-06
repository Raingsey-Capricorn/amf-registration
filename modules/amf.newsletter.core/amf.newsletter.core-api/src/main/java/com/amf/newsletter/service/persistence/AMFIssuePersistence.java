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

import java.util.Date;

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
	 * @param amfIssueId the primary key of the current amf issue
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public AMFIssue[] findByUuid_PrevAndNext(
			long amfIssueId, String uuid,
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
	 * @param amfIssueId the primary key of the current amf issue
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public AMFIssue[] findByUuid_C_PrevAndNext(
			long amfIssueId, String uuid, long companyId,
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
	 * Returns all the amf issues where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @return the matching amf issues
	 */
	public java.util.List<AMFIssue> findByAMFIssueId(long amfIssueId);

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
	public java.util.List<AMFIssue> findByAMFIssueId(
		long amfIssueId, int start, int end);

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
	public java.util.List<AMFIssue> findByAMFIssueId(
		long amfIssueId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

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
	public java.util.List<AMFIssue> findByAMFIssueId(
		long amfIssueId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf issue in the ordered set where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public AMFIssue findByAMFIssueId_First(
			long amfIssueId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
				orderByComparator)
		throws NoSuchAMFIssueException;

	/**
	 * Returns the first amf issue in the ordered set where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public AMFIssue fetchByAMFIssueId_First(
		long amfIssueId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

	/**
	 * Returns the last amf issue in the ordered set where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public AMFIssue findByAMFIssueId_Last(
			long amfIssueId,
			com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
				orderByComparator)
		throws NoSuchAMFIssueException;

	/**
	 * Returns the last amf issue in the ordered set where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public AMFIssue fetchByAMFIssueId_Last(
		long amfIssueId,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

	/**
	 * Removes all the amf issues where amfIssueId = &#63; from the database.
	 *
	 * @param amfIssueId the amf issue ID
	 */
	public void removeByAMFIssueId(long amfIssueId);

	/**
	 * Returns the number of amf issues where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @return the number of matching amf issues
	 */
	public int countByAMFIssueId(long amfIssueId);

	/**
	 * Returns all the amf issues where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @return the matching amf issues
	 */
	public java.util.List<AMFIssue> findByAMFIssueDate(Date issueDate);

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
	public java.util.List<AMFIssue> findByAMFIssueDate(
		Date issueDate, int start, int end);

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
	public java.util.List<AMFIssue> findByAMFIssueDate(
		Date issueDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

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
	public java.util.List<AMFIssue> findByAMFIssueDate(
		Date issueDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first amf issue in the ordered set where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public AMFIssue findByAMFIssueDate_First(
			Date issueDate,
			com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
				orderByComparator)
		throws NoSuchAMFIssueException;

	/**
	 * Returns the first amf issue in the ordered set where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public AMFIssue fetchByAMFIssueDate_First(
		Date issueDate,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

	/**
	 * Returns the last amf issue in the ordered set where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	public AMFIssue findByAMFIssueDate_Last(
			Date issueDate,
			com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
				orderByComparator)
		throws NoSuchAMFIssueException;

	/**
	 * Returns the last amf issue in the ordered set where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	public AMFIssue fetchByAMFIssueDate_Last(
		Date issueDate,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

	/**
	 * Returns the amf issues before and after the current amf issue in the ordered set where issueDate = &#63;.
	 *
	 * @param amfIssueId the primary key of the current amf issue
	 * @param issueDate the issue date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public AMFIssue[] findByAMFIssueDate_PrevAndNext(
			long amfIssueId, Date issueDate,
			com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
				orderByComparator)
		throws NoSuchAMFIssueException;

	/**
	 * Removes all the amf issues where issueDate = &#63; from the database.
	 *
	 * @param issueDate the issue date
	 */
	public void removeByAMFIssueDate(Date issueDate);

	/**
	 * Returns the number of amf issues where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @return the number of matching amf issues
	 */
	public int countByAMFIssueDate(Date issueDate);

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
	 * @param amfIssueId the primary key for the new amf issue
	 * @return the new amf issue
	 */
	public AMFIssue create(long amfIssueId);

	/**
	 * Removes the amf issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfIssueId the primary key of the amf issue
	 * @return the amf issue that was removed
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public AMFIssue remove(long amfIssueId) throws NoSuchAMFIssueException;

	public AMFIssue updateImpl(AMFIssue amfIssue);

	/**
	 * Returns the amf issue with the primary key or throws a <code>NoSuchAMFIssueException</code> if it could not be found.
	 *
	 * @param amfIssueId the primary key of the amf issue
	 * @return the amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	public AMFIssue findByPrimaryKey(long amfIssueId)
		throws NoSuchAMFIssueException;

	/**
	 * Returns the amf issue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfIssueId the primary key of the amf issue
	 * @return the amf issue, or <code>null</code> if a amf issue with the primary key could not be found
	 */
	public AMFIssue fetchByPrimaryKey(long amfIssueId);

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

	/**
	 * Returns the primaryKeys of amf articles associated with the amf issue.
	 *
	 * @param pk the primary key of the amf issue
	 * @return long[] of the primaryKeys of amf articles associated with the amf issue
	 */
	public long[] getAMFArticlePrimaryKeys(long pk);

	/**
	 * Returns all the amf issue associated with the amf article.
	 *
	 * @param pk the primary key of the amf article
	 * @return the amf issues associated with the amf article
	 */
	public java.util.List<AMFIssue> getAMFArticleAMFIssues(long pk);

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
	public java.util.List<AMFIssue> getAMFArticleAMFIssues(
		long pk, int start, int end);

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
	public java.util.List<AMFIssue> getAMFArticleAMFIssues(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AMFIssue>
			orderByComparator);

	/**
	 * Returns the number of amf articles associated with the amf issue.
	 *
	 * @param pk the primary key of the amf issue
	 * @return the number of amf articles associated with the amf issue
	 */
	public int getAMFArticlesSize(long pk);

	/**
	 * Returns <code>true</code> if the amf article is associated with the amf issue.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePK the primary key of the amf article
	 * @return <code>true</code> if the amf article is associated with the amf issue; <code>false</code> otherwise
	 */
	public boolean containsAMFArticle(long pk, long amfArticlePK);

	/**
	 * Returns <code>true</code> if the amf issue has any amf articles associated with it.
	 *
	 * @param pk the primary key of the amf issue to check for associations with amf articles
	 * @return <code>true</code> if the amf issue has any amf articles associated with it; <code>false</code> otherwise
	 */
	public boolean containsAMFArticles(long pk);

	/**
	 * Adds an association between the amf issue and the amf article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePK the primary key of the amf article
	 */
	public void addAMFArticle(long pk, long amfArticlePK);

	/**
	 * Adds an association between the amf issue and the amf article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticle the amf article
	 */
	public void addAMFArticle(
		long pk, com.amf.newsletter.model.AMFArticle amfArticle);

	/**
	 * Adds an association between the amf issue and the amf articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePKs the primary keys of the amf articles
	 */
	public void addAMFArticles(long pk, long[] amfArticlePKs);

	/**
	 * Adds an association between the amf issue and the amf articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticles the amf articles
	 */
	public void addAMFArticles(
		long pk,
		java.util.List<com.amf.newsletter.model.AMFArticle> amfArticles);

	/**
	 * Clears all associations between the amf issue and its amf articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue to clear the associated amf articles from
	 */
	public void clearAMFArticles(long pk);

	/**
	 * Removes the association between the amf issue and the amf article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePK the primary key of the amf article
	 */
	public void removeAMFArticle(long pk, long amfArticlePK);

	/**
	 * Removes the association between the amf issue and the amf article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticle the amf article
	 */
	public void removeAMFArticle(
		long pk, com.amf.newsletter.model.AMFArticle amfArticle);

	/**
	 * Removes the association between the amf issue and the amf articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePKs the primary keys of the amf articles
	 */
	public void removeAMFArticles(long pk, long[] amfArticlePKs);

	/**
	 * Removes the association between the amf issue and the amf articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticles the amf articles
	 */
	public void removeAMFArticles(
		long pk,
		java.util.List<com.amf.newsletter.model.AMFArticle> amfArticles);

	/**
	 * Sets the amf articles associated with the amf issue, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePKs the primary keys of the amf articles to be associated with the amf issue
	 */
	public void setAMFArticles(long pk, long[] amfArticlePKs);

	/**
	 * Sets the amf articles associated with the amf issue, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticles the amf articles to be associated with the amf issue
	 */
	public void setAMFArticles(
		long pk,
		java.util.List<com.amf.newsletter.model.AMFArticle> amfArticles);

}