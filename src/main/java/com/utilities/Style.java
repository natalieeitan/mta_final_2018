package com.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Style {
	RURAL("כפרי", 1),
	CLASSIC("קלאסי", 2),
	URBAN("אורבני", 4);
	private String name;
	private int bitValue;

	Style(final String name, final int bit) {
		this.name = name;
		this.bitValue = bit;
	}

	public String getName() {
		return name;
	}

	public int getBitValue() {
		return bitValue;
	}

	public static String convertBitsToStyleList(int styles) {
		String stylesString = "";
		for (Style style : Style.values()) {
			if ((style.getBitValue() & styles) > 0) {
				stylesString = stylesString + style.getName()+", ";
			}
		}
		if(stylesString.endsWith(", ")){
			stylesString = stylesString.substring(0,stylesString.length() - 2);
		}
		return stylesString;
	}

	public static int ConvertStyleListToBits(List<Style> styleList) {
		int result = 0;
		for (Style style : styleList) {
			result += style.getBitValue();
		}
		return result;
	}

	public static int convertStringArrayStyleToBits(String[] stylesStr) {
		List<Style> stylesList = new ArrayList<>();
		for (String style : stylesStr) {
			stylesList.add(Style.valueOf(style));
		}
		return ConvertStyleListToBits(stylesList);
	}

	public static Style getStyleByInt(int style) {
		return Arrays.stream(values())
				.filter(a -> a.getBitValue() == style)
				.findFirst()
				.orElse(null);
	}

}