package com.example.demo.utils;


/**
 * 字符串工具类
 * @author
 *
 */
public class StringUtil {

	public static String joinString(String ... args) {
		StringBuffer stringBuffer = new StringBuffer();
		for (String str : args) {
			stringBuffer.append(str);
		}
		return stringBuffer.toString();

	}


}