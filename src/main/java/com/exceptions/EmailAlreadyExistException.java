package com.exceptions;

/**
 * Created by natalieeitan on 31/05/2018.
 */
public class EmailAlreadyExistException extends Exception {
	public EmailAlreadyExistException(String message){
		super(message);
	}
}
