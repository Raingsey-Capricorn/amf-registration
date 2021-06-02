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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AMFArticle}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFArticle
 * @generated
 */
public class AMFArticleWrapper
	extends BaseModelWrapper<AMFArticle>
	implements AMFArticle, ModelWrapper<AMFArticle> {

	public AMFArticleWrapper(AMFArticle amfArticle) {
		super(amfArticle);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("amfArticleId", getAmfArticleId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("issueNumber", getIssueNumber());
		attributes.put("title", getTitle());
		attributes.put("author", getAuthor());
		attributes.put("order", getOrder());
		attributes.put("content", getContent());
		attributes.put("journalId", getJournalId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long amfArticleId = (Long)attributes.get("amfArticleId");

		if (amfArticleId != null) {
			setAmfArticleId(amfArticleId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer issueNumber = (Integer)attributes.get("issueNumber");

		if (issueNumber != null) {
			setIssueNumber(issueNumber);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long journalId = (Long)attributes.get("journalId");

		if (journalId != null) {
			setJournalId(journalId);
		}
	}

	/**
	 * Returns the amf article ID of this amf article.
	 *
	 * @return the amf article ID of this amf article
	 */
	@Override
	public long getAmfArticleId() {
		return model.getAmfArticleId();
	}

	/**
	 * Returns the author of this amf article.
	 *
	 * @return the author of this amf article
	 */
	@Override
	public String getAuthor() {
		return model.getAuthor();
	}

	/**
	 * Returns the company ID of this amf article.
	 *
	 * @return the company ID of this amf article
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content of this amf article.
	 *
	 * @return the content of this amf article
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the create date of this amf article.
	 *
	 * @return the create date of this amf article
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the issue number of this amf article.
	 *
	 * @return the issue number of this amf article
	 */
	@Override
	public int getIssueNumber() {
		return model.getIssueNumber();
	}

	/**
	 * Returns the journal ID of this amf article.
	 *
	 * @return the journal ID of this amf article
	 */
	@Override
	public long getJournalId() {
		return model.getJournalId();
	}

	/**
	 * Returns the modified date of this amf article.
	 *
	 * @return the modified date of this amf article
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the order of this amf article.
	 *
	 * @return the order of this amf article
	 */
	@Override
	public int getOrder() {
		return model.getOrder();
	}

	/**
	 * Returns the primary key of this amf article.
	 *
	 * @return the primary key of this amf article
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the title of this amf article.
	 *
	 * @return the title of this amf article
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this amf article.
	 *
	 * @return the user ID of this amf article
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this amf article.
	 *
	 * @return the user name of this amf article
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this amf article.
	 *
	 * @return the user uuid of this amf article
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this amf article.
	 *
	 * @return the uuid of this amf article
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the amf article ID of this amf article.
	 *
	 * @param amfArticleId the amf article ID of this amf article
	 */
	@Override
	public void setAmfArticleId(long amfArticleId) {
		model.setAmfArticleId(amfArticleId);
	}

	/**
	 * Sets the author of this amf article.
	 *
	 * @param author the author of this amf article
	 */
	@Override
	public void setAuthor(String author) {
		model.setAuthor(author);
	}

	/**
	 * Sets the company ID of this amf article.
	 *
	 * @param companyId the company ID of this amf article
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content of this amf article.
	 *
	 * @param content the content of this amf article
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the create date of this amf article.
	 *
	 * @param createDate the create date of this amf article
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the issue number of this amf article.
	 *
	 * @param issueNumber the issue number of this amf article
	 */
	@Override
	public void setIssueNumber(int issueNumber) {
		model.setIssueNumber(issueNumber);
	}

	/**
	 * Sets the journal ID of this amf article.
	 *
	 * @param journalId the journal ID of this amf article
	 */
	@Override
	public void setJournalId(long journalId) {
		model.setJournalId(journalId);
	}

	/**
	 * Sets the modified date of this amf article.
	 *
	 * @param modifiedDate the modified date of this amf article
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the order of this amf article.
	 *
	 * @param order the order of this amf article
	 */
	@Override
	public void setOrder(int order) {
		model.setOrder(order);
	}

	/**
	 * Sets the primary key of this amf article.
	 *
	 * @param primaryKey the primary key of this amf article
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the title of this amf article.
	 *
	 * @param title the title of this amf article
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this amf article.
	 *
	 * @param userId the user ID of this amf article
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this amf article.
	 *
	 * @param userName the user name of this amf article
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this amf article.
	 *
	 * @param userUuid the user uuid of this amf article
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this amf article.
	 *
	 * @param uuid the uuid of this amf article
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected AMFArticleWrapper wrap(AMFArticle amfArticle) {
		return new AMFArticleWrapper(amfArticle);
	}

}