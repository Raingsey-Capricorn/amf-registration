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

package com.amf.newsletters.service.persistence.impl;

import com.amf.newsletters.exception.NoSuchIssuesException;
import com.amf.newsletters.model.Issues;
import com.amf.newsletters.model.impl.IssuesImpl;
import com.amf.newsletters.model.impl.IssuesModelImpl;
import com.amf.newsletters.service.persistence.IssuesPersistence;
import com.amf.newsletters.service.persistence.impl.constants.NewsletterPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the issues service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = IssuesPersistence.class)
public class IssuesPersistenceImpl
	extends BasePersistenceImpl<Issues> implements IssuesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>IssuesUtil</code> to access the issues persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		IssuesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the issueses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching issueses
	 */
	@Override
	public List<Issues> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Issues> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Issues> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Issues> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Issues> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Issues> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Issues> list = null;

		if (useFinderCache) {
			list = (List<Issues>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Issues issues : list) {
					if (!uuid.equals(issues.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ISSUES_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IssuesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Issues>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first issues in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	@Override
	public Issues findByUuid_First(
			String uuid, OrderByComparator<Issues> orderByComparator)
		throws NoSuchIssuesException {

		Issues issues = fetchByUuid_First(uuid, orderByComparator);

		if (issues != null) {
			return issues;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchIssuesException(sb.toString());
	}

	/**
	 * Returns the first issues in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues, or <code>null</code> if a matching issues could not be found
	 */
	@Override
	public Issues fetchByUuid_First(
		String uuid, OrderByComparator<Issues> orderByComparator) {

		List<Issues> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last issues in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	@Override
	public Issues findByUuid_Last(
			String uuid, OrderByComparator<Issues> orderByComparator)
		throws NoSuchIssuesException {

		Issues issues = fetchByUuid_Last(uuid, orderByComparator);

		if (issues != null) {
			return issues;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchIssuesException(sb.toString());
	}

	/**
	 * Returns the last issues in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues, or <code>null</code> if a matching issues could not be found
	 */
	@Override
	public Issues fetchByUuid_Last(
		String uuid, OrderByComparator<Issues> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Issues> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Issues[] findByUuid_PrevAndNext(
			long issueId, String uuid,
			OrderByComparator<Issues> orderByComparator)
		throws NoSuchIssuesException {

		uuid = Objects.toString(uuid, "");

		Issues issues = findByPrimaryKey(issueId);

		Session session = null;

		try {
			session = openSession();

			Issues[] array = new IssuesImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, issues, uuid, orderByComparator, true);

			array[1] = issues;

			array[2] = getByUuid_PrevAndNext(
				session, issues, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Issues getByUuid_PrevAndNext(
		Session session, Issues issues, String uuid,
		OrderByComparator<Issues> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ISSUES_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(IssuesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(issues)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Issues> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the issueses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Issues issues :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(issues);
		}
	}

	/**
	 * Returns the number of issueses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching issueses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ISSUES_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "issues.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(issues.uuid IS NULL OR issues.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the issues where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchIssuesException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	@Override
	public Issues findByUUID_G(String uuid, long groupId)
		throws NoSuchIssuesException {

		Issues issues = fetchByUUID_G(uuid, groupId);

		if (issues == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchIssuesException(sb.toString());
		}

		return issues;
	}

	/**
	 * Returns the issues where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching issues, or <code>null</code> if a matching issues could not be found
	 */
	@Override
	public Issues fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the issues where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching issues, or <code>null</code> if a matching issues could not be found
	 */
	@Override
	public Issues fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Issues) {
			Issues issues = (Issues)result;

			if (!Objects.equals(uuid, issues.getUuid()) ||
				(groupId != issues.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ISSUES_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Issues> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Issues issues = list.get(0);

					result = issues;

					cacheResult(issues);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Issues)result;
		}
	}

	/**
	 * Removes the issues where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the issues that was removed
	 */
	@Override
	public Issues removeByUUID_G(String uuid, long groupId)
		throws NoSuchIssuesException {

		Issues issues = findByUUID_G(uuid, groupId);

		return remove(issues);
	}

	/**
	 * Returns the number of issueses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching issueses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ISSUES_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"issues.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(issues.uuid IS NULL OR issues.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"issues.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the issueses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching issueses
	 */
	@Override
	public List<Issues> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Issues> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Issues> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Issues> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Issues> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Issues> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Issues> list = null;

		if (useFinderCache) {
			list = (List<Issues>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Issues issues : list) {
					if (!uuid.equals(issues.getUuid()) ||
						(companyId != issues.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_ISSUES_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IssuesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Issues>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Issues findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Issues> orderByComparator)
		throws NoSuchIssuesException {

		Issues issues = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (issues != null) {
			return issues;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchIssuesException(sb.toString());
	}

	/**
	 * Returns the first issues in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues, or <code>null</code> if a matching issues could not be found
	 */
	@Override
	public Issues fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Issues> orderByComparator) {

		List<Issues> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Issues findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Issues> orderByComparator)
		throws NoSuchIssuesException {

		Issues issues = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (issues != null) {
			return issues;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchIssuesException(sb.toString());
	}

	/**
	 * Returns the last issues in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues, or <code>null</code> if a matching issues could not be found
	 */
	@Override
	public Issues fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Issues> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Issues> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Issues[] findByUuid_C_PrevAndNext(
			long issueId, String uuid, long companyId,
			OrderByComparator<Issues> orderByComparator)
		throws NoSuchIssuesException {

		uuid = Objects.toString(uuid, "");

		Issues issues = findByPrimaryKey(issueId);

		Session session = null;

		try {
			session = openSession();

			Issues[] array = new IssuesImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, issues, uuid, companyId, orderByComparator, true);

			array[1] = issues;

			array[2] = getByUuid_C_PrevAndNext(
				session, issues, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Issues getByUuid_C_PrevAndNext(
		Session session, Issues issues, String uuid, long companyId,
		OrderByComparator<Issues> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ISSUES_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(IssuesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(issues)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Issues> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the issueses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Issues issues :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(issues);
		}
	}

	/**
	 * Returns the number of issueses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching issueses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ISSUES_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"issues.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(issues.uuid IS NULL OR issues.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"issues.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByIssuedDate;
	private FinderPath _finderPathWithoutPaginationFindByIssuedDate;
	private FinderPath _finderPathCountByIssuedDate;

	/**
	 * Returns all the issueses where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @return the matching issueses
	 */
	@Override
	public List<Issues> findByIssuedDate(Date issuedDate) {
		return findByIssuedDate(
			issuedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Issues> findByIssuedDate(Date issuedDate, int start, int end) {
		return findByIssuedDate(issuedDate, start, end, null);
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
	@Override
	public List<Issues> findByIssuedDate(
		Date issuedDate, int start, int end,
		OrderByComparator<Issues> orderByComparator) {

		return findByIssuedDate(
			issuedDate, start, end, orderByComparator, true);
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
	@Override
	public List<Issues> findByIssuedDate(
		Date issuedDate, int start, int end,
		OrderByComparator<Issues> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByIssuedDate;
				finderArgs = new Object[] {_getTime(issuedDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByIssuedDate;
			finderArgs = new Object[] {
				_getTime(issuedDate), start, end, orderByComparator
			};
		}

		List<Issues> list = null;

		if (useFinderCache) {
			list = (List<Issues>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Issues issues : list) {
					if (!Objects.equals(issuedDate, issues.getIssuedDate())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ISSUES_WHERE);

			boolean bindIssuedDate = false;

			if (issuedDate == null) {
				sb.append(_FINDER_COLUMN_ISSUEDDATE_ISSUEDDATE_1);
			}
			else {
				bindIssuedDate = true;

				sb.append(_FINDER_COLUMN_ISSUEDDATE_ISSUEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IssuesModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIssuedDate) {
					queryPos.add(new Timestamp(issuedDate.getTime()));
				}

				list = (List<Issues>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first issues in the ordered set where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	@Override
	public Issues findByIssuedDate_First(
			Date issuedDate, OrderByComparator<Issues> orderByComparator)
		throws NoSuchIssuesException {

		Issues issues = fetchByIssuedDate_First(issuedDate, orderByComparator);

		if (issues != null) {
			return issues;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("issuedDate=");
		sb.append(issuedDate);

		sb.append("}");

		throw new NoSuchIssuesException(sb.toString());
	}

	/**
	 * Returns the first issues in the ordered set where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issues, or <code>null</code> if a matching issues could not be found
	 */
	@Override
	public Issues fetchByIssuedDate_First(
		Date issuedDate, OrderByComparator<Issues> orderByComparator) {

		List<Issues> list = findByIssuedDate(
			issuedDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last issues in the ordered set where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues
	 * @throws NoSuchIssuesException if a matching issues could not be found
	 */
	@Override
	public Issues findByIssuedDate_Last(
			Date issuedDate, OrderByComparator<Issues> orderByComparator)
		throws NoSuchIssuesException {

		Issues issues = fetchByIssuedDate_Last(issuedDate, orderByComparator);

		if (issues != null) {
			return issues;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("issuedDate=");
		sb.append(issuedDate);

		sb.append("}");

		throw new NoSuchIssuesException(sb.toString());
	}

	/**
	 * Returns the last issues in the ordered set where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issues, or <code>null</code> if a matching issues could not be found
	 */
	@Override
	public Issues fetchByIssuedDate_Last(
		Date issuedDate, OrderByComparator<Issues> orderByComparator) {

		int count = countByIssuedDate(issuedDate);

		if (count == 0) {
			return null;
		}

		List<Issues> list = findByIssuedDate(
			issuedDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Issues[] findByIssuedDate_PrevAndNext(
			long issueId, Date issuedDate,
			OrderByComparator<Issues> orderByComparator)
		throws NoSuchIssuesException {

		Issues issues = findByPrimaryKey(issueId);

		Session session = null;

		try {
			session = openSession();

			Issues[] array = new IssuesImpl[3];

			array[0] = getByIssuedDate_PrevAndNext(
				session, issues, issuedDate, orderByComparator, true);

			array[1] = issues;

			array[2] = getByIssuedDate_PrevAndNext(
				session, issues, issuedDate, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Issues getByIssuedDate_PrevAndNext(
		Session session, Issues issues, Date issuedDate,
		OrderByComparator<Issues> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ISSUES_WHERE);

		boolean bindIssuedDate = false;

		if (issuedDate == null) {
			sb.append(_FINDER_COLUMN_ISSUEDDATE_ISSUEDDATE_1);
		}
		else {
			bindIssuedDate = true;

			sb.append(_FINDER_COLUMN_ISSUEDDATE_ISSUEDDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(IssuesModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindIssuedDate) {
			queryPos.add(new Timestamp(issuedDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(issues)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Issues> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the issueses where issuedDate = &#63; from the database.
	 *
	 * @param issuedDate the issued date
	 */
	@Override
	public void removeByIssuedDate(Date issuedDate) {
		for (Issues issues :
				findByIssuedDate(
					issuedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(issues);
		}
	}

	/**
	 * Returns the number of issueses where issuedDate = &#63;.
	 *
	 * @param issuedDate the issued date
	 * @return the number of matching issueses
	 */
	@Override
	public int countByIssuedDate(Date issuedDate) {
		FinderPath finderPath = _finderPathCountByIssuedDate;

		Object[] finderArgs = new Object[] {_getTime(issuedDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ISSUES_WHERE);

			boolean bindIssuedDate = false;

			if (issuedDate == null) {
				sb.append(_FINDER_COLUMN_ISSUEDDATE_ISSUEDDATE_1);
			}
			else {
				bindIssuedDate = true;

				sb.append(_FINDER_COLUMN_ISSUEDDATE_ISSUEDDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIssuedDate) {
					queryPos.add(new Timestamp(issuedDate.getTime()));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ISSUEDDATE_ISSUEDDATE_1 =
		"issues.issuedDate IS NULL";

	private static final String _FINDER_COLUMN_ISSUEDDATE_ISSUEDDATE_2 =
		"issues.issuedDate = ?";

	public IssuesPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Issues.class);

		setModelImplClass(IssuesImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the issues in the entity cache if it is enabled.
	 *
	 * @param issues the issues
	 */
	@Override
	public void cacheResult(Issues issues) {
		entityCache.putResult(IssuesImpl.class, issues.getPrimaryKey(), issues);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {issues.getUuid(), issues.getGroupId()}, issues);
	}

	/**
	 * Caches the issueses in the entity cache if it is enabled.
	 *
	 * @param issueses the issueses
	 */
	@Override
	public void cacheResult(List<Issues> issueses) {
		for (Issues issues : issueses) {
			if (entityCache.getResult(
					IssuesImpl.class, issues.getPrimaryKey()) == null) {

				cacheResult(issues);
			}
		}
	}

	/**
	 * Clears the cache for all issueses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IssuesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the issues.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Issues issues) {
		entityCache.removeResult(IssuesImpl.class, issues);
	}

	@Override
	public void clearCache(List<Issues> issueses) {
		for (Issues issues : issueses) {
			entityCache.removeResult(IssuesImpl.class, issues);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(IssuesImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(IssuesModelImpl issuesModelImpl) {
		Object[] args = new Object[] {
			issuesModelImpl.getUuid(), issuesModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, issuesModelImpl, false);
	}

	/**
	 * Creates a new issues with the primary key. Does not add the issues to the database.
	 *
	 * @param issueId the primary key for the new issues
	 * @return the new issues
	 */
	@Override
	public Issues create(long issueId) {
		Issues issues = new IssuesImpl();

		issues.setNew(true);
		issues.setPrimaryKey(issueId);

		String uuid = PortalUUIDUtil.generate();

		issues.setUuid(uuid);

		issues.setCompanyId(CompanyThreadLocal.getCompanyId());

		return issues;
	}

	/**
	 * Removes the issues with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param issueId the primary key of the issues
	 * @return the issues that was removed
	 * @throws NoSuchIssuesException if a issues with the primary key could not be found
	 */
	@Override
	public Issues remove(long issueId) throws NoSuchIssuesException {
		return remove((Serializable)issueId);
	}

	/**
	 * Removes the issues with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the issues
	 * @return the issues that was removed
	 * @throws NoSuchIssuesException if a issues with the primary key could not be found
	 */
	@Override
	public Issues remove(Serializable primaryKey) throws NoSuchIssuesException {
		Session session = null;

		try {
			session = openSession();

			Issues issues = (Issues)session.get(IssuesImpl.class, primaryKey);

			if (issues == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIssuesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(issues);
		}
		catch (NoSuchIssuesException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Issues removeImpl(Issues issues) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(issues)) {
				issues = (Issues)session.get(
					IssuesImpl.class, issues.getPrimaryKeyObj());
			}

			if (issues != null) {
				session.delete(issues);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (issues != null) {
			clearCache(issues);
		}

		return issues;
	}

	@Override
	public Issues updateImpl(Issues issues) {
		boolean isNew = issues.isNew();

		if (!(issues instanceof IssuesModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(issues.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(issues);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in issues proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Issues implementation " +
					issues.getClass());
		}

		IssuesModelImpl issuesModelImpl = (IssuesModelImpl)issues;

		if (Validator.isNull(issues.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			issues.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (issues.getCreateDate() == null)) {
			if (serviceContext == null) {
				issues.setCreateDate(now);
			}
			else {
				issues.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!issuesModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				issues.setModifiedDate(now);
			}
			else {
				issues.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(issues);
			}
			else {
				issues = (Issues)session.merge(issues);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(IssuesImpl.class, issuesModelImpl, false, true);

		cacheUniqueFindersCache(issuesModelImpl);

		if (isNew) {
			issues.setNew(false);
		}

		issues.resetOriginalValues();

		return issues;
	}

	/**
	 * Returns the issues with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the issues
	 * @return the issues
	 * @throws NoSuchIssuesException if a issues with the primary key could not be found
	 */
	@Override
	public Issues findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIssuesException {

		Issues issues = fetchByPrimaryKey(primaryKey);

		if (issues == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIssuesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return issues;
	}

	/**
	 * Returns the issues with the primary key or throws a <code>NoSuchIssuesException</code> if it could not be found.
	 *
	 * @param issueId the primary key of the issues
	 * @return the issues
	 * @throws NoSuchIssuesException if a issues with the primary key could not be found
	 */
	@Override
	public Issues findByPrimaryKey(long issueId) throws NoSuchIssuesException {
		return findByPrimaryKey((Serializable)issueId);
	}

	/**
	 * Returns the issues with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param issueId the primary key of the issues
	 * @return the issues, or <code>null</code> if a issues with the primary key could not be found
	 */
	@Override
	public Issues fetchByPrimaryKey(long issueId) {
		return fetchByPrimaryKey((Serializable)issueId);
	}

	/**
	 * Returns all the issueses.
	 *
	 * @return the issueses
	 */
	@Override
	public List<Issues> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Issues> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Issues> findAll(
		int start, int end, OrderByComparator<Issues> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Issues> findAll(
		int start, int end, OrderByComparator<Issues> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Issues> list = null;

		if (useFinderCache) {
			list = (List<Issues>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ISSUES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ISSUES;

				sql = sql.concat(IssuesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Issues>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the issueses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Issues issues : findAll()) {
			remove(issues);
		}
	}

	/**
	 * Returns the number of issueses.
	 *
	 * @return the number of issueses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ISSUES);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "issueId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ISSUES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return IssuesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the issues persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new IssuesModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Issues.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByIssuedDate = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIssuedDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"issuedDate"}, true);

		_finderPathWithoutPaginationFindByIssuedDate = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIssuedDate",
			new String[] {Date.class.getName()}, new String[] {"issuedDate"},
			true);

		_finderPathCountByIssuedDate = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIssuedDate",
			new String[] {Date.class.getName()}, new String[] {"issuedDate"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(IssuesImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = NewsletterPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = NewsletterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = NewsletterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_ISSUES =
		"SELECT issues FROM Issues issues";

	private static final String _SQL_SELECT_ISSUES_WHERE =
		"SELECT issues FROM Issues issues WHERE ";

	private static final String _SQL_COUNT_ISSUES =
		"SELECT COUNT(issues) FROM Issues issues";

	private static final String _SQL_COUNT_ISSUES_WHERE =
		"SELECT COUNT(issues) FROM Issues issues WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "issues.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Issues exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Issues exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		IssuesPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(NewsletterPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class IssuesModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			IssuesModelImpl issuesModelImpl = (IssuesModelImpl)baseModel;

			long columnBitmask = issuesModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(issuesModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= issuesModelImpl.getColumnBitmask(
						columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(issuesModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			IssuesModelImpl issuesModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = issuesModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = issuesModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}