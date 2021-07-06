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

package com.amf.newsletter.service.persistence.impl;

import com.amf.newsletter.exception.NoSuchAMFIssueException;
import com.amf.newsletter.model.AMFArticle;
import com.amf.newsletter.model.AMFIssue;
import com.amf.newsletter.model.impl.AMFIssueImpl;
import com.amf.newsletter.model.impl.AMFIssueModelImpl;
import com.amf.newsletter.service.persistence.AMFIssuePersistence;
import com.amf.newsletter.service.persistence.impl.constants.AMFNewsletterPersistenceConstants;

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
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ListUtil;
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
 * The persistence implementation for the amf issue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AMFIssuePersistence.class)
public class AMFIssuePersistenceImpl
	extends BasePersistenceImpl<AMFIssue> implements AMFIssuePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AMFIssueUtil</code> to access the amf issue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AMFIssueImpl.class.getName();

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
	 * Returns all the amf issues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amf issues
	 */
	@Override
	public List<AMFIssue> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AMFIssue> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<AMFIssue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<AMFIssue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator, boolean useFinderCache) {

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

		List<AMFIssue> list = null;

		if (useFinderCache) {
			list = (List<AMFIssue>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AMFIssue amfIssue : list) {
					if (!uuid.equals(amfIssue.getUuid())) {
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

			sb.append(_SQL_SELECT_AMFISSUE_WHERE);

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
				sb.append(AMFIssueModelImpl.ORDER_BY_JPQL);
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

				list = (List<AMFIssue>)QueryUtil.list(
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
	 * Returns the first amf issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue findByUuid_First(
			String uuid, OrderByComparator<AMFIssue> orderByComparator)
		throws NoSuchAMFIssueException {

		AMFIssue amfIssue = fetchByUuid_First(uuid, orderByComparator);

		if (amfIssue != null) {
			return amfIssue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAMFIssueException(sb.toString());
	}

	/**
	 * Returns the first amf issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue fetchByUuid_First(
		String uuid, OrderByComparator<AMFIssue> orderByComparator) {

		List<AMFIssue> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue findByUuid_Last(
			String uuid, OrderByComparator<AMFIssue> orderByComparator)
		throws NoSuchAMFIssueException {

		AMFIssue amfIssue = fetchByUuid_Last(uuid, orderByComparator);

		if (amfIssue != null) {
			return amfIssue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAMFIssueException(sb.toString());
	}

	/**
	 * Returns the last amf issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue fetchByUuid_Last(
		String uuid, OrderByComparator<AMFIssue> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AMFIssue> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amf issues before and after the current amf issue in the ordered set where uuid = &#63;.
	 *
	 * @param amfIssueId the primary key of the current amf issue
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	@Override
	public AMFIssue[] findByUuid_PrevAndNext(
			long amfIssueId, String uuid,
			OrderByComparator<AMFIssue> orderByComparator)
		throws NoSuchAMFIssueException {

		uuid = Objects.toString(uuid, "");

		AMFIssue amfIssue = findByPrimaryKey(amfIssueId);

		Session session = null;

		try {
			session = openSession();

			AMFIssue[] array = new AMFIssueImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, amfIssue, uuid, orderByComparator, true);

			array[1] = amfIssue;

			array[2] = getByUuid_PrevAndNext(
				session, amfIssue, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AMFIssue getByUuid_PrevAndNext(
		Session session, AMFIssue amfIssue, String uuid,
		OrderByComparator<AMFIssue> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AMFISSUE_WHERE);

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
			sb.append(AMFIssueModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(amfIssue)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AMFIssue> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf issues where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AMFIssue amfIssue :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(amfIssue);
		}
	}

	/**
	 * Returns the number of amf issues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amf issues
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AMFISSUE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"amfIssue.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(amfIssue.uuid IS NULL OR amfIssue.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the amf issue where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAMFIssueException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue findByUUID_G(String uuid, long groupId)
		throws NoSuchAMFIssueException {

		AMFIssue amfIssue = fetchByUUID_G(uuid, groupId);

		if (amfIssue == null) {
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

			throw new NoSuchAMFIssueException(sb.toString());
		}

		return amfIssue;
	}

	/**
	 * Returns the amf issue where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the amf issue where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue fetchByUUID_G(
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

		if (result instanceof AMFIssue) {
			AMFIssue amfIssue = (AMFIssue)result;

			if (!Objects.equals(uuid, amfIssue.getUuid()) ||
				(groupId != amfIssue.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_AMFISSUE_WHERE);

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

				List<AMFIssue> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AMFIssue amfIssue = list.get(0);

					result = amfIssue;

					cacheResult(amfIssue);
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
			return (AMFIssue)result;
		}
	}

	/**
	 * Removes the amf issue where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the amf issue that was removed
	 */
	@Override
	public AMFIssue removeByUUID_G(String uuid, long groupId)
		throws NoSuchAMFIssueException {

		AMFIssue amfIssue = findByUUID_G(uuid, groupId);

		return remove(amfIssue);
	}

	/**
	 * Returns the number of amf issues where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching amf issues
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AMFISSUE_WHERE);

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
		"amfIssue.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(amfIssue.uuid IS NULL OR amfIssue.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"amfIssue.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the amf issues where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching amf issues
	 */
	@Override
	public List<AMFIssue> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AMFIssue> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<AMFIssue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<AMFIssue> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator, boolean useFinderCache) {

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

		List<AMFIssue> list = null;

		if (useFinderCache) {
			list = (List<AMFIssue>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AMFIssue amfIssue : list) {
					if (!uuid.equals(amfIssue.getUuid()) ||
						(companyId != amfIssue.getCompanyId())) {

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

			sb.append(_SQL_SELECT_AMFISSUE_WHERE);

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
				sb.append(AMFIssueModelImpl.ORDER_BY_JPQL);
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

				list = (List<AMFIssue>)QueryUtil.list(
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
	 * Returns the first amf issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AMFIssue> orderByComparator)
		throws NoSuchAMFIssueException {

		AMFIssue amfIssue = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (amfIssue != null) {
			return amfIssue;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAMFIssueException(sb.toString());
	}

	/**
	 * Returns the first amf issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AMFIssue> orderByComparator) {

		List<AMFIssue> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AMFIssue findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AMFIssue> orderByComparator)
		throws NoSuchAMFIssueException {

		AMFIssue amfIssue = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (amfIssue != null) {
			return amfIssue;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAMFIssueException(sb.toString());
	}

	/**
	 * Returns the last amf issue in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AMFIssue> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AMFIssue> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public AMFIssue[] findByUuid_C_PrevAndNext(
			long amfIssueId, String uuid, long companyId,
			OrderByComparator<AMFIssue> orderByComparator)
		throws NoSuchAMFIssueException {

		uuid = Objects.toString(uuid, "");

		AMFIssue amfIssue = findByPrimaryKey(amfIssueId);

		Session session = null;

		try {
			session = openSession();

			AMFIssue[] array = new AMFIssueImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, amfIssue, uuid, companyId, orderByComparator, true);

			array[1] = amfIssue;

			array[2] = getByUuid_C_PrevAndNext(
				session, amfIssue, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AMFIssue getByUuid_C_PrevAndNext(
		Session session, AMFIssue amfIssue, String uuid, long companyId,
		OrderByComparator<AMFIssue> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_AMFISSUE_WHERE);

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
			sb.append(AMFIssueModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(amfIssue)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AMFIssue> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf issues where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AMFIssue amfIssue :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(amfIssue);
		}
	}

	/**
	 * Returns the number of amf issues where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching amf issues
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AMFISSUE_WHERE);

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
		"amfIssue.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(amfIssue.uuid IS NULL OR amfIssue.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"amfIssue.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByAMFIssueId;
	private FinderPath _finderPathWithoutPaginationFindByAMFIssueId;
	private FinderPath _finderPathCountByAMFIssueId;

	/**
	 * Returns all the amf issues where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @return the matching amf issues
	 */
	@Override
	public List<AMFIssue> findByAMFIssueId(long amfIssueId) {
		return findByAMFIssueId(
			amfIssueId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<AMFIssue> findByAMFIssueId(
		long amfIssueId, int start, int end) {

		return findByAMFIssueId(amfIssueId, start, end, null);
	}

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
	@Override
	public List<AMFIssue> findByAMFIssueId(
		long amfIssueId, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator) {

		return findByAMFIssueId(
			amfIssueId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<AMFIssue> findByAMFIssueId(
		long amfIssueId, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAMFIssueId;
				finderArgs = new Object[] {amfIssueId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAMFIssueId;
			finderArgs = new Object[] {
				amfIssueId, start, end, orderByComparator
			};
		}

		List<AMFIssue> list = null;

		if (useFinderCache) {
			list = (List<AMFIssue>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AMFIssue amfIssue : list) {
					if (amfIssueId != amfIssue.getAmfIssueId()) {
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

			sb.append(_SQL_SELECT_AMFISSUE_WHERE);

			sb.append(_FINDER_COLUMN_AMFISSUEID_AMFISSUEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AMFIssueModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(amfIssueId);

				list = (List<AMFIssue>)QueryUtil.list(
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
	 * Returns the first amf issue in the ordered set where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue findByAMFIssueId_First(
			long amfIssueId, OrderByComparator<AMFIssue> orderByComparator)
		throws NoSuchAMFIssueException {

		AMFIssue amfIssue = fetchByAMFIssueId_First(
			amfIssueId, orderByComparator);

		if (amfIssue != null) {
			return amfIssue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("amfIssueId=");
		sb.append(amfIssueId);

		sb.append("}");

		throw new NoSuchAMFIssueException(sb.toString());
	}

	/**
	 * Returns the first amf issue in the ordered set where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue fetchByAMFIssueId_First(
		long amfIssueId, OrderByComparator<AMFIssue> orderByComparator) {

		List<AMFIssue> list = findByAMFIssueId(
			amfIssueId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf issue in the ordered set where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue findByAMFIssueId_Last(
			long amfIssueId, OrderByComparator<AMFIssue> orderByComparator)
		throws NoSuchAMFIssueException {

		AMFIssue amfIssue = fetchByAMFIssueId_Last(
			amfIssueId, orderByComparator);

		if (amfIssue != null) {
			return amfIssue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("amfIssueId=");
		sb.append(amfIssueId);

		sb.append("}");

		throw new NoSuchAMFIssueException(sb.toString());
	}

	/**
	 * Returns the last amf issue in the ordered set where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue fetchByAMFIssueId_Last(
		long amfIssueId, OrderByComparator<AMFIssue> orderByComparator) {

		int count = countByAMFIssueId(amfIssueId);

		if (count == 0) {
			return null;
		}

		List<AMFIssue> list = findByAMFIssueId(
			amfIssueId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the amf issues where amfIssueId = &#63; from the database.
	 *
	 * @param amfIssueId the amf issue ID
	 */
	@Override
	public void removeByAMFIssueId(long amfIssueId) {
		for (AMFIssue amfIssue :
				findByAMFIssueId(
					amfIssueId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(amfIssue);
		}
	}

	/**
	 * Returns the number of amf issues where amfIssueId = &#63;.
	 *
	 * @param amfIssueId the amf issue ID
	 * @return the number of matching amf issues
	 */
	@Override
	public int countByAMFIssueId(long amfIssueId) {
		FinderPath finderPath = _finderPathCountByAMFIssueId;

		Object[] finderArgs = new Object[] {amfIssueId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AMFISSUE_WHERE);

			sb.append(_FINDER_COLUMN_AMFISSUEID_AMFISSUEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(amfIssueId);

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

	private static final String _FINDER_COLUMN_AMFISSUEID_AMFISSUEID_2 =
		"amfIssue.amfIssueId = ?";

	private FinderPath _finderPathWithPaginationFindByAMFIssueDate;
	private FinderPath _finderPathWithoutPaginationFindByAMFIssueDate;
	private FinderPath _finderPathCountByAMFIssueDate;

	/**
	 * Returns all the amf issues where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @return the matching amf issues
	 */
	@Override
	public List<AMFIssue> findByAMFIssueDate(Date issueDate) {
		return findByAMFIssueDate(
			issueDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<AMFIssue> findByAMFIssueDate(
		Date issueDate, int start, int end) {

		return findByAMFIssueDate(issueDate, start, end, null);
	}

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
	@Override
	public List<AMFIssue> findByAMFIssueDate(
		Date issueDate, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator) {

		return findByAMFIssueDate(
			issueDate, start, end, orderByComparator, true);
	}

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
	@Override
	public List<AMFIssue> findByAMFIssueDate(
		Date issueDate, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAMFIssueDate;
				finderArgs = new Object[] {_getTime(issueDate)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAMFIssueDate;
			finderArgs = new Object[] {
				_getTime(issueDate), start, end, orderByComparator
			};
		}

		List<AMFIssue> list = null;

		if (useFinderCache) {
			list = (List<AMFIssue>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AMFIssue amfIssue : list) {
					if (!Objects.equals(issueDate, amfIssue.getIssueDate())) {
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

			sb.append(_SQL_SELECT_AMFISSUE_WHERE);

			boolean bindIssueDate = false;

			if (issueDate == null) {
				sb.append(_FINDER_COLUMN_AMFISSUEDATE_ISSUEDATE_1);
			}
			else {
				bindIssueDate = true;

				sb.append(_FINDER_COLUMN_AMFISSUEDATE_ISSUEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AMFIssueModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIssueDate) {
					queryPos.add(new Timestamp(issueDate.getTime()));
				}

				list = (List<AMFIssue>)QueryUtil.list(
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
	 * Returns the first amf issue in the ordered set where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue findByAMFIssueDate_First(
			Date issueDate, OrderByComparator<AMFIssue> orderByComparator)
		throws NoSuchAMFIssueException {

		AMFIssue amfIssue = fetchByAMFIssueDate_First(
			issueDate, orderByComparator);

		if (amfIssue != null) {
			return amfIssue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("issueDate=");
		sb.append(issueDate);

		sb.append("}");

		throw new NoSuchAMFIssueException(sb.toString());
	}

	/**
	 * Returns the first amf issue in the ordered set where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue fetchByAMFIssueDate_First(
		Date issueDate, OrderByComparator<AMFIssue> orderByComparator) {

		List<AMFIssue> list = findByAMFIssueDate(
			issueDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf issue in the ordered set where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue
	 * @throws NoSuchAMFIssueException if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue findByAMFIssueDate_Last(
			Date issueDate, OrderByComparator<AMFIssue> orderByComparator)
		throws NoSuchAMFIssueException {

		AMFIssue amfIssue = fetchByAMFIssueDate_Last(
			issueDate, orderByComparator);

		if (amfIssue != null) {
			return amfIssue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("issueDate=");
		sb.append(issueDate);

		sb.append("}");

		throw new NoSuchAMFIssueException(sb.toString());
	}

	/**
	 * Returns the last amf issue in the ordered set where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf issue, or <code>null</code> if a matching amf issue could not be found
	 */
	@Override
	public AMFIssue fetchByAMFIssueDate_Last(
		Date issueDate, OrderByComparator<AMFIssue> orderByComparator) {

		int count = countByAMFIssueDate(issueDate);

		if (count == 0) {
			return null;
		}

		List<AMFIssue> list = findByAMFIssueDate(
			issueDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amf issues before and after the current amf issue in the ordered set where issueDate = &#63;.
	 *
	 * @param amfIssueId the primary key of the current amf issue
	 * @param issueDate the issue date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	@Override
	public AMFIssue[] findByAMFIssueDate_PrevAndNext(
			long amfIssueId, Date issueDate,
			OrderByComparator<AMFIssue> orderByComparator)
		throws NoSuchAMFIssueException {

		AMFIssue amfIssue = findByPrimaryKey(amfIssueId);

		Session session = null;

		try {
			session = openSession();

			AMFIssue[] array = new AMFIssueImpl[3];

			array[0] = getByAMFIssueDate_PrevAndNext(
				session, amfIssue, issueDate, orderByComparator, true);

			array[1] = amfIssue;

			array[2] = getByAMFIssueDate_PrevAndNext(
				session, amfIssue, issueDate, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AMFIssue getByAMFIssueDate_PrevAndNext(
		Session session, AMFIssue amfIssue, Date issueDate,
		OrderByComparator<AMFIssue> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AMFISSUE_WHERE);

		boolean bindIssueDate = false;

		if (issueDate == null) {
			sb.append(_FINDER_COLUMN_AMFISSUEDATE_ISSUEDATE_1);
		}
		else {
			bindIssueDate = true;

			sb.append(_FINDER_COLUMN_AMFISSUEDATE_ISSUEDATE_2);
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
			sb.append(AMFIssueModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindIssueDate) {
			queryPos.add(new Timestamp(issueDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(amfIssue)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AMFIssue> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf issues where issueDate = &#63; from the database.
	 *
	 * @param issueDate the issue date
	 */
	@Override
	public void removeByAMFIssueDate(Date issueDate) {
		for (AMFIssue amfIssue :
				findByAMFIssueDate(
					issueDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(amfIssue);
		}
	}

	/**
	 * Returns the number of amf issues where issueDate = &#63;.
	 *
	 * @param issueDate the issue date
	 * @return the number of matching amf issues
	 */
	@Override
	public int countByAMFIssueDate(Date issueDate) {
		FinderPath finderPath = _finderPathCountByAMFIssueDate;

		Object[] finderArgs = new Object[] {_getTime(issueDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AMFISSUE_WHERE);

			boolean bindIssueDate = false;

			if (issueDate == null) {
				sb.append(_FINDER_COLUMN_AMFISSUEDATE_ISSUEDATE_1);
			}
			else {
				bindIssueDate = true;

				sb.append(_FINDER_COLUMN_AMFISSUEDATE_ISSUEDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIssueDate) {
					queryPos.add(new Timestamp(issueDate.getTime()));
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

	private static final String _FINDER_COLUMN_AMFISSUEDATE_ISSUEDATE_1 =
		"amfIssue.issueDate IS NULL";

	private static final String _FINDER_COLUMN_AMFISSUEDATE_ISSUEDATE_2 =
		"amfIssue.issueDate = ?";

	public AMFIssuePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AMFIssue.class);

		setModelImplClass(AMFIssueImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the amf issue in the entity cache if it is enabled.
	 *
	 * @param amfIssue the amf issue
	 */
	@Override
	public void cacheResult(AMFIssue amfIssue) {
		entityCache.putResult(
			AMFIssueImpl.class, amfIssue.getPrimaryKey(), amfIssue);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {amfIssue.getUuid(), amfIssue.getGroupId()}, amfIssue);
	}

	/**
	 * Caches the amf issues in the entity cache if it is enabled.
	 *
	 * @param amfIssues the amf issues
	 */
	@Override
	public void cacheResult(List<AMFIssue> amfIssues) {
		for (AMFIssue amfIssue : amfIssues) {
			if (entityCache.getResult(
					AMFIssueImpl.class, amfIssue.getPrimaryKey()) == null) {

				cacheResult(amfIssue);
			}
		}
	}

	/**
	 * Clears the cache for all amf issues.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AMFIssueImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the amf issue.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AMFIssue amfIssue) {
		entityCache.removeResult(AMFIssueImpl.class, amfIssue);
	}

	@Override
	public void clearCache(List<AMFIssue> amfIssues) {
		for (AMFIssue amfIssue : amfIssues) {
			entityCache.removeResult(AMFIssueImpl.class, amfIssue);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AMFIssueImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AMFIssueModelImpl amfIssueModelImpl) {

		Object[] args = new Object[] {
			amfIssueModelImpl.getUuid(), amfIssueModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, amfIssueModelImpl, false);
	}

	/**
	 * Creates a new amf issue with the primary key. Does not add the amf issue to the database.
	 *
	 * @param amfIssueId the primary key for the new amf issue
	 * @return the new amf issue
	 */
	@Override
	public AMFIssue create(long amfIssueId) {
		AMFIssue amfIssue = new AMFIssueImpl();

		amfIssue.setNew(true);
		amfIssue.setPrimaryKey(amfIssueId);

		String uuid = PortalUUIDUtil.generate();

		amfIssue.setUuid(uuid);

		amfIssue.setCompanyId(CompanyThreadLocal.getCompanyId());

		return amfIssue;
	}

	/**
	 * Removes the amf issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfIssueId the primary key of the amf issue
	 * @return the amf issue that was removed
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	@Override
	public AMFIssue remove(long amfIssueId) throws NoSuchAMFIssueException {
		return remove((Serializable)amfIssueId);
	}

	/**
	 * Removes the amf issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the amf issue
	 * @return the amf issue that was removed
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	@Override
	public AMFIssue remove(Serializable primaryKey)
		throws NoSuchAMFIssueException {

		Session session = null;

		try {
			session = openSession();

			AMFIssue amfIssue = (AMFIssue)session.get(
				AMFIssueImpl.class, primaryKey);

			if (amfIssue == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAMFIssueException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(amfIssue);
		}
		catch (NoSuchAMFIssueException noSuchEntityException) {
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
	protected AMFIssue removeImpl(AMFIssue amfIssue) {
		amfIssueToAMFArticleTableMapper.deleteLeftPrimaryKeyTableMappings(
			amfIssue.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(amfIssue)) {
				amfIssue = (AMFIssue)session.get(
					AMFIssueImpl.class, amfIssue.getPrimaryKeyObj());
			}

			if (amfIssue != null) {
				session.delete(amfIssue);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (amfIssue != null) {
			clearCache(amfIssue);
		}

		return amfIssue;
	}

	@Override
	public AMFIssue updateImpl(AMFIssue amfIssue) {
		boolean isNew = amfIssue.isNew();

		if (!(amfIssue instanceof AMFIssueModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(amfIssue.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(amfIssue);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in amfIssue proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AMFIssue implementation " +
					amfIssue.getClass());
		}

		AMFIssueModelImpl amfIssueModelImpl = (AMFIssueModelImpl)amfIssue;

		if (Validator.isNull(amfIssue.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			amfIssue.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (amfIssue.getCreateDate() == null)) {
			if (serviceContext == null) {
				amfIssue.setCreateDate(now);
			}
			else {
				amfIssue.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!amfIssueModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				amfIssue.setModifiedDate(now);
			}
			else {
				amfIssue.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(amfIssue);
			}
			else {
				amfIssue = (AMFIssue)session.merge(amfIssue);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AMFIssueImpl.class, amfIssueModelImpl, false, true);

		cacheUniqueFindersCache(amfIssueModelImpl);

		if (isNew) {
			amfIssue.setNew(false);
		}

		amfIssue.resetOriginalValues();

		return amfIssue;
	}

	/**
	 * Returns the amf issue with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the amf issue
	 * @return the amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	@Override
	public AMFIssue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAMFIssueException {

		AMFIssue amfIssue = fetchByPrimaryKey(primaryKey);

		if (amfIssue == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAMFIssueException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return amfIssue;
	}

	/**
	 * Returns the amf issue with the primary key or throws a <code>NoSuchAMFIssueException</code> if it could not be found.
	 *
	 * @param amfIssueId the primary key of the amf issue
	 * @return the amf issue
	 * @throws NoSuchAMFIssueException if a amf issue with the primary key could not be found
	 */
	@Override
	public AMFIssue findByPrimaryKey(long amfIssueId)
		throws NoSuchAMFIssueException {

		return findByPrimaryKey((Serializable)amfIssueId);
	}

	/**
	 * Returns the amf issue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfIssueId the primary key of the amf issue
	 * @return the amf issue, or <code>null</code> if a amf issue with the primary key could not be found
	 */
	@Override
	public AMFIssue fetchByPrimaryKey(long amfIssueId) {
		return fetchByPrimaryKey((Serializable)amfIssueId);
	}

	/**
	 * Returns all the amf issues.
	 *
	 * @return the amf issues
	 */
	@Override
	public List<AMFIssue> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AMFIssue> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AMFIssue> findAll(
		int start, int end, OrderByComparator<AMFIssue> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AMFIssue> findAll(
		int start, int end, OrderByComparator<AMFIssue> orderByComparator,
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

		List<AMFIssue> list = null;

		if (useFinderCache) {
			list = (List<AMFIssue>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AMFISSUE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AMFISSUE;

				sql = sql.concat(AMFIssueModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AMFIssue>)QueryUtil.list(
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
	 * Removes all the amf issues from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AMFIssue amfIssue : findAll()) {
			remove(amfIssue);
		}
	}

	/**
	 * Returns the number of amf issues.
	 *
	 * @return the number of amf issues
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AMFISSUE);

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

	/**
	 * Returns the primaryKeys of amf articles associated with the amf issue.
	 *
	 * @param pk the primary key of the amf issue
	 * @return long[] of the primaryKeys of amf articles associated with the amf issue
	 */
	@Override
	public long[] getAMFArticlePrimaryKeys(long pk) {
		long[] pks = amfIssueToAMFArticleTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the amf issue associated with the amf article.
	 *
	 * @param pk the primary key of the amf article
	 * @return the amf issues associated with the amf article
	 */
	@Override
	public List<AMFIssue> getAMFArticleAMFIssues(long pk) {
		return getAMFArticleAMFIssues(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

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
	@Override
	public List<AMFIssue> getAMFArticleAMFIssues(long pk, int start, int end) {
		return getAMFArticleAMFIssues(pk, start, end, null);
	}

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
	@Override
	public List<AMFIssue> getAMFArticleAMFIssues(
		long pk, int start, int end,
		OrderByComparator<AMFIssue> orderByComparator) {

		return amfIssueToAMFArticleTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of amf articles associated with the amf issue.
	 *
	 * @param pk the primary key of the amf issue
	 * @return the number of amf articles associated with the amf issue
	 */
	@Override
	public int getAMFArticlesSize(long pk) {
		long[] pks = amfIssueToAMFArticleTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the amf article is associated with the amf issue.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePK the primary key of the amf article
	 * @return <code>true</code> if the amf article is associated with the amf issue; <code>false</code> otherwise
	 */
	@Override
	public boolean containsAMFArticle(long pk, long amfArticlePK) {
		return amfIssueToAMFArticleTableMapper.containsTableMapping(
			pk, amfArticlePK);
	}

	/**
	 * Returns <code>true</code> if the amf issue has any amf articles associated with it.
	 *
	 * @param pk the primary key of the amf issue to check for associations with amf articles
	 * @return <code>true</code> if the amf issue has any amf articles associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsAMFArticles(long pk) {
		if (getAMFArticlesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the amf issue and the amf article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePK the primary key of the amf article
	 */
	@Override
	public void addAMFArticle(long pk, long amfArticlePK) {
		AMFIssue amfIssue = fetchByPrimaryKey(pk);

		if (amfIssue == null) {
			amfIssueToAMFArticleTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, amfArticlePK);
		}
		else {
			amfIssueToAMFArticleTableMapper.addTableMapping(
				amfIssue.getCompanyId(), pk, amfArticlePK);
		}
	}

	/**
	 * Adds an association between the amf issue and the amf article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticle the amf article
	 */
	@Override
	public void addAMFArticle(long pk, AMFArticle amfArticle) {
		AMFIssue amfIssue = fetchByPrimaryKey(pk);

		if (amfIssue == null) {
			amfIssueToAMFArticleTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				amfArticle.getPrimaryKey());
		}
		else {
			amfIssueToAMFArticleTableMapper.addTableMapping(
				amfIssue.getCompanyId(), pk, amfArticle.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the amf issue and the amf articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePKs the primary keys of the amf articles
	 */
	@Override
	public void addAMFArticles(long pk, long[] amfArticlePKs) {
		long companyId = 0;

		AMFIssue amfIssue = fetchByPrimaryKey(pk);

		if (amfIssue == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = amfIssue.getCompanyId();
		}

		amfIssueToAMFArticleTableMapper.addTableMappings(
			companyId, pk, amfArticlePKs);
	}

	/**
	 * Adds an association between the amf issue and the amf articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticles the amf articles
	 */
	@Override
	public void addAMFArticles(long pk, List<AMFArticle> amfArticles) {
		addAMFArticles(
			pk,
			ListUtil.toLongArray(
				amfArticles, AMFArticle.AMF_ARTICLE_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the amf issue and its amf articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue to clear the associated amf articles from
	 */
	@Override
	public void clearAMFArticles(long pk) {
		amfIssueToAMFArticleTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the amf issue and the amf article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePK the primary key of the amf article
	 */
	@Override
	public void removeAMFArticle(long pk, long amfArticlePK) {
		amfIssueToAMFArticleTableMapper.deleteTableMapping(pk, amfArticlePK);
	}

	/**
	 * Removes the association between the amf issue and the amf article. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticle the amf article
	 */
	@Override
	public void removeAMFArticle(long pk, AMFArticle amfArticle) {
		amfIssueToAMFArticleTableMapper.deleteTableMapping(
			pk, amfArticle.getPrimaryKey());
	}

	/**
	 * Removes the association between the amf issue and the amf articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePKs the primary keys of the amf articles
	 */
	@Override
	public void removeAMFArticles(long pk, long[] amfArticlePKs) {
		amfIssueToAMFArticleTableMapper.deleteTableMappings(pk, amfArticlePKs);
	}

	/**
	 * Removes the association between the amf issue and the amf articles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticles the amf articles
	 */
	@Override
	public void removeAMFArticles(long pk, List<AMFArticle> amfArticles) {
		removeAMFArticles(
			pk,
			ListUtil.toLongArray(
				amfArticles, AMFArticle.AMF_ARTICLE_ID_ACCESSOR));
	}

	/**
	 * Sets the amf articles associated with the amf issue, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticlePKs the primary keys of the amf articles to be associated with the amf issue
	 */
	@Override
	public void setAMFArticles(long pk, long[] amfArticlePKs) {
		Set<Long> newAMFArticlePKsSet = SetUtil.fromArray(amfArticlePKs);
		Set<Long> oldAMFArticlePKsSet = SetUtil.fromArray(
			amfIssueToAMFArticleTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeAMFArticlePKsSet = new HashSet<Long>(
			oldAMFArticlePKsSet);

		removeAMFArticlePKsSet.removeAll(newAMFArticlePKsSet);

		amfIssueToAMFArticleTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeAMFArticlePKsSet));

		newAMFArticlePKsSet.removeAll(oldAMFArticlePKsSet);

		long companyId = 0;

		AMFIssue amfIssue = fetchByPrimaryKey(pk);

		if (amfIssue == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = amfIssue.getCompanyId();
		}

		amfIssueToAMFArticleTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newAMFArticlePKsSet));
	}

	/**
	 * Sets the amf articles associated with the amf issue, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf issue
	 * @param amfArticles the amf articles to be associated with the amf issue
	 */
	@Override
	public void setAMFArticles(long pk, List<AMFArticle> amfArticles) {
		try {
			long[] amfArticlePKs = new long[amfArticles.size()];

			for (int i = 0; i < amfArticles.size(); i++) {
				AMFArticle amfArticle = amfArticles.get(i);

				amfArticlePKs[i] = amfArticle.getPrimaryKey();
			}

			setAMFArticles(pk, amfArticlePKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
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
		return "amfIssueId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AMFISSUE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AMFIssueModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the amf issue persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new AMFIssueModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AMFIssue.class.getName()));

		amfIssueToAMFArticleTableMapper = TableMapperFactory.getTableMapper(
			"AMFNewsletter_amfissue_article#amfIssueId",
			"AMFNewsletter_amfissue_article", "companyId", "amfIssueId",
			"amfArticleId", this, AMFArticle.class);

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

		_finderPathWithPaginationFindByAMFIssueId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAMFIssueId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"amfIssueId"}, true);

		_finderPathWithoutPaginationFindByAMFIssueId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAMFIssueId",
			new String[] {Long.class.getName()}, new String[] {"amfIssueId"},
			true);

		_finderPathCountByAMFIssueId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAMFIssueId",
			new String[] {Long.class.getName()}, new String[] {"amfIssueId"},
			false);

		_finderPathWithPaginationFindByAMFIssueDate = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAMFIssueDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"issueDate"}, true);

		_finderPathWithoutPaginationFindByAMFIssueDate = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAMFIssueDate",
			new String[] {Date.class.getName()}, new String[] {"issueDate"},
			true);

		_finderPathCountByAMFIssueDate = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAMFIssueDate",
			new String[] {Date.class.getName()}, new String[] {"issueDate"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AMFIssueImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}

		TableMapperFactory.removeTableMapper(
			"AMFNewsletter_amfissue_article#amfIssueId");
	}

	@Override
	@Reference(
		target = AMFNewsletterPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AMFNewsletterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AMFNewsletterPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	protected TableMapper<AMFIssue, AMFArticle> amfIssueToAMFArticleTableMapper;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_AMFISSUE =
		"SELECT amfIssue FROM AMFIssue amfIssue";

	private static final String _SQL_SELECT_AMFISSUE_WHERE =
		"SELECT amfIssue FROM AMFIssue amfIssue WHERE ";

	private static final String _SQL_COUNT_AMFISSUE =
		"SELECT COUNT(amfIssue) FROM AMFIssue amfIssue";

	private static final String _SQL_COUNT_AMFISSUE_WHERE =
		"SELECT COUNT(amfIssue) FROM AMFIssue amfIssue WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "amfIssue.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AMFIssue exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AMFIssue exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AMFIssuePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(AMFNewsletterPersistenceConstants.class.getName());
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

	private static class AMFIssueModelArgumentsResolver
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

			AMFIssueModelImpl amfIssueModelImpl = (AMFIssueModelImpl)baseModel;

			long columnBitmask = amfIssueModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(amfIssueModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						amfIssueModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(amfIssueModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			AMFIssueModelImpl amfIssueModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = amfIssueModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = amfIssueModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}