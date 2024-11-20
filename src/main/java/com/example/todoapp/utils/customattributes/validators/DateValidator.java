package com.example.todoapp.utils.customattributes.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * ValidDate is used to validate if informed date is valid
 */
public class DateValidator implements ConstraintValidator<ValidDate, String> {

    /**
     * Initialize parameters
     * @param constraintAnnotation
     */
    @Override
    public void initialize(ValidDate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     * Valid informed date
     * @param dateStr
     * @param context
     * @return
     */
    @Override
    public boolean isValid(String dateStr, ConstraintValidatorContext context) {
        if (dateStr == null || dateStr.isEmpty()) {
            return true; // You may want to handle null/empty values separately if necessary.
        }

        try {
            // Try to parse the date to check if it's a valid date
            LocalDate.parse(dateStr); // You can use LocalDateTime.parse() if you need time precision as well
            return true;  // The date is valid
        } catch (DateTimeParseException e) {
            return false;  // The date is invalid, i.e., it can't be parsed
        }
    }
}
