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

package com.amf.newsletter.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.amf.newsletter.service.http.AMFArticleServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AMFArticleSoap implements Serializable {

	public static AMFArticleSoap toSoapModel(AMFArticle model) {
		AMFArticleSoap soapModel = new AMFArticleSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAmfArticleId(model.getAmfArticleId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setIssueNumber(model.getIssueNumber());
		soapModel.setTitle(model.getTitle());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setOrder(model.getOrder());
		soapModel.setContent(model.getContent());

		return soapModel;
	}

	public static AMFArticleSoap[] toSoapModels(AMFArticle[] models) {
		AMFArticleSoap[] soapModels = new AMFArticleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AMFArticleSoap[][] toSoapModels(AMFArticle[][] models) {
		AMFArticleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AMFArticleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AMFArticleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AMFArticleSoap[] toSoapModels(List<AMFArticle> models) {
		List<AMFArticleSoap> soapModels = new ArrayList<AMFArticleSoap>(
			models.size());

		for (AMFArticle model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AMFArticleSoap[soapModels.size()]);
	}

	public AMFArticleSoap() {
	}

	public long getPrimaryKey() {
		return _amfArticleId;
	}

	public void setPrimaryKey(long pk) {
		setAmfArticleId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAmfArticleId() {
		return _amfArticleId;
	}

	public void setAmfArticleId(long amfArticleId) {
		_amfArticleId = amfArticleId;
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

	public int getIssueNumber() {
		return _issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		_issueNumber = issueNumber;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	private String _uuid;
	private long _amfArticleId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _issueNumber;
	private String _title;
	private String _author;
	private int _order;
	private String _content;

}