package com.entities;

import java.util.UUID;

public class User {
	protected String id;
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

	public String generateDb()
	{
		String uniqueID = UUID.randomUUID().toString();
		return uniqueID;
	}
	public String getId() {
		return this.id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getEmail(){ return this.email;}

	public String getPassword() {
		return password;
	}
}
