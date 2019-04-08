package com.fehead.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBAccess {
	
	public SqlSession getSqlSession() throws IOException{
		//ͨ�������ļ���ȡ���ݿ����������Ϣ
		//·��Ϊ��Ŀ¼��src�У�
		Reader reader = Resources.getResourceAsReader("com/fehead/config/Configuration.xml");
		//ͨ��������Ϣ����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//ͨ��SqlSessionFactory��һ�����ݿ�Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}

}