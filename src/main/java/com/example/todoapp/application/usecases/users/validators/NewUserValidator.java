package com.example.todoapp.application.usecases.users.validators;

import com.example.todoapp.borders.models.User;
import com.example.todoapp.borders.utils.constants.Messages;
import com.example.todoapp.borders.utils.validator.BaseValidator;

import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;

/**
 * Validator to check if user already exists
 */
public class NewUserValidator extends BaseValidator<User> {

    /***
     * Define rules for existent user
     */
    @Override
    public void rules() {
        this.ruleFor(x -> x)
                .must(nullValue())
                .withFieldName("email")
                .withMessage(Messages.ERROR_CONFLICT);
    }
}
