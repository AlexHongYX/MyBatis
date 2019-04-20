package com.example.sports.service.service;

public interface ConnectServiceV1 {
	/**
	 * 插入连接表信息（运动员id, 学院id, 比赛项目id）
	 * @param type 比赛类型（个人/团体）
	 * @param message 运动员信息，个人则是学号，团体则是名称
	 * @param matchProject 比赛项目名称
	 */
	public void insertConnect(int type, String message, String matchProjectName);
	/**
	 * 修改连接表信息
	 * @param type 类型，个人/团体
	 * @param message 信息，个人则是学号，团体则是名称
	 * @param matchProjectName 比赛项目名称 
	 * @param rank 排名
	 * @param grade 成绩
	 * @param oldMessage 旧的运动员信息，个人则是学号，团体则是名称
	 * @param oldMatchProjectName 旧的比赛项目名称
	 */
	public void updateConnect(int type, String message, String matchProjectName, int rank, String grade, String oldMessage, String oldMatchProjectName);
	/**
	 * 插入比赛成绩(名次和成绩)
	 * @param type 比赛类型
	 * @param message 信息，个人则是学号，团体则是名称
	 * @param matchProjectName 比赛
	 * @param rank 名次 
	 * @param grade 成绩
	 */
	public void insertGrade(int type, String message, String matchProjectName, int rank, String grade);
}
