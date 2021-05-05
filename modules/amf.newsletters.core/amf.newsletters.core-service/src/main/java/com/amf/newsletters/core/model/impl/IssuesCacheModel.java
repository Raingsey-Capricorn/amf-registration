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

package com.amf.newsletters.core.model.impl;

import com.amf.newsletters.core.model.Issues;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Issues in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class IssuesCacheModel implements CacheModel<Issues>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof IssuesCacheModel)) {
			return false;
		}

		IssuesCacheModel issuesCacheModel = (IssuesCacheModel)object;

		if (issueId == issuesCacheModel.issueId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, issueId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", issueId=");
		sb.append(issueId);
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
	public Issues toEntityModel() {
		IssuesImpl issuesImpl = new IssuesImpl();

		if (uuid == null) {
			issuesImpl.setUuid("");
		}
		else {
			issuesImpl.setUuid(uuid);
		}

		issuesImpl.setIssueId(issueId);
		issuesImpl.setGroupId(groupId);
		issuesImpl.setUserGroupId(userGroupId);
		issuesImpl.setCompanyId(companyId);
		issuesImpl.setUserId(userId);

		if (userName == null) {
			issuesImpl.setUserName("");
		}
		else {
			issuesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			issuesImpl.setCreateDate(null);
		}
		else {
			issuesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			issuesImpl.setModifiedDate(null);
		}
		else {
			issuesImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (issuedDate == Long.MIN_VALUE) {
			issuesImpl.setIssuedDate(null);
		}
		else {
			issuesImpl.setIssuedDate(new Date(issuedDate));
		}

		issuesImpl.setIssueNumber(issueNumber);

		if (title == null) {
			issuesImpl.setTitle("");
		}
		else {
			issuesImpl.setTitle(title);
		}

		if (description == null) {
			issuesImpl.setDescription("");
		}
		else {
			issuesImpl.setDescription(description);
		}

		issuesImpl.resetOriginalValues();

		return issuesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		issueId = objectInput.readLong();

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

		objectOutput.writeLong(issueId);

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
	public long issueId;
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