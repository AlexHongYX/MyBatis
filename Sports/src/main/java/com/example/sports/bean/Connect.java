package com.example.sports.bean;
/**
 * 连接表对应实体类
 * @author Misaki
 *
 */
public class Connect {
	/*运动员编号*/
	private int athletesId;
	/*比赛项目编号*/
	private int matchProjectId;
	/*学院编号*/
	private int collegeId;
	/*名次*/
	private int rank;
	/*成绩*/
	private String grade;
	public int getAthletesId() {
		return athletesId;
	}
	public void setAthletesId(int athletesId) {
		this.athletesId = athletesId;
	}
	public int getMatchProjectId() {
		return matchProjectId;
	}
	public void setMatchProjectId(int matchProjectId) {
		this.matchProjectId = matchProjectId;
	}
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
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
