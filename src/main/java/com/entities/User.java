package com.entities;

import com.utilities.UserType;

import java.util.UUID;

public class User {
	protected String id;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String password;
	protected boolean emailVerified;
	protected UserType type;

	public User(String ID, String firstName, String lastName, String email, String password) {
		this.id=ID;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		emailVerified=false;
	}

	public User(String firstName, String lastName, String email, String password) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		emailVerified=false;
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

	public String getFirstName(){return this.firstName;}

	public void setFirstName(String FirstName)
	{
		this.firstName = FirstName;
	}

	public String getLastName(){return this.lastName;}

	public void setLastName(String LastName)
	{
		this.lastName = LastName;
	}

	public String getEmail(){ return this.email;}

	public void setEmail(String Email)
	{
		this.email = Email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String Password) {
		this.password=Password;
	}

	public Integer getEmailVerified() { return (emailVerified ? 1:0);}

	public void setEmailVerified(Integer isVerified){
		if(isVerified==1) {
            this.emailVerified=true;
        } else
			this.emailVerified=false;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}
}
