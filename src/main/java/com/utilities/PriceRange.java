package com.utilities;

import java.util.Arrays;

public enum PriceRange {
	NO_RANGE("עוד לא גיבשנו תקציב", 1),
	ONE_FIFTY("151-200", 2),
	TWO_HUNDRED("201-250", 4),
	TWO_FIFTY("251-300", 8),
	THREE_HUNDRED("301-350", 16),
	THREE_FIFTY("351-400", 32),
	FOUR_HUNDRED("401-450", 64),
	FOUR_FIFTY("451-500", 128),
	FIVE_HUNDRED("יותר מ-500", 256);
	private String name;
	private int bitValue;

	PriceRange(final String name, int bit) {
		this.name = name;
		this.bitValue = bit;
	}

	public String getName() {
		return name;
	}

	public int getBitValue() {
		return bitValue;
	}

	//    public static PriceRange convertBitsToPriceRange(int value) {
	//        for (PriceRange pr : PriceRange.values()) {
	//            if ((pr.getBitValue() & value) > 0)
	//                return pr;
	//        }
	//
	//        return PriceRange.NO_RANGE;
	//    }

	public int getBottomValue() {
		if (this.equals(NO_RANGE)) {
			return 0;
		}
		if (this.equals(FIVE_HUNDRED)) {
			return 500;
		}

		String bottomString = getName().substring(0, 3);
		return Integer.parseInt(bottomString);
	}

	public int getTopValue() {
		if (this.equals(NO_RANGE)) {
			return 5000;
		}

		if (this.equals(FIVE_HUNDRED)) {
			return 5000;
		}

		String topString = getName().substring(4, 7);
		return Integer.parseInt(topString);
	}
	//
	//    public boolean checkIfPriceDoesNotExceedFromRange(int price){
	//        if(this.name.equals(NO_RANGE.getName())){
	//            return true;}
	//
	//        if((price>this.getTopValue())){
	//            return false;}
	//
	//        return true;
	//    }

	public boolean checkIfPriceIsInRange(int price) {

		if ((price >= this.getBottomValue()) && (price <= this.getTopValue())) {
			return true;
		}

		return false;
	}

	public static PriceRange convertIntToPriceRange(int value) {
		for (PriceRange pr : PriceRange.values()) {
			if (pr.checkIfPriceIsInRange(value)) {
				return pr;
			}
		}

		return PriceRange.NO_RANGE;
	}

	public static PriceRange getPrinceRangeByInt(int priceRange) {
		return Arrays.stream(values())
				.filter(a -> a.getBitValue() == priceRange)
				.findFirst()
				.orElse(null);
	}
}