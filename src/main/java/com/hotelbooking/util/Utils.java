package com.hotelbooking.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils implements Serializable {

	private static final long serialVersionUID = -9058103104198899675L;

	private static final Logger logger = LoggerFactory.getLogger(Utils.class);

	public static String getValidString(String str) {
		return ((null == str) ? StringConstants.EMPTY : str.trim());
	}

	public static boolean isEmpty(String str) {
		return (((null == str) || (str.trim().isEmpty())) ? true : false);
	}

	public static boolean isNotEmpty(String str) {
		return !(isEmpty(str));
	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(List list) {
		return (((null == list) || (list.isEmpty())) ? true : false);
	}

	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(List list) {
		return !(isEmpty(list));
	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(ArrayList arrList) {
		return (((null == arrList) || (arrList.isEmpty())) ? true : false);
	}

	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(ArrayList arrList) {
		return !(isEmpty(arrList));
	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Map map) {
		return (((null == map) || (map.isEmpty())) ? true : false);
	}

	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(Map map) {
		return !(isEmpty(map));
	}

}
