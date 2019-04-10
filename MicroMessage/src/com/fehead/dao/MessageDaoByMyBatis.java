package com.fehead.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.fehead.bean.Message;
import com.fehead.db.DBAccess;

public class MessageDaoByMyBatis {
	
	/**
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 */
	public List<Message> queryMessageList(String command,String description){
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		//�������message��Ϊ�˸���command��description���в�ѯ
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);
		try {
			sqlSession = dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
				//ͨ��Message.queryMessageList����Message�ռ���idΪqueryMessageList��select
			messageList = sqlSession.selectList("Message.queryMessageList",message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
			
		}
		return messageList;
	}
	
	/**
	 * ����ɾ����¼
	 */
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
				//ͨ��Message.deleteOneɾ��ID=id�ļ�¼
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	/**
	 * ����ɾ����¼
	 */
	public void deleteBatch(List<Integer> ids){
		DBAccess dbAccess = new DBAccess();
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAccess.getSqlSession();
			//ͨ��sqlSessionִ��SQL���
				//ͨ��Message.deleteOneɾ��ID=id�ļ�¼
			sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	}
	
	/**
	 * ���ڲ���
	 * public static void main(String[] args) {
		MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
		messageDaoByMyBatis.queryMessageList("", "");
		}
	 */
	
}
