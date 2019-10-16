package com.threeatom.util;

public class ValidateUtil {

	
	public static void validateNotNull(Object arg,String argname) throws IllegalArgumentException{
		if(arg==null) {
			throw new IllegalArgumentException(String.format("[%s] should not be null", argname));
		}
	}
}
