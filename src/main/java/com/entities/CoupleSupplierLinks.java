package com.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoupleSupplierLinks {
	//this map is to represent links between couple and supplier
	// key: string: will be userId of Couple
	// value: list of string: userId of supplier
	Map<String, List<String>> map = new HashMap<>();

}
