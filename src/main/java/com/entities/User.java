package com.entities;

/**
 * Created by natalieeitan on 09/04/2018.
 */
public class User {
	protected int id;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String password;
	protected boolean emailVerified;

	public User(String firstName, String lastName, String email, String password) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public int getId() {
		return id;
	}
}
