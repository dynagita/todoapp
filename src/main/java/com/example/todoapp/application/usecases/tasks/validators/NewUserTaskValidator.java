package com.example.todoapp.application.usecases.tasks.validators;

import com.example.todoapp.borders.models.Task;
import com.example.todoapp.borders.utils.constants.Messages;
import com.example.todoapp.borders.utils.validator.BaseValidator;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;

public class NewUserTaskValidator extends BaseValidator<Task> {
    @Override
    public void rules() {
        this.ruleFor(x -> x)
                .must(nullValue())
                .withFieldName("task")
                .withMessage(Messages.ERROR_CONFLICT);
    }
}
