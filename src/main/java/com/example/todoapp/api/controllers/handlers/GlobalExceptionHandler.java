package com.example.todoapp.api.controllers.handlers;

import com.example.todoapp.borders.responses.ErrorDetail;
import com.example.todoapp.borders.responses.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This is a handler for collect and log error requests
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Collect constraint violations and set the bad request response
     * @param ex exception thrown
     * @return Corrected response
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Response> handleValidationException(ConstraintViolationException ex) {

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

    /**
     * Collect arguments violations and set the bad request response
     * @param ex exception thrown
     * @return Corrected response
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        List<ErrorDetail> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new ErrorDetail(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        var response = Response.<String>ProducessBadRequestResult(errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * Collect all exceptions not handled and set to bad request response
     * @param ex exception thrown
     * @return Corrected response
     */
    // Handle generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleGenericException(Exception ex) {

        if(ex.getClass() == HttpMessageNotReadableException.class){
            var details = new ArrayList<ErrorDetail>();
            details.add(new ErrorDetail("N/A", ex.getMessage()));
            return new ResponseEntity<>(Response.<String>ProducessBadRequestResult(details), HttpStatus.BAD_REQUEST);
        }

        var response = Response.<String>ProduceInternalServerErrorResult();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}