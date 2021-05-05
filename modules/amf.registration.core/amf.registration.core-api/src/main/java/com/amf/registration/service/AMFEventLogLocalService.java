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

package com.amf.registration.service;

import com.amf.registration.exception.NoSuchAMFEventLogException;
import com.amf.registration.model.AMFEventLog;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.HashMap;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for AMFEventLog. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventLogLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AMFEventLogLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.amf.registration.service.impl.AMFEventLogLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the amf event log local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AMFEventLogLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the amf event log to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFEventLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfEventLog the amf event log
	 * @return the amf event log that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AMFEventLog addAMFEventLog(AMFEventLog amfEventLog);

	/**
	 * @param loggedInUser
	 * @return
	 */
	public AMFEventLog addAMFEventLog(User loggedInUser);

	public void addAMFUserAMFEventLog(long amfUserId, AMFEventLog amfEventLog);

	public void addAMFUserAMFEventLog(long amfUserId, long amfEventLogId);

	public void addAMFUserAMFEventLogs(
		long amfUserId, List<AMFEventLog> amfEventLogs);

	public void addAMFUserAMFEventLogs(long amfUserId, long[] amfEventLogIds);

	public void clearAMFUserAMFEventLogs(long amfUserId);

	/**
	 * Creates a new amf event log with the primary key. Does not add the amf event log to the database.
	 *
	 * @param amfEventLogId the primary key for the new amf event log
	 * @return the new amf event log
	 */
	@Transactional(enabled = false)
	public AMFEventLog createAMFEventLog(long amfEventLogId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the amf event log from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFEventLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfEventLog the amf event log
	 * @return the amf event log that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public AMFEventLog deleteAMFEventLog(AMFEventLog amfEventLog);

	/**
	 * Deletes the amf event log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFEventLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfEventLogId the primary key of the amf event log
	 * @return the amf event log that was removed
	 * @throws PortalException if a amf event log with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public AMFEventLog deleteAMFEventLog(long amfEventLogId)
		throws PortalException;

	public void deleteAMFUserAMFEventLog(
		long amfUserId, AMFEventLog amfEventLog);

	public void deleteAMFUserAMFEventLog(long amfUserId, long amfEventLogId);

	public void deleteAMFUserAMFEventLogs(
		long amfUserId, List<AMFEventLog> amfEventLogs);

	public void deleteAMFUserAMFEventLogs(
		long amfUserId, long[] amfEventLogIds);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.registration.model.impl.AMFEventLogModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.registration.model.impl.AMFEventLogModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AMFEventLog fetchAMFEventLog(long amfEventLogId);

	/**
	 * Returns the amf event log matching the UUID and group.
	 *
	 * @param uuid the amf event log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amf event log, or <code>null</code> if a matching amf event log could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AMFEventLog fetchAMFEventLogByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the amf event log with the primary key.
	 *
	 * @param amfEventLogId the primary key of the amf event log
	 * @return the amf event log
	 * @throws PortalException if a amf event log with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AMFEventLog getAMFEventLog(long amfEventLogId)
		throws PortalException;

	/**
	 * @param groupId
	 * @param userId
	 * @param status
	 * @param start
	 * @param end
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HashMap<String, Object> getAMFEventLogBy(
		long groupId, long userId, String status, int start, int end);

	/**
	 * @param groupId
	 * @param status
	 * @param start
	 * @param end
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HashMap<String, Object> getAMFEventLogBy(
			long groupId, String status, int start, int end)
		throws NoSuchAMFEventLogException;

	/**
	 * @param groupId
	 * @param userId
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AMFEventLog getAmfEventLogByGroupAndUser(long groupId, long userId)
		throws NoSuchAMFEventLogException;

	/**
	 * Returns the amf event log matching the UUID and group.
	 *
	 * @param uuid the amf event log's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amf event log
	 * @throws PortalException if a matching amf event log could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AMFEventLog getAMFEventLogByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the amf event logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.amf.registration.model.impl.AMFEventLogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amf event logs
	 * @param end the upper bound of the range of amf event logs (not inclusive)
	 * @return the range of amf event logs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AMFEventLog> getAMFEventLogs(int start, int end);

	/**
	 * @param groupId
	 * @param start
	 * @param end
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HashMap<String, Object> getAMFEventLogs(
			long groupId, int start, int end)
		throws NoSuchAMFEventLogException;

	/**
	 * Returns all the amf event logs matching the UUID and company.
	 *
	 * @param uuid the UUID of the amf event logs
	 * @param companyId the primary key of the company
	 * @return the matching amf event logs, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AMFEventLog> getAMFEventLogsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of amf event logs matching the UUID and company.
	 *
	 * @param uuid the UUID of the amf event logs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of amf event logs
	 * @param end the upper bound of the range of amf event logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching amf event logs, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AMFEventLog> getAMFEventLogsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AMFEventLog> orderByComparator);

	/**
	 * Returns the number of amf event logs.
	 *
	 * @return the number of amf event logs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAMFEventLogsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AMFEventLog> getAMFUserAMFEventLogs(long amfUserId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AMFEventLog> getAMFUserAMFEventLogs(
		long amfUserId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AMFEventLog> getAMFUserAMFEventLogs(
		long amfUserId, int start, int end,
		OrderByComparator<AMFEventLog> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAMFUserAMFEventLogsCount(long amfUserId);

	/**
	 * Returns the amfUserIds of the amf users associated with the amf event log.
	 *
	 * @param amfEventLogId the amfEventLogId of the amf event log
	 * @return long[] the amfUserIds of amf users associated with the amf event log
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getAMFUserPrimaryKeys(long amfEventLogId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasAMFUserAMFEventLog(long amfUserId, long amfEventLogId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasAMFUserAMFEventLogs(long amfUserId);

	public void setAMFUserAMFEventLogs(long amfUserId, long[] amfEventLogIds);

	/**
	 * Updates the amf event log in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMFEventLogLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amfEventLog the amf event log
	 * @return the amf event log that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AMFEventLog updateAMFEventLog(AMFEventLog amfEventLog);

}