package com.aw.biz;

import java.io.UnsupportedEncodingException;

public class EcodingUtil {

	public static String transform(String str){
		if(null!=str && !"".equals(str)){
			try {
				str = new String(str.getBytes("iso8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
}
