package com.example.todoapp.application.Responses;

public class ErrorDetail {
    private String field;
    private String message;

    public ErrorDetail(){
    }

    public ErrorDetail(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
