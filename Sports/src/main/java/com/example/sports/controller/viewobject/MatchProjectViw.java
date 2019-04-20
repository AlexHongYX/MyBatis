package com.example.sports.controller.viewobject;
/**
 * 比赛项目对应实体类
 * @author Misaki
 *
 */
public class MatchProjectViw {
	/*比赛项目名称*/
	private String name;
	/*比赛类型*/
	private String type;
	/*比赛时间*/
	private String time;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
