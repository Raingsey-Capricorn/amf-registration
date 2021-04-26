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

package com.amf.registration.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AMFEventLog}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFEventLog
 * @generated
 */
public class AMFEventLogWrapper
	extends BaseModelWrapper<AMFEventLog>
	implements AMFEventLog, ModelWrapper<AMFEventLog> {

	public AMFEventLogWrapper(AMFEventLog amfEventLog) {
		super(amfEventLog);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("amfEventLogId", getAmfEventLogId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("groupId", getGroupId());
		attributes.put("userGroupId", getUserGroupId());
		attributes.put("userId", getUserId());
		attributes.put("lastLoginDate", getLastLoginDate());
		attributes.put("lastLoginIP", getLastLoginIP());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long amfEventLogId = (Long)attributes.get("amfEventLogId");

		if (amfEventLogId != null) {
			setAmfEventLogId(amfEventLogId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userGroupId = (Long)attributes.get("userGroupId");

		if (userGroupId != null) {
			setUserGroupId(userGroupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date lastLoginDate = (Date)attributes.get("lastLoginDate");

		if (lastLoginDate != null) {
			setLastLoginDate(lastLoginDate);
		}

		String lastLoginIP = (String)attributes.get("lastLoginIP");

		if (lastLoginIP != null) {
			setLastLoginIP(lastLoginIP);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the amf event log ID of this amf event log.
	 *
	 * @return the amf event log ID of this amf event log
	 */
	@Override
	public long getAmfEventLogId() {
		return model.getAmfEventLogId();
	}

	@Override
	public String getCombinedUserInfo()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getCombinedUserInfo();
	}

	/**
	 * Returns the company ID of this amf event log.
	 *
	 * @return the company ID of this amf event log
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this amf event log.
	 *
	 * @return the create date of this amf event log
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this amf event log.
	 *
	 * @return the group ID of this amf event log
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the last login date of this amf event log.
	 *
	 * @return the last login date of this amf event log
	 */
	@Override
	public Date getLastLoginDate() {
		return model.getLastLoginDate();
	}

	/**
	 * Returns the last login ip of this amf event log.
	 *
	 * @return the last login ip of this amf event log
	 */
	@Override
	public String getLastLoginIP() {
		return model.getLastLoginIP();
	}

	/**
	 * Returns the modified date of this amf event log.
	 *
	 * @return the modified date of this amf event log
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this amf event log.
	 *
	 * @return the primary key of this amf event log
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this amf event log.
	 *
	 * @return the status of this amf event log
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the user group ID of this amf event log.
	 *
	 * @return the user group ID of this amf event log
	 */
	@Override
	public long getUserGroupId() {
		return model.getUserGroupId();
	}

	/**
	 * Returns the user ID of this amf event log.
	 *
	 * @return the user ID of this amf event log
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this amf event log.
	 *
	 * @return the user uuid of this amf event log
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this amf event log.
	 *
	 * @return the uuid of this amf event log
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the amf event log ID of this amf event log.
	 *
	 * @param amfEventLogId the amf event log ID of this amf event log
	 */
	@Override
	public void setAmfEventLogId(long amfEventLogId) {
		model.setAmfEventLogId(amfEventLogId);
	}

	/**
	 * Sets the company ID of this amf event log.
	 *
	 * @param companyId the company ID of this amf event log
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this amf event log.
	 *
	 * @param createDate the create date of this amf event log
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this amf event log.
	 *
	 * @param groupId the group ID of this amf event log
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the last login date of this amf event log.
	 *
	 * @param lastLoginDate the last login date of this amf event log
	 */
	@Override
	public void setLastLoginDate(Date lastLoginDate) {
		model.setLastLoginDate(lastLoginDate);
	}

	/**
	 * Sets the last login ip of this amf event log.
	 *
	 * @param lastLoginIP the last login ip of this amf event log
	 */
	@Override
	public void setLastLoginIP(String lastLoginIP) {
		model.setLastLoginIP(lastLoginIP);
	}

	/**
	 * Sets the modified date of this amf event log.
	 *
	 * @param modifiedDate the modified date of this amf event log
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this amf event log.
	 *
	 * @param primaryKey the primary key of this amf event log
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this amf event log.
	 *
	 * @param status the status of this amf event log
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the user group ID of this amf event log.
	 *
	 * @param userGroupId the user group ID of this amf event log
	 */
	@Override
	public void setUserGroupId(long userGroupId) {
		model.setUserGroupId(userGroupId);
	}

	/**
	 * Sets the user ID of this amf event log.
	 *
	 * @param userId the user ID of this amf event log
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this amf event log.
	 *
	 * @param userUuid the user uuid of this amf event log
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this amf event log.
	 *
	 * @param uuid the uuid of this amf event log
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected AMFEventLogWrapper wrap(AMFEventLog amfEventLog) {
		return new AMFEventLogWrapper(amfEventLog);
	}

}