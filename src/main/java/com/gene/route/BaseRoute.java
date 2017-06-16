package com.gene.route;
import com.gene.common.control.DictControl;
import com.gene.common.control.HomeControl;
import com.gene.common.control.LoginControl;
import com.gene.common.control.OrgControl;
import com.jfinal.config.Routes;
/**
 * 此方法用于登陆和首页功能的路径选择
 * */
public class BaseRoute extends Routes {

	@Override
	public void config() {
		setBaseViewPath("/");
		//登陆路径
		add("/",LoginControl.class);
//		addInterceptor(new LoginInterceptor());
		//首页路径
		add("/home",HomeControl.class);
		//单位路径
		add("/org",OrgControl.class);
		//字典路径
		add("/dict",DictControl.class);
	}
}
