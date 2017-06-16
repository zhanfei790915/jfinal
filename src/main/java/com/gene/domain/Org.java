package com.gene.domain;

import java.util.List;

import com.gene.plugin.ioc.Service;
import com.gene.ui.domain.OrgUI;
import com.jfinal.plugin.activerecord.Model;

@Service
public class Org extends Model<Org>{

	/**
	 * 单位DAO
	 */
	private static final long serialVersionUID = 1L;
	
	/***
	 * 根据传入的父节点ID得到该父节点下面所有单位的树型结构
	 * 如果想得到所有单位的树型结构,调用时请传结点treeID为0
	 * */
	public OrgUI[] getOrgTree(Integer treeId){
		List<Org> orgList  = find("select * from org where pid="+treeId.intValue()+"");
		int i = 0;
		OrgUI[] orgUIs = new OrgUI[orgList.size()];
		for (final Org o : orgList) {
			Integer id = o.getInt("id");
			orgUIs[i] = new OrgUI();
			orgUIs[i].setId(id.toString());
			orgUIs[i].setText(o.getStr("name").toString());
			orgUIs[i].setChildren(getOrgTree(o.getInt("id")));
			i ++;
		}
		return orgUIs;
	}
}
