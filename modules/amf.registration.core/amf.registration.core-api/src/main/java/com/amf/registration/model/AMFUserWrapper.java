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
 * This class is a wrapper for {@link AMFUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFUser
 * @generated
 */
public class AMFUserWrapper
	extends BaseModelWrapper<AMFUser>
	implements AMFUser, ModelWrapper<AMFUser> {

	public AMFUserWrapper(AMFUser amfUser) {
		super(amfUser);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("amfUserId", getAmfUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userName", getUserName());
		attributes.put("userId", getUserId());
		attributes.put("addressId", getAddressId());
		attributes.put("homePhone", getHomePhone());
		attributes.put("mobilePhone", getMobilePhone());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long amfUserId = (Long)attributes.get("amfUserId");

		if (amfUserId != null) {
			setAmfUserId(amfUserId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		String homePhone = (String)attributes.get("homePhone");

		if (homePhone != null) {
			setHomePhone(homePhone);
		}

		String mobilePhone = (String)attributes.get("mobilePhone");

		if (mobilePhone != null) {
			setMobilePhone(mobilePhone);
		}
	}

	/**
	 * @param addressId
	 * @return
	 */
	@Override
	public String getAddress(long addressId) {
		return model.getAddress(addressId);
	}

	/**
	 * Returns the address ID of this amf user.
	 *
	 * @return the address ID of this amf user
	 */
	@Override
	public long getAddressId() {
		return model.getAddressId();
	}

	/**
	 * @return
	 */
	@Override
	public AMFEventLog getAMFEventLog() {
		return model.getAMFEventLog();
	}

	/**
	 * This method return a list of AMFEventLog which retrieve all the AMFEventLog which contain the AMFUserID
	 *
	 * @return
	 */
	@Override
	public java.util.List<AMFEventLog> getAMFEventLogs() {
		return model.getAMFEventLogs();
	}

	/**
	 * Returns the amf user ID of this amf user.
	 *
	 * @return the amf user ID of this amf user
	 */
	@Override
	public long getAmfUserId() {
		return model.getAmfUserId();
	}

	/**
	 * Returns the amf user uuid of this amf user.
	 *
	 * @return the amf user uuid of this amf user
	 */
	@Override
	public String getAmfUserUuid() {
		return model.getAmfUserUuid();
	}

	/**
	 * @return String value of screen-name and user-ID in one String formatted value
	 * @throws com.liferay.portal.kernel.exception.PortalException
	 */
	@Override
	public String getCombinedUserInfo() {
		return model.getCombinedUserInfo();
	}

	/**
	 * Returns the company ID of this amf user.
	 *
	 * @return the company ID of this amf user
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this amf user.
	 *
	 * @return the create date of this amf user
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * @return
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * @return
	 */
	@Override
	public String getEventStatus() {
		return model.getEventStatus();
	}

	/**
	 * Returns the group ID of this amf user.
	 *
	 * @return the group ID of this amf user
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the home phone of this amf user.
	 *
	 * @return the home phone of this amf user
	 */
	@Override
	public String getHomePhone() {
		return model.getHomePhone();
	}

	@Override
	public String getLastLoginDate() {
		return model.getLastLoginDate();
	}

	/**
	 * @return
	 * @throws com.liferay.portal.kernel.exception.PortalException
	 */
	@Override
	public String getLastLoginIP() {
		return model.getLastLoginIP();
	}

	/**
	 * Returns the mobile phone of this amf user.
	 *
	 * @return the mobile phone of this amf user
	 */
	@Override
	public String getMobilePhone() {
		return model.getMobilePhone();
	}

	/**
	 * Returns the modified date of this amf user.
	 *
	 * @return the modified date of this amf user
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this amf user.
	 *
	 * @return the primary key of this amf user
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this amf user.
	 *
	 * @return the user ID of this amf user
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this amf user.
	 *
	 * @return the user name of this amf user
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this amf user.
	 *
	 * @return the user uuid of this amf user
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this amf user.
	 *
	 * @return the uuid of this amf user
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
	 * Sets the address ID of this amf user.
	 *
	 * @param addressId the address ID of this amf user
	 */
	@Override
	public void setAddressId(long addressId) {
		model.setAddressId(addressId);
	}

	/**
	 * Sets the amf user ID of this amf user.
	 *
	 * @param amfUserId the amf user ID of this amf user
	 */
	@Override
	public void setAmfUserId(long amfUserId) {
		model.setAmfUserId(amfUserId);
	}

	/**
	 * Sets the amf user uuid of this amf user.
	 *
	 * @param amfUserUuid the amf user uuid of this amf user
	 */
	@Override
	public void setAmfUserUuid(String amfUserUuid) {
		model.setAmfUserUuid(amfUserUuid);
	}

	/**
	 * Sets the company ID of this amf user.
	 *
	 * @param companyId the company ID of this amf user
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this amf user.
	 *
	 * @param createDate the create date of this amf user
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this amf user.
	 *
	 * @param groupId the group ID of this amf user
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the home phone of this amf user.
	 *
	 * @param homePhone the home phone of this amf user
	 */
	@Override
	public void setHomePhone(String homePhone) {
		model.setHomePhone(homePhone);
	}

	/**
	 * Sets the mobile phone of this amf user.
	 *
	 * @param mobilePhone the mobile phone of this amf user
	 */
	@Override
	public void setMobilePhone(String mobilePhone) {
		model.setMobilePhone(mobilePhone);
	}

	/**
	 * Sets the modified date of this amf user.
	 *
	 * @param modifiedDate the modified date of this amf user
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this amf user.
	 *
	 * @param primaryKey the primary key of this amf user
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this amf user.
	 *
	 * @param userId the user ID of this amf user
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this amf user.
	 *
	 * @param userName the user name of this amf user
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this amf user.
	 *
	 * @param userUuid the user uuid of this amf user
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this amf user.
	 *
	 * @param uuid the uuid of this amf user
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
	protected AMFUserWrapper wrap(AMFUser amfUser) {
		return new AMFUserWrapper(amfUser);
	}

}