package com.example.sports.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DBAccess {

//	@Value("classpath:Configuration.xml")
//	Resource reader;

	public SqlSession getSqlSession() throws IOException {
		//通过配置文件获取数据库连接信息
//		Reader reader = Resources.getResourceAsReader("classpath:Configuration.xml");
		Resource resource = new ClassPathResource("Configuration.xml");
		//通过配置信息构建一个SqlSessionFactoory
		SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(resource.getInputStream());
		//通过sqlSessionFactory打开 一个数据库会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}
}
