package com.example.todoapp.borders.utils.validator;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.context.ValidationResult;
import com.example.todoapp.borders.responses.ErrorDetail;

import java.util.List;

public abstract class BaseValidator<T> extends AbstractValidator<T> {
    private List<ErrorDetail> errors;

    public List<ErrorDetail> getErrorsDetail(ValidationResult validation){
        return validation
                .getErrors()
                .stream()
                .map(x -> new ErrorDetail(x.getField(), x.getMessage()))
                .toList();
    }
}
