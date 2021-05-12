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

package com.amf.newsletter.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AMFIssue}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFIssue
 * @generated
 */
public class AMFIssueWrapper
	extends BaseModelWrapper<AMFIssue>
	implements AMFIssue, ModelWrapper<AMFIssue> {

	public AMFIssueWrapper(AMFIssue amfIssue) {
		super(amfIssue);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("amfissueId", getAmfissueId());
		attributes.put("groupId", getGroupId());
		attributes.put("userGroupId", getUserGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("issuedDate", getIssuedDate());
		attributes.put("issueNumber", getIssueNumber());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long amfissueId = (Long)attributes.get("amfissueId");

		if (amfissueId != null) {
			setAmfissueId(amfissueId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userGroupId = (Long)attributes.get("userGroupId");

		if (userGroupId != null) {
			setUserGroupId(userGroupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date issuedDate = (Date)attributes.get("issuedDate");

		if (issuedDate != null) {
			setIssuedDate(issuedDate);
		}

		Integer issueNumber = (Integer)attributes.get("issueNumber");

		if (issueNumber != null) {
			setIssueNumber(issueNumber);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the amfissue ID of this amf issue.
	 *
	 * @return the amfissue ID of this amf issue
	 */
	@Override
	public long getAmfissueId() {
		return model.getAmfissueId();
	}

	/**
	 * Returns the company ID of this amf issue.
	 *
	 * @return the company ID of this amf issue
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this amf issue.
	 *
	 * @return the create date of this amf issue
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this amf issue.
	 *
	 * @return the description of this amf issue
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this amf issue.
	 *
	 * @return the group ID of this amf issue
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the issued date of this amf issue.
	 *
	 * @return the issued date of this amf issue
	 */
	@Override
	public Date getIssuedDate() {
		return model.getIssuedDate();
	}

	/**
	 * Returns the issue number of this amf issue.
	 *
	 * @return the issue number of this amf issue
	 */
	@Override
	public int getIssueNumber() {
		return model.getIssueNumber();
	}

	/**
	 * Returns the modified date of this amf issue.
	 *
	 * @return the modified date of this amf issue
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this amf issue.
	 *
	 * @return the primary key of this amf issue
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this amf issue.
	 *
	 * @return the title of this amf issue
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user group ID of this amf issue.
	 *
	 * @return the user group ID of this amf issue
	 */
	@Override
	public long getUserGroupId() {
		return model.getUserGroupId();
	}

	/**
	 * Returns the user ID of this amf issue.
	 *
	 * @return the user ID of this amf issue
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this amf issue.
	 *
	 * @return the user name of this amf issue
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this amf issue.
	 *
	 * @return the user uuid of this amf issue
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this amf issue.
	 *
	 * @return the uuid of this amf issue
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
	 * Sets the amfissue ID of this amf issue.
	 *
	 * @param amfissueId the amfissue ID of this amf issue
	 */
	@Override
	public void setAmfissueId(long amfissueId) {
		model.setAmfissueId(amfissueId);
	}

	/**
	 * Sets the company ID of this amf issue.
	 *
	 * @param companyId the company ID of this amf issue
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this amf issue.
	 *
	 * @param createDate the create date of this amf issue
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this amf issue.
	 *
	 * @param description the description of this amf issue
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this amf issue.
	 *
	 * @param groupId the group ID of this amf issue
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the issued date of this amf issue.
	 *
	 * @param issuedDate the issued date of this amf issue
	 */
	@Override
	public void setIssuedDate(Date issuedDate) {
		model.setIssuedDate(issuedDate);
	}

	/**
	 * Sets the issue number of this amf issue.
	 *
	 * @param issueNumber the issue number of this amf issue
	 */
	@Override
	public void setIssueNumber(int issueNumber) {
		model.setIssueNumber(issueNumber);
	}

	/**
	 * Sets the modified date of this amf issue.
	 *
	 * @param modifiedDate the modified date of this amf issue
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this amf issue.
	 *
	 * @param primaryKey the primary key of this amf issue
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this amf issue.
	 *
	 * @param title the title of this amf issue
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user group ID of this amf issue.
	 *
	 * @param userGroupId the user group ID of this amf issue
	 */
	@Override
	public void setUserGroupId(long userGroupId) {
		model.setUserGroupId(userGroupId);
	}

	/**
	 * Sets the user ID of this amf issue.
	 *
	 * @param userId the user ID of this amf issue
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this amf issue.
	 *
	 * @param userName the user name of this amf issue
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this amf issue.
	 *
	 * @param userUuid the user uuid of this amf issue
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this amf issue.
	 *
	 * @param uuid the uuid of this amf issue
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
	protected AMFIssueWrapper wrap(AMFIssue amfIssue) {
		return new AMFIssueWrapper(amfIssue);
	}

}