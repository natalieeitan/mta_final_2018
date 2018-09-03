package com.exceptions;

public class EmailDoesNotExistException extends Exception {
    public EmailDoesNotExistException(){}

    @Override
    public String getMessage() {
        return "Email Does Not Exist!";
    }
}
