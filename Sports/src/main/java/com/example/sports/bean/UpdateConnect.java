package com.example.sports.bean;
/**
 * 修改连接表所用到的类
 * @author Misaki
 *
 */
public class UpdateConnect {
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
	/*旧运动员编号*/
	private int oldAthletesId;
	/*旧比赛项目编号*/
	private int oldMatchProjectId;
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
	public int getOldAthletesId() {
		return oldAthletesId;
	}
	public void setOldAthletesId(int oldAthletesId) {
		this.oldAthletesId = oldAthletesId;
	}
	public int getOldMatchProjectId() {
		return oldMatchProjectId;
	}
	public void setOldMatchProjectId(int oldMatchProjectId) {
		this.oldMatchProjectId = oldMatchProjectId;
	}
	
	
}
