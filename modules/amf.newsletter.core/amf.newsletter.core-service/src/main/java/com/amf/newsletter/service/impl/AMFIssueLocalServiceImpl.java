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

import com.amf.newsletter.exception.NoSuchAMFIssueException;
import com.amf.newsletter.model.AMFArticle;
import com.amf.newsletter.model.AMFIssue;
import com.amf.newsletter.service.AMFArticleLocalServiceUtil;
import com.amf.newsletter.service.AMFIssueLocalService;
import com.amf.newsletter.service.AMFIssueLocalServiceUtil;
import com.amf.newsletter.service.base.AMFIssueLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
    @Override
    public List<AMFIssue> getSampleAMFAmfIssues() {

        AMFArticle articleOne = AMFArticleLocalServiceUtil.createAMFArticle(CounterLocalServiceUtil.increment(AMFArticle.class.getName()));
        articleOne.setIssueNumber(new Random().nextInt(100));
        articleOne.setAuthor("Mc Andre");
        articleOne.setContent("Content-test-one");
        articleOne.setTitle("Example Title");
        articleOne.setNew(true);

        AMFArticle articleTwo = AMFArticleLocalServiceUtil.createAMFArticle(CounterLocalServiceUtil.increment(AMFArticle.class.getName()));
        articleTwo.setIssueNumber(new Random().nextInt(100));
        articleTwo.setAuthor("Mc Andre");
        articleTwo.setContent("Content-test-one");
        articleTwo.setTitle("Example Title");
        articleTwo.setNew(true);

        AMFArticle articleThree = AMFArticleLocalServiceUtil.createAMFArticle(CounterLocalServiceUtil.increment(AMFArticle.class.getName()));
        articleThree.setIssueNumber(new Random().nextInt(100));
        articleThree.setAuthor("Mc Andre");
        articleThree.setContent("Content-test-three");
        articleThree.setTitle("Example Title");
        articleThree.setNew(true);

        AMFArticle articleFour = AMFArticleLocalServiceUtil.createAMFArticle(CounterLocalServiceUtil.increment(AMFArticle.class.getName()));
        articleFour.setIssueNumber(new Random().nextInt(100));
        articleFour.setAuthor("Mc Andre");
        articleFour.setContent("Content-test-one");
        articleFour.setTitle("Example Title");
        articleFour.setNew(true);

        AMFArticle articleFive = AMFArticleLocalServiceUtil.createAMFArticle(CounterLocalServiceUtil.increment(AMFArticle.class.getName()));
        articleFive.setIssueNumber(new Random().nextInt(100));
        articleFive.setAuthor("Mc Andre");
        articleFive.setContent("Content-test-one");
        articleFive.setTitle("Example Title");
        articleFive.setNew(true);

        AMFArticle articleSix = AMFArticleLocalServiceUtil.createAMFArticle(CounterLocalServiceUtil.increment(AMFArticle.class.getName()));
        articleSix.setIssueNumber(new Random().nextInt(100));
        articleSix.setAuthor("Mc Andre");
        articleSix.setContent("Content-test-three");
        articleSix.setTitle("Example Title");
        articleSix.setNew(true);

        AMFArticle articleSeven = AMFArticleLocalServiceUtil.createAMFArticle(CounterLocalServiceUtil.increment(AMFArticle.class.getName()));
        articleSeven.setIssueNumber(new Random().nextInt(100));
        articleSeven.setAuthor("Mc Andre");
        articleSeven.setContent("Content-test-three");
        articleSeven.setTitle("Example Title");
        articleSeven.setNew(true);
        try {
            AMFIssue amfIssueOne = AMFIssueLocalServiceUtil.createAMFIssue(CounterLocalServiceUtil.increment(AMFIssue.class.getName()));
            amfIssueOne.setIssueDate(new SimpleDateFormat("MMM dd,yyyy").parse("January 02,2021"));
            amfIssueOne.setIssueNumber(new Random().nextInt(100));
            amfIssueOne.setTitle("Tech-Trench?");
            amfIssueOne.setDescription("Tech-Trench - People tend to grab the techy-stuffs every day");

            AMFIssue amfIssueTwo = AMFIssueLocalServiceUtil.createAMFIssue(CounterLocalServiceUtil.increment(AMFIssue.class.getName()));
            amfIssueTwo.setIssueDate(new SimpleDateFormat("MMM dd,yyyy").parse("February 02,2021"));
            amfIssueTwo.setIssueNumber(new Random().nextInt(100));
            amfIssueTwo.setTitle("Tech-Trench?");
            amfIssueTwo.setDescription("Tech-Trench - People tend to grab the techy-stuffs every day");

            AMFIssue amfIssueThree = AMFIssueLocalServiceUtil.createAMFIssue(CounterLocalServiceUtil.increment(AMFIssue.class.getName()));
            amfIssueThree.setIssueDate(new SimpleDateFormat("MMM dd,yyyy").parse("March 12,2021"));
            amfIssueThree.setIssueNumber(new Random().nextInt(100));
            amfIssueThree.setTitle("Tech-Trench?");
            amfIssueThree.setDescription("Tech-Trench - People tend to grab the techy-stuffs every day");

            AMFArticleLocalServiceUtil.addAMFIssueAMFArticles(amfIssueOne.getAmfIssueId(), Arrays.asList(articleOne, articleTwo, articleThree));
            AMFArticleLocalServiceUtil.addAMFIssueAMFArticles(amfIssueTwo.getAmfIssueId(), Arrays.asList(articleOne, articleTwo, articleThree));
            AMFArticleLocalServiceUtil.addAMFIssueAMFArticles(amfIssueThree.getAmfIssueId(), Collections.singletonList(articleSeven));

            return Arrays.asList(amfIssueOne, amfIssueTwo, amfIssueThree);
        } catch (ParseException e) {
            return Collections.emptyList();
        }
    }



}