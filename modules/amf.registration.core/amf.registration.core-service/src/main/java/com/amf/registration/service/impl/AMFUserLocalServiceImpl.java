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

package com.amf.registration.service.impl;

import com.amf.registration.model.AMFUser;
import com.amf.registration.service.base.AMFUserLocalServiceBaseImpl;
import com.amf.registration.validator.AMFUserValidator;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.*;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import lombok.Getter;
import lombok.Setter;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the amf user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.amf.registration.service.AMFUserLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMFUserLocalServiceBaseImpl
 */
@Getter
@Setter
@Component(
        property = "model.class.name=com.amf.registration.model.AMFUser",
        service = AopService.class
)
public class AMFUserLocalServiceImpl extends AMFUserLocalServiceBaseImpl {

    private long groupID;
    private String inputUserName;
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Use <code>com.amf.registration.service.AMFUserLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.amf.registration.service.AMFUserLocalServiceUtil</code>.
     */

    /**
     * @param themeDisplay
     * @param userName
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param gender
     * @param birthDate
     * @param password
     * @param confirmedPassword
     * @param homePhone
     * @param mobilePhone
     * @param addressLineOne
     * @param addressLineTwo
     * @param city
     * @param regionId
     * @param zip
     * @param securityQuestion
     * @param securityAnswer
     * @param acceptedTOU
     * @param serviceContext
     * @return
     * @throws PortalException
     */
    public AMFUser addAMFUser(
            ThemeDisplay themeDisplay,
            String userName,
            String firstName,
            String lastName,
            String emailAddress,
            String gender,
            Date birthDate,
            String password,
            String confirmedPassword,
            String homePhone,
            String mobilePhone,
            String addressLineOne,
            String addressLineTwo,
            String city,
            String regionId,
            String zip,
            String securityQuestion,
            String securityAnswer,
            String acceptedTOU,
            ServiceContext serviceContext) throws PortalException {

        amfUserValidator.validate(this,
                userName,
                firstName,
                lastName,
                emailAddress,
                gender,
                birthDate,
                password,
                confirmedPassword,
                homePhone,
                mobilePhone,
                addressLineOne,
                addressLineTwo,
                city,
                regionId,
                zip,
                securityQuestion,
                securityAnswer,
                acceptedTOU
        );
        try {

            Calendar cal = Calendar.getInstance();
            cal.setTime(birthDate);
            serviceContext.setCommand(ActionKeys.ADD_ENTRY);
            serviceContext.setCommand(ActionKeys.UPDATE);

            try {
                User user = userService.addUser(
                        themeDisplay.getCompanyId(),
                        false,
                        password,
                        confirmedPassword,
                        true,
                        userName,
                        emailAddress,
                        LocaleUtil.fromLanguageId("en_US"),
                        firstName,
                        "",
                        lastName,
                        0L,
                        0L,
                        gender.equals("male"),
                        (cal.get(Calendar.MONTH) + 1),
                        cal.get(Calendar.DAY_OF_MONTH),
                        cal.get(Calendar.YEAR),
                        "",
                        null,
                        null,
                        null,
                        null,
                        false,
                        serviceContext
                );

            } catch (PortalException e) {
                e.printStackTrace();
            }

            long amfUserId = counterLocalService.increment(AMFUser.class.getName());
            Country country = countryService.getCountryByName("united-states");
            Address address = addressService.addAddress(
                    AMFUser.class.getName(),
                    amfUserId,
                    addressLineOne,
                    addressLineTwo,
                    "",
                    city,
                    zip,
                    Long.parseLong(regionId),
                    country.getCountryId(),
                    0l,
                    true,
                    true,
                    serviceContext
            );

            AMFUser amfUser = createAMFUser(amfUserId);
            amfUser.setAmfUserId(amfUserId);
            amfUser.setUserCreatorID(0L);
//            amfUser.setUserId(user.getUserId());
            amfUser.setCompanyId(themeDisplay.getCompanyId());
            amfUser.setAddressID(address.getAddressId());
            amfUser.setGroupId(themeDisplay.getScopeGroupId());
            amfUser.setUserName(userName);
            amfUser.setCreateDate(new Date());
            amfUser.setModifiedDate(new Date());
            amfUser.setGender(gender);
            amfUser.setHomePhone(homePhone);
            amfUser.setMobilePhone(mobilePhone);
            amfUser.setSecurityQuestion(securityQuestion);
            amfUser.setSecurityAnswer(securityAnswer);
            amfUser.setAcceptedTOU(acceptedTOU);
            amfUser = super.addAMFUser(amfUser);

            return amfUser;

        } catch (PortalException e) {
            throw new PortalException(e.getMessage());
        }
    }

    /**
     * @param groupId
     * @param keywords
     * @param start
     * @param end
     * @param orderByComparator
     * @return
     */
    @Override
    public List<AMFUser> getAMFUsersByKeywords(
            final long groupId,
            final String keywords,
            final int start,
            final int end,
            final OrderByComparator<AMFUser> orderByComparator
    ) {
        return amfUserLocalService.dynamicQuery(getKeywordSearchDynamicQuery(groupId, keywords), start, end, orderByComparator);
    }

    /**
     * @param groupId
     * @param userName
     * @return
     */
    @Override
    public long getAMFUsersCountByKeywords(long groupId, String userName) {
        return amfUserLocalService.dynamicQueryCount(
                getKeywordSearchDynamicQuery(groupId, userName));
    }

    /**
     * @param groupId
     * @param userName
     * @return
     */
    @Override
    public long getAMFUserByUserName(long groupId, String userName) {
        return amfUserLocalService.dynamicQueryCount(
                getUserNameSearchDynamicQuery(groupId, userName));
    }

    @Override
    public boolean isUserNameUnique() {
        return getAMFUserByUserName(getGroupID(), getInputUserName()) == 0;
    }

    /**
     * @param groupId
     * @param keywords
     * @return
     */
    private DynamicQuery getKeywordSearchDynamicQuery(
            final long groupId,
            final String keywords) {

        DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
        if (Validator.isNotNull(keywords)) {
            Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
            disjunctionQuery.add(RestrictionsFactoryUtil.like("userName", "%" + keywords + "%"));
            dynamicQuery.add(disjunctionQuery);
        }
        return dynamicQuery;
    }

    /**
     * @param groupId
     * @param userName
     * @return
     */
    private DynamicQuery getUserNameSearchDynamicQuery(
            final long groupId,
            final String userName) {

        DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
        if (Validator.isNotNull(userName)) {
            Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
            disjunctionQuery.add(RestrictionsFactoryUtil.eq("userName", userName));
            dynamicQuery.add(disjunctionQuery);
        }
        return dynamicQuery;
    }

    @Reference
    private AMFUserValidator amfUserValidator;

    @Reference
    private UserService userService;

    @Reference
    private AddressService addressService;

    @Reference
    private CountryService countryService;

    @Reference
    private RegionService regionService;

}