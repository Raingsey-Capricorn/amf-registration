/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.amf.newsletter.model.impl;

import com.amf.newsletter.model.AMFArticle;
import com.amf.newsletter.service.AMFArticleLocalServiceUtil;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * The extended model implementation for the AMFIssue service. Represents a row in the &quot;amf_issue&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.amf.newsletter.model.AMFIssue</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class AMFIssueImpl extends AMFIssueBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a amf issue model instance should use the {@link com.amf.newsletter.model.AMFIssue} interface instead.
     */
    public AMFIssueImpl() {
    }

    /**
     * @return
     */
    @Override
    public List<AMFArticle> getAMFArticles() {
        return AMFArticleLocalServiceUtil.getAMFIssueAMFArticles(getAmfIssueId());
    }

    /**
     * @return
     */
    @Override
    public String getFormattedIssueDateTitle() {
        return String.format("%d, %s", getIssueNumber(), new SimpleDateFormat("MMM dd, yyyy").format(getIssuedDate()));
    }

    /**
     * @return
     */
    @Override
    public String getIssueDateFormatAsMonth() {
        return new SimpleDateFormat("MMMM").format(getIssuedDate());
    }
}