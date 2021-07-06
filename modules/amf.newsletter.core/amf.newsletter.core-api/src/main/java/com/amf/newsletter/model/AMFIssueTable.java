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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;amf_issue&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AMFIssue
 * @generated
 */
public class AMFIssueTable extends BaseTable<AMFIssueTable> {

	public static final AMFIssueTable INSTANCE = new AMFIssueTable();

	public final Column<AMFIssueTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AMFIssueTable, Long> amfIssueId = createColumn(
		"amfIssueId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AMFIssueTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AMFIssueTable, Long> userGroupId = createColumn(
		"userGroupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AMFIssueTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AMFIssueTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AMFIssueTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AMFIssueTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AMFIssueTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AMFIssueTable, Date> issueDate = createColumn(
		"issueDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AMFIssueTable, Integer> issueNumber = createColumn(
		"issueNumber", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AMFIssueTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AMFIssueTable, Long> journalId = createColumn(
		"journalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AMFIssueTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AMFIssueTable() {
		super("amf_issue", AMFIssueTable::new);
	}

}