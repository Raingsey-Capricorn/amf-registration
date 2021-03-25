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
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setGender(model.getGender());
		soapModel.setBirthDay(model.getBirthDay());
		soapModel.setBirthMonth(model.getBirthMonth());
		soapModel.setBirthYear(model.getBirthYear());
		soapModel.setPassword(model.getPassword());
		soapModel.setConfirmedPassword(model.getConfirmedPassword());
		soapModel.setHomePhone(model.getHomePhone());
		soapModel.setMobilePhone(model.getMobilePhone());
		soapModel.setAddress(model.getAddress());
		soapModel.setAddress2(model.getAddress2());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setZip(model.getZip());
		soapModel.setSecurityQuestion(model.getSecurityQuestion());
		soapModel.setSecurityAnswer(model.getSecurityAnswer());
		soapModel.setAcceptedTOU(model.getAcceptedTOU());

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

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public int getBirthDay() {
		return _birthDay;
	}

	public void setBirthDay(int birthDay) {
		_birthDay = birthDay;
	}

	public int getBirthMonth() {
		return _birthMonth;
	}

	public void setBirthMonth(int birthMonth) {
		_birthMonth = birthMonth;
	}

	public int getBirthYear() {
		return _birthYear;
	}

	public void setBirthYear(int birthYear) {
		_birthYear = birthYear;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public String getConfirmedPassword() {
		return _confirmedPassword;
	}

	public void setConfirmedPassword(String confirmedPassword) {
		_confirmedPassword = confirmedPassword;
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

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getAddress2() {
		return _address2;
	}

	public void setAddress2(String address2) {
		_address2 = address2;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getZip() {
		return _zip;
	}

	public void setZip(String zip) {
		_zip = zip;
	}

	public String getSecurityQuestion() {
		return _securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		_securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return _securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		_securityAnswer = securityAnswer;
	}

	public String getAcceptedTOU() {
		return _acceptedTOU;
	}

	public void setAcceptedTOU(String acceptedTOU) {
		_acceptedTOU = acceptedTOU;
	}

	private String _uuid;
	private long _amfUserId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _firstName;
	private String _lastName;
	private String _emailAddress;
	private String _gender;
	private int _birthDay;
	private int _birthMonth;
	private int _birthYear;
	private String _password;
	private String _confirmedPassword;
	private String _homePhone;
	private String _mobilePhone;
	private String _address;
	private String _address2;
	private String _city;
	private String _state;
	private String _zip;
	private String _securityQuestion;
	private String _securityAnswer;
	private String _acceptedTOU;

}