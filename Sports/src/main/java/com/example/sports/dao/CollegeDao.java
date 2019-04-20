package com.example.sports.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.sports.bean.College;
import com.example.sports.db.DBAccess;
import org.apache.ibatis.session.SqlSession;


/**
 * 学院表数据库操作
 * @author Misaki
 *
 */
public class CollegeDao {
	public List<College> queryCollegeList() {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<College> collegeList = new ArrayList<College>();
		try {
			//sql通过自己的封装拿到数据库连接
			sqlSession = dbAccess.getSqlSession();
			collegeList = sqlSession.selectList("College.queryCollegeList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return collegeList;
	}
}
