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
import com.amf.newsletter.service.base.AMFIssueLocalServiceBaseImpl;
import com.amf.newsletter.service.persistence.AMFIssueUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import lombok.SneakyThrows;
import org.osgi.service.component.annotations.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/**
 * The implementation of the amf issue local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.amf.newsletter.service.AMFIssueLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFIssueLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=com.amf.newsletter.model.AMFIssue",
        service = AopService.class
)
public class AMFIssueLocalServiceImpl extends AMFIssueLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Use <code>com.amf.newsletter.service.AMFIssueLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.amf.newsletter.service.AMFIssueLocalServiceUtil</code>.
     */

    /**
     * @param issueDate
     * @return
     */
    public List<AMFIssue> findByAMFIssueDate(Date issueDate) {
        return AMFIssueUtil.findByAMFIssueDate(issueDate);
    }

    /**
     * @param date
     * @return
     */
    @SneakyThrows
    public List<AMFIssue> getAMFIssuesWithinMonth(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date firstDateOfMonth = new SimpleDateFormat("yyyy-MM-dd").parse(localDate.with(TemporalAdjusters.firstDayOfMonth()).toString());
        Date lastDateOfMonth = new SimpleDateFormat("yyyy-MM-dd").parse(localDate.with(TemporalAdjusters.lastDayOfMonth()).toString());

        return amfIssueLocalService.dynamicQuery(amfIssueLocalService.dynamicQuery()
                .add(RestrictionsFactoryUtil.between("issueDate", firstDateOfMonth, lastDateOfMonth))
        );
    }

    /**
     * @param date
     * @return
     */
    @SneakyThrows
    public List<AMFIssue> getAMFIssuesWithinYear(Date date) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date firstDateOfYear = new SimpleDateFormat("yyyy-MM-dd").parse(localDate.with(TemporalAdjusters.firstDayOfYear()).toString());
        Date lastDateOfYear = new SimpleDateFormat("yyyy-MM-dd").parse(localDate.with(TemporalAdjusters.lastDayOfYear()).toString());

        return amfIssueLocalService.dynamicQuery(amfIssueLocalService.dynamicQuery()
                .add(RestrictionsFactoryUtil.between("issueDate", firstDateOfYear, lastDateOfYear))
                .addOrder(OrderFactoryUtil.desc("issueDate"))
        );
    }

    /**
     * @param date
     * @param issueNumber
     * @return
     */
    @SneakyThrows
    public List<AMFIssue> getAMFIssuesWithinMonth(Date date, int issueNumber) {
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date firstDateOfMonth = new SimpleDateFormat("yyyy-MM-dd").parse(localDate.with(TemporalAdjusters.firstDayOfMonth()).toString());
        Date lastDateOfMonth = new SimpleDateFormat("yyyy-MM-dd").parse(localDate.with(TemporalAdjusters.lastDayOfMonth()).toString());

        return amfIssueLocalService.dynamicQuery(amfIssueLocalService.dynamicQuery()
                .add(RestrictionsFactoryUtil.le("issueNumber", issueNumber))
                .add(RestrictionsFactoryUtil.between("issueDate", firstDateOfMonth, lastDateOfMonth))
        );
    }
}