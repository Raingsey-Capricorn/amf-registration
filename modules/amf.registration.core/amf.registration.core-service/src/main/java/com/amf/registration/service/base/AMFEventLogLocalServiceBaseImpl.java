/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.amf.registration.service.base;

import com.amf.registration.model.AMFEventLog;
import com.amf.registration.service.AMFEventLogLocalService;
import com.amf.registration.service.persistence.AMFEventLogPersistence;
import com.amf.registration.service.persistence.AMFUserPersistence;
import com.liferay.exportimport.kernel.lar.*;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Reference;

import javax.sql.DataSource;
import java.io.Serializable;
import java.util.List;

/**
 * Provides the base implementation for the amf event log local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.amf.registration.service.impl.AMFEventLogLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.amf.registration.service.impl.AMFEventLogLocalServiceImpl
 * @generated
 */
public abstract class AMFEventLogLocalServiceBaseImpl
        extends BaseLocalServiceImpl
        implements AMFEventLogLocalService, AopService, IdentifiableOSGiService {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Use <code>AMFEventLogLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.amf.registration.service.AMFEventLogLocalServiceUtil</code>.
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
    @Override
    public AMFEventLog addAMFEventLog(AMFEventLog amfEventLog) {
        amfEventLog.setNew(true);

        return amfEventLogPersistence.update(amfEventLog);
    }

    /**
     * Creates a new amf event log with the primary key. Does not add the amf event log to the database.
     *
     * @param amfEventLogId the primary key for the new amf event log
     * @return the new amf event log
     */
    @Override
    @Transactional(enabled = false)
    public AMFEventLog createAMFEventLog(long amfEventLogId) {
        return amfEventLogPersistence.create(amfEventLogId);
    }

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
    @Override
    public AMFEventLog deleteAMFEventLog(long amfEventLogId)
            throws PortalException {

        return amfEventLogPersistence.remove(amfEventLogId);
    }

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
    @Override
    public AMFEventLog deleteAMFEventLog(AMFEventLog amfEventLog) {
        return amfEventLogPersistence.remove(amfEventLog);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(
                AMFEventLog.class, clazz.getClassLoader());
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     */
    @Override
    public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
        return amfEventLogPersistence.findWithDynamicQuery(dynamicQuery);
    }

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
    @Override
    public <T> List<T> dynamicQuery(
            DynamicQuery dynamicQuery, int start, int end) {

        return amfEventLogPersistence.findWithDynamicQuery(
                dynamicQuery, start, end);
    }

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
    @Override
    public <T> List<T> dynamicQuery(
            DynamicQuery dynamicQuery, int start, int end,
            OrderByComparator<T> orderByComparator) {

        return amfEventLogPersistence.findWithDynamicQuery(
                dynamicQuery, start, end, orderByComparator);
    }

    /**
     * Returns the number of rows matching the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows matching the dynamic query
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery) {
        return amfEventLogPersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Returns the number of rows matching the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows matching the dynamic query
     */
    @Override
    public long dynamicQueryCount(
            DynamicQuery dynamicQuery, Projection projection) {

        return amfEventLogPersistence.countWithDynamicQuery(
                dynamicQuery, projection);
    }

    @Override
    public AMFEventLog fetchAMFEventLog(long amfEventLogId) {
        return amfEventLogPersistence.fetchByPrimaryKey(amfEventLogId);
    }

    /**
     * Returns the amf event log matching the UUID and group.
     *
     * @param uuid the amf event log's UUID
     * @param groupId the primary key of the group
     * @return the matching amf event log, or <code>null</code> if a matching amf event log could not be found
     */
    @Override
    public AMFEventLog fetchAMFEventLogByUuidAndGroupId(
            String uuid, long groupId) {

        return amfEventLogPersistence.fetchByUUID_G(uuid, groupId);
    }

    /**
     * Returns the amf event log with the primary key.
     *
     * @param amfEventLogId the primary key of the amf event log
     * @return the amf event log
     * @throws PortalException if a amf event log with the primary key could not be found
     */
    @Override
    public AMFEventLog getAMFEventLog(long amfEventLogId)
            throws PortalException {

        return amfEventLogPersistence.findByPrimaryKey(amfEventLogId);
    }

    @Override
    public ActionableDynamicQuery getActionableDynamicQuery() {
        ActionableDynamicQuery actionableDynamicQuery =
                new DefaultActionableDynamicQuery();

        actionableDynamicQuery.setBaseLocalService(amfEventLogLocalService);
        actionableDynamicQuery.setClassLoader(getClassLoader());
        actionableDynamicQuery.setModelClass(AMFEventLog.class);

        actionableDynamicQuery.setPrimaryKeyPropertyName("amfEventLogId");

        return actionableDynamicQuery;
    }

    @Override
    public IndexableActionableDynamicQuery
    getIndexableActionableDynamicQuery() {

        IndexableActionableDynamicQuery indexableActionableDynamicQuery =
                new IndexableActionableDynamicQuery();

        indexableActionableDynamicQuery.setBaseLocalService(
                amfEventLogLocalService);
        indexableActionableDynamicQuery.setClassLoader(getClassLoader());
        indexableActionableDynamicQuery.setModelClass(AMFEventLog.class);

        indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
                "amfEventLogId");

        return indexableActionableDynamicQuery;
    }

    protected void initActionableDynamicQuery(
            ActionableDynamicQuery actionableDynamicQuery) {

        actionableDynamicQuery.setBaseLocalService(amfEventLogLocalService);
        actionableDynamicQuery.setClassLoader(getClassLoader());
        actionableDynamicQuery.setModelClass(AMFEventLog.class);

        actionableDynamicQuery.setPrimaryKeyPropertyName("amfEventLogId");
    }

    @Override
    public ExportActionableDynamicQuery getExportActionableDynamicQuery(
            final PortletDataContext portletDataContext) {

        final ExportActionableDynamicQuery exportActionableDynamicQuery =
                new ExportActionableDynamicQuery() {

                    @Override
                    public long performCount() throws PortalException {
                        ManifestSummary manifestSummary =
                                portletDataContext.getManifestSummary();

                        StagedModelType stagedModelType = getStagedModelType();

                        long modelAdditionCount = super.performCount();

                        manifestSummary.addModelAdditionCount(
                                stagedModelType, modelAdditionCount);

                        long modelDeletionCount =
                                ExportImportHelperUtil.getModelDeletionCount(
                                        portletDataContext, stagedModelType);

                        manifestSummary.addModelDeletionCount(
                                stagedModelType, modelDeletionCount);

                        return modelAdditionCount;
                    }

                };

        initActionableDynamicQuery(exportActionableDynamicQuery);

        exportActionableDynamicQuery.setAddCriteriaMethod(
                new ActionableDynamicQuery.AddCriteriaMethod() {

                    @Override
                    public void addCriteria(DynamicQuery dynamicQuery) {
                        portletDataContext.addDateRangeCriteria(
                                dynamicQuery, "modifiedDate");
                    }

                });

        exportActionableDynamicQuery.setCompanyId(
                portletDataContext.getCompanyId());

        exportActionableDynamicQuery.setPerformActionMethod(
                new ActionableDynamicQuery.PerformActionMethod<AMFEventLog>() {

                    @Override
                    public void performAction(AMFEventLog amfEventLog)
                            throws PortalException {

                        StagedModelDataHandlerUtil.exportStagedModel(
                                portletDataContext, amfEventLog);
                    }

                });
        exportActionableDynamicQuery.setStagedModelType(
                new StagedModelType(
                        PortalUtil.getClassNameId(AMFEventLog.class.getName())));

        return exportActionableDynamicQuery;
    }

    /**
     * @throws PortalException
     */
    public PersistedModel createPersistedModel(Serializable primaryKeyObj)
            throws PortalException {

        return amfEventLogPersistence.create(((Long) primaryKeyObj).longValue());
    }

    /**
     * @throws PortalException
     */
    @Override
    public PersistedModel deletePersistedModel(PersistedModel persistedModel)
            throws PortalException {

        return amfEventLogLocalService.deleteAMFEventLog(
                (AMFEventLog) persistedModel);
    }

    public BasePersistence<AMFEventLog> getBasePersistence() {
        return amfEventLogPersistence;
    }

    /**
     * @throws PortalException
     */
    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
            throws PortalException {

        return amfEventLogPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns all the amf event logs matching the UUID and company.
     *
     * @param uuid the UUID of the amf event logs
     * @param companyId the primary key of the company
     * @return the matching amf event logs, or an empty list if no matches were found
     */
    @Override
    public List<AMFEventLog> getAMFEventLogsByUuidAndCompanyId(
            String uuid, long companyId) {

        return amfEventLogPersistence.findByUuid_C(uuid, companyId);
    }

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
    @Override
    public List<AMFEventLog> getAMFEventLogsByUuidAndCompanyId(
            String uuid, long companyId, int start, int end,
            OrderByComparator<AMFEventLog> orderByComparator) {

        return amfEventLogPersistence.findByUuid_C(
                uuid, companyId, start, end, orderByComparator);
    }

    /**
     * Returns the amf event log matching the UUID and group.
     *
     * @param uuid the amf event log's UUID
     * @param groupId the primary key of the group
     * @return the matching amf event log
     * @throws PortalException if a matching amf event log could not be found
     */
    @Override
    public AMFEventLog getAMFEventLogByUuidAndGroupId(String uuid, long groupId)
            throws PortalException {

        return amfEventLogPersistence.findByUUID_G(uuid, groupId);
    }

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
    @Override
    public List<AMFEventLog> getAMFEventLogs(int start, int end) {
        return amfEventLogPersistence.findAll(start, end);
    }

    /**
     * Returns the number of amf event logs.
     *
     * @return the number of amf event logs
     */
    @Override
    public int getAMFEventLogsCount() {
        return amfEventLogPersistence.countAll();
    }

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
    @Override
    public AMFEventLog updateAMFEventLog(AMFEventLog amfEventLog) {
        return amfEventLogPersistence.update(amfEventLog);
    }

    /**
     */
    @Override
    public void addAMFUserAMFEventLog(long amfUserId, long amfEventLogId) {
        amfUserPersistence.addAMFEventLog(amfUserId, amfEventLogId);
    }

    /**
     */
    @Override
    public void addAMFUserAMFEventLog(long amfUserId, AMFEventLog amfEventLog) {
        amfUserPersistence.addAMFEventLog(amfUserId, amfEventLog);
    }

    /**
     */
    @Override
    public void addAMFUserAMFEventLogs(long amfUserId, long[] amfEventLogIds) {
        amfUserPersistence.addAMFEventLogs(amfUserId, amfEventLogIds);
    }

    /**
     */
    @Override
    public void addAMFUserAMFEventLogs(
            long amfUserId, List<AMFEventLog> amfEventLogs) {

        amfUserPersistence.addAMFEventLogs(amfUserId, amfEventLogs);
    }

    /**
     */
    @Override
    public void clearAMFUserAMFEventLogs(long amfUserId) {
        amfUserPersistence.clearAMFEventLogs(amfUserId);
    }

    /**
     */
    @Override
    public void deleteAMFUserAMFEventLog(long amfUserId, long amfEventLogId) {
        amfUserPersistence.removeAMFEventLog(amfUserId, amfEventLogId);
    }

    /**
     */
    @Override
    public void deleteAMFUserAMFEventLog(
            long amfUserId, AMFEventLog amfEventLog) {

        amfUserPersistence.removeAMFEventLog(amfUserId, amfEventLog);
    }

    /**
     */
    @Override
    public void deleteAMFUserAMFEventLogs(
            long amfUserId, long[] amfEventLogIds) {

        amfUserPersistence.removeAMFEventLogs(amfUserId, amfEventLogIds);
    }

    /**
     */
    @Override
    public void deleteAMFUserAMFEventLogs(
            long amfUserId, List<AMFEventLog> amfEventLogs) {

        amfUserPersistence.removeAMFEventLogs(amfUserId, amfEventLogs);
    }

    /**
     * Returns the amfUserIds of the amf users associated with the amf event log.
     *
     * @param amfEventLogId the amfEventLogId of the amf event log
     * @return long[] the amfUserIds of amf users associated with the amf event log
     */
    @Override
    public long[] getAMFUserPrimaryKeys(long amfEventLogId) {
        return amfEventLogPersistence.getAMFUserPrimaryKeys(amfEventLogId);
    }

    /**
     */
    @Override
    public List<AMFEventLog> getAMFUserAMFEventLogs(long amfUserId) {
        return amfEventLogPersistence.getAMFUserAMFEventLogs(amfUserId);
    }

    /**
     */
    @Override
    public List<AMFEventLog> getAMFUserAMFEventLogs(
            long amfUserId, int start, int end) {

        return amfEventLogPersistence.getAMFUserAMFEventLogs(
                amfUserId, start, end);
    }

    /**
     */
    @Override
    public List<AMFEventLog> getAMFUserAMFEventLogs(
            long amfUserId, int start, int end,
            OrderByComparator<AMFEventLog> orderByComparator) {

        return amfEventLogPersistence.getAMFUserAMFEventLogs(
                amfUserId, start, end, orderByComparator);
    }

    /**
     */
    @Override
    public int getAMFUserAMFEventLogsCount(long amfUserId) {
        return amfUserPersistence.getAMFEventLogsSize(amfUserId);
    }

    /**
     */
    @Override
    public boolean hasAMFUserAMFEventLog(long amfUserId, long amfEventLogId) {
        return amfUserPersistence.containsAMFEventLog(amfUserId, amfEventLogId);
    }

    /**
     */
    @Override
    public boolean hasAMFUserAMFEventLogs(long amfUserId) {
        return amfUserPersistence.containsAMFEventLogs(amfUserId);
    }

    /**
     */
    @Override
    public void setAMFUserAMFEventLogs(long amfUserId, long[] amfEventLogIds) {
        amfUserPersistence.setAMFEventLogs(amfUserId, amfEventLogIds);
    }

    @Override
    public Class<?>[] getAopInterfaces() {
        return new Class<?>[]{
                AMFEventLogLocalService.class, IdentifiableOSGiService.class,
                PersistedModelLocalService.class
        };
    }

    @Override
    public void setAopProxy(Object aopProxy) {
        amfEventLogLocalService = (AMFEventLogLocalService) aopProxy;
    }

    /**
     * Returns the OSGi service identifier.
     *
     * @return the OSGi service identifier
     */
    @Override
    public String getOSGiServiceIdentifier() {
        return AMFEventLogLocalService.class.getName();
    }

    protected Class<?> getModelClass() {
        return AMFEventLog.class;
    }

    protected String getModelClassName() {
        return AMFEventLog.class.getName();
    }

    /**
     * Performs a SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) {
        try {
            DataSource dataSource = amfEventLogPersistence.getDataSource();

            DB db = DBManagerUtil.getDB();

            sql = db.buildSQL(sql);
            sql = PortalUtil.transformSQL(sql);

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
                    dataSource, sql);

            sqlUpdate.update();
        } catch (Exception exception) {
            throw new SystemException(exception);
        }
    }

    protected AMFEventLogLocalService amfEventLogLocalService;

    @Reference
    protected AMFEventLogPersistence amfEventLogPersistence;

    @Reference
    protected AMFUserPersistence amfUserPersistence;

    @Reference
    protected com.liferay.counter.kernel.service.CounterLocalService
            counterLocalService;

    @Reference
    protected com.liferay.portal.kernel.service.ClassNameLocalService
            classNameLocalService;

    @Reference
    protected com.liferay.portal.kernel.service.ResourceLocalService
            resourceLocalService;

    @Reference
    protected com.liferay.portal.kernel.service.UserLocalService
            userLocalService;

}