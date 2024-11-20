package com.example.todoapp.application.responses;

/**
 * Class for detailing requests errors
 */
public class ErrorDetail {
    private String field;
    private String message;

    /**
     * Create a new ErrorDetail
     */
    public ErrorDetail(){
    }

    /**
     * Create a new error detail
     * @param field
     * @param message
     */
    public ErrorDetail(String field, String message) {
        this.field = field;
        this.message = message;
    }

    /**
     * Create a new error detail
     * @param message
     */
    public ErrorDetail(String message) {
        this.message = message;
        this.field = "N/A";
    }

    /**
     * Get field on error
     * @return
     */
    public String getField() {
        return field;
    }

    /**
     * Get detailed error message
     * @return
     */
    public String getMessage() {
        return message;
    }
}
