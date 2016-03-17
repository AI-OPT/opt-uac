
package com.ai.opt.uac.util;
import java.util.regex.Pattern;

public final class RegexUtils {
	private static final String phoneRegex = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0-9]))\\d{8}$";
	private static final String emailRegex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
	
	private RegexUtils(){}
	
	public static boolean checkIsPhone(String str){
		return Pattern.matches(phoneRegex, str);
	}
	
	public static boolean checkIsEmail(String str){
		return Pattern.matches(emailRegex, str);
	}
	
}
