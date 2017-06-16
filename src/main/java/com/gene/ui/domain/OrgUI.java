package com.gene.ui.domain;

public class OrgUI {
	private String id;
	private String text;
	private OrgUI[] children;
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
	public OrgUI[] getChildren() {
		return children;
	}
	public void setChildren(OrgUI[] children) {
		this.children = children;
	}
	

}
