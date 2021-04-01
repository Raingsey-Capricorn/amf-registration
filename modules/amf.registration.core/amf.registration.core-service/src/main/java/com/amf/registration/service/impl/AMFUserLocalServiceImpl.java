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
import com.amf.registration.service.AMFUserLocalServiceUtil;
import com.amf.registration.service.base.AMFUserLocalServiceBaseImpl;
import com.amf.registration.validator.AMFUserValidator;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.PwdEncryptorException;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.pwd.PasswordEncryptorUtil;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
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

        amfUserValidator.validate(
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

        User registerUser = setNewUserAttributes(userName, firstName, lastName, emailAddress, birthDate, password, securityQuestion, securityAnswer, acceptedTOU);
        Contact registerContact = setNewContactAttributes(birthDate, registerUser);
        Address registerAddress = setNewAddressAttributes(userName, addressLineOne, addressLineTwo, city, regionId, zip, registerUser);
        AMFUser amfUser = setNewAMFUserAttributes(homePhone, mobilePhone, registerUser, registerContact, registerAddress);
        try {
            UserLocalServiceUtil.addUser(registerUser);
            ContactLocalServiceUtil.addContact(registerContact);
            AddressLocalServiceUtil.addAddress(registerAddress);
            amfUser = AMFUserLocalServiceUtil.addAMFUser(amfUser);
            return amfUser;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PortalException(e);
        }

    }

    /**
     * @param homePhone
     * @param mobilePhone
     * @param registerUser
     * @param registerContact
     * @param registerAddress
     * @return
     */
    private AMFUser setNewAMFUserAttributes(String homePhone, String mobilePhone, User registerUser, Contact registerContact, Address registerAddress) {
        long amfUserID = counterLocalService.increment(AMFUser.class.getName());
        AMFUser amfUser = AMFUserLocalServiceUtil.createAMFUser(amfUserID);
        amfUser.setUserId(registerUser.getUserId());
        amfUser.setAddressId(registerAddress.getAddressId());
        amfUser.setContractId(registerContact.getContactId());
        amfUser.setHomePhone(homePhone);
        amfUser.setMobilePhone(mobilePhone);
        amfUser.setUserName(registerUser.getScreenName());
        amfUser.setCreateDate(new Date());
        amfUser.setModifiedDate(new Date());
        return amfUser;
    }

    /**
     * @param userName
     * @param addressLineOne
     * @param addressLineTwo
     * @param city
     * @param regionId
     * @param zip
     * @param registerUser
     * @return
     * @throws PortalException
     */
    private Address setNewAddressAttributes(String userName, String addressLineOne, String addressLineTwo, String city, String regionId, String zip, User registerUser) throws PortalException {
        long addressId = counterLocalService.increment(Address.class.getName());
        Address registerAddress = AddressLocalServiceUtil.createAddress(addressId);
        registerAddress.setCreateDate(new Date());
        registerAddress.setModifiedDate(new Date());
        registerAddress.setUserId(registerUser.getUserId());
        registerAddress.setCity(city);
        registerAddress.setCountryId(countryService.getCountryByName("united-states").getCountryId());
        registerAddress.setRegionId(Long.parseLong(regionId));
        registerAddress.setZip(zip);
        registerAddress.setNew(true);
        registerAddress.setStreet1(addressLineOne);
        registerAddress.setStreet2(addressLineTwo);
        registerAddress.setUserName(userName);
        return registerAddress;
    }

    /**
     * @param birthDate
     * @param registerUser
     * @return
     */
    private Contact setNewContactAttributes(Date birthDate, User registerUser) {
        long contactID = counterLocalService.increment(Contact.class.getName());
        Contact registerContact = ContactLocalServiceUtil.createContact(contactID);
        registerContact.setUserId(registerUser.getUserId());
        registerContact.setCreateDate(new Date());
        registerContact.setModifiedDate(new Date());
        registerContact.setBirthday(birthDate);
        registerContact.setMale(true);
        registerContact.setUserName(registerUser.getScreenName());
        registerContact.setUserId(registerUser.getUserId());
        return registerContact;
    }

    /**
     * @param userName
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param birthDate
     * @param password
     * @param securityQuestion
     * @param securityAnswer
     * @param acceptedTOU
     * @return
     */
    private User setNewUserAttributes(String userName, String firstName, String lastName, String emailAddress, Date birthDate, String password, String securityQuestion, String securityAnswer, String acceptedTOU) throws PwdEncryptorException {
        long userID = counterLocalService.increment(User.class.getName());
        User registerUser = UserLocalServiceUtil.createUser(userID);
        Calendar cal = Calendar.getInstance();
        cal.setTime(birthDate);
        registerUser.setScreenName(userName);
        registerUser.setFirstName(firstName);
        registerUser.setLastName(lastName);
        registerUser.setPassword(PasswordEncryptorUtil.encrypt(password));
        registerUser.setPasswordUnencrypted(password);
        registerUser.setPasswordEncrypted(true);
        registerUser.setEmailAddress(emailAddress);
        registerUser.setEmailAddressVerified(false);
        registerUser.setCreateDate(new Date());
        registerUser.setModifiedDate(new Date());
        registerUser.setGreeting("Hello " + userName);
        registerUser.setLanguageId(LocaleUtil.fromLanguageId("en_US").getLanguage());
        registerUser.setReminderQueryQuestion(securityQuestion);
        registerUser.setReminderQueryAnswer(securityAnswer);
        registerUser.setAgreedToTermsOfUse(Boolean.parseBoolean(acceptedTOU));
        return registerUser;
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
    private CountryService countryService;

}