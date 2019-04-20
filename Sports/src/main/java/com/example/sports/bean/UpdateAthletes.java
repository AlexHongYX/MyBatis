package com.example.sports.bean;
/**
 * 修改运动员所用到的类
 * @author Misaki
 *
 */
public class UpdateAthletes {
	/*运动员编号*/
	private int id;
	/*新学号*/
	private String stuNum;
	/*旧信息*/
	private String oldStu;
	/*运动员名称*/
	private String name;
	/*运动员性别*/
	private String sex;
	/*运动员对应学院的编号*/
	private int collegeId;
	/*班级*/
	private String className;
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
	public String getOldStuNum() {
		return oldStu;
	}
	public void setOldStuNum(String oldStuNum) {
		this.oldStu = oldStuNum;
	}
	
}
