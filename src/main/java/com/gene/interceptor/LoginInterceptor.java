package com.gene.interceptor;

import java.util.ArrayList;

import com.gene.domain.User;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class LoginInterceptor implements Interceptor {
	public static ArrayList<String> excludes = new ArrayList<String>();
	static {
		excludes.add("/toLogin");
		excludes.add("/toRegist");
		excludes.add("/org/getAllOrgTree");
		excludes.add("/regist");
		excludes.add("/doLogout");
	}

	public void intercept(Invocation inv) {
		if (excludes.contains(inv.getActionKey())) {
			inv.invoke();
		}else{
			User user = (User) inv.getController().getSessionAttr("user");
			if (user == null) {
				inv.getController().redirect("/toLogin");
			} else {
				inv.invoke();
			}
		}
	}
}
