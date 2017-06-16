package com.gene.common.control;

import com.gene.domain.User;
import com.gene.plugin.ioc.Autowired;
import com.gene.validator.LoginValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

public class LoginControl extends Controller {
	@Autowired
	private User user;

	@Before(LoginValidator.class)
	/**
	 * 到登陆界面
	 * */
	public void toLogin() {
		User user = getSessionAttr("user");
		if (user == null) {
			render("/view/login.html");
		} else {
			redirect("/home/toHome");
		}
	}

	/**
	 * 做登陆动作
	 * */
	public void doLogin() {
		redirect("/home/toHome");
	}

	/**
	 * 到首页内容部分
	 * */
	public void toProtal() {
		render("/view/protal.html");
	}

	/**
	 * 到首页标题栏
	 * */
	public void toHeader() {
		User user = (User) getSessionAttr("user");
		setAttr("user", user);
		render("/view/header.html");
	}

	/**
	 * 到用户修改密码界面
	 * */
	public void toUpdatePwd() {
		User user = (User) getSessionAttr("user");
		setAttr("user", user);
		render("/view/updatePwd.html");
	}

	/**
	 * 做修改密码操作
	 * */
	public void updatePwd() {
		User user = getSessionAttr("user");
		user.updatePwd(user.get("loginID").toString(), getPara("password"));
		redirect("/home/toHome");
	}

	/**
	 * 到注册界面
	 * */
	public void toRegist() {
		// 由Ioc的get方法来得到需要的BEAN
		// Org org = (Org)Ioc.getBean(Org.class);
		// List<Org> orgs = org.dao().find("select * from org");
		// setAttr("orgs", orgs1);
		render("/view/register.html");
	}

	/**
	 * 做注册操作
	 * */
	public void regist() {
		boolean isSu = user.set("loginID", getPara("loginid"))
				.set("loginName", "").set("password", getPara("loginpwd"))
				.set("orgid", getPara("regOrg")).set("roleid", 1)
				.set("stat", 1).save();
		if (isSu) {
			setSessionAttr("user", user);
			redirect("/home/toHome");
		} else {
			setAttr("msg", "注册失败!");
			redirect("/view/register.html");
		}
	}

	/**
	 * 做用户注销操作
	 * */
	public void doLogout() {
		setSessionAttr("user", null);
		doLogin();
	}
}
