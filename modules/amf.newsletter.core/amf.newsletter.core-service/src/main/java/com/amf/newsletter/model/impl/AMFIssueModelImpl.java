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

package com.amf.newsletter.model.impl;

import com.amf.newsletter.model.AMFIssue;
import com.amf.newsletter.model.AMFIssueModel;
import com.amf.newsletter.model.AMFIssueSoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the AMFIssue service. Represents a row in the &quot;amf_issue&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AMFIssueModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AMFIssueImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFIssueImpl
 * @generated
 */
@JSON(strict = true)
public class AMFIssueModelImpl
	extends BaseModelImpl<AMFIssue> implements AMFIssueModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a amf issue model instance should use the <code>AMFIssue</code> interface instead.
	 */
	public static final String TABLE_NAME = "amf_issue";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"amfIssueId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"userGroupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"issueDate", Types.TIMESTAMP},
		{"issueNumber", Types.INTEGER}, {"title", Types.VARCHAR},
		{"journalId", Types.BIGINT}, {"description", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("amfIssueId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userGroupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("issueDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("issueNumber", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("journalId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table amf_issue (uuid_ VARCHAR(75) null,amfIssueId LONG not null primary key,groupId LONG,userGroupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,issueDate DATE null,issueNumber INTEGER,title VARCHAR(75) null,journalId LONG,description VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table amf_issue";

	public static final String ORDER_BY_JPQL =
		" ORDER BY amfIssue.issueDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY amf_issue.issueDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long AMFISSUEID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long ISSUEDATE_COLUMN_BITMASK = 16L;

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

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static AMFIssue toModel(AMFIssueSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AMFIssue model = new AMFIssueImpl();

		model.setUuid(soapModel.getUuid());
		model.setAmfIssueId(soapModel.getAmfIssueId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserGroupId(soapModel.getUserGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setIssueDate(soapModel.getIssueDate());
		model.setIssueNumber(soapModel.getIssueNumber());
		model.setTitle(soapModel.getTitle());
		model.setJournalId(soapModel.getJournalId());
		model.setDescription(soapModel.getDescription());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<AMFIssue> toModels(AMFIssueSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AMFIssue> models = new ArrayList<AMFIssue>(soapModels.length);

		for (AMFIssueSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final String
		MAPPING_TABLE_AMFNEWSLETTER_AMFISSUE_ARTICLE_NAME =
			"AMFNewsletter_amfissue_article";

	public static final Object[][]
		MAPPING_TABLE_AMFNEWSLETTER_AMFISSUE_ARTICLE_COLUMNS = {
			{"companyId", Types.BIGINT}, {"amfArticleId", Types.BIGINT},
			{"amfIssueId", Types.BIGINT}
		};

	public static final String
		MAPPING_TABLE_AMFNEWSLETTER_AMFISSUE_ARTICLE_SQL_CREATE =
			"create table AMFNewsletter_amfissue_article (companyId LONG not null,amfArticleId LONG not null,amfIssueId LONG not null,primary key (amfArticleId, amfIssueId))";

	public AMFIssueModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _amfIssueId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAmfIssueId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _amfIssueId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AMFIssue.class;
	}

	@Override
	public String getModelClassName() {
		return AMFIssue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AMFIssue, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AMFIssue, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AMFIssue, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((AMFIssue)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AMFIssue, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AMFIssue, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AMFIssue)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AMFIssue, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AMFIssue, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, AMFIssue>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			AMFIssue.class.getClassLoader(), AMFIssue.class,
			ModelWrapper.class);

		try {
			Constructor<AMFIssue> constructor =
				(Constructor<AMFIssue>)proxyClass.getConstructor(
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

	private static final Map<String, Function<AMFIssue, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AMFIssue, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AMFIssue, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<AMFIssue, Object>>();
		Map<String, BiConsumer<AMFIssue, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<AMFIssue, ?>>();

		attributeGetterFunctions.put("uuid", AMFIssue::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<AMFIssue, String>)AMFIssue::setUuid);
		attributeGetterFunctions.put("amfIssueId", AMFIssue::getAmfIssueId);
		attributeSetterBiConsumers.put(
			"amfIssueId", (BiConsumer<AMFIssue, Long>)AMFIssue::setAmfIssueId);
		attributeGetterFunctions.put("groupId", AMFIssue::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<AMFIssue, Long>)AMFIssue::setGroupId);
		attributeGetterFunctions.put("userGroupId", AMFIssue::getUserGroupId);
		attributeSetterBiConsumers.put(
			"userGroupId",
			(BiConsumer<AMFIssue, Long>)AMFIssue::setUserGroupId);
		attributeGetterFunctions.put("companyId", AMFIssue::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<AMFIssue, Long>)AMFIssue::setCompanyId);
		attributeGetterFunctions.put("userId", AMFIssue::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<AMFIssue, Long>)AMFIssue::setUserId);
		attributeGetterFunctions.put("userName", AMFIssue::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<AMFIssue, String>)AMFIssue::setUserName);
		attributeGetterFunctions.put("createDate", AMFIssue::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<AMFIssue, Date>)AMFIssue::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", AMFIssue::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<AMFIssue, Date>)AMFIssue::setModifiedDate);
		attributeGetterFunctions.put("issueDate", AMFIssue::getIssueDate);
		attributeSetterBiConsumers.put(
			"issueDate", (BiConsumer<AMFIssue, Date>)AMFIssue::setIssueDate);
		attributeGetterFunctions.put("issueNumber", AMFIssue::getIssueNumber);
		attributeSetterBiConsumers.put(
			"issueNumber",
			(BiConsumer<AMFIssue, Integer>)AMFIssue::setIssueNumber);
		attributeGetterFunctions.put("title", AMFIssue::getTitle);
		attributeSetterBiConsumers.put(
			"title", (BiConsumer<AMFIssue, String>)AMFIssue::setTitle);
		attributeGetterFunctions.put("journalId", AMFIssue::getJournalId);
		attributeSetterBiConsumers.put(
			"journalId", (BiConsumer<AMFIssue, Long>)AMFIssue::setJournalId);
		attributeGetterFunctions.put("description", AMFIssue::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<AMFIssue, String>)AMFIssue::setDescription);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
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

	@JSON
	@Override
	public long getAmfIssueId() {
		return _amfIssueId;
	}

	@Override
	public void setAmfIssueId(long amfIssueId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_amfIssueId = amfIssueId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalAmfIssueId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("amfIssueId"));
	}

	@JSON
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

	@JSON
	@Override
	public long getUserGroupId() {
		return _userGroupId;
	}

	@Override
	public void setUserGroupId(long userGroupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userGroupId = userGroupId;
	}

	@JSON
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

	@JSON
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

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
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

	@JSON
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

	@JSON
	@Override
	public Date getIssueDate() {
		return _issueDate;
	}

	@Override
	public void setIssueDate(Date issueDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_issueDate = issueDate;
	}

	@JSON
	@Override
	public int getIssueNumber() {
		return _issueNumber;
	}

	@Override
	public void setIssueNumber(int issueNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_issueNumber = issueNumber;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_title = title;
	}

	@JSON
	@Override
	public long getJournalId() {
		return _journalId;
	}

	@Override
	public void setJournalId(long journalId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_journalId = journalId;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(AMFIssue.class.getName()));
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
			getCompanyId(), AMFIssue.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AMFIssue toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, AMFIssue>
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
		AMFIssueImpl amfIssueImpl = new AMFIssueImpl();

		amfIssueImpl.setUuid(getUuid());
		amfIssueImpl.setAmfIssueId(getAmfIssueId());
		amfIssueImpl.setGroupId(getGroupId());
		amfIssueImpl.setUserGroupId(getUserGroupId());
		amfIssueImpl.setCompanyId(getCompanyId());
		amfIssueImpl.setUserId(getUserId());
		amfIssueImpl.setUserName(getUserName());
		amfIssueImpl.setCreateDate(getCreateDate());
		amfIssueImpl.setModifiedDate(getModifiedDate());
		amfIssueImpl.setIssueDate(getIssueDate());
		amfIssueImpl.setIssueNumber(getIssueNumber());
		amfIssueImpl.setTitle(getTitle());
		amfIssueImpl.setJournalId(getJournalId());
		amfIssueImpl.setDescription(getDescription());

		amfIssueImpl.resetOriginalValues();

		return amfIssueImpl;
	}

	@Override
	public int compareTo(AMFIssue amfIssue) {
		int value = 0;

		value = DateUtil.compareTo(getIssueDate(), amfIssue.getIssueDate());

		value = value * -1;

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

		if (!(object instanceof AMFIssue)) {
			return false;
		}

		AMFIssue amfIssue = (AMFIssue)object;

		long primaryKey = amfIssue.getPrimaryKey();

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
	public CacheModel<AMFIssue> toCacheModel() {
		AMFIssueCacheModel amfIssueCacheModel = new AMFIssueCacheModel();

		amfIssueCacheModel.uuid = getUuid();

		String uuid = amfIssueCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			amfIssueCacheModel.uuid = null;
		}

		amfIssueCacheModel.amfIssueId = getAmfIssueId();

		amfIssueCacheModel.groupId = getGroupId();

		amfIssueCacheModel.userGroupId = getUserGroupId();

		amfIssueCacheModel.companyId = getCompanyId();

		amfIssueCacheModel.userId = getUserId();

		amfIssueCacheModel.userName = getUserName();

		String userName = amfIssueCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			amfIssueCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			amfIssueCacheModel.createDate = createDate.getTime();
		}
		else {
			amfIssueCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			amfIssueCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			amfIssueCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Date issueDate = getIssueDate();

		if (issueDate != null) {
			amfIssueCacheModel.issueDate = issueDate.getTime();
		}
		else {
			amfIssueCacheModel.issueDate = Long.MIN_VALUE;
		}

		amfIssueCacheModel.issueNumber = getIssueNumber();

		amfIssueCacheModel.title = getTitle();

		String title = amfIssueCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			amfIssueCacheModel.title = null;
		}

		amfIssueCacheModel.journalId = getJournalId();

		amfIssueCacheModel.description = getDescription();

		String description = amfIssueCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			amfIssueCacheModel.description = null;
		}

		return amfIssueCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AMFIssue, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AMFIssue, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AMFIssue, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((AMFIssue)this));
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
		Map<String, Function<AMFIssue, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AMFIssue, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AMFIssue, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((AMFIssue)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, AMFIssue>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _amfIssueId;
	private long _groupId;
	private long _userGroupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private Date _issueDate;
	private int _issueNumber;
	private String _title;
	private long _journalId;
	private String _description;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<AMFIssue, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((AMFIssue)this);
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
		_columnOriginalValues.put("amfIssueId", _amfIssueId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("userGroupId", _userGroupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("issueDate", _issueDate);
		_columnOriginalValues.put("issueNumber", _issueNumber);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("journalId", _journalId);
		_columnOriginalValues.put("description", _description);
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

		columnBitmasks.put("amfIssueId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("userGroupId", 8L);

		columnBitmasks.put("companyId", 16L);

		columnBitmasks.put("userId", 32L);

		columnBitmasks.put("userName", 64L);

		columnBitmasks.put("createDate", 128L);

		columnBitmasks.put("modifiedDate", 256L);

		columnBitmasks.put("issueDate", 512L);

		columnBitmasks.put("issueNumber", 1024L);

		columnBitmasks.put("title", 2048L);

		columnBitmasks.put("journalId", 4096L);

		columnBitmasks.put("description", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private AMFIssue _escapedModel;

}