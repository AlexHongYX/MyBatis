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
 * ��ָ����Ӧ�����ݿ����
 *
 */
public class CommandDaoByMyBatis {
	/**
	 * ���ݲ�ѯ������ѯָ���б�
	 */
	public List<Command> queryCommandList(String name,String description){
		DBAccess dbAccess = new DBAccess();
		List<Command> commandList = new ArrayList<Command>();
		SqlSession sqlSession = null;
		//�������message��Ϊ�˸���command��description���в�ѯ
		Command command = new Command();
		command.setName(name);
		command.setDescription(description);
		try {
			sqlSession = dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
				//ͨ��Message.queryMessageList����Message�ռ���idΪqueryMessageList��select
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
	 * ���ָ���б�
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
			//ͨ��sqlSessionִ��SQL���
			//ͨ��Message.queryMessageList����Message�ռ���idΪqueryMessageList��select
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
