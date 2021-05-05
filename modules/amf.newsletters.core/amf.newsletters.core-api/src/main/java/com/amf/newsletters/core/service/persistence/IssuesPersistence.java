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

import com.amf.newsletters.core.exception.NoSuchIssuesException;
import com.amf.newsletters.core.model.Issues;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the issues service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssuesUtil
 * @generated
 */
@ProviderType
public interface IssuesPersistence extends BasePersistence<Issues> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IssuesUtil} to access the issues persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the issueses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching issueses
	 */
	public java.util.List<Issues> findByUuid(String uuid);

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
	public java.util.List<Issues> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Issues> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Issues>
			orderByComparator);

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
	public java.util.List<Issues> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Issues>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first issues in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	public Issues findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Issues>
				orderByComparator)
		throws NoSuchIssuesException;

	/**
	 * Returns the first issues in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public Issues fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Issues>
			orderByComparator);

	/**
	 * Returns the last issues in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	public Issues findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Issues>
				orderByComparator)
		throws NoSuchIssuesException;

	/**
	 * Returns the last issues in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public Issues fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Issues>
			orderByComparator);

	/**
	 * Returns the issueses before and after the current issues in the ordered set where uuid = &#63;.
	 *
	 * @param issueId the primary key of the current issues
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next issues
	 * @throws NoSuchIssuesException if a issues with the primary key could not be found
	 */
	public Issues[] findByUuid_PrevAndNext(
			long issueId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Issues>
				orderByComparator)
		throws NoSuchIssuesException;

	/**
	 * Removes all the issueses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of issueses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching issueses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the issues where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchIssuesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	public Issues findByUUID_G(String uuid, long groupId)
		throws NoSuchIssuesException;

	/**
	 * Returns the issues where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public Issues fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the issues where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public Issues fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the issues where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the issues that was removed
	 */
	public Issues removeByUUID_G(String uuid, long groupId)
		throws NoSuchIssuesException;

	/**
	 * Returns the number of issueses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching issueses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the issueses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching issueses
	 */
	public java.util.List<Issues> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Issues> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Issues> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Issues>
			orderByComparator);

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
	public java.util.List<Issues> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Issues>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first issues in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	public Issues findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Issues>
				orderByComparator)
		throws NoSuchIssuesException;

	/**
	 * Returns the first issues in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public Issues fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Issues>
			orderByComparator);

	/**
	 * Returns the last issues in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	public Issues findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Issues>
				orderByComparator)
		throws NoSuchIssuesException;

	/**
	 * Returns the last issues in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public Issues fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Issues>
			orderByComparator);

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
	public Issues[] findByUuid_C_PrevAndNext(
			long issueId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Issues>
				orderByComparator)
		throws NoSuchIssuesException;

	/**
	 * Removes all the issueses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of issueses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching issueses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the issueses where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @return the matching issueses
	 */
	public java.util.List<Issues> findByIssuedDate(Date issuedDate);

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
	public java.util.List<Issues> findByIssuedDate(
		Date issuedDate, int start, int end);

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
	public java.util.List<Issues> findByIssuedDate(
		Date issuedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Issues>
			orderByComparator);

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
	public java.util.List<Issues> findByIssuedDate(
		Date issuedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Issues>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first issues in the ordered set where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	public Issues findByIssuedDate_First(
			Date issuedDate,
			com.liferay.portal.kernel.util.OrderByComparator<Issues>
				orderByComparator)
		throws NoSuchIssuesException;

	/**
	 * Returns the first issues in the ordered set where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public Issues fetchByIssuedDate_First(
		Date issuedDate,
		com.liferay.portal.kernel.util.OrderByComparator<Issues>
			orderByComparator);

	/**
	 * Returns the last issues in the ordered set where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	public Issues findByIssuedDate_Last(
			Date issuedDate,
			com.liferay.portal.kernel.util.OrderByComparator<Issues>
				orderByComparator)
		throws NoSuchIssuesException;

	/**
	 * Returns the last issues in the ordered set where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues, or <code>null</code> if a matching issues could not be found
	 */
	public Issues fetchByIssuedDate_Last(
		Date issuedDate,
		com.liferay.portal.kernel.util.OrderByComparator<Issues>
			orderByComparator);

	/**
	 * Returns the issueses before and after the current issues in the ordered set where issuedDate = &#63;.
	 *
	 * @param issueId the primary key of the current issues
	 * @param issuedDate the issued date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next issues
	 * @throws NoSuchIssuesException if a issues with the primary key could not be found
	 */
	public Issues[] findByIssuedDate_PrevAndNext(
			long issueId, Date issuedDate,
			com.liferay.portal.kernel.util.OrderByComparator<Issues>
				orderByComparator)
		throws NoSuchIssuesException;

	/**
	 * Removes all the issueses where issuedDate = &#63; from the database.
	 *
	 * @param issuedDate the issued date
	 */
	public void removeByIssuedDate(Date issuedDate);

	/**
	 * Returns the number of issueses where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @return the number of matching issueses
	 */
	public int countByIssuedDate(Date issuedDate);

	/**
	 * Caches the issues in the entity cache if it is enabled.
	 *
	 * @param issues the issues
	 */
	public void cacheResult(Issues issues);

	/**
	 * Caches the issueses in the entity cache if it is enabled.
	 *
	 * @param issueses the issueses
	 */
	public void cacheResult(java.util.List<Issues> issueses);

	/**
	 * Creates a new issues with the primary key. Does not add the issues to the database.
	 *
	 * @param issueId the primary key for the new issues
	 * @return the new issues
	 */
	public Issues create(long issueId);

	/**
	 * Removes the issues with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param issueId the primary key of the issues
	 * @return the issues that was removed
	 * @throws NoSuchIssuesException if a issues with the primary key could not be found
	 */
	public Issues remove(long issueId) throws NoSuchIssuesException;

	public Issues updateImpl(Issues issues);

	/**
	 * Returns the issues with the primary key or throws a <code>NoSuchIssuesException</code> if it could not be found.
	 *
	 * @param issueId the primary key of the issues
	 * @return the issues
	 * @throws NoSuchIssuesException if a issues with the primary key could not be found
	 */
	public Issues findByPrimaryKey(long issueId) throws NoSuchIssuesException;

	/**
	 * Returns the issues with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param issueId the primary key of the issues
	 * @return the issues, or <code>null</code> if a issues with the primary key could not be found
	 */
	public Issues fetchByPrimaryKey(long issueId);

	/**
	 * Returns all the issueses.
	 *
	 * @return the issueses
	 */
	public java.util.List<Issues> findAll();

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
	public java.util.List<Issues> findAll(int start, int end);

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
	public java.util.List<Issues> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Issues>
			orderByComparator);

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
	public java.util.List<Issues> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Issues>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the issueses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of issueses.
	 *
	 * @return the number of issueses
	 */
	public int countAll();

}