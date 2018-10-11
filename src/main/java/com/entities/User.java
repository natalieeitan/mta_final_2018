package com.entities;

import com.utilities.UserType;

import java.util.UUID;

public class User {
	protected String id;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String password;
	protected UserType type;

	public User(String ID, String firstName, String lastName, String email, String password) {
		this.id = ID;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}

	public User(String firstName, String lastName, String email, String password, UserType type) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.type=type;
		this.id = generateDb();
	}

	public User(String ID, String firstName, String lastName, String email, String password, UserType type) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.type=type;
		this.id = ID;
	}



	public User(User user) {
		this.email = user.getEmail();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.password = user.getPassword();
		this.id = user.getId();
		this.type = user.getType();
	}

	public User() {
		this.email = "";
		this.firstName = "";
		this.lastName = "";
		this.password = "";
		this.id = "";
		this.type = null;

	}

	public String generateDb() {
		String uniqueID = UUID.randomUUID().toString();
		return uniqueID;
	}

	public String getId() {
		return this.id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String FirstName) {
		this.firstName = FirstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String LastName) {
		this.lastName = LastName;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return password;
	}

	public UserType getType() {
		return type;
	}

}
