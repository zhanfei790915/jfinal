package com.gene.ui.domain;

public class MenuUI {
	private String id;
	private String text;
	private MenuUI[] children;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public MenuUI[] getChildren() {
		return children;
	}
	public void setChildren(MenuUI[] children) {
		this.children = children;
	}
	
	
	

}
