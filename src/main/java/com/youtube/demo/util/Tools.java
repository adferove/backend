package com.youtube.demo.util;

public class Tools {

	public static boolean isStringNotNull(String pValue) {
		if(pValue==null || pValue.trim().equals("")) {
			return false;
		}
		return true;
	}
	
}
