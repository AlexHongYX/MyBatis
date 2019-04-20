package com.example.sports.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.sports.bean.Athletes;
import com.example.sports.bean.MatchProject;
import com.example.sports.bean.UpdateAthletes;
import com.example.sports.db.DBAccess;
import org.apache.ibatis.session.SqlSession;


/**
 * 运动员表数据库操作
 * @author Misaki
 *
 */
public class AthletesDao {
	/**
	 *  查找所有运动员
	 * @return 返回整张运动员表（团体个人）
	 */
	public List<Athletes> queryAthletesList() {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Athletes> athletesList = new ArrayList<Athletes>();
		try {
			//sql通过自己的封装拿到数据库连接
			sqlSession = dbAccess.getSqlSession();
			athletesList = sqlSession.selectList("Athletes.queryAthletesList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return athletesList;
	}
	/**
	 *  根据学号查找运动员
	 * @return 返回运动员对象
	 */
	public Athletes queryAthleteByStuNum(String stuNum) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		Athletes athlete = new Athletes();
		athlete.setStuNum(stuNum);
		try {
			//sql通过自己的封装拿到数据库连接
			sqlSession = dbAccess.getSqlSession();
			athlete = sqlSession.selectOne("Athletes.queryAthleteByStuNum", athlete);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return athlete;
	}/**
	 *  根据id查找运动员
	 * @return 返回运动员对象
	 */
	public Athletes queryAthleteById(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		Athletes athlete = new Athletes();
		athlete.setId(id);
		try {
			//sql通过自己的封装拿到数据库连接
			sqlSession = dbAccess.getSqlSession();
			athlete = sqlSession.selectOne("Athletes.queryAthleteById", athlete);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return athlete;
	}
	/**
	 *  根据名称查找团体
	 * @return 返回运动员（团体）对象
	 */
	public Athletes queryTeamByName(String name) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		Athletes athlete = new Athletes();
		athlete.setName(name);
		try {
			//sql通过自己的封装拿到数据库连接
			sqlSession = dbAccess.getSqlSession();
			athlete = sqlSession.selectOne("Athletes.queryAthleteByName", athlete);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return athlete;
	}
	/**
	 * 根据比赛项目查找运动员
	 * @param name 比赛项目
	 * @return 运动员表
	 */
	public List<Athletes> queryAthletesListByMatchProject(String name) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Athletes> athletesList = new ArrayList<Athletes>();
		try {
			//sql通过自己的封装拿到数据库连接
			MatchProject matchProject = new MatchProject();
			matchProject.setName(name);
			sqlSession = dbAccess.getSqlSession();
			athletesList = sqlSession.selectList("Athletes.queryAthletesListByMatchProject", matchProject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return athletesList;
	}
	/**
	 * 添加运动员信息
	 * @param name 运动员 姓名
	 * @param sex 运动员性别
	 * @param collegeId 学院编号
	 * @param isTeam 团体/个人
	 */
	public void insertAthletes(String stuNum, String name, String sex, int collegeId, String className,int isTeam) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Athletes athletes = new Athletes();
			athletes.setStuNum(stuNum);
			athletes.setName(name);
			athletes.setSex(sex);
			athletes.setCollegeId(collegeId);
			athletes.setClassName(className);
			athletes.setIsTeam(isTeam);
			sqlSession.insert("Athletes.insertAthletes", athletes);
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
	 * 根据学号删除运动员根据学号删除运动员
	 */
	public void deleteAthletesByStuNum(String stuNum) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Athletes athletes = new Athletes();
			athletes.setStuNum(stuNum);
			sqlSession.delete("Athletes.deleteAthletesByStuNum", athletes);
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
	 * 根据姓名删除运动员（团体）
	 */
		public void deleteAthletesByName(String name) {
			DBAccess dbAccess = new DBAccess();
			SqlSession sqlSession = null;
			try {
				sqlSession = dbAccess.getSqlSession();
				Athletes athletes = new Athletes();
				athletes.setName(name);
				sqlSession.delete("Athletes.deleteAthletesByName", athletes);
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
		 * 根据学号修改运动员信息
		 * @param newStuNum 新学号
		 * @param name 名字
		 * @param sex 性别
		 * @param collegeId 学院编号
		 * @param className 班级名称
		 * @param isTeam 团体/个人
		 * @param oldStuNum 旧学号
		 */
		public void updateAthletesByStuNum(String StuNum, String name, String sex, int collegeId, String className, String oldStu) {
			DBAccess dbAccess = new DBAccess();
			SqlSession sqlSession = null;
			try {
				sqlSession = dbAccess.getSqlSession();
				UpdateAthletes updateAthletes = new UpdateAthletes();
				updateAthletes.setStuNum(StuNum);
				updateAthletes.setName(name);
				updateAthletes.setSex(sex);
				updateAthletes.setCollegeId(collegeId);
				updateAthletes.setClassName(className);
				updateAthletes.setOldStuNum(oldStu);
				sqlSession.update("Athletes.updateAthletesByStuNum", updateAthletes);
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
		 * 根据名称修改团体信息
		 * @param newStuNum 新学号
		 * @param name 名字
		 * @param sex 性别
		 * @param collegeId 学院编号
		 * @param className 班级名称
		 * @param isTeam 团体/个人
		 * @param oldStuNum 旧学号
		 */
		public void updateAthletesByName(String StuNum, String name, String sex, int collegeId, String className, String oldStu) {
			DBAccess dbAccess = new DBAccess();
			SqlSession sqlSession = null;
			try {
				sqlSession = dbAccess.getSqlSession();
				UpdateAthletes updateAthletes = new UpdateAthletes();
				updateAthletes.setStuNum(StuNum);
				updateAthletes.setName(name);
				updateAthletes.setSex(sex);
				updateAthletes.setCollegeId(collegeId);
				updateAthletes.setClassName(className);
				updateAthletes.setOldStuNum(oldStu);
				sqlSession.update("Athletes.updateAthletesByName", updateAthletes);
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
}
