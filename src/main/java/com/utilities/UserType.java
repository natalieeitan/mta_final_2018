package com.utilities;

public enum UserType {
	Couple("Couple"),
	Supplier("Supplier")
	;
	private String name;

	UserType(final String name) {
		this.name = name;
	}
}
