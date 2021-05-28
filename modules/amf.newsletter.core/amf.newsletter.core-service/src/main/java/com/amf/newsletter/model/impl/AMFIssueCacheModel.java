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

package com.amf.newsletter.model.impl;

import com.amf.newsletter.model.AMFIssue;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AMFIssue in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AMFIssueCacheModel
	implements CacheModel<AMFIssue>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AMFIssueCacheModel)) {
			return false;
		}

		AMFIssueCacheModel amfIssueCacheModel = (AMFIssueCacheModel)object;

		if (amfIssueId == amfIssueCacheModel.amfIssueId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, amfIssueId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", amfIssueId=");
		sb.append(amfIssueId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userGroupId=");
		sb.append(userGroupId);
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
		sb.append(", issuedDate=");
		sb.append(issuedDate);
		sb.append(", issueNumber=");
		sb.append(issueNumber);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AMFIssue toEntityModel() {
		AMFIssueImpl amfIssueImpl = new AMFIssueImpl();

		if (uuid == null) {
			amfIssueImpl.setUuid("");
		}
		else {
			amfIssueImpl.setUuid(uuid);
		}

		amfIssueImpl.setAmfIssueId(amfIssueId);
		amfIssueImpl.setGroupId(groupId);
		amfIssueImpl.setUserGroupId(userGroupId);
		amfIssueImpl.setCompanyId(companyId);
		amfIssueImpl.setUserId(userId);

		if (userName == null) {
			amfIssueImpl.setUserName("");
		}
		else {
			amfIssueImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			amfIssueImpl.setCreateDate(null);
		}
		else {
			amfIssueImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			amfIssueImpl.setModifiedDate(null);
		}
		else {
			amfIssueImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (issuedDate == Long.MIN_VALUE) {
			amfIssueImpl.setIssuedDate(null);
		}
		else {
			amfIssueImpl.setIssuedDate(new Date(issuedDate));
		}

		amfIssueImpl.setIssueNumber(issueNumber);

		if (title == null) {
			amfIssueImpl.setTitle("");
		}
		else {
			amfIssueImpl.setTitle(title);
		}

		if (description == null) {
			amfIssueImpl.setDescription("");
		}
		else {
			amfIssueImpl.setDescription(description);
		}

		amfIssueImpl.resetOriginalValues();

		return amfIssueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		amfIssueId = objectInput.readLong();

		groupId = objectInput.readLong();

		userGroupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		issuedDate = objectInput.readLong();

		issueNumber = objectInput.readInt();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(amfIssueId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userGroupId);

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
		objectOutput.writeLong(issuedDate);

		objectOutput.writeInt(issueNumber);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public String uuid;
	public long amfIssueId;
	public long groupId;
	public long userGroupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long issuedDate;
	public int issueNumber;
	public String title;
	public String description;

}