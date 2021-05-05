package com.amf.registration.utilities.validator;

import com.amf.registration.exception.AMFUserValidationException;
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
        boolean result = true;
        result &= getValidityCheckFor(firstName, errorMessages, ALPHANUMERIC_WITH_MIN1_MAX50_LENGTH_PATTERN, "invalidFirstName");
        result &= getValidityCheckFor(lastName, errorMessages, ALPHANUMERIC_WITH_MIN1_MAX50_LENGTH_PATTERN, "invalidLastName");
        result &= getValidityCheckFor(userName, errorMessages, ALPHANUMERIC_WITH_MIN4_MAX16_LENGTH_PATTERN, "invalidUserName");
        result &= getValidityCheckFor(emailAddress, errorMessages, ALPHABETIC_EMAIL_PATTERN, "invalidEmail");
        result &= getValidityCheckFor(gender, errorMessages, null, "invalidGender");
        result &= isDateOfBirthValid(birthDate, errorMessages);
        result &= isPasswordMatchedAndValid(password, confirmedPassword, errorMessages);
        result &= getValidityCheckFor(address, errorMessages, ALPHANUMERIC_WITH_MIN1_MAX255_LENGTH_PATTERN, "addressInvalid");
        result &= getValidityCheckFor(city, errorMessages, ALPHANUMERIC_WITH_MIN1_MAX255_LENGTH_PATTERN, "cityInvalid");
        result &= getValidityCheckFor(state, errorMessages, ALPHANUMERIC_WITH_MIN1_MAX255_LENGTH_PATTERN, "stateInvalid");
        result &= getValidityCheckFor(zip, errorMessages, NUMERIC_WITH_MIN1_MAX5_LENGTH_PATTERN, "zipCodeInvalid");
        result &= getValidityCheckFor(securityAnswer, errorMessages, ALPHANUMERIC_WITH_MIN1_MAX255_LENGTH_PATTERN, "stateInvalid");
        result &= getValidityCheckFor(acceptedTOU, errorMessages, null, "termAndConditionInvalid");
        if (!result) {
            throw new AMFUserValidationException(errorMessages);
        }
    }

    /**
     * @param passwordMap
     * @param passwordConfirmationMap
     * @param errors
     * @return
     */
    private boolean isPasswordMatchedAndValid(String passwordMap, String passwordConfirmationMap, List<String> errors) {
        return getValidityCheckFor(passwordMap, errorMessages, PASSWORD_MIN8_MAX20_LENGTH_PATTERN_COMPLEX, "invalidPassword") &&
                getValidityCheckFor(passwordConfirmationMap, errorMessages, PASSWORD_MIN8_MAX20_LENGTH_PATTERN_COMPLEX, "confirmationPasswordMismatch") &&
                passwordMap.compareTo(passwordConfirmationMap) == 0;
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
     * @param inputValue
     * @param errorMessages
     * @param regularExpressionForValidation
     * @param invalidMessage
     * @return
     */
    private boolean getValidityCheckFor(
            String inputValue,
            final List<String> errorMessages,
            final String regularExpressionForValidation,
            final String invalidMessage) {
        boolean result = true;
        result &= !inputValue.isEmpty();
        if (regularExpressionForValidation != null) {
            result &= Pattern.compile(regularExpressionForValidation).matcher(inputValue).matches();
        }
        errorMessages.add(!result ? invalidMessage : "");
        return result;
    }

}
