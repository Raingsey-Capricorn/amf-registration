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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AMFIssue service. Represents a row in the &quot;amf_issue&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AMFIssueModel
 * @generated
 */
@ImplementationClassName("com.amf.newsletter.model.impl.AMFIssueImpl")
@ProviderType
public interface AMFIssue extends AMFIssueModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.amf.newsletter.model.impl.AMFIssueImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AMFIssue, Long> AMF_ISSUE_ID_ACCESSOR =
		new Accessor<AMFIssue, Long>() {

			@Override
			public Long get(AMFIssue amfIssue) {
				return amfIssue.getAmfIssueId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AMFIssue> getTypeClass() {
				return AMFIssue.class;
			}

		};

	/**
	 * @return
	 */
	public java.util.List<AMFArticle> getAMFArticles();

	/**
	 * @return
	 */
	public String getFormattedIssueDateTitle();

	/**
	 * @return
	 */
	public String getIssueDateFormatAsMonth();

}