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

/**
 * The table class for the &quot;AMFNewsletter_amfissue_article&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AMFArticle
 * @see AMFIssue
 * @generated
 */
public class AMFNewsletter_amfissue_articleTable
	extends BaseTable<AMFNewsletter_amfissue_articleTable> {

	public static final AMFNewsletter_amfissue_articleTable INSTANCE =
		new AMFNewsletter_amfissue_articleTable();

	public final Column<AMFNewsletter_amfissue_articleTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AMFNewsletter_amfissue_articleTable, Long>
		amfArticleId = createColumn(
			"amfArticleId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AMFNewsletter_amfissue_articleTable, Long> amfIssueId =
		createColumn(
			"amfIssueId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private AMFNewsletter_amfissue_articleTable() {
		super(
			"AMFNewsletter_amfissue_article",
			AMFNewsletter_amfissue_articleTable::new);
	}

}