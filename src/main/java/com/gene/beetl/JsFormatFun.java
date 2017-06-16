package com.gene.beetl;

import org.beetl.core.Context;
import org.beetl.core.Function;

import com.gene.common.util.TypeUtil;

public class JsFormatFun implements Function{
	@Override
	public Object call(Object[] arg0, Context arg1) {
		 if (arg0.length != 1) {
		      throw new RuntimeException("参数错误，期望Object");
		    }
		    Object obj = arg0[0];
		    if (TypeUtil.isEmpty(obj)) {
		      return "undefined";
		    }
		    if (TypeUtil.isNum(obj)) {
		      return obj.toString();
		    }
		    return TypeUtil.format(obj);
	}
}
