package com.example.sports.bean;
/**
 * 运动员表对应实体类
 * @author Misaki
 *
 */
public class Athletes {
	/*运动员编号*/
	private int id;
	/*学号*/
	private String stuNum;
	/*运动员名称*/
	private String name;
	/*运动员性别*/
	private String sex;
	/*运动员对应学院的编号*/
	private int collegeId;
	/*班级*/
	private String className;
	/*是否是集体，0个人1集体*/
	private int isTeam;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public int getIsTeam() {
		return isTeam;
	}
	public void setIsTeam(int isTeam) {
		this.isTeam = isTeam;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
}
