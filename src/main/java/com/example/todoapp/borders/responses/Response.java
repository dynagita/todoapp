package com.example.todoapp.borders.responses;

import com.example.todoapp.borders.utils.constants.ErrorResponseCodes;
import com.example.todoapp.borders.utils.constants.Messages;
import com.example.todoapp.borders.utils.enums.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a class for normalizing API's response.
 */
public class Response<T> {
    private T data;

    private ResponseStatus status;
    private Error error;
    private String message;

    /**
     * Create a new Response
     */
    public Response() {

    }

    /**
     * Get data attribute
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * Set data attribute
     * @param data
     */
    private void setData(T data) {
        this.data = data;
    }

    /**
     * Get status attribute
     * @return status
     */
    public ResponseStatus getStatus() {
        return status;
    }

    /**
     * Set status attribute
     * @param status
     */
    private void setStatus(ResponseStatus status) {
        this.status = status;
    }

    /**
     * Get error attribute
     * @return error
     */
    public Error getError() {
        return error;
    }

    /**
     * Set error attribute
     * @param error
     */
    private void setError(Error error) {
        this.error = error;
    }

    /**
     * Get message attribute
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set message attribute
     * @param message
     */
    private void setMessage(String message) {
        this.message = message;
    }

    /**
     * Create response error
     * @param responseCode ResponseCode you wish to inform requester
     * @param errorDetails Errors detail you wish to inform requester
     * @return
     */
    private void CreateError(String responseCode, List<ErrorDetail> errorDetails) {
        setError(new Error(responseCode, errorDetails));
    }

    public Boolean hasError(){
        return error != null;
    }

    /**
     * Produce a successful response
     * @param data Data you wish to return for requester
     * @return Response object, default API's response
     */
    public static <T> Response ProduceSuccessResult(T data){
        Response response = new Response();
        response.setData(data);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setMessage(Messages.SUCCESS_MESSAGE);
        return response;
    }

    /**
     * Produce a bad request response
      * @param errorDetailList List of failed field and reasons
     * @return Response object, default API's response
     */
    public static Response ProducessBadRequestResult(List<ErrorDetail> errorDetailList){
        Response response = new Response();
        response.setMessage(Messages.ERROR_REQUEST_VALIDATION);
        response.setStatus(ResponseStatus.ERROR);
        response.CreateError(ErrorResponseCodes.REQUEST_VALIDATION, errorDetailList);
        return response;
    }

    /**
     * Produce a business logic error response
     * @param errorDetailList List of failed rules you wish to notify requester
     * @return Response object, default API's response
     */
    public static Response ProducessBusinessErrorResult(List<ErrorDetail> errorDetailList){
        Response response = new Response();
        response.setMessage(Messages.ERROR_BUSINESS_VALIDATION);
        response.setStatus(ResponseStatus.ERROR);
        response.CreateError(ErrorResponseCodes.BUSINESS_VALIDATION, errorDetailList);
        return response;
    }

    /**
     * Produce an internal server error response
     * @return Response object, default API's response
     */
    public static Response ProduceInternalServerErrorResult(){
        Response response = new Response();
        response.setMessage(Messages.INTERNAL_SERVER_ERROR);
        response.setStatus(ResponseStatus.ERROR);
        List<ErrorDetail> details = new ArrayList<>();
        details.add(new ErrorDetail("N/A", Messages.INTERNAL_SERVER_ERROR));
        response.CreateError(ErrorResponseCodes.INTERNAL_ERROR, details);
        return response;
    }

    /**
     * Produce a not found response
     * @param id id not found searched
     * @return new Response for not found purpose
     */
    public static Response ProduceNotFoundResult(String field, String value){
        Response response = new Response();
        response.setMessage(Messages.NOT_FOUND);
        response.setStatus(ResponseStatus.NOT_FOUND);
        List<ErrorDetail> details = new ArrayList<>();
        details.add(new ErrorDetail(field, Messages.NOT_FOUND));
        response.CreateError(ErrorResponseCodes.NOT_FOUND, details);
        return response;
    }
}
