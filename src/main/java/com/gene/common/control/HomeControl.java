package com.gene.common.control;

import java.util.ArrayList;
import java.util.List;
import com.gene.domain.Menu;
import com.gene.plugin.ioc.Autowired;
import com.gene.ui.domain.MenuUI;
import com.jfinal.core.Controller;

public class HomeControl extends Controller {

	@Autowired
	private Menu menu;

	public void toHome() {
		// 得到一级菜单的列表
		List<Menu> list = menu.dao().getAllMenuRoot();
		List<Menu> menuList = new ArrayList<Menu>(list);
		setAttr("menuList", menuList);
		render("/view/index.html");
	}

	/**
	 * 由一级菜单的ID，得到此一级菜单的树型菜单
	 ***/
	public void getTreeMenu() {
		Integer treeId = getParaToInt(0);
		if (treeId == null) {
			renderJson("系统异常");
			return;
		}
		MenuUI[] menuui = menu.dao().getTreeMenu(treeId);
		renderJson(menuui);
	}

}
