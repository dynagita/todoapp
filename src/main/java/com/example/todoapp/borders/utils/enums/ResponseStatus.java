package com.example.todoapp.borders.utils.enums;

/**
 * Response status enum
 */
public enum ResponseStatus {
    ERROR,
    SUCCESS,
    NOT_FOUND,
    ERROR_CONFLICT,
    INTERNAL_SERVER_ERROR;

    public String getResponseStatus(){
        return this.name();
    }
}
