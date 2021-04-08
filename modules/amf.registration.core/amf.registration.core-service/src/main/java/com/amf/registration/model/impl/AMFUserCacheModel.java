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
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", amfUserId=");
		sb.append(amfUserId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", contractId=");
		sb.append(contractId);
		sb.append(", addressId=");
		sb.append(addressId);
		sb.append(", homePhone=");
		sb.append(homePhone);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", eventLog=");
		sb.append(eventLog);
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

		if (userName == null) {
			amfUserImpl.setUserName("");
		}
		else {
			amfUserImpl.setUserName(userName);
		}

		amfUserImpl.setUserId(userId);
		amfUserImpl.setContractId(contractId);
		amfUserImpl.setAddressId(addressId);

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

		amfUserImpl.setEventLog(eventLog);

		amfUserImpl.resetOriginalValues();

		return amfUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		amfUserId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userName = objectInput.readUTF();

		userId = objectInput.readLong();

		contractId = objectInput.readLong();

		addressId = objectInput.readLong();
		homePhone = objectInput.readUTF();
		mobilePhone = objectInput.readUTF();

		eventLog = objectInput.readLong();
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
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(userId);

		objectOutput.writeLong(contractId);

		objectOutput.writeLong(addressId);

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

		objectOutput.writeLong(eventLog);
	}

	public String uuid;
	public long amfUserId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String userName;
	public long userId;
	public long contractId;
	public long addressId;
	public String homePhone;
	public String mobilePhone;
	public long eventLog;

}