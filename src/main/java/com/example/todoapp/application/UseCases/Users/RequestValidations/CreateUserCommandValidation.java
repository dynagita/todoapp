package com.example.todoapp.application.UseCases.Users.RequestValidations;

import br.com.fluentvalidator.AbstractValidator;
import com.example.todoapp.Utils.Constants.Messages;
import com.example.todoapp.application.UseCases.Users.CreateUser.CreateUserCommand;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static br.com.fluentvalidator.predicate.ComparablePredicate.lessThan;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.*;

public class CreateUserCommandValidation extends AbstractValidator<CreateUserCommand> {
    @Override
    public void rules() {
        ruleFor(CreateUserCommand::getName)
                .must(not(nullValue()))
                .withFieldName("name")
                .withMessage(Messages.REQUIRED_PROPERTY);

        ruleFor(CreateUserCommand::getLastName)
                .must(not(nullValue()))
                .withFieldName("lastName")
                .withMessage(Messages.REQUIRED_PROPERTY>);

        Date minDate = Date.from(LocalDate
                .now()
                .minusYears(10)
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant());

        ruleFor(CreateUserCommand::getBornDate)
                .must(lessThan(minDate))
                .withFieldName("bornDate")
                .withMessage(Messages.MIN_AGE_FOR_REGISTERING);

        ruleFor(CreateUserCommand::getEmail)
                .must(stringMatches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
                .withFieldName("email")
                .withMessage(Messages.E_MAIL_MUST_BE_VALID);

        ruleFor(CreateUserCommand::getPhoneNumber)
                .must(stringMatches("([+55]{3})([(]?[0]?[1-9]{2}[)]?)[9]?([1-9]{4})-?([0-9]{4})\n"))
                .withFieldName("phoneNumber")
                .withMessage(Messages.BRAZILIAN_NUMBER_REQUIRED);
    }
}
