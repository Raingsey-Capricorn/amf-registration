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
 * The table class for the &quot;amf_article&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AMFArticle
 * @generated
 */
public class AMFArticleTable extends BaseTable<AMFArticleTable> {

	public static final AMFArticleTable INSTANCE = new AMFArticleTable();

	public final Column<AMFArticleTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AMFArticleTable, Long> amfArticleId = createColumn(
		"amfArticleId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AMFArticleTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AMFArticleTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AMFArticleTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AMFArticleTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AMFArticleTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AMFArticleTable, Integer> issueNumber = createColumn(
		"issueNumber", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AMFArticleTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AMFArticleTable, String> author = createColumn(
		"author", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AMFArticleTable, Integer> order = createColumn(
		"order_", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AMFArticleTable, String> content = createColumn(
		"content", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AMFArticleTable, Long> journalId = createColumn(
		"journalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private AMFArticleTable() {
		super("amf_article", AMFArticleTable::new);
	}

}