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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.amf.newsletter.service.http.AMFIssueServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AMFIssueSoap implements Serializable {

	public static AMFIssueSoap toSoapModel(AMFIssue model) {
		AMFIssueSoap soapModel = new AMFIssueSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAmfissueId(model.getAmfissueId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserGroupId(model.getUserGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setIssuedDate(model.getIssuedDate());
		soapModel.setIssueNumber(model.getIssueNumber());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static AMFIssueSoap[] toSoapModels(AMFIssue[] models) {
		AMFIssueSoap[] soapModels = new AMFIssueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AMFIssueSoap[][] toSoapModels(AMFIssue[][] models) {
		AMFIssueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AMFIssueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AMFIssueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AMFIssueSoap[] toSoapModels(List<AMFIssue> models) {
		List<AMFIssueSoap> soapModels = new ArrayList<AMFIssueSoap>(
			models.size());

		for (AMFIssue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AMFIssueSoap[soapModels.size()]);
	}

	public AMFIssueSoap() {
	}

	public long getPrimaryKey() {
		return _amfissueId;
	}

	public void setPrimaryKey(long pk) {
		setAmfissueId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAmfissueId() {
		return _amfissueId;
	}

	public void setAmfissueId(long amfissueId) {
		_amfissueId = amfissueId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserGroupId() {
		return _userGroupId;
	}

	public void setUserGroupId(long userGroupId) {
		_userGroupId = userGroupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getIssuedDate() {
		return _issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		_issuedDate = issuedDate;
	}

	public int getIssueNumber() {
		return _issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		_issueNumber = issueNumber;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private String _uuid;
	private long _amfissueId;
	private long _groupId;
	private long _userGroupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _issuedDate;
	private int _issueNumber;
	private String _title;
	private String _description;

}