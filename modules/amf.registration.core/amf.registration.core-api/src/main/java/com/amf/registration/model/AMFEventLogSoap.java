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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AMFEventLogSoap implements Serializable {

	public static AMFEventLogSoap toSoapModel(AMFEventLog model) {
		AMFEventLogSoap soapModel = new AMFEventLogSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAmfEventLogId(model.getAmfEventLogId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setLastLoginDate(model.getLastLoginDate());
		soapModel.setLastLoginIP(model.getLastLoginIP());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static AMFEventLogSoap[] toSoapModels(AMFEventLog[] models) {
		AMFEventLogSoap[] soapModels = new AMFEventLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AMFEventLogSoap[][] toSoapModels(AMFEventLog[][] models) {
		AMFEventLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AMFEventLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AMFEventLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AMFEventLogSoap[] toSoapModels(List<AMFEventLog> models) {
		List<AMFEventLogSoap> soapModels = new ArrayList<AMFEventLogSoap>(
			models.size());

		for (AMFEventLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AMFEventLogSoap[soapModels.size()]);
	}

	public AMFEventLogSoap() {
	}

	public long getPrimaryKey() {
		return _amfEventLogId;
	}

	public void setPrimaryKey(long pk) {
		setAmfEventLogId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAmfEventLogId() {
		return _amfEventLogId;
	}

	public void setAmfEventLogId(long amfEventLogId) {
		_amfEventLogId = amfEventLogId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getLastLoginDate() {
		return _lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		_lastLoginDate = lastLoginDate;
	}

	public String getLastLoginIP() {
		return _lastLoginIP;
	}

	public void setLastLoginIP(String lastLoginIP) {
		_lastLoginIP = lastLoginIP;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private String _uuid;
	private long _amfEventLogId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _groupId;
	private long _userId;
	private Date _lastLoginDate;
	private String _lastLoginIP;
	private String _status;

}