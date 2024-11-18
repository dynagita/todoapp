package com.example.todoapp.api.Middlewares;

import com.example.todoapp.application.Responses.ErrorDetail;
import com.example.todoapp.application.Responses.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Response<?>> handleValidationException(ConstraintViolationException ex) {
        List<String> errors = ex.getConstraintViolations().stream()
                .map(violation -> violation.getMessage())
                .collect(Collectors.toList());

        var details = new ArrayList<ErrorDetail>();
        errors.forEach(error ->{
            details.add(new ErrorDetail("/NA", error));
        });
        var response = Response.<String>ProducessBadRequestResult(details);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<ErrorDetail> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new ErrorDetail(fieldError.getField(), fieldError.getDefaultMessage()))  // Including field name
                .collect(Collectors.toList());



        var response = Response.<String>ProducessBadRequestResult(errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<String>> handleGenericException(Exception ex) {
        /*
                //Loggin
                List.of(ex.getMessage())
        */
        if(ex.getClass() == HttpMessageNotReadableException.class){
            var details = new ArrayList<ErrorDetail>();
            details.add(new ErrorDetail("N/A", ex.getMessage()));
            return new ResponseEntity<>(Response.<String>ProducessBadRequestResult(details), HttpStatus.BAD_REQUEST);
        }

        var response = Response.<String>ProduceInternalServerErrorResult();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}