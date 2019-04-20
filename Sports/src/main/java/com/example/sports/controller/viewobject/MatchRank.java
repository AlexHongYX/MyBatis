package com.example.sports.controller.viewobject;
/**
 * 每一场比赛排名实体类
 * @author Misaki
 *
 */
public class MatchRank {
	/*运动员姓名*/
	private String name;
	/*班级*/
	private String className;
	/*名次*/
	private int rank;
	/*成绩*/
	private String grade;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
