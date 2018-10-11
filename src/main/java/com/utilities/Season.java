package com.utilities;

public enum Season{
	FALL("Fall"),
	WINTER("Winter"),
	SPRING("Spring"),
	SUMMER("Summer")
	;
	private String name;

	Season(final String name) {
		this.name = name;
	}
}