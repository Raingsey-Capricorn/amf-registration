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
 * This class is used by SOAP remote services, specifically {@link com.amf.registration.service.http.AMFUserServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AMFUserSoap implements Serializable {

	public static AMFUserSoap toSoapModel(AMFUser model) {
		AMFUserSoap soapModel = new AMFUserSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAmfUserId(model.getAmfUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserName(model.getUserName());
		soapModel.setUserId(model.getUserId());
		soapModel.setAddressId(model.getAddressId());
		soapModel.setHomePhone(model.getHomePhone());
		soapModel.setMobilePhone(model.getMobilePhone());

		return soapModel;
	}

	public static AMFUserSoap[] toSoapModels(AMFUser[] models) {
		AMFUserSoap[] soapModels = new AMFUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AMFUserSoap[][] toSoapModels(AMFUser[][] models) {
		AMFUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AMFUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AMFUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AMFUserSoap[] toSoapModels(List<AMFUser> models) {
		List<AMFUserSoap> soapModels = new ArrayList<AMFUserSoap>(
			models.size());

		for (AMFUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AMFUserSoap[soapModels.size()]);
	}

	public AMFUserSoap() {
	}

	public long getPrimaryKey() {
		return _amfUserId;
	}

	public void setPrimaryKey(long pk) {
		setAmfUserId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAmfUserId() {
		return _amfUserId;
	}

	public void setAmfUserId(long amfUserId) {
		_amfUserId = amfUserId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
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

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getAddressId() {
		return _addressId;
	}

	public void setAddressId(long addressId) {
		_addressId = addressId;
	}

	public String getHomePhone() {
		return _homePhone;
	}

	public void setHomePhone(String homePhone) {
		_homePhone = homePhone;
	}

	public String getMobilePhone() {
		return _mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		_mobilePhone = mobilePhone;
	}

	private String _uuid;
	private long _amfUserId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _userName;
	private long _userId;
	private long _addressId;
	private String _homePhone;
	private String _mobilePhone;

}