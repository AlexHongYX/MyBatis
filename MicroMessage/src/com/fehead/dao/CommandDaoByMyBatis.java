package com.fehead.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fehead.bean.CommandContent;
import org.apache.ibatis.session.SqlSession;

import com.fehead.bean.Command;
import com.fehead.bean.Message;
import com.fehead.db.DBAccess;

/**
 * 与指令表对应的数据库操作
 *
 */
public class CommandDaoByMyBatis {
	/**
	 * 根据查询条件查询指令列表
	 */
	public List<Command> queryCommandList(String name,String description){
		DBAccess dbAccess = new DBAccess();
		List<Command> commandList = new ArrayList<Command>();
		SqlSession sqlSession = null;
		//定义这个message是为了根据command和description进行查询
		Command command = new Command();
		command.setName(name);
		command.setDescription(description);
		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
				//通过Message.queryMessageList访问Message空间中id为queryMessageList的select
			commandList = sqlSession.selectList("Command.queryCommandList",command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
			
		}
		return commandList;
	}

	/**
	 * 添加指定列表
	 */
	public void insertOne(String name, String description, List<CommandContent> commandContentList){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;

		Command command = new Command();
		command.setName(name);
		command.setDescription(description);
		command.setContentList(commandContentList);

		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
			//通过Message.queryMessageList访问Message空间中id为queryMessageList的select
			sqlSession.selectList("Command.insertList",command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}

		}
	}
}
