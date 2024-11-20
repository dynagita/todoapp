package com.example.todoapp.application.responses;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for returning into generic response, filled when something is not ok on request.
 */
public class Error {
    private String code;
    private List<ErrorDetail> details;

    /**
     * Create a new Error
     */
    public Error(){
        details = new ArrayList<ErrorDetail>();
    }

    /**
     * Create a new error
     * @param code
     * @param details
     */
    public Error(String code, List<ErrorDetail> details) {
        this.code = code;
        this.details = details;
    }

    /**
     * Get error code
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * Get error details
     * @return
     */
    public List<ErrorDetail> getDetails() {
        return details;
    }

}
