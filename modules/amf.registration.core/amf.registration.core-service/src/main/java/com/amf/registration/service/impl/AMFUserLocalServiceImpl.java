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

import com.amf.registration.exception.AMFUserValidationException;
import com.amf.registration.model.AMFEventLog;
import com.amf.registration.model.AMFUser;
import com.amf.registration.service.AMFEventLogLocalService;
import com.amf.registration.service.AMFEventLogLocalServiceUtil;
import com.amf.registration.service.AMFUserGroupService;
import com.amf.registration.service.AMFUserLocalServiceUtil;
import com.amf.registration.service.base.AMFUserLocalServiceBaseImpl;
import com.amf.registration.utilities.EventStatus;
import com.amf.registration.validator.AMFUserValidator;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.NoSuchGroupException;
import com.liferay.portal.kernel.exception.NoSuchUserGroupException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.*;
import com.liferay.portal.kernel.security.auth.FullNameGeneratorFactory;
import com.liferay.portal.kernel.security.pwd.PasswordEncryptorUtil;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import lombok.Getter;
import lombok.Setter;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.*;
import java.util.stream.Collectors;

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
            final ThemeDisplay themeDisplay,
            final String userName,
            final String firstName,
            final String lastName,
            final String emailAddress,
            final String gender,
            final Date birthDate,
            final String password,
            final String confirmedPassword,
            final String homePhone,
            final String mobilePhone,
            final String addressLineOne,
            final String addressLineTwo,
            final String city,
            final String regionId,
            final String zip,
            final String securityQuestion,
            final String securityAnswer,
            final String acceptedTOU,
            final com.liferay.portal.kernel.service.ServiceContext serviceContext
    ) throws AMFUserValidationException, NoSuchGroupException {

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

        try {
            User registerUser = createUserEntity(themeDisplay, userName, firstName, lastName, emailAddress, password, securityQuestion, securityAnswer, acceptedTOU, serviceContext);
            Contact registerContact = createContactEntity(userName, firstName, lastName, emailAddress, birthDate, gender, registerUser);
            registerUser.setContactId(registerContact.getContactId());
            UserLocalServiceUtil.updateUser(registerUser);
            RoleLocalServiceUtil.addUserRole(registerUser.getUserId(), RoleLocalServiceUtil.getRole(registerUser.getCompanyId(), "User"));

            Group registerGroup = createGroupEntity(registerUser, serviceContext);
            LayoutSetLocalServiceUtil.addLayoutSet(registerGroup.getGroupId(), true);
            LayoutSetLocalServiceUtil.addLayoutSet(registerGroup.getGroupId(), false);
            UserLocalServiceUtil.addGroupUser(registerGroup.getGroupId(), registerUser.getUserId());
            UserLocalServiceUtil.addUserGroupUser(amfUserGroupService.getAMFUserGroupId(), registerUser);

            Address registerAddress = createAddressEntity(userName, addressLineOne, addressLineTwo, city, Long.parseLong(regionId), zip, registerUser);
            AMFUser registerAMFUser = createAMFUserEntity(homePhone, mobilePhone, registerUser, registerAddress);
            AMFEventLog amfEventLog = createEventLogEntity(registerAMFUser, registerUser);
            AMFEventLogLocalServiceUtil.addAMFUserAMFEventLogs(registerAMFUser.getAmfUserId(), Collections.singletonList(amfEventLog));


            final boolean portletActions = false;
            final boolean addGroupPermissions = true;
            final boolean addGuestPermissions = true;
            getResourceLocalService().addResources(
                    registerUser.getCompanyId(),
                    registerAMFUser.getGroupId(),
                    registerUser.getUserId(),
                    User.class.getName(),
                    registerUser.getUserId(),
                    portletActions,
                    addGroupPermissions,
                    addGuestPermissions
            );

            return AMFUserLocalServiceUtil.addAMFUser(registerAMFUser);
        } catch (NoSuchGroupException e) {
            throw new NoSuchGroupException(e.getMessage());
        } catch (Exception e) {
            throw new AMFUserValidationException(e);
        }

    }

    /**
     * @param regionCode
     * @param start
     * @param end
     * @return
     */
    @Override
    public HashMap<String, Object> getAMFUserBaseOnPostalCode(long regionCode, int start, int end) {
        HashMap<String, Object> searchData = new HashMap<>();
        try {
            if (getDynamicQueryForUserBaseOnRegion(regionCode, start, end) != null) {
                searchData.put("amfUsers", amfUserLocalService.dynamicQuery(getDynamicQueryForUserBaseOnRegion(regionCode, start, end)));
                searchData.put("amfUserCount", amfUserLocalService.dynamicQueryCount(getDynamicQueryForUserBaseOnRegion(regionCode, 0, 0)));
            }
        } catch (Exception e) {
            searchData.put("amfUsers", Collections.emptyList());
            searchData.put("amfUserCount", 0);
        } finally {
            return searchData;
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
            final OrderByComparator<AMFUser> orderByComparator) {

        return amfUserLocalService.dynamicQuery(getKeywordSearchDynamicQuery(groupId, keywords), start, end, orderByComparator);
    }

    /**
     * @param groupId
     * @param userName
     * @return
     */
    @Override
    public long getAMFUsersCountByKeywords(
            long groupId,
            String userName) {

        return amfUserLocalService.dynamicQueryCount(
                getKeywordSearchDynamicQuery(groupId, userName));
    }

    /**
     * @param groupId
     * @param userName
     * @return
     */
    @Override
    public long getAMFUserByUserName(
            long groupId,
            String userName) {

        return amfUserLocalService.dynamicQueryCount(
                getUserNameSearchDynamicQuery(groupId, userName));
    }

    /**
     * @param groupId
     * @param userId
     * @param userName
     * @return
     */
    @Override
    public AMFUser getAMFUserByGroupUserAndUserName(
            long groupId,
            long userId,
            String userName) throws NoSuchGroupException {

        return (AMFUser) amfUserLocalService.dynamicQuery(getDynamicQueryForGroupUserAndUsername(groupId, userId, userName))
                .stream()
                .findFirst()
                .orElseThrow(NoSuchGroupException::new);
    }

    /**
     * @return
     */
    @Override
    public boolean isUserNameUnique() {
        return getAMFUserByUserName(getGroupID(), getInputUserName()) == 0;
    }

    /**
     * @param groupId
     * @param eventStatus
     * @return
     */
    @Override
    public List<AMFUser> getAMFUserEventLogByStatus(
            long groupId,
            String eventStatus) {

        return amfEventLogLocalService.dynamicQuery(getEventLogStatusSearchDynamicQuery(groupId, eventStatus));
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
     * @param status
     * @return
     */
    private DynamicQuery getEventLogStatusSearchDynamicQuery(
            final long groupId,
            final String status) {

        DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
        if (Validator.isNotNull(status)) {
            Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
            disjunctionQuery.add(RestrictionsFactoryUtil.eq("status", status));
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

    /**
     * @param groupId
     * @param userId
     * @param userName
     * @return
     */
    private DynamicQuery getDynamicQueryForGroupUserAndUsername(
            long groupId,
            long userId,
            String userName) {

        try {
            DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));
            if (Validator.isNotNull(userId)) {
                Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();
                disjunctionQuery.add(RestrictionsFactoryUtil.eq("userId", userId));
                disjunctionQuery.add(RestrictionsFactoryUtil.eq("userName", userName));
                dynamicQuery.add(disjunctionQuery);
            }
            return dynamicQuery;
        } catch (NullPointerException npe) {
            return null;
        }
    }

    /**
     * @param registerUser
     * @param serviceContext
     * @return
     */
    private Group createGroupEntity(final User registerUser, final ServiceContext serviceContext) throws PortalException {

        final long groupId = CounterLocalServiceUtil.increment();
        final long classNameId = ClassNameLocalServiceUtil.getClassName(com.liferay.portal.kernel.model.User.class.getName()).getClassNameId();
        final long userOwnerId = registerUser.getUserId();
        final long companyId = registerUser.getCompanyId();
        final String uuID = serviceContext.getUuid();

        Group group = GroupLocalServiceUtil.createGroup(groupId);
        group.setClassNameId(classNameId);
        group.setCreatorUserId(registerUser.getUserId());
        group.setCompanyId(companyId);
        group.setUuid(uuID);
        group.setClassPK(userOwnerId);
        group.setCreatorUserId(userOwnerId);
        group.setGroupKey(String.valueOf(userOwnerId));
        group.setManualMembership(true);
        group.setMembershipRestriction(MembershipRequestConstants.STATUS_APPROVED);
        group.setSite(true);
        group.setType(0);
        group.setTreePath(StringPool.SLASH + groupId + StringPool.SLASH);
        group.setFriendlyURL(StringPool.SLASH + registerUser.getScreenName());
        group.setActive(true);
        return GroupLocalServiceUtil.addGroup(group);

    }

    /**
     * @param themeDisplay
     * @param userName
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param password
     * @param acceptedTOU
     * @param securityQuestion
     * @param securityAnswer
     * @param serviceContext
     * @return
     * @throws Exception
     */
    private User createUserEntity(
            final ThemeDisplay themeDisplay,
            final String userName,
            final String firstName,
            final String lastName,
            final String emailAddress,
            final String password,
            final String securityQuestion,
            final String securityAnswer,
            final String acceptedTOU,
            final ServiceContext serviceContext
    ) throws Exception {

        try {
            final long userId = counterLocalService.increment();
            final String fullName = FullNameGeneratorFactory.getInstance().getFullName(firstName, null, lastName);
            final Locale locale = LocaleUtil.fromLanguageId("en_US");
            final String greeting = LanguageUtil.format(locale, "welcome-x", fullName, false);
            final User defaultUser = userLocalService.getDefaultUser(themeDisplay.getCompanyId());
            final PasswordPolicy passwordPolicy = defaultUser.getPasswordPolicy();

            User registerUser = UserLocalServiceUtil.createUser(userId);
            registerUser.setNew(true);
            registerUser.setDefaultUser(false);
            registerUser.setPassword(PasswordEncryptorUtil.encrypt(password));
            registerUser.setPasswordUnencrypted(password);
            registerUser.setPasswordEncrypted(true);
            registerUser.setPasswordReset((passwordPolicy != null) && passwordPolicy.isChangeable() && passwordPolicy.isChangeRequired());
            registerUser.setGreeting(greeting);
            registerUser.setScreenName(userName);
            registerUser.setEmailAddress(emailAddress);
            registerUser.setDigest(registerUser.getDigest(password));
            registerUser.setTimeZoneId(defaultUser.getTimeZoneId());
            registerUser.setCompanyId(themeDisplay.getCompanyId());
            registerUser.setLanguageId(LocaleUtil.toLanguageId(locale));
            registerUser.setFirstName(firstName);
            registerUser.setLastName(lastName);
            registerUser.setJobTitle("AMF User");
            registerUser.setGreeting("Hello " + userName);
            registerUser.setCreateDate(new Date());
            registerUser.setReminderQueryQuestion(securityQuestion);
            registerUser.setReminderQueryAnswer(securityAnswer);
            registerUser.setAgreedToTermsOfUse(acceptedTOU.equals("true"));
            registerUser.setEmailAddressVerified(true);
            registerUser.setStatus(WorkflowConstants.STATUS_APPROVED);
            registerUser.setExpandoBridgeAttributes(serviceContext);

            return UserLocalServiceUtil.addUser(registerUser);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * @param userName
     * @param firstName
     * @param lastName
     * @param emailAddress
     * @param birthDate
     * @param registerUser
     * @return
     */
    private Contact createContactEntity(
            final String userName,
            final String firstName,
            final String lastName,
            final String emailAddress,
            final Date birthDate,
            final String gender,
            final User registerUser) throws PortalException {

        final long contactId = counterLocalService.increment();
        final String className = User.class.getName();
        final long classPk = registerUser.getUserId();
        final long userClassNameId = ClassNameLocalServiceUtil.getClassNameId(User.class);
        final long accountId = CompanyLocalServiceUtil.getCompanyById(registerUser.getCompanyId()).getAccountId();

        Contact registerContact = ContactLocalServiceUtil.createContact(contactId);
        registerContact.setUserId(registerUser.getUserId());
        registerContact.setUserName(registerUser.getFullName());
        registerContact.setClassName(className);
        registerContact.setClassPK(classPk);
        registerContact.setAccountId(accountId);
        registerContact.setClassNameId(userClassNameId);
        registerContact.setParentContactId(ContactConstants.DEFAULT_PARENT_CONTACT_ID);
        registerContact.setMale(gender.equals("male"));
        registerContact.setCreateDate(new Date());
        registerContact.setBirthday(birthDate);
        registerContact.setEmailAddress(emailAddress);
        registerContact.setFirstName(firstName);
        registerContact.setLastName(lastName);
        registerContact.setUserName(userName);
        registerContact.setNew(true);
        return ContactLocalServiceUtil.addContact(registerContact);
    }


    /**
     * @param regionCode
     * @param start
     * @param end
     * @return
     */
    private DynamicQuery getDynamicQueryForUserBaseOnRegion(final long regionCode, final int start, final int end) throws NoSuchUserGroupException {

        if (regionCode > 0) {
            List<Long> amfMemberIds = null;
            try {
                amfMemberIds = UserLocalServiceUtil
                        .getUserGroupUsers(amfUserGroupService.getAMFUserGroupId())
                        .stream()
                        .map(User::getUserId).collect(Collectors.toList());
            } catch (NoSuchUserGroupException e) {
                throw new NoSuchUserGroupException(e.getMessage());
            }
            DynamicQuery addressDQ = addressLocalService.dynamicQuery()
                    .add(RestrictionsFactoryUtil.conjunction())
                    .add(RestrictionsFactoryUtil.in("userId", amfMemberIds))
                    .add(RestrictionsFactoryUtil.eq("regionId", regionCode))
                    .setProjection(ProjectionFactoryUtil.groupProperty(("userId")));
            List<Long> matchedAddresses = addressLocalService.dynamicQuery(addressDQ);
            if (matchedAddresses.size() > 0) {
                DynamicQuery amfUserDQ = dynamicQuery();
                amfUserDQ.add(RestrictionsFactoryUtil.conjunction().add(RestrictionsFactoryUtil.in("userId", matchedAddresses)));
                if (start >= 0 && end > 0) {
                    amfUserDQ.setLimit(start, end);
                }
                return amfUserDQ;
            }
        }
        return null;
    }

    /**
     * @param amfUser
     */
    private AMFEventLog createEventLogEntity(final AMFUser amfUser, final User user) throws NoSuchGroupException {
        try {

            long amfEvenLogId = counterLocalService.increment(AMFEventLog.class.getName());
            AMFEventLog amfEventLog = AMFEventLogLocalServiceUtil.createAMFEventLog(amfEvenLogId);
            amfEventLog.setUserId(amfUser.getUserId());
            amfEventLog.setGroupId(user.getGroupId());
            amfEventLog.setUserGroupId(Arrays.stream(user.getUserGroupIds()).findFirst().orElseThrow(NoSuchGroupException::new));
            amfEventLog.setLastLoginIP("0.0.0.0");
            amfEventLog.setStatus(EventStatus.REGISTER);
            amfEventLog.setCreateDate(new Date());
            amfEventLog.setNew(true);
            return AMFEventLogLocalServiceUtil.addAMFEventLog(amfEventLog);

        } catch (PortalException e) {
            throw new NoSuchGroupException(e.getMessage());
        }
    }

    /**
     * @param homePhone
     * @param mobilePhone
     * @param registerUser
     * @param registerAddress
     * @return
     */
    private AMFUser createAMFUserEntity(
            final String homePhone,
            final String mobilePhone,
            final User registerUser,
            final Address registerAddress) throws Exception {
        try {

            long amfUserID = counterLocalService.increment(AMFUser.class.getName());
            AMFUser amfUser = AMFUserLocalServiceUtil.createAMFUser(amfUserID);
            amfUser.setGroupId(registerUser.getGroupId());
            amfUser.setUserId(registerUser.getUserId());
            amfUser.setUserName(registerUser.getScreenName());
            amfUser.setAddressId(registerAddress.getAddressId());
            amfUser.setHomePhone(homePhone);
            amfUser.setMobilePhone(mobilePhone);
            amfUser.setCreateDate(new Date());
            amfUser.setModifiedDate(new Date());
            return amfUser;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
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
    private Address createAddressEntity(final String userName,
                                        final String addressLineOne,
                                        final String addressLineTwo,
                                        final String city,
                                        final long regionId,
                                        final String zip,
                                        final User registerUser) throws PortalException {

        final long addressId = counterLocalService.increment(Address.class.getName());
        final String className = Address.class.getName();
        final long classPk = registerUser.getContactId();
        final long contactClassNameId = ClassNameLocalServiceUtil.getClassNameId(Contact.class);
        final long countryId = countryService.getCountryByName("united-states").getCountryId();

        Address registerAddress = AddressLocalServiceUtil.createAddress(addressId);
        registerAddress.setUserId(registerUser.getUserId());
        registerAddress.setClassPK(classPk);
        registerAddress.setClassName(className);
        registerAddress.setClassNameId(contactClassNameId);
        registerAddress.setTypeId(11001); //Other
        registerAddress.setCountryId(countryId);
        registerAddress.setRegionId(regionId);
        registerAddress.setCity(city);
        registerAddress.setZip(zip);
        registerAddress.setNew(true);
        registerAddress.setUserName(userName);
        registerAddress.setStreet1(addressLineOne);
        registerAddress.setStreet2(addressLineTwo);
        registerAddress.setCreateDate(new Date());
        registerAddress.setModifiedDate(new Date());

        return AddressLocalServiceUtil.addAddress(registerAddress);
    }


    @Reference
    private AMFUserValidator amfUserValidator;

    @Reference
    private CountryService countryService;

    @Reference
    private UserService userService;

    @Reference
    private ResourceLocalService resourceLocalService;

    @Reference
    private AMFEventLogLocalService amfEventLogLocalService;

    @Reference
    private AddressLocalService addressLocalService;

    @Reference
    private AMFUserGroupService amfUserGroupService;

    @Reference
    private UserLocalService userLocalService;

    @Reference
    private ListTypeLocalService listTypeLocalService;

    @Reference
    private CompanyService companyService;
}