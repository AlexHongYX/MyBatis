package com.example.sports.service.service.impl;

import java.util.List;

import com.example.sports.bean.College;
import com.example.sports.bean.Connect;
import com.example.sports.bean.MedalNum;
import com.example.sports.controller.viewobject.CollegePoint;
import com.example.sports.dao.CollegeDao;
import com.example.sports.dao.ConnectDao;
import com.example.sports.service.service.CollegeServiceV1;
import org.springframework.stereotype.Service;

/**
 * 学院相关操作外部接口
 * @author Misaki
 *
 */
@Service
public class CollegeServiceImpl implements CollegeServiceV1 {
	private final int COLLEGECOUNT = 13;
	/**
	 * 查询所有学院得分情况及奖牌数量
	 * @return 返回所有学院得分情况数组
	 */
	public CollegePoint[] getAllCollegePoint() {
		//创建十三个学院的分数类数组
		CollegePoint[] collegePoint = new CollegePoint[COLLEGECOUNT];
		//查出成绩表
		ConnectDao connectDao = new ConnectDao();
		List<Connect> connectList = connectDao.queryConnectList();
		//查出学院表
		CollegeDao collegeDao = new CollegeDao();
		List<College> collegeList = collegeDao.queryCollegeList();
		//建立分数信息数组
		int numOfGold[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		int numOfSilver[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		int numOfCopper[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		//遍历统计各学院
		for(Connect connect : connectList) {
			if(connect.getRank() == 1)
			{
				numOfGold[connect.getCollegeId() - 1] += 1;
			}
			else if(connect.getRank() == 2)
			{
				numOfSilver[connect.getCollegeId() - 1] += 1;
			}
			else if(connect.getRank() == 3)
			{
				numOfCopper[connect.getCollegeId() - 1] += 1;
			}
		}
		//向分数类数组的每一个对象赋值
		for(int i = 0; i < COLLEGECOUNT; i++) {
			collegePoint[i] = new CollegePoint();
			collegePoint[i].setCollegeId(collegeList.get(i).getId());
			collegePoint[i].setCollegeName(collegeList.get(i).getName());
			collegePoint[i].setGold(numOfGold[i]);
			collegePoint[i].setSilver(numOfSilver[i]);
			collegePoint[i].setCopper(numOfCopper[i]);
			collegePoint[i].setTotal();
		}
		return collegePoint;
	}
	/**
	 * 
	 * @param college 学院名称
	 * @return 某个学院的得分及奖牌数
	 */
	public CollegePoint getCollegePoint(String college) {
		CollegeServiceImpl collegeService = new CollegeServiceImpl();
		CollegePoint[] collegePoint = collegeService.getAllCollegePoint();
		int i = 0;
		for(; i < COLLEGECOUNT; i++) {
			if(collegePoint[i].getCollegeName().equals(college) == true) {
				break;
			}
		}
		return collegePoint[i];
	}
	/**
	 * 查询所有学院得分情况及奖牌数量
	 * @return 返回所有学院得分情况数组
	 */
	public CollegePoint[] getAllCollegePoint2() {
		//创建十三个学院的分数类数组
		CollegePoint[] collegePoint = new CollegePoint[COLLEGECOUNT];
		ConnectDao connectDao = new ConnectDao();
		//拿到各学院金银铜牌总数表
		List<MedalNum> goldNumList = connectDao.queryGoldNumList();
		List<MedalNum> silverNumList = connectDao.querySilverNumList();
		List<MedalNum> copperNumList = connectDao.queryCopperNumList();
		//查出学院表
		CollegeDao collegeDao = new CollegeDao();
		List<College> collegeList = collegeDao.queryCollegeList();
		//建立分数信息数组
		int numOfGold[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		int numOfSilver[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		int numOfCopper[] = {0,0,0,0,0,0,0,0,0,0,0,0,0};
		//将金银铜表表导入分数信息数组
		for(MedalNum num : goldNumList) {
			numOfGold[num.getCollegeId() - 1] = num.getNum();
		}
		for(MedalNum num : silverNumList) {
			numOfSilver[num.getCollegeId() - 1] = num.getNum();
		}
		for(MedalNum num : copperNumList) {
			numOfCopper[num.getCollegeId() - 1] = num.getNum();
		}
		//向分数类数组的每一个对象赋值
		for(int i = 0; i < COLLEGECOUNT; i++) {
			collegePoint[i] = new CollegePoint();
			collegePoint[i].setCollegeId(collegeList.get(i).getId());
			collegePoint[i].setCollegeName(collegeList.get(i).getName());
			collegePoint[i].setGold(numOfGold[i]);
			collegePoint[i].setSilver(numOfSilver[i]);
			collegePoint[i].setCopper(numOfCopper[i]);
			collegePoint[i].setTotal();
		}
		return collegePoint;
	}
	/**
	 * 
	 * @param college 学院名称
	 * @return 某个学院的得分及奖牌数
	 */
	public CollegePoint getCollegePoint2(String college) {
		CollegeServiceImpl collegeService = new CollegeServiceImpl();
		CollegePoint[] collegePoint = collegeService.getAllCollegePoint();
		int i = 0;
		for(; i < COLLEGECOUNT; i++) {
			if(collegePoint[i].getCollegeName().equals(college) == true) {
				break;
			}
		}
		return collegePoint[i];
	}
}
