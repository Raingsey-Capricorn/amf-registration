package com.amf.registration.validator;

import com.amf.registration.exception.AMFUserValidationException;

import java.util.Date;
import java.util.List;

public interface AMFUserValidator {
    List<String> getErrorMessages();

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
     * @param address
     * @param address2
     * @param city
     * @param state
     * @param zip
     * @param securityQuestion
     * @param securityAnswer
     * @param acceptedTOU
     * @throws AMFUserValidationException
     */
    void validate(
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
            String address,
            String address2,
            String city,
            String state,
            String zip,
            String securityQuestion,
            String securityAnswer,
            String acceptedTOU)
            throws AMFUserValidationException;
}
