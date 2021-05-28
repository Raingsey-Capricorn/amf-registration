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

package com.amf.newsletter.service.impl;

import com.amf.newsletter.model.AMFArticle;
import com.amf.newsletter.model.AMFIssue;
import com.amf.newsletter.service.AMFArticleLocalServiceUtil;
import com.amf.newsletter.service.AMFIssueLocalServiceUtil;
import com.amf.newsletter.service.base.AMFArticleLocalServiceBaseImpl;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;

import lombok.SneakyThrows;
import org.osgi.service.component.annotations.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * The implementation of the amf article local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.amf.newsletter.service.AMFArticleLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFArticleLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=com.amf.newsletter.model.AMFArticle",
        service = AopService.class
)
public class AMFArticleLocalServiceImpl extends AMFArticleLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Use <code>com.amf.newsletter.service.AMFArticleLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.amf.newsletter.service.AMFArticleLocalServiceUtil</code>.
     */
}