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

package com.amf.registration.model.impl;

import com.amf.registration.model.AMFEventLog;
import com.amf.registration.model.AMFEventLogModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the AMFEventLog service. Represents a row in the &quot;amfeventlog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AMFEventLogModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AMFEventLogImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventLogImpl
 * @generated
 */
public class AMFEventLogModelImpl
	extends BaseModelImpl<AMFEventLog> implements AMFEventLogModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a amf event log model instance should use the <code>AMFEventLog</code> interface instead.
	 */
	public static final String TABLE_NAME = "amfeventlog";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"amfEventLogId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"groupId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"lastLoginDate", Types.TIMESTAMP},
		{"lastLoginIP", Types.VARCHAR}, {"status", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("amfEventLogId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("lastLoginDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("lastLoginIP", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table amfeventlog (uuid_ VARCHAR(75) null,amfEventLogId LONG not null primary key,companyId LONG,createDate DATE null,modifiedDate DATE null,groupId LONG,userId LONG,lastLoginDate DATE null,lastLoginIP VARCHAR(75) null,status VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table amfeventlog";

	public static final String ORDER_BY_JPQL =
		" ORDER BY amfEventLog.lastLoginDate ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY amfeventlog.lastLoginDate ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long LASTLOGINDATE_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public static final String MAPPING_TABLE_EVENTLOG_NAME = "eventlog";

	public static final Object[][] MAPPING_TABLE_EVENTLOG_COLUMNS = {
		{"companyId", Types.BIGINT}, {"amfEventLogId", Types.BIGINT},
		{"amfUserId", Types.BIGINT}
	};

	public static final String MAPPING_TABLE_EVENTLOG_SQL_CREATE =
		"create table eventlog (companyId LONG not null,amfEventLogId LONG not null,amfUserId LONG not null,primary key (amfEventLogId, amfUserId))";

	public AMFEventLogModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _amfEventLogId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAmfEventLogId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _amfEventLogId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AMFEventLog.class;
	}

	@Override
	public String getModelClassName() {
		return AMFEventLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AMFEventLog, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AMFEventLog, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AMFEventLog, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((AMFEventLog)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AMFEventLog, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AMFEventLog, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AMFEventLog)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AMFEventLog, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AMFEventLog, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, AMFEventLog>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			AMFEventLog.class.getClassLoader(), AMFEventLog.class,
			ModelWrapper.class);

		try {
			Constructor<AMFEventLog> constructor =
				(Constructor<AMFEventLog>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<AMFEventLog, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AMFEventLog, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AMFEventLog, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<AMFEventLog, Object>>();
		Map<String, BiConsumer<AMFEventLog, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<AMFEventLog, ?>>();

		attributeGetterFunctions.put("uuid", AMFEventLog::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<AMFEventLog, String>)AMFEventLog::setUuid);
		attributeGetterFunctions.put(
			"amfEventLogId", AMFEventLog::getAmfEventLogId);
		attributeSetterBiConsumers.put(
			"amfEventLogId",
			(BiConsumer<AMFEventLog, Long>)AMFEventLog::setAmfEventLogId);
		attributeGetterFunctions.put("companyId", AMFEventLog::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<AMFEventLog, Long>)AMFEventLog::setCompanyId);
		attributeGetterFunctions.put("createDate", AMFEventLog::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<AMFEventLog, Date>)AMFEventLog::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", AMFEventLog::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<AMFEventLog, Date>)AMFEventLog::setModifiedDate);
		attributeGetterFunctions.put("groupId", AMFEventLog::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<AMFEventLog, Long>)AMFEventLog::setGroupId);
		attributeGetterFunctions.put("userId", AMFEventLog::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<AMFEventLog, Long>)AMFEventLog::setUserId);
		attributeGetterFunctions.put(
			"lastLoginDate", AMFEventLog::getLastLoginDate);
		attributeSetterBiConsumers.put(
			"lastLoginDate",
			(BiConsumer<AMFEventLog, Date>)AMFEventLog::setLastLoginDate);
		attributeGetterFunctions.put(
			"lastLoginIP", AMFEventLog::getLastLoginIP);
		attributeSetterBiConsumers.put(
			"lastLoginIP",
			(BiConsumer<AMFEventLog, String>)AMFEventLog::setLastLoginIP);
		attributeGetterFunctions.put("status", AMFEventLog::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<AMFEventLog, String>)AMFEventLog::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@Override
	public long getAmfEventLogId() {
		return _amfEventLogId;
	}

	@Override
	public void setAmfEventLogId(long amfEventLogId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_amfEventLogId = amfEventLogId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public Date getLastLoginDate() {
		return _lastLoginDate;
	}

	@Override
	public void setLastLoginDate(Date lastLoginDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastLoginDate = lastLoginDate;
	}

	@Override
	public String getLastLoginIP() {
		if (_lastLoginIP == null) {
			return "";
		}
		else {
			return _lastLoginIP;
		}
	}

	@Override
	public void setLastLoginIP(String lastLoginIP) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_lastLoginIP = lastLoginIP;
	}

	@Override
	public String getStatus() {
		if (_status == null) {
			return "";
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(AMFEventLog.class.getName()));
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), AMFEventLog.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AMFEventLog toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, AMFEventLog>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AMFEventLogImpl amfEventLogImpl = new AMFEventLogImpl();

		amfEventLogImpl.setUuid(getUuid());
		amfEventLogImpl.setAmfEventLogId(getAmfEventLogId());
		amfEventLogImpl.setCompanyId(getCompanyId());
		amfEventLogImpl.setCreateDate(getCreateDate());
		amfEventLogImpl.setModifiedDate(getModifiedDate());
		amfEventLogImpl.setGroupId(getGroupId());
		amfEventLogImpl.setUserId(getUserId());
		amfEventLogImpl.setLastLoginDate(getLastLoginDate());
		amfEventLogImpl.setLastLoginIP(getLastLoginIP());
		amfEventLogImpl.setStatus(getStatus());

		amfEventLogImpl.resetOriginalValues();

		return amfEventLogImpl;
	}

	@Override
	public int compareTo(AMFEventLog amfEventLog) {
		int value = 0;

		value = DateUtil.compareTo(
			getLastLoginDate(), amfEventLog.getLastLoginDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AMFEventLog)) {
			return false;
		}

		AMFEventLog amfEventLog = (AMFEventLog)object;

		long primaryKey = amfEventLog.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<AMFEventLog> toCacheModel() {
		AMFEventLogCacheModel amfEventLogCacheModel =
			new AMFEventLogCacheModel();

		amfEventLogCacheModel.uuid = getUuid();

		String uuid = amfEventLogCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			amfEventLogCacheModel.uuid = null;
		}

		amfEventLogCacheModel.amfEventLogId = getAmfEventLogId();

		amfEventLogCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			amfEventLogCacheModel.createDate = createDate.getTime();
		}
		else {
			amfEventLogCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			amfEventLogCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			amfEventLogCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		amfEventLogCacheModel.groupId = getGroupId();

		amfEventLogCacheModel.userId = getUserId();

		Date lastLoginDate = getLastLoginDate();

		if (lastLoginDate != null) {
			amfEventLogCacheModel.lastLoginDate = lastLoginDate.getTime();
		}
		else {
			amfEventLogCacheModel.lastLoginDate = Long.MIN_VALUE;
		}

		amfEventLogCacheModel.lastLoginIP = getLastLoginIP();

		String lastLoginIP = amfEventLogCacheModel.lastLoginIP;

		if ((lastLoginIP != null) && (lastLoginIP.length() == 0)) {
			amfEventLogCacheModel.lastLoginIP = null;
		}

		amfEventLogCacheModel.status = getStatus();

		String status = amfEventLogCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			amfEventLogCacheModel.status = null;
		}

		return amfEventLogCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AMFEventLog, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AMFEventLog, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AMFEventLog, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((AMFEventLog)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<AMFEventLog, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AMFEventLog, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AMFEventLog, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((AMFEventLog)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, AMFEventLog>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _amfEventLogId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _groupId;
	private long _userId;
	private Date _lastLoginDate;
	private String _lastLoginIP;
	private String _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<AMFEventLog, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((AMFEventLog)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("amfEventLogId", _amfEventLogId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("lastLoginDate", _lastLoginDate);
		_columnOriginalValues.put("lastLoginIP", _lastLoginIP);
		_columnOriginalValues.put("status", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("amfEventLogId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("createDate", 8L);

		columnBitmasks.put("modifiedDate", 16L);

		columnBitmasks.put("groupId", 32L);

		columnBitmasks.put("userId", 64L);

		columnBitmasks.put("lastLoginDate", 128L);

		columnBitmasks.put("lastLoginIP", 256L);

		columnBitmasks.put("status", 512L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private AMFEventLog _escapedModel;

}