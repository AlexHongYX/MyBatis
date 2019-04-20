package com.example.sports.controller.viewobject;
/**
 * 学院金牌数量及总分实体类
 * @author Misaki
 *
 */
public class CollegePoint {
	/*学院编号*/
	private int collegeId;
	/*学院名称*/
	private String collegeName;
	/*金牌数量*/
	private int gold;
	/*银牌数量*/
	private int silver;
	/*铜牌数量*/
	private int copper;
	/*总分*/
	private int total;
	/*
	 * 计算总分 
	 * 这里假设一个金牌3分，银牌2分，铜牌1分
	 */
	public void setTotal()
	{
		this.total = this.gold * 3 + this.silver * 2 + this.copper;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getSilver() {
		return silver;
	}
	public void setSilver(int silver) {
		this.silver = silver;
	}
	public int getCopper() {
		return copper;
	}
	public void setCopper(int copper) {
		this.copper = copper;
	}
	public int getTotal() {
		return total;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
}
