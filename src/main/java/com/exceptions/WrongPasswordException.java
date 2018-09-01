package com.exceptions;

public class WrongPasswordException extends Exception {
    public WrongPasswordException(){}

    @Override
    public String getMessage() {
        return "Wrong Password!";
    }
}
