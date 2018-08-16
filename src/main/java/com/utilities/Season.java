package com.utilities;

/**
 * Created by natalieeitan on 09/04/2018.
 */
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