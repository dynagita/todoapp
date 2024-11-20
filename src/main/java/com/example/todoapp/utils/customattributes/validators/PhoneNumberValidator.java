package com.example.todoapp.utils.customattributes.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {
    private Pattern pattern;
    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        try {
            pattern = Pattern.compile(constraintAnnotation.regexPattern());
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid regex for 'regexPattern' in @PhoneNumber annotation. Use a valid regex");
        }
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
