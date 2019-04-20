package com.example.sports.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.sports.bean.MatchProject;
import com.example.sports.bean.UpdateMatchProject;
import com.example.sports.db.DBAccess;
import org.apache.ibatis.session.SqlSession;


/**
 * 比赛项目表数据库操作
 * @author Misaki
 *
 */
public class MatchProjectDao {
	/**
	 * 插入比赛项目
	 * @param name 比赛项目名称
	 * @param type 比赛项目类型
	 * @param time 比赛时间
	 */
	public void insertMatchProject(String name, int type, String time) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			MatchProject matchProject = new MatchProject();
			matchProject.setName(name);
			matchProject.setType(type);
			matchProject.setTime(time);
			sqlSession.insert("MatchProject.insertMatchProject", matchProject);
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
	 * 根据比赛名称删除比赛项目
	 * @param name
	 */
	public void deleteMatchProjectByName(String name) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			MatchProject matchProject = new MatchProject();
			matchProject.setName(name);
			sqlSession.delete("MatchProject.deleteMatchProjectByName", matchProject);
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
	 * 根据比赛名称修改比赛
	 * @param name 新比赛名称
	 * @param type 比赛类型
	 * @param time 比赛类型
	 * @param oldName 旧的比赛名称
	 */
	public void updateMatchProjectByName(String name, int type, String time, String oldName) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			UpdateMatchProject updateMatchProject = new UpdateMatchProject();
			updateMatchProject.setName(name);
			updateMatchProject.setType(type);
			updateMatchProject.setTime(time);
			updateMatchProject.setOldName(oldName);
			sqlSession.update("MatchProject.updateMatchProjectByName", updateMatchProject);
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
	 * 查询所有比赛项目
	 * @return 比赛项目集合
	 */
	public List<MatchProject> queryMatchProjectList() {
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<MatchProject> matchProject = new ArrayList<MatchProject>();
		try {
			sqlSession = dbAccess.getSqlSession();
			matchProject = sqlSession.selectList("MatchProject.queryMatchProjectList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return matchProject;
	}
	/**
	 * 根据名称查找比赛项目
	 * @param name 比赛名称
	 * @return 比赛项目对象
	 */
	public MatchProject queryMatchProjectByName(String name) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		MatchProject matchProject = new MatchProject();
		matchProject.setName(name);
		try {
			sqlSession = dbAccess.getSqlSession();
			matchProject = sqlSession.selectOne("MatchProject.queryMatchProjectByName", matchProject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return matchProject;
	}
}
