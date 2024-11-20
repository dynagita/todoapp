package com.example.todoapp.utils.enums;

/**
 * Response status enum
 */
public enum ResponseStatus {
    ERROR,
    SUCCESS,
    NOT_FOUND,
    INTERNAL_SERVER_ERROR;

    public String getResponseStatus(){
        return this.name();
    }
}
