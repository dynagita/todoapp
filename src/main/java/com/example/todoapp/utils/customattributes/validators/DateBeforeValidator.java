package com.example.todoapp.utils.customattributes.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * DateBeforeValidator is used to validate dates before a period as params
 */
public class DateBeforeValidator implements ConstraintValidator<DateBefore, LocalDate> {

    Integer minimalAge;

    /**
     * Initialize properties
     * @param constraintAnnotation
     */
    @Override
    public void initialize(DateBefore constraintAnnotation) {
        try {
            minimalAge = Integer.parseInt(constraintAnnotation.value());
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format for 'value' in @DateBefore annotation. Use yyyy-MM-dd.");
        }
    }

    /**
     * Validate date with time in years
     * @param date
     * @param context
     * @return
     */
    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {

        var minDate = LocalDate
                .now()
                .minusYears(minimalAge);
        return date != null && date.isBefore(minDate);
    }
}