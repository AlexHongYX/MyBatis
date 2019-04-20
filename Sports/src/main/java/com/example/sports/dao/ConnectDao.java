package com.example.sports.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.sports.bean.Connect;
import com.example.sports.bean.MatchProject;
import com.example.sports.bean.MedalNum;
import com.example.sports.bean.UpdateConnect;
import com.example.sports.db.DBAccess;
import org.apache.ibatis.session.SqlSession;


/**
 * 连接表数据库操作
 * @author Misaki
 *
 */
public class ConnectDao {
	/**
	 *  查询connect表所有信息
	 */
	public List<Connect> queryConnectList() {
		//连接数据库操作对象
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Connect> connectList = new ArrayList<Connect>();
		try {
			sqlSession = dbAccess.getSqlSession();
			connectList = sqlSession.selectList("Connect.queryConnectList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return connectList;
	}
	/**
	 *  查询各学院金牌数量情况
	 * @return 返回各学院奖牌数类
	 */
	public List<MedalNum> queryGoldNumList() {
		//连接数据库操作对象
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<MedalNum> connectList = new ArrayList<MedalNum>();
		try {
			sqlSession = dbAccess.getSqlSession();
			connectList = sqlSession.selectList("Connect.queryGoldNumList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return connectList;
	}
	/**
	 *  查询各学院银牌数量情况
	 * @return 返回各学院奖牌数类
	 */
	public List<MedalNum> querySilverNumList() {
		//连接数据库操作对象
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<MedalNum> connectList = new ArrayList<MedalNum>();
		try {
			sqlSession = dbAccess.getSqlSession();
			connectList = sqlSession.selectList("Connect.querySilverNumList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return connectList;
	}
	/**
	 *  查询各学院铜牌数量情况
	 * @return 返回各学院奖牌数类
	 */
	public List<MedalNum> queryCopperNumList() {
		//连接数据库操作对象
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<MedalNum> connectList = new ArrayList<MedalNum>();
		try {
			sqlSession = dbAccess.getSqlSession();
			connectList = sqlSession.selectList("Connect.queryCopperNumList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return connectList;
	}
	/**
	 * 插入连接表比赛信息
	 * @param athletesId 运动员编号
	 * @param collegeId 学院编号
	 * @param matchProjectId 比赛项目编号
	 */
	public void insertConnect(int athletesId, int collegeId, int matchProjectId) {
		//连接数据库操作对象
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		Connect connect = new Connect();
		connect.setAthletesId(athletesId);
		connect.setCollegeId(collegeId);
		connect.setMatchProjectId(matchProjectId);
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.insert("Connect.insertConnect", connect);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	/**
	 * 修改连接表比赛信息
	 * @param athletesId 运动员编号
	 * @param collegeId 学院编号
	 * @param matchProjectId 比赛项目编号
	 * @param rank 名次
	 * @param grade 成绩
	 * @param oldAthletesId 原来的运动员编号
	 * @param oldMatchProjectId 原来的比赛项目编号
	 */
	public void updateConnect(int athletesId, int collegeId, int matchProjectId, int rank, String grade, int oldAthletesId, int oldMatchProjectId) {
		//连接数据库操作对象
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		UpdateConnect connect = new UpdateConnect();
		connect.setAthletesId(athletesId);
		connect.setCollegeId(collegeId);
		connect.setMatchProjectId(matchProjectId);
		connect.setRank(rank);
		connect.setGrade(grade);
		connect.setOldAthletesId(oldAthletesId);
		connect.setOldMatchProjectId(oldMatchProjectId);
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.update("Connect.updateConnect", connect);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	/**
	 * 查询比赛排名
	 * @param matchProjectId 比赛项目编号
	 * @return 连接表集合
	 */
	public List<Connect> queryRank(int matchProjectId) {
		//连接数据库操作对象
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		MatchProject matchProject = new MatchProject();
		matchProject.setId(matchProjectId);
		List<Connect> connectList = new ArrayList<Connect>();
		try {
			sqlSession = dbAccess.getSqlSession();
			connectList  = sqlSession.selectList("Connect.queryRank", matchProject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return connectList;
	}
}
