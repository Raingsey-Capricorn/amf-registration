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
		StringBundler sb = new StringBundler(33);

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
		sb.append(", userCreatorID=");
		sb.append(userCreatorID);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", homePhone=");
		sb.append(homePhone);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", addressID=");
		sb.append(addressID);
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

		amfUserImpl.setUserCreatorID(userCreatorID);

		if (gender == null) {
			amfUserImpl.setGender("");
		}
		else {
			amfUserImpl.setGender(gender);
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

		amfUserImpl.setAddressID(addressID);

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

		userCreatorID = objectInput.readLong();
		gender = objectInput.readUTF();
		homePhone = objectInput.readUTF();
		mobilePhone = objectInput.readUTF();

		addressID = objectInput.readLong();
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

		objectOutput.writeLong(userCreatorID);

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
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

		objectOutput.writeLong(addressID);

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
	public long userCreatorID;
	public String gender;
	public String homePhone;
	public String mobilePhone;
	public long addressID;
	public String securityQuestion;
	public String securityAnswer;
	public String acceptedTOU;

}