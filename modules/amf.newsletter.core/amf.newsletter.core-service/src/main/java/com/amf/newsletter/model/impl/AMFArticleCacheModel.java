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

import com.amf.newsletter.model.AMFArticle;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AMFArticle in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AMFArticleCacheModel
	implements CacheModel<AMFArticle>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AMFArticleCacheModel)) {
			return false;
		}

		AMFArticleCacheModel amfArticleCacheModel =
			(AMFArticleCacheModel)object;

		if (amfarticleId == amfArticleCacheModel.amfarticleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, amfarticleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", amfarticleId=");
		sb.append(amfarticleId);
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
		sb.append(", issueNumber=");
		sb.append(issueNumber);
		sb.append(", title=");
		sb.append(title);
		sb.append(", author=");
		sb.append(author);
		sb.append(", order=");
		sb.append(order);
		sb.append(", content=");
		sb.append(content);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AMFArticle toEntityModel() {
		AMFArticleImpl amfArticleImpl = new AMFArticleImpl();

		if (uuid == null) {
			amfArticleImpl.setUuid("");
		}
		else {
			amfArticleImpl.setUuid(uuid);
		}

		amfArticleImpl.setAmfarticleId(amfarticleId);
		amfArticleImpl.setCompanyId(companyId);
		amfArticleImpl.setUserId(userId);

		if (userName == null) {
			amfArticleImpl.setUserName("");
		}
		else {
			amfArticleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			amfArticleImpl.setCreateDate(null);
		}
		else {
			amfArticleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			amfArticleImpl.setModifiedDate(null);
		}
		else {
			amfArticleImpl.setModifiedDate(new Date(modifiedDate));
		}

		amfArticleImpl.setIssueNumber(issueNumber);

		if (title == null) {
			amfArticleImpl.setTitle("");
		}
		else {
			amfArticleImpl.setTitle(title);
		}

		if (author == null) {
			amfArticleImpl.setAuthor("");
		}
		else {
			amfArticleImpl.setAuthor(author);
		}

		amfArticleImpl.setOrder(order);

		if (content == null) {
			amfArticleImpl.setContent("");
		}
		else {
			amfArticleImpl.setContent(content);
		}

		amfArticleImpl.resetOriginalValues();

		return amfArticleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		amfarticleId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		issueNumber = objectInput.readInt();
		title = objectInput.readUTF();
		author = objectInput.readUTF();

		order = objectInput.readInt();
		content = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(amfarticleId);

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

		objectOutput.writeInt(issueNumber);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (author == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(author);
		}

		objectOutput.writeInt(order);

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}
	}

	public String uuid;
	public long amfarticleId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int issueNumber;
	public String title;
	public String author;
	public int order;
	public String content;

}