package com.amf.registration.utilities.validator;

import com.amf.registration.exception.AMFUserValidationException;
import com.amf.registration.service.AMFUserLocalService;
import com.amf.registration.validator.AMFUserValidator;
import lombok.Getter;
import org.osgi.service.component.annotations.Component;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Getter
@Component(
        immediate = true,
        service = AMFUserValidator.class
)
public class AMFUserValidatorImpl implements AMFUserValidator {
    private static final String ALPHANUMERIC_PATTERN = "[A-Za-z0-9]";
    private static final String PASSWORD_MIN8_MAX20_LENGTH_PATTERN_COMPLEX = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    private static final String ALPHANUMERIC_WITH_MIN4_MAX16_LENGTH_PATTERN = "(" + ALPHANUMERIC_PATTERN + ".{4,16})";
    private static final String ALPHANUMERIC_WITH_MIN1_MAX50_LENGTH_PATTERN = "(" + ALPHANUMERIC_PATTERN + ".{1,50})";
    private static final String ALPHANUMERIC_WITH_MIN1_MAX255_LENGTH_PATTERN = "(" + ALPHANUMERIC_PATTERN + ".{1,255})";
    private static final String ALPHABETIC_EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private static final String NUMERIC_WITH_MIN1_MAX10_LENGTH_PATTERN = "[0-9]{1,10}";
    private static final String NUMERIC_WITH_MIN1_MAX5_LENGTH_PATTERN = "[0-9]{1,5}";
    private List<String> errorMessages;

