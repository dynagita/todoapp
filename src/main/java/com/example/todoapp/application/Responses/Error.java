package com.example.todoapp.application.Responses;

import java.util.ArrayList;
import java.util.List;

public class Error {
    private String code;
    private List<ErrorDetail> details;

    public Error(){
        details = new ArrayList<ErrorDetail>();
    }

    public Error(String code, List<ErrorDetail> details) {
        this.code = code;
        this.details = details;
    }

    public String getCode() {
        return code;
    }

    public List<ErrorDetail> getDetails() {
        return details;
    }

}
