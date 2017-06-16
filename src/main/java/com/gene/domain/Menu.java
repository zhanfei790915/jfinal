package com.gene.domain;

import java.util.List;
import com.gene.plugin.ioc.Service;
import com.gene.ui.domain.MenuUI;
import com.jfinal.plugin.activerecord.Model;
@Service
public class Menu extends Model<Menu>{


	private static final long serialVersionUID = 1L;
	/**
	 * 找到所有一级菜单数据
	 */
	public List<Menu> getAllMenuRoot(){
		return find("select * from menu where pid=0");
	}
	
	/**
	 *由一级菜单得到此一级菜单下的树型菜单 
	 **/
	public MenuUI[] getTreeMenu(Integer treeId){
		List<Menu> menuList  = find("select * from menu where pid="+treeId.intValue()+"");
		int i = 0;
		MenuUI[] menuUIs = new MenuUI[menuList.size()];
		for (final Menu m : menuList) {
			Integer id = m.getInt("id");
			menuUIs[i] = new MenuUI();
			menuUIs[i].setId(id.toString());
			menuUIs[i].setText(m.getStr("name").toString());
			menuUIs[i].setChildren(getTreeMenu(m.getInt("id")));
			i ++;
		}
		return menuUIs;
	}

}
