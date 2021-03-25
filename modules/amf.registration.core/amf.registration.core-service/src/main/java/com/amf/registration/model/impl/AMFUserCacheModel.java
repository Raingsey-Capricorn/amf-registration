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

import com.amf.registration.model.AMFUser;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AMFUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AMFUserCacheModel implements CacheModel<AMFUser>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AMFUserCacheModel)) {
			return false;
		}

		AMFUserCacheModel amfUserCacheModel = (AMFUserCacheModel)object;

		if (amfUserId == amfUserCacheModel.amfUserId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, amfUserId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(55);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", amfUserId=");
		sb.append(amfUserId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", birthDay=");
		sb.append(birthDay);
		sb.append(", birthMonth=");
		sb.append(birthMonth);
		sb.append(", birthYear=");
		sb.append(birthYear);
		sb.append(", password=");
		sb.append(password);
		sb.append(", confirmedPassword=");
		sb.append(confirmedPassword);
		sb.append(", homePhone=");
		sb.append(homePhone);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", address=");
		sb.append(address);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", zip=");
		sb.append(zip);
		sb.append(", securityQuestion=");
		sb.append(securityQuestion);
		sb.append(", securityAnswer=");
		sb.append(securityAnswer);
		sb.append(", acceptedTOU=");
		sb.append(acceptedTOU);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AMFUser toEntityModel() {
		AMFUserImpl amfUserImpl = new AMFUserImpl();

		if (uuid == null) {
			amfUserImpl.setUuid("");
		}
		else {
			amfUserImpl.setUuid(uuid);
		}

		amfUserImpl.setAmfUserId(amfUserId);
		amfUserImpl.setGroupId(groupId);
		amfUserImpl.setCompanyId(companyId);
		amfUserImpl.setUserId(userId);

		if (userName == null) {
			amfUserImpl.setUserName("");
		}
		else {
			amfUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			amfUserImpl.setCreateDate(null);
		}
		else {
			amfUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			amfUserImpl.setModifiedDate(null);
		}
		else {
			amfUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			amfUserImpl.setFirstName("");
		}
		else {
			amfUserImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			amfUserImpl.setLastName("");
		}
		else {
			amfUserImpl.setLastName(lastName);
		}

		if (emailAddress == null) {
			amfUserImpl.setEmailAddress("");
		}
		else {
			amfUserImpl.setEmailAddress(emailAddress);
		}

		if (gender == null) {
			amfUserImpl.setGender("");
		}
		else {
			amfUserImpl.setGender(gender);
		}

		amfUserImpl.setBirthDay(birthDay);
		amfUserImpl.setBirthMonth(birthMonth);
		amfUserImpl.setBirthYear(birthYear);

		if (password == null) {
			amfUserImpl.setPassword("");
		}
		else {
			amfUserImpl.setPassword(password);
		}

		if (confirmedPassword == null) {
			amfUserImpl.setConfirmedPassword("");
		}
		else {
			amfUserImpl.setConfirmedPassword(confirmedPassword);
		}

		if (homePhone == null) {
			amfUserImpl.setHomePhone("");
		}
		else {
			amfUserImpl.setHomePhone(homePhone);
		}

		if (mobilePhone == null) {
			amfUserImpl.setMobilePhone("");
		}
		else {
			amfUserImpl.setMobilePhone(mobilePhone);
		}

		if (address == null) {
			amfUserImpl.setAddress("");
		}
		else {
			amfUserImpl.setAddress(address);
		}

		if (address2 == null) {
			amfUserImpl.setAddress2("");
		}
		else {
			amfUserImpl.setAddress2(address2);
		}

		if (city == null) {
			amfUserImpl.setCity("");
		}
		else {
			amfUserImpl.setCity(city);
		}

		if (state == null) {
			amfUserImpl.setState("");
		}
		else {
			amfUserImpl.setState(state);
		}

		if (zip == null) {
			amfUserImpl.setZip("");
		}
		else {
			amfUserImpl.setZip(zip);
		}

		if (securityQuestion == null) {
			amfUserImpl.setSecurityQuestion("");
		}
		else {
			amfUserImpl.setSecurityQuestion(securityQuestion);
		}

		if (securityAnswer == null) {
			amfUserImpl.setSecurityAnswer("");
		}
		else {
			amfUserImpl.setSecurityAnswer(securityAnswer);
		}

		if (acceptedTOU == null) {
			amfUserImpl.setAcceptedTOU("");
		}
		else {
			amfUserImpl.setAcceptedTOU(acceptedTOU);
		}

		amfUserImpl.resetOriginalValues();

		return amfUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		amfUserId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		gender = objectInput.readUTF();

		birthDay = objectInput.readInt();

		birthMonth = objectInput.readInt();

		birthYear = objectInput.readInt();
		password = objectInput.readUTF();
		confirmedPassword = objectInput.readUTF();
		homePhone = objectInput.readUTF();
		mobilePhone = objectInput.readUTF();
		address = objectInput.readUTF();
		address2 = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		zip = objectInput.readUTF();
		securityQuestion = objectInput.readUTF();
		securityAnswer = objectInput.readUTF();
		acceptedTOU = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(amfUserId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		objectOutput.writeInt(birthDay);

		objectOutput.writeInt(birthMonth);

		objectOutput.writeInt(birthYear);

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (confirmedPassword == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(confirmedPassword);
		}

		if (homePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(homePhone);
		}

		if (mobilePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobilePhone);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (address2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address2);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (zip == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zip);
		}

		if (securityQuestion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(securityQuestion);
		}

		if (securityAnswer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(securityAnswer);
		}

		if (acceptedTOU == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(acceptedTOU);
		}
	}

	public String uuid;
	public long amfUserId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public String emailAddress;
	public String gender;
	public int birthDay;
	public int birthMonth;
	public int birthYear;
	public String password;
	public String confirmedPassword;
	public String homePhone;
	public String mobilePhone;
	public String address;
	public String address2;
	public String city;
	public String state;
	public String zip;
	public String securityQuestion;
	public String securityAnswer;
	public String acceptedTOU;

}