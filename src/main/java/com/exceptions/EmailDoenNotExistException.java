package com.exceptions;

public class EmailDoenNotExistException extends Exception {
    public EmailDoenNotExistException(){}

    @Override
    public String getMessage() {
        return "Email Does Not Exist!";
    }
}
