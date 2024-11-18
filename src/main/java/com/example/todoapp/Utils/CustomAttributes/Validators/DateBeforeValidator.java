package com.example.todoapp.Utils.CustomAttributes.Validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateBeforeValidator implements ConstraintValidator<DateBefore, LocalDate> {

    Integer minimalAge;

    @Override
    public void initialize(DateBefore constraintAnnotation) {
        try {
            minimalAge = Integer.parseInt(constraintAnnotation.value());
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format for 'value' in @DateBefore annotation. Use yyyy-MM-dd.");
        }
    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {

        var minDate = LocalDate
                .now()
                .minusYears(minimalAge);
        return date != null && date.isBefore(minDate);
    }
}