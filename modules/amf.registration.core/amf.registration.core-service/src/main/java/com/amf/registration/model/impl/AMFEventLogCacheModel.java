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

import com.amf.registration.model.AMFEventLog;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AMFEventLog in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AMFEventLogCacheModel
	implements CacheModel<AMFEventLog>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AMFEventLogCacheModel)) {
			return false;
		}

		AMFEventLogCacheModel amfEventLogCacheModel =
			(AMFEventLogCacheModel)object;

		if (amfEventLogId == amfEventLogCacheModel.amfEventLogId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, amfEventLogId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", amfEventLogId=");
		sb.append(amfEventLogId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", lastLoginDate=");
		sb.append(lastLoginDate);
		sb.append(", lastLoginIP=");
		sb.append(lastLoginIP);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AMFEventLog toEntityModel() {
		AMFEventLogImpl amfEventLogImpl = new AMFEventLogImpl();

		if (uuid == null) {
			amfEventLogImpl.setUuid("");
		}
		else {
			amfEventLogImpl.setUuid(uuid);
		}

		amfEventLogImpl.setAmfEventLogId(amfEventLogId);
		amfEventLogImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			amfEventLogImpl.setCreateDate(null);
		}
		else {
			amfEventLogImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			amfEventLogImpl.setModifiedDate(null);
		}
		else {
			amfEventLogImpl.setModifiedDate(new Date(modifiedDate));
		}

		amfEventLogImpl.setGroupId(groupId);
		amfEventLogImpl.setUserId(userId);

		if (lastLoginDate == Long.MIN_VALUE) {
			amfEventLogImpl.setLastLoginDate(null);
		}
		else {
			amfEventLogImpl.setLastLoginDate(new Date(lastLoginDate));
		}

		if (lastLoginIP == null) {
			amfEventLogImpl.setLastLoginIP("");
		}
		else {
			amfEventLogImpl.setLastLoginIP(lastLoginIP);
		}

		if (status == null) {
			amfEventLogImpl.setStatus("");
		}
		else {
			amfEventLogImpl.setStatus(status);
		}

		amfEventLogImpl.resetOriginalValues();

		return amfEventLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		amfEventLogId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		lastLoginDate = objectInput.readLong();
		lastLoginIP = objectInput.readUTF();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(amfEventLogId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(lastLoginDate);

		if (lastLoginIP == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastLoginIP);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public String uuid;
	public long amfEventLogId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long groupId;
	public long userId;
	public long lastLoginDate;
	public String lastLoginIP;
	public String status;

}