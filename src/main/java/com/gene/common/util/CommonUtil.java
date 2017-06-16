package com.gene.common.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommonUtil {
	public static final String DS_MAIN = "main";
	public static final String DS_EOVA = "eova";

	public static boolean isEmpty(Object o) {
		if (o == null) {
			return true;
		}
		if ((o instanceof String)) {
			if (o.toString().trim().equals(""))
				return true;
		} else if ((o instanceof List)) {
			if (((List<?>) o).size() == 0)
				return true;
		} else if ((o instanceof Map)) {
			if (((Map<?, ?>) o).size() == 0)
				return true;
		} else if ((o instanceof Set)) {
			if (((Set<?>) o).size() == 0)
				return true;
		} else if ((o instanceof Object[])) {
			if (((Object[]) o).length == 0)
				return true;
		} else if ((o instanceof int[])) {
			if (((int[]) o).length == 0)
				return true;
		} else if (((o instanceof long[])) && (((long[]) o).length == 0)) {
			return true;
		}

		return false;
	}

	public static boolean isOneEmpty(Object[] os) {
		Object[] arrayOfObject = os;
		int j = os.length;
		for (int i = 0; i < j; i++) {
			Object o = arrayOfObject[i];
			if (isEmpty(o)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isAllEmpty(Object[] os) {
		Object[] arrayOfObject = os;
		int j = os.length;
		for (int i = 0; i < j; i++) {
			Object o = arrayOfObject[i];
			if (!isEmpty(o)) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNum(Object obj) {
		try {
			Integer.parseInt(obj.toString());
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean isFalse(Object str) {
		if ((isEmpty(str)) || (str.toString().trim().equalsIgnoreCase("false"))) {
			return true;
		}
		return false;
	}

	public static String format(Object str) {
		return "'" + str.toString() + "'";
	}

	public static int toInt(Object obj) {
		return Integer.parseInt(obj.toString());
	}

	public static int toInt(Object obj, int defaultValue) {
		if (isEmpty(obj)) {
			return defaultValue;
		}
		return toInt(obj);
	}

	public static long toLong(Object obj) {
		return Long.parseLong(obj.toString());
	}

	public static long toLong(Object obj, long defaultValue) {
		if (isEmpty(obj)) {
			return defaultValue;
		}
		return toLong(obj);
	}

	public static double toDouble(Object obj) {
		return Double.parseDouble(obj.toString());
	}

	public static Boolean toBoolean(Object obj) {
		return Boolean.valueOf(Boolean.parseBoolean(obj.toString()));
	}

	public static Boolean toBoolean(Object obj, Boolean defaultValue) {
		if (isEmpty(obj)) {
			return defaultValue;
		}
		return toBoolean(obj);
	}

	public static String join(Object[] array, char sign) {
		if (array == null) {
			return null;
		}
		int arraySize = array.length;
		int bufSize = arraySize == 0 ? 0 : ((array[0] == null ? 16 : array[0]
				.toString().length()) + 1) * arraySize;
		StringBuilder sb = new StringBuilder(bufSize);

		for (int i = 0; i < arraySize; i++) {
			if (i > 0) {
				sb.append(sign);
			}
			if (array[i] != null) {
				sb.append(array[i]);
			}
		}
		return sb.toString();
	}

	public static String delEnd(String str, String sign) {
		if (str.endsWith(sign)) {
			return str.substring(0, str.lastIndexOf(sign));
		}
		return str;
	}
}