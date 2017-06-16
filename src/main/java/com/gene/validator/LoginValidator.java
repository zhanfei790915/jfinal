package com.gene.validator;

import com.gene.domain.User;
import com.gene.plugin.ioc.Ioc;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/***
 * 登陆验证，采用JFinal后台验证框架
 * */
public class LoginValidator extends Validator {
	@Override
	protected void validate(Controller c) {
		String loginID = c.getPara("loginid");
		String loginPWD = c.getPara("loginpwd");
		if (loginID == null) {
			addError("msg", "");
		} else {
			User user = (User)Ioc.getBean(User.class);
			user = user.dao().getUserByUserID(loginID);
			if (user == null) {
				addError("msg", "用户不存在!");
			} else if (!user.getStr("password").equals(loginPWD)) {
				addError("msg", "密码错误!");
			} else {
				c.setSessionAttr("user", user);
			}
		}
	}
	@Override
	protected void handleError(Controller c) {
		c.keepPara();
		c.render("/view/login.html");
	}

}
