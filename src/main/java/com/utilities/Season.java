package com.utilities;

/**
 * Created by natalieeitan on 09/04/2018.
 */
public enum Season{
	SUMMER("Summer"),
	SPRING("Spring"),
	WINTER("Winter"),
	FALL("fall")
	;
	private String name;

	Season(final String name) {
		this.name = name;
	}
}