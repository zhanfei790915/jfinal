package com.gene.domain;


import java.util.List;

import com.gene.plugin.ioc.Service;
import com.gene.ui.domain.DictUI;
import com.jfinal.plugin.activerecord.Model;
@Service
public class Dict extends Model<Dict>{

	/**
	 * 查询所有字典数据
	 */
	private static final long serialVersionUID = 1L;
	
	public int getAllDictsCount(){
		List<Dict> dicts = find("select * from dict");
		return dicts.size();
	}

	public DictUI[] getAllDicts(String page,String rows){
		int i = 0;
		int p = Integer.parseInt(page);
		int r = Integer.parseInt(rows);
		List<Dict> dicts = find("select * from dict limit "+(p-1)*r+","+r+"");
		DictUI[] dictUIs = new DictUI[dicts.size()];
		for (final Dict dict : dicts) {
			dictUIs[i] = new DictUI();
			dictUIs[i].setId(dict.getInt("id"));
			dictUIs[i].setValue(dict.getStr("value"));
			dictUIs[i].setName(dict.getStr("name"));
			dictUIs[i].setType(dict.getStr("type"));
			dictUIs[i].setSubType(dict.getStr("subType"));
			i ++;
		}
		return dictUIs;
	}
}
