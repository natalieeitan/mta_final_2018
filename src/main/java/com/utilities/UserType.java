package com.utilities;

public enum UserType {
	COUPLE("Couple"),
	SUPPLIER("Supplier")
	;

	private String name;

	UserType(final String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
