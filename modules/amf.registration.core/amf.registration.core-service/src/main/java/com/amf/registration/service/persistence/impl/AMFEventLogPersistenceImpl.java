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

package com.amf.registration.service.persistence.impl;

import com.amf.registration.exception.NoSuchAMFEventLogException;
import com.amf.registration.model.AMFEventLog;
import com.amf.registration.model.AMFUser;
import com.amf.registration.model.impl.AMFEventLogImpl;
import com.amf.registration.model.impl.AMFEventLogModelImpl;
import com.amf.registration.service.persistence.AMFEventLogPersistence;
import com.amf.registration.service.persistence.impl.constants.AMFRegistrationPersistenceConstants;

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
 * The persistence implementation for the amf event log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AMFEventLogPersistence.class)
public class AMFEventLogPersistenceImpl
	extends BasePersistenceImpl<AMFEventLog> implements AMFEventLogPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AMFEventLogUtil</code> to access the amf event log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AMFEventLogImpl.class.getName();

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
	 * Returns all the amf event logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amf event logs
	 */
	@Override
	public List<AMFEventLog> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AMFEventLog> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<AMFEventLog> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFEventLog> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<AMFEventLog> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AMFEventLog> orderByComparator,
		boolean useFinderCache) {

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

		List<AMFEventLog> list = null;

		if (useFinderCache) {
			list = (List<AMFEventLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AMFEventLog amfEventLog : list) {
					if (!uuid.equals(amfEventLog.getUuid())) {
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

			sb.append(_SQL_SELECT_AMFEVENTLOG_WHERE);

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
				sb.append(AMFEventLogModelImpl.ORDER_BY_JPQL);
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

				list = (List<AMFEventLog>)QueryUtil.list(
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
	 * Returns the first amf event log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event log
	 * @throws NoSuchAMFEventLogException if a matching amf event log could not be found
	 */
	@Override
	public AMFEventLog findByUuid_First(
			String uuid, OrderByComparator<AMFEventLog> orderByComparator)
		throws NoSuchAMFEventLogException {

		AMFEventLog amfEventLog = fetchByUuid_First(uuid, orderByComparator);

		if (amfEventLog != null) {
			return amfEventLog;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAMFEventLogException(sb.toString());
	}

	/**
	 * Returns the first amf event log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	@Override
	public AMFEventLog fetchByUuid_First(
		String uuid, OrderByComparator<AMFEventLog> orderByComparator) {

		List<AMFEventLog> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amf event log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event log
	 * @throws NoSuchAMFEventLogException if a matching amf event log could not be found
	 */
	@Override
	public AMFEventLog findByUuid_Last(
			String uuid, OrderByComparator<AMFEventLog> orderByComparator)
		throws NoSuchAMFEventLogException {

		AMFEventLog amfEventLog = fetchByUuid_Last(uuid, orderByComparator);

		if (amfEventLog != null) {
			return amfEventLog;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAMFEventLogException(sb.toString());
	}

	/**
	 * Returns the last amf event log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	@Override
	public AMFEventLog fetchByUuid_Last(
		String uuid, OrderByComparator<AMFEventLog> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AMFEventLog> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AMFEventLog[] findByUuid_PrevAndNext(
			long amfEventLogId, String uuid,
			OrderByComparator<AMFEventLog> orderByComparator)
		throws NoSuchAMFEventLogException {

		uuid = Objects.toString(uuid, "");

		AMFEventLog amfEventLog = findByPrimaryKey(amfEventLogId);

		Session session = null;

		try {
			session = openSession();

			AMFEventLog[] array = new AMFEventLogImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, amfEventLog, uuid, orderByComparator, true);

			array[1] = amfEventLog;

			array[2] = getByUuid_PrevAndNext(
				session, amfEventLog, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AMFEventLog getByUuid_PrevAndNext(
		Session session, AMFEventLog amfEventLog, String uuid,
		OrderByComparator<AMFEventLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AMFEVENTLOG_WHERE);

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
			sb.append(AMFEventLogModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(amfEventLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AMFEventLog> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf event logs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AMFEventLog amfEventLog :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(amfEventLog);
		}
	}

	/**
	 * Returns the number of amf event logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amf event logs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AMFEVENTLOG_WHERE);

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
		"amfEventLog.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(amfEventLog.uuid IS NULL OR amfEventLog.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the amf event log where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAMFEventLogException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amf event log
	 * @throws NoSuchAMFEventLogException if a matching amf event log could not be found
	 */
	@Override
	public AMFEventLog findByUUID_G(String uuid, long groupId)
		throws NoSuchAMFEventLogException {

		AMFEventLog amfEventLog = fetchByUUID_G(uuid, groupId);

		if (amfEventLog == null) {
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

			throw new NoSuchAMFEventLogException(sb.toString());
		}

		return amfEventLog;
	}

	/**
	 * Returns the amf event log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	@Override
	public AMFEventLog fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the amf event log where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	@Override
	public AMFEventLog fetchByUUID_G(
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

		if (result instanceof AMFEventLog) {
			AMFEventLog amfEventLog = (AMFEventLog)result;

			if (!Objects.equals(uuid, amfEventLog.getUuid()) ||
				(groupId != amfEventLog.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_AMFEVENTLOG_WHERE);

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

				List<AMFEventLog> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AMFEventLog amfEventLog = list.get(0);

					result = amfEventLog;

					cacheResult(amfEventLog);
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
			return (AMFEventLog)result;
		}
	}

	/**
	 * Removes the amf event log where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the amf event log that was removed
	 */
	@Override
	public AMFEventLog removeByUUID_G(String uuid, long groupId)
		throws NoSuchAMFEventLogException {

		AMFEventLog amfEventLog = findByUUID_G(uuid, groupId);

		return remove(amfEventLog);
	}

	/**
	 * Returns the number of amf event logs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching amf event logs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AMFEVENTLOG_WHERE);

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
		"amfEventLog.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(amfEventLog.uuid IS NULL OR amfEventLog.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"amfEventLog.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the amf event logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching amf event logs
	 */
	@Override
	public List<AMFEventLog> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AMFEventLog> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<AMFEventLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AMFEventLog> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<AMFEventLog> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AMFEventLog> orderByComparator,
		boolean useFinderCache) {

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

		List<AMFEventLog> list = null;

		if (useFinderCache) {
			list = (List<AMFEventLog>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AMFEventLog amfEventLog : list) {
					if (!uuid.equals(amfEventLog.getUuid()) ||
						(companyId != amfEventLog.getCompanyId())) {

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

			sb.append(_SQL_SELECT_AMFEVENTLOG_WHERE);

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
				sb.append(AMFEventLogModelImpl.ORDER_BY_JPQL);
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

				list = (List<AMFEventLog>)QueryUtil.list(
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
	 * Returns the first amf event log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event log
	 * @throws NoSuchAMFEventLogException if a matching amf event log could not be found
	 */
	@Override
	public AMFEventLog findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AMFEventLog> orderByComparator)
		throws NoSuchAMFEventLogException {

		AMFEventLog amfEventLog = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (amfEventLog != null) {
			return amfEventLog;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAMFEventLogException(sb.toString());
	}

	/**
	 * Returns the first amf event log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	@Override
	public AMFEventLog fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AMFEventLog> orderByComparator) {

		List<AMFEventLog> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AMFEventLog findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AMFEventLog> orderByComparator)
		throws NoSuchAMFEventLogException {

		AMFEventLog amfEventLog = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (amfEventLog != null) {
			return amfEventLog;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAMFEventLogException(sb.toString());
	}

	/**
	 * Returns the last amf event log in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	@Override
	public AMFEventLog fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AMFEventLog> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AMFEventLog> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AMFEventLog[] findByUuid_C_PrevAndNext(
			long amfEventLogId, String uuid, long companyId,
			OrderByComparator<AMFEventLog> orderByComparator)
		throws NoSuchAMFEventLogException {

		uuid = Objects.toString(uuid, "");

		AMFEventLog amfEventLog = findByPrimaryKey(amfEventLogId);

		Session session = null;

		try {
			session = openSession();

			AMFEventLog[] array = new AMFEventLogImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, amfEventLog, uuid, companyId, orderByComparator, true);

			array[1] = amfEventLog;

			array[2] = getByUuid_C_PrevAndNext(
				session, amfEventLog, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AMFEventLog getByUuid_C_PrevAndNext(
		Session session, AMFEventLog amfEventLog, String uuid, long companyId,
		OrderByComparator<AMFEventLog> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_AMFEVENTLOG_WHERE);

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
			sb.append(AMFEventLogModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(amfEventLog)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AMFEventLog> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amf event logs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AMFEventLog amfEventLog :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(amfEventLog);
		}
	}

	/**
	 * Returns the number of amf event logs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching amf event logs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AMFEVENTLOG_WHERE);

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
		"amfEventLog.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(amfEventLog.uuid IS NULL OR amfEventLog.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"amfEventLog.companyId = ?";

	public AMFEventLogPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AMFEventLog.class);

		setModelImplClass(AMFEventLogImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the amf event log in the entity cache if it is enabled.
	 *
	 * @param amfEventLog the amf event log
	 */
	@Override
	public void cacheResult(AMFEventLog amfEventLog) {
		entityCache.putResult(
			AMFEventLogImpl.class, amfEventLog.getPrimaryKey(), amfEventLog);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {amfEventLog.getUuid(), amfEventLog.getGroupId()},
			amfEventLog);
	}

	/**
	 * Caches the amf event logs in the entity cache if it is enabled.
	 *
	 * @param amfEventLogs the amf event logs
	 */
	@Override
	public void cacheResult(List<AMFEventLog> amfEventLogs) {
		for (AMFEventLog amfEventLog : amfEventLogs) {
			if (entityCache.getResult(
					AMFEventLogImpl.class, amfEventLog.getPrimaryKey()) ==
						null) {

				cacheResult(amfEventLog);
			}
		}
	}

	/**
	 * Clears the cache for all amf event logs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AMFEventLogImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the amf event log.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AMFEventLog amfEventLog) {
		entityCache.removeResult(AMFEventLogImpl.class, amfEventLog);
	}

	@Override
	public void clearCache(List<AMFEventLog> amfEventLogs) {
		for (AMFEventLog amfEventLog : amfEventLogs) {
			entityCache.removeResult(AMFEventLogImpl.class, amfEventLog);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AMFEventLogImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AMFEventLogModelImpl amfEventLogModelImpl) {

		Object[] args = new Object[] {
			amfEventLogModelImpl.getUuid(), amfEventLogModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, amfEventLogModelImpl, false);
	}

	/**
	 * Creates a new amf event log with the primary key. Does not add the amf event log to the database.
	 *
	 * @param amfEventLogId the primary key for the new amf event log
	 * @return the new amf event log
	 */
	@Override
	public AMFEventLog create(long amfEventLogId) {
		AMFEventLog amfEventLog = new AMFEventLogImpl();

		amfEventLog.setNew(true);
		amfEventLog.setPrimaryKey(amfEventLogId);

		String uuid = PortalUUIDUtil.generate();

		amfEventLog.setUuid(uuid);

		amfEventLog.setCompanyId(CompanyThreadLocal.getCompanyId());

		return amfEventLog;
	}

	/**
	 * Removes the amf event log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amfEventLogId the primary key of the amf event log
	 * @return the amf event log that was removed
	 * @throws NoSuchAMFEventLogException if a amf event log with the primary key could not be found
	 */
	@Override
	public AMFEventLog remove(long amfEventLogId)
		throws NoSuchAMFEventLogException {

		return remove((Serializable)amfEventLogId);
	}

	/**
	 * Removes the amf event log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the amf event log
	 * @return the amf event log that was removed
	 * @throws NoSuchAMFEventLogException if a amf event log with the primary key could not be found
	 */
	@Override
	public AMFEventLog remove(Serializable primaryKey)
		throws NoSuchAMFEventLogException {

		Session session = null;

		try {
			session = openSession();

			AMFEventLog amfEventLog = (AMFEventLog)session.get(
				AMFEventLogImpl.class, primaryKey);

			if (amfEventLog == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAMFEventLogException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(amfEventLog);
		}
		catch (NoSuchAMFEventLogException noSuchEntityException) {
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
	protected AMFEventLog removeImpl(AMFEventLog amfEventLog) {
		amfEventLogToAMFUserTableMapper.deleteLeftPrimaryKeyTableMappings(
			amfEventLog.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(amfEventLog)) {
				amfEventLog = (AMFEventLog)session.get(
					AMFEventLogImpl.class, amfEventLog.getPrimaryKeyObj());
			}

			if (amfEventLog != null) {
				session.delete(amfEventLog);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (amfEventLog != null) {
			clearCache(amfEventLog);
		}

		return amfEventLog;
	}

	@Override
	public AMFEventLog updateImpl(AMFEventLog amfEventLog) {
		boolean isNew = amfEventLog.isNew();

		if (!(amfEventLog instanceof AMFEventLogModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(amfEventLog.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(amfEventLog);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in amfEventLog proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AMFEventLog implementation " +
					amfEventLog.getClass());
		}

		AMFEventLogModelImpl amfEventLogModelImpl =
			(AMFEventLogModelImpl)amfEventLog;

		if (Validator.isNull(amfEventLog.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			amfEventLog.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (amfEventLog.getCreateDate() == null)) {
			if (serviceContext == null) {
				amfEventLog.setCreateDate(now);
			}
			else {
				amfEventLog.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!amfEventLogModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				amfEventLog.setModifiedDate(now);
			}
			else {
				amfEventLog.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(amfEventLog);
			}
			else {
				amfEventLog = (AMFEventLog)session.merge(amfEventLog);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AMFEventLogImpl.class, amfEventLogModelImpl, false, true);

		cacheUniqueFindersCache(amfEventLogModelImpl);

		if (isNew) {
			amfEventLog.setNew(false);
		}

		amfEventLog.resetOriginalValues();

		return amfEventLog;
	}

	/**
	 * Returns the amf event log with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the amf event log
	 * @return the amf event log
	 * @throws NoSuchAMFEventLogException if a amf event log with the primary key could not be found
	 */
	@Override
	public AMFEventLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAMFEventLogException {

		AMFEventLog amfEventLog = fetchByPrimaryKey(primaryKey);

		if (amfEventLog == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAMFEventLogException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return amfEventLog;
	}

	/**
	 * Returns the amf event log with the primary key or throws a <code>NoSuchAMFEventLogException</code> if it could not be found.
	 *
	 * @param amfEventLogId the primary key of the amf event log
	 * @return the amf event log
	 * @throws NoSuchAMFEventLogException if a amf event log with the primary key could not be found
	 */
	@Override
	public AMFEventLog findByPrimaryKey(long amfEventLogId)
		throws NoSuchAMFEventLogException {

		return findByPrimaryKey((Serializable)amfEventLogId);
	}

	/**
	 * Returns the amf event log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amfEventLogId the primary key of the amf event log
	 * @return the amf event log, or <code>null</code> if a amf event log with the primary key could not be found
	 */
	@Override
	public AMFEventLog fetchByPrimaryKey(long amfEventLogId) {
		return fetchByPrimaryKey((Serializable)amfEventLogId);
	}

	/**
	 * Returns all the amf event logs.
	 *
	 * @return the amf event logs
	 */
	@Override
	public List<AMFEventLog> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AMFEventLog> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AMFEventLog> findAll(
		int start, int end, OrderByComparator<AMFEventLog> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AMFEventLog> findAll(
		int start, int end, OrderByComparator<AMFEventLog> orderByComparator,
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

		List<AMFEventLog> list = null;

		if (useFinderCache) {
			list = (List<AMFEventLog>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AMFEVENTLOG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AMFEVENTLOG;

				sql = sql.concat(AMFEventLogModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AMFEventLog>)QueryUtil.list(
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
	 * Removes all the amf event logs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AMFEventLog amfEventLog : findAll()) {
			remove(amfEventLog);
		}
	}

	/**
	 * Returns the number of amf event logs.
	 *
	 * @return the number of amf event logs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AMFEVENTLOG);

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
	 * Returns the primaryKeys of amf users associated with the amf event log.
	 *
	 * @param pk the primary key of the amf event log
	 * @return long[] of the primaryKeys of amf users associated with the amf event log
	 */
	@Override
	public long[] getAMFUserPrimaryKeys(long pk) {
		long[] pks = amfEventLogToAMFUserTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the amf event log associated with the amf user.
	 *
	 * @param pk the primary key of the amf user
	 * @return the amf event logs associated with the amf user
	 */
	@Override
	public List<AMFEventLog> getAMFUserAMFEventLogs(long pk) {
		return getAMFUserAMFEventLogs(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<AMFEventLog> getAMFUserAMFEventLogs(
		long pk, int start, int end) {

		return getAMFUserAMFEventLogs(pk, start, end, null);
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
	@Override
	public List<AMFEventLog> getAMFUserAMFEventLogs(
		long pk, int start, int end,
		OrderByComparator<AMFEventLog> orderByComparator) {

		return amfEventLogToAMFUserTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of amf users associated with the amf event log.
	 *
	 * @param pk the primary key of the amf event log
	 * @return the number of amf users associated with the amf event log
	 */
	@Override
	public int getAMFUsersSize(long pk) {
		long[] pks = amfEventLogToAMFUserTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the amf user is associated with the amf event log.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPK the primary key of the amf user
	 * @return <code>true</code> if the amf user is associated with the amf event log; <code>false</code> otherwise
	 */
	@Override
	public boolean containsAMFUser(long pk, long amfUserPK) {
		return amfEventLogToAMFUserTableMapper.containsTableMapping(
			pk, amfUserPK);
	}

	/**
	 * Returns <code>true</code> if the amf event log has any amf users associated with it.
	 *
	 * @param pk the primary key of the amf event log to check for associations with amf users
	 * @return <code>true</code> if the amf event log has any amf users associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsAMFUsers(long pk) {
		if (getAMFUsersSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the amf event log and the amf user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPK the primary key of the amf user
	 */
	@Override
	public void addAMFUser(long pk, long amfUserPK) {
		AMFEventLog amfEventLog = fetchByPrimaryKey(pk);

		if (amfEventLog == null) {
			amfEventLogToAMFUserTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, amfUserPK);
		}
		else {
			amfEventLogToAMFUserTableMapper.addTableMapping(
				amfEventLog.getCompanyId(), pk, amfUserPK);
		}
	}

	/**
	 * Adds an association between the amf event log and the amf user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUser the amf user
	 */
	@Override
	public void addAMFUser(long pk, AMFUser amfUser) {
		AMFEventLog amfEventLog = fetchByPrimaryKey(pk);

		if (amfEventLog == null) {
			amfEventLogToAMFUserTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, amfUser.getPrimaryKey());
		}
		else {
			amfEventLogToAMFUserTableMapper.addTableMapping(
				amfEventLog.getCompanyId(), pk, amfUser.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the amf event log and the amf users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPKs the primary keys of the amf users
	 */
	@Override
	public void addAMFUsers(long pk, long[] amfUserPKs) {
		long companyId = 0;

		AMFEventLog amfEventLog = fetchByPrimaryKey(pk);

		if (amfEventLog == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = amfEventLog.getCompanyId();
		}

		amfEventLogToAMFUserTableMapper.addTableMappings(
			companyId, pk, amfUserPKs);
	}

	/**
	 * Adds an association between the amf event log and the amf users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUsers the amf users
	 */
	@Override
	public void addAMFUsers(long pk, List<AMFUser> amfUsers) {
		addAMFUsers(
			pk, ListUtil.toLongArray(amfUsers, AMFUser.AMF_USER_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the amf event log and its amf users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log to clear the associated amf users from
	 */
	@Override
	public void clearAMFUsers(long pk) {
		amfEventLogToAMFUserTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the amf event log and the amf user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPK the primary key of the amf user
	 */
	@Override
	public void removeAMFUser(long pk, long amfUserPK) {
		amfEventLogToAMFUserTableMapper.deleteTableMapping(pk, amfUserPK);
	}

	/**
	 * Removes the association between the amf event log and the amf user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUser the amf user
	 */
	@Override
	public void removeAMFUser(long pk, AMFUser amfUser) {
		amfEventLogToAMFUserTableMapper.deleteTableMapping(
			pk, amfUser.getPrimaryKey());
	}

	/**
	 * Removes the association between the amf event log and the amf users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPKs the primary keys of the amf users
	 */
	@Override
	public void removeAMFUsers(long pk, long[] amfUserPKs) {
		amfEventLogToAMFUserTableMapper.deleteTableMappings(pk, amfUserPKs);
	}

	/**
	 * Removes the association between the amf event log and the amf users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUsers the amf users
	 */
	@Override
	public void removeAMFUsers(long pk, List<AMFUser> amfUsers) {
		removeAMFUsers(
			pk, ListUtil.toLongArray(amfUsers, AMFUser.AMF_USER_ID_ACCESSOR));
	}

	/**
	 * Sets the amf users associated with the amf event log, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUserPKs the primary keys of the amf users to be associated with the amf event log
	 */
	@Override
	public void setAMFUsers(long pk, long[] amfUserPKs) {
		Set<Long> newAMFUserPKsSet = SetUtil.fromArray(amfUserPKs);
		Set<Long> oldAMFUserPKsSet = SetUtil.fromArray(
			amfEventLogToAMFUserTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeAMFUserPKsSet = new HashSet<Long>(oldAMFUserPKsSet);

		removeAMFUserPKsSet.removeAll(newAMFUserPKsSet);

		amfEventLogToAMFUserTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeAMFUserPKsSet));

		newAMFUserPKsSet.removeAll(oldAMFUserPKsSet);

		long companyId = 0;

		AMFEventLog amfEventLog = fetchByPrimaryKey(pk);

		if (amfEventLog == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = amfEventLog.getCompanyId();
		}

		amfEventLogToAMFUserTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newAMFUserPKsSet));
	}

	/**
	 * Sets the amf users associated with the amf event log, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the amf event log
	 * @param amfUsers the amf users to be associated with the amf event log
	 */
	@Override
	public void setAMFUsers(long pk, List<AMFUser> amfUsers) {
		try {
			long[] amfUserPKs = new long[amfUsers.size()];

			for (int i = 0; i < amfUsers.size(); i++) {
				AMFUser amfUser = amfUsers.get(i);

				amfUserPKs[i] = amfUser.getPrimaryKey();
			}

			setAMFUsers(pk, amfUserPKs);
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
		return "amfEventLogId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AMFEVENTLOG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AMFEventLogModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the amf event log persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new AMFEventLogModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AMFEventLog.class.getName()));

		amfEventLogToAMFUserTableMapper = TableMapperFactory.getTableMapper(
			"eventlog#amfEventLogId", "eventlog", "companyId", "amfEventLogId",
			"amfUserId", this, AMFUser.class);

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
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(AMFEventLogImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}

		TableMapperFactory.removeTableMapper("eventlog#amfEventLogId");
	}

	@Override
	@Reference(
		target = AMFRegistrationPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AMFRegistrationPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AMFRegistrationPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	protected TableMapper<AMFEventLog, AMFUser> amfEventLogToAMFUserTableMapper;

	private static final String _SQL_SELECT_AMFEVENTLOG =
		"SELECT amfEventLog FROM AMFEventLog amfEventLog";

	private static final String _SQL_SELECT_AMFEVENTLOG_WHERE =
		"SELECT amfEventLog FROM AMFEventLog amfEventLog WHERE ";

	private static final String _SQL_COUNT_AMFEVENTLOG =
		"SELECT COUNT(amfEventLog) FROM AMFEventLog amfEventLog";

	private static final String _SQL_COUNT_AMFEVENTLOG_WHERE =
		"SELECT COUNT(amfEventLog) FROM AMFEventLog amfEventLog WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "amfEventLog.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AMFEventLog exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AMFEventLog exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AMFEventLogPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(AMFRegistrationPersistenceConstants.class.getName());
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

	private static class AMFEventLogModelArgumentsResolver
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

			AMFEventLogModelImpl amfEventLogModelImpl =
				(AMFEventLogModelImpl)baseModel;

			long columnBitmask = amfEventLogModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(amfEventLogModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						amfEventLogModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(amfEventLogModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			AMFEventLogModelImpl amfEventLogModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = amfEventLogModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = amfEventLogModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}