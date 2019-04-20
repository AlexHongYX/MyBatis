package com.example.sports.bean;
/**
 * 比赛项目对应实体类
 * @author Misaki
 *
 */
public class MatchProject {
	/*比赛项目编号*/
	private int id;
	/*比赛项目名称*/
	private String name;
	/*比赛类型，0个人，1团体*/
	private int type;
	/*比赛时间*/
	private String time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
