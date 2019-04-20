package com.example.sports.controller.viewobject;

public class AthletesViwForMatchProject {
	/*运动员编号*/
	private int id;
	/*学号*/
	private String stuNum;
	/*运动员姓名*/
	private String name;
	/*性别*/
	private String sex;
	/*班级*/
	private String className;
	/*学院*/
	private String college;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
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
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	@Override
	public String toString() {
		return "AthletesViwForMatchProject [id=" + id + ", stuNum=" + stuNum + ", name=" + name + ", sex=" + sex
				+ ", className=" + className + ", college=" + college + "]";
	}
	
}
