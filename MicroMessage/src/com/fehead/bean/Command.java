package com.fehead.bean;

import java.util.List;

public class Command {
	
	private String id;
	private String name;
	private String description;
	
	//ģ��һ�Զ�Ľṹ
	private List<CommandContent> contentList;
	
	public List<CommandContent> getContentList() {
		return contentList;
	}
	public void setContentList(List<CommandContent> contentList) {
		this.contentList = contentList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}