    @Override
    public void validate(
            AMFUserLocalService amfUserLocalService,
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
            throws AMFUserValidationException {

        errorMessages = new ArrayList<>();
        if (!isAMFUserValid(
                amfUserLocalService,
                firstName,
                lastName,
                emailAddress,
                userName,
                gender,
                birthDate,
                password,
                confirmedPassword,
                address,
                city,
                state,
                zip,
                securityAnswer,
                acceptedTOU,
                errorMessages)) {
            throw new AMFUserValidationException(errorMessages);
        }
    }

    /**
     * @param firstName
     * @param lastName
     * @param email
     * @param userName
     * @param gender
     * @param dateOfBirth
     * @param password
     * @param passwordConfirmation
     * @param addressOne
     * @param city
     * @param state
     * @param zipCode
     * @param securityAnswer
     * @param accepted
     * @param errors
     * @return
     */
    private boolean isAMFUserValid(
            AMFUserLocalService amfUserLocalService,
            String firstName,
            String lastName,
            String email,
            String userName,
            String gender,
            final Date dateOfBirth,
            String password,
            String passwordConfirmation,
            String addressOne,
            String city,
            String state,
            String zipCode,
            String securityAnswer,
            String accepted,
            final List<String> errors) {

        boolean result = true;
        result &= isFirstNameValid(firstName, errors);
        result &= isLastNameValid(lastName, errors);
        result &= isUserNameValid(amfUserLocalService, userName, errors);
        result &= isEmailValid(email, errors);
        result &= isGenderValid(gender, errors);
        result &= isDateOfBirthValid(dateOfBirth, errors);
        result &= isPasswordMatchedAndValid(password, passwordConfirmation, errors);
        result &= isAddressOneValid(addressOne, errors);
        result &= isCityValid(city, errors);
        result &= isStateValid(state, errors);
        result &= isZipCodeValid(zipCode, errors);
        result &= isSecurityAnswerValid(securityAnswer, errors);
        result &= isAcceptedValid(accepted, errors);
        return result;
    }


    /**
     * @param acceptedMap
     * @param errors
     * @return
     */
    private boolean isAcceptedValid(String acceptedMap, List<String> errors) {
        return getValidityCheckFor(acceptedMap, errors, null, "termAndConditionInvalid");
    }

    /**
     * @param securityAnswerMap
     * @param errors
     * @return
     */
    private boolean isSecurityAnswerValid(String securityAnswerMap, List<String> errors) {
        return getValidityCheckFor(securityAnswerMap, errors, ALPHANUMERIC_WITH_MIN1_MAX255_LENGTH_PATTERN, "stateInvalid");
    }

    /**
     * @param zipCodeMap
     * @param errors
     * @return
     */
    private boolean isZipCodeValid(String zipCodeMap, List<String> errors) {
        return getValidityCheckFor(zipCodeMap, errors, NUMERIC_WITH_MIN1_MAX5_LENGTH_PATTERN, "zipCodeInvalid");
    }

    /**
     * @param stateMap
     * @param errors
     * @return
     */
    private boolean isStateValid(String stateMap, List<String> errors) {
        return getValidityCheckFor(stateMap, errors, ALPHANUMERIC_WITH_MIN1_MAX255_LENGTH_PATTERN, "stateInvalid");
    }

    /**
     * @param cityMap
     * @param errors
     * @return
     */
    private boolean isCityValid(String cityMap, List<String> errors) {
        return getValidityCheckFor(cityMap, errors, ALPHANUMERIC_WITH_MIN1_MAX255_LENGTH_PATTERN, "cityInvalid");
    }

    /**
     * @param addressOneMap
     * @param errors
     * @return
     */
    private boolean isAddressOneValid(String addressOneMap, List<String> errors) {
        return getValidityCheckFor(addressOneMap, errors, ALPHANUMERIC_WITH_MIN1_MAX255_LENGTH_PATTERN, "addressInvalid");
    }

    /**
     * @param passwordMap
     * @param passwordConfirmationMap
     * @param errors
     * @return
     */
    private boolean isPasswordMatchedAndValid(String passwordMap, String passwordConfirmationMap, List<String> errors) {
        return isPasswordValid(passwordMap, errors) && isPasswordConfirmationValid(passwordConfirmationMap, errors) && passwordMap.compareTo(passwordConfirmationMap) == 0;
    }

    /**
     * @param passwordConfirmationMap
     * @param errors
     * @return
     */
    private boolean isPasswordConfirmationValid(String passwordConfirmationMap, List<String> errors) {
        return getValidityCheckFor(passwordConfirmationMap, errors, PASSWORD_MIN8_MAX20_LENGTH_PATTERN_COMPLEX, "confirmationPasswordMismatch");
    }

    /**
     * @param passwordMap
     * @param errors
     * @return
     */
    private boolean isPasswordValid(String passwordMap, List<String> errors) {
        return getValidityCheckFor(passwordMap, errors, PASSWORD_MIN8_MAX20_LENGTH_PATTERN_COMPLEX, "invalidPassword");
    }

    /**
     * @param dateOfBirthMap
     * @param errors
     * @return
     */
    private boolean isDateOfBirthValid(Date dateOfBirthMap, List<String> errors) {
        LocalDate birthDate = dateOfBirthMap.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate currentDate = LocalDate.now();
        if (Period.between(birthDate, currentDate).getYears() < 13) {
            errors.add("invalidAge");
            return false;
        }
        return true;
    }

    /**
     * @param genderMap
     * @param errors
     * @return
     */
    private boolean isGenderValid(String genderMap, List<String> errors) {
        return getValidityCheckFor(genderMap, errors, null, "invalidGender");
    }

    /**
     * @param emailMap
     * @param errors
     * @return
     */
    private boolean isEmailValid(String emailMap, List<String> errors) {
        return getValidityCheckFor(emailMap, errors, ALPHABETIC_EMAIL_PATTERN, "invalidEmail");
    }

    /**
     * @param amfUserLocalService
     * @param userName
     * @param errors
     * @return
     */
    private boolean isUserNameValid(AMFUserLocalService amfUserLocalService, String userName, List<String> errors) {
        boolean validityFlag = true;
        if (!amfUserLocalService.isUserNameUnique()) {
            validityFlag = false;
            errorMessages.add("duplicatedUserName");
        }

        return validityFlag && getValidityCheckFor(userName, errors, ALPHANUMERIC_WITH_MIN4_MAX16_LENGTH_PATTERN, "invalidUserName");
    }

    /**
     * @param lastNameMap
     * @param errors
     * @return
     */
    private boolean isLastNameValid(String lastNameMap, List<String> errors) {
        return getValidityCheckFor(lastNameMap, errors, ALPHANUMERIC_WITH_MIN1_MAX50_LENGTH_PATTERN, "invalidLastName");
    }

    /**
     * @param firstNameMap
     * @param errors
     * @return
     */
    private boolean isFirstNameValid(String firstNameMap, List<String> errors) {
        return getValidityCheckFor(firstNameMap, errors, ALPHANUMERIC_WITH_MIN1_MAX50_LENGTH_PATTERN, "invalidFirstName");
    }

    /**
     * @param inputValue
     * @param errors
     * @return
     */
    private boolean getValidityCheckFor(
            String inputValue,
            final List<String> errors,
            final String regularExpressionForValidation,
            final String invalidMessage) {
        boolean result = true;
        result &= !inputValue.isEmpty();
        if (regularExpressionForValidation != null) {
            result &= Pattern.compile(regularExpressionForValidation).matcher(inputValue).matches();
        }
        errors.add(!result ? invalidMessage : "");
        return result;
    }

}
