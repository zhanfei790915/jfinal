package com.gene.common.control;

import com.gene.domain.Dict;
import com.gene.plugin.ioc.Autowired;
import com.gene.ui.domain.DictUI;
import com.jfinal.core.Controller;
import com.jfinal.render.JsonRender;

public class DictControl extends Controller{
	@Autowired
	private Dict dict;

	public void toDict(){
		render("/view/dict/dict.html");
	}
	/**
	 * 得到所有字典数据
	 * */
	public void getAllDict(){
		DictUI[] dictUIs = dict.getAllDicts(getPara("page"),getPara("rows"));
		JsonRender jsonRender = new JsonRender(dictUIs);
		String rjson = jsonRender.getJsonText();
		rjson = "{\"total\":"+dict.getAllDictsCount()+",\"rows\":"+rjson+"}";
		renderJson(rjson);
	}
}
