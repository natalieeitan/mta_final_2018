package com.utilities;

import com.entities.User;

public enum UserType {
	Couple("Couple", 1),
	Supplier("Supplier", 2)
	;

	private String name;
	private int bitValue;

	UserType(final String name, int bit) {
		this.name = name;
		this.bitValue=bit;
	}

	public String getName() {
		return name;
	}
	public int getBitValue(){return bitValue;}

	public UserType translateIntToType(int value)
    {
        UserType userType=null;

        for(UserType type:UserType.values())
        {
            if((type.getBitValue()&value)>0)
            {
                userType=type;
                break;
            }
        }

        return userType;
    }
}
