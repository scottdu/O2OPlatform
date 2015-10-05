package com.o2o.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	
	public static boolean isEmpty(String input) {
		if(input == null)
			return true;
		return "".equals(input);
	}
	
	public static boolean isBlank(String input) {
		if(isEmpty(input)) {
			return true;
		}
		return "".equals(input.trim());
	}
	
	public static boolean isEmail(String input) {
		if(isEmpty(input) || isBlank(input)) {
			return false;
		}
		Pattern p =  Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Matcher m = p.matcher(input);  
        return m.matches();  
	}
	
	public static boolean isMobile(String input) {
		if(isEmpty(input) || isBlank(input)) {
			return false;
		}
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(input);  
        return m.matches();  
	}
}
