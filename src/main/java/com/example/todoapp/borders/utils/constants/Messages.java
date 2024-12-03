package com.example.todoapp.borders.utils.constants;

/**
 * Messages constants
 */
public class Messages {
    public static final String SUCCESS_MESSAGE = "Request has been successful.";
    public static final String ERROR_REQUEST_VALIDATION = "Request is not valid.";
    public static final String ERROR_BUSINESS_VALIDATION = "Business validation failed.";
    public static final String NOT_FOUND = "Register was not found.";
    public static final String INTERNAL_SERVER_ERROR = "Sorry our servers are facing some problems. Try again if this error persist please let us know.";
    public static final String REQUIRED_PROPERTY = "Required property.";
    public static final String MIN_AGE_FOR_REGISTERING = "10 years old is required.";
    public static final String VALID_DATE_REQUIRED = "You must fill a valid date on format yyyy-MM-dd.";
    public static final String E_MAIL_MUST_BE_VALID = "Must fill a valid e-mail.";
    public static final String BRAZILIAN_NUMBER_REQUIRED = "Must fill a valid brazilian phone number, patterns: (##)9####-####, (##)####-####, (##)9########, (##)########.";
    public static final String INVALID_REGEX = "Invalid regex for 'regexPattern' in @PhoneNumber annotation. Use a valid regex.";
    public static final String INVALID_DATE = "Invalid date format for 'value' in @DateBefore annotation. Use yyyy-MM-dd.";
    public static final String MAX_TAKE_LIMIT = "Maximum take limit exceeded.";
    public static final String MIN_TAKE_LIMIT = "Minimum take limit exceeded.";
    public static final String ERROR_CONFLICT = "Not able to persist, register already exists.";
}
