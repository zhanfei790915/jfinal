package com.gene.common.control;

import com.gene.domain.Org;
import com.gene.plugin.ioc.Autowired;
import com.gene.ui.domain.OrgUI;
import com.jfinal.core.Controller;

public class OrgControl extends Controller{

	@Autowired
	private Org org;
	
	/**
	 * 得到所有单位的树型结构
	 * */
	public void getAllOrgTree(){
		OrgUI[] orgs = org.getOrgTree(0);
		renderJson(orgs);
	}
}