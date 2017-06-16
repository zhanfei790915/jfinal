package com.gene.common.config;

import org.beetl.core.GroupTemplate;
import org.beetl.ext.jfinal3.JFinal3BeetlRenderFactory;
import com.gene.domain.Dict;
import com.gene.domain.Menu;
import com.gene.domain.Org;
import com.gene.domain.User;
import com.gene.interceptor.LoginInterceptor;
import com.gene.plugin.ioc.AutowiredInterceptor;
import com.gene.plugin.ioc.Ioc;
import com.gene.route.BaseRoute;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.template.Engine;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
public class MainConfig extends JFinalConfig {
	/**
	 * 配置JFinal常量
	 **/
	@Override
	public void configConstant(Constants me) {
		// 读取数据库配置文件
		PropKit.use("config.properties");
		// 设置当前是否为开发模式
		me.setDevMode(PropKit.getBoolean("devMode"));
		// 设置默认上传文件保存路径 getFile等使用
		me.setBaseUploadPath("upload/temp/");
		// 设置上传最大限制尺寸
		// me.setMaxPostSize(1024*1024*10);
		// 设置默认下载文件路径 renderFile使用
		me.setBaseDownloadPath("download");
		// 设置默认视图渲染工厂
		JFinal3BeetlRenderFactory rf = new JFinal3BeetlRenderFactory();
		rf.config();
		me.setRenderFactory(rf);
		GroupTemplate gt = rf.groupTemplate;
		gt.getConf();
		// 设置404渲染视图
		me.setError404View("404.html");
	}
	/**
	 * 配置JFinal路由映射
	 */
	@Override
	public void configRoute(Routes me) {
		// 基本登陆和首页的路由映射
		me.add(new BaseRoute());
	}
	/**
	 * 配置JFinal插件 数据库连接池 ORM 缓存等插件 自定义插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		//配置数据库连接池c3p0插件[jfinal3.0自身预置了7个插件,分别是activerecord、auth、c3p0、cron4j、druid、ehcache、redis]
		C3p0Plugin dbPlugin = new C3p0Plugin(PropKit.get("jdbcUrl"),PropKit.get("user"), PropKit.get("password"));
//		DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"),PropKit.get("user"), PropKit.get("password"));
		me.add(dbPlugin);
		//配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dbPlugin);
		arp.setShowSql(PropKit.getBoolean("devMode"));
		me.add(arp);
		//将对象users加入数据源映射
		arp.addMapping("users", User.class);
		arp.addMapping("org", Org.class);
		arp.addMapping("menu", Menu.class);
		arp.addMapping("dict", Dict.class);
		//配置EHcache
		me.add(new EhCachePlugin());
		//配置IOC
		Ioc ioc = Ioc.getIoc();
		me.add(ioc);
		ioc.addPackage("com.gene.domain",true);
	}
	/**
	 * 配置全局拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		//登陆验证拦截器,访问系统所有资源必须验证用户是否成功登陆,除toLogin toRegist等
		me.addGlobalActionInterceptor(new LoginInterceptor());
		//用于实现在控制器拦截IOC的业务
		me.addGlobalActionInterceptor(new AutowiredInterceptor());
	}

	/**
	 * 配置全局处理器
	 */
	@Override
	public void configHandler(Handlers me) {
	}
	/**
	 * JFinal启动后调用
	 */
	@Override
	public void afterJFinalStart() {
	}
	/**
	 * JFinal Stop之前调用
	 */
	@Override
	public void beforeJFinalStop() {
	}
	/**
	 * 配置模板引擎
	 */
	@Override
	public void configEngine(Engine me) {
		// 这里只有选择JFinal TPL的时候才用
		// 配置共享函数模板
		// me.addSharedFunction("/view/common/layout.html")
	}
	public static void main(String[] args) {
		JFinal.start("src/main/webapp", 81, "/", 5);
	}

}
