package com.fehead.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.fehead.bean.Message;
import com.fehead.bean.UpdateMessage;
import com.fehead.db.DBAccess;

import javax.swing.*;

public class MessageDaoByMyBatis {

	/**
	 * 根据查询条件查询消息列表的条数
	 */
	public int count(Message message) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			result = imessage.count(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return result;
	}

	//拦截器实现分页
	public List<Message> queryMessageListByPage(Map<String,Object> parameter) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageListByPage(parameter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}

//	//未实现拦截器分页前
//	/**
//	 * 根据查询条件+分页查询消息列表
//	 */
//	public List<Message> queryMessageListByPage(Map<String,Object> parameter) {
//		DBAccess dbAccess = new DBAccess();
//		List<Message> messageList = new ArrayList<>();
//		SqlSession sqlSession = null;
//		try {
//			sqlSession = dbAccess.getSqlSession();
//			// 通过sqlSession执行SQL语句
//			IMessage imessage = sqlSession.getMapper(IMessage.class);
//			messageList = imessage.queryMessageListByPage(parameter);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if(sqlSession != null) {
//				sqlSession.close();
//			}
//		}
//		return messageList;
//	}
	
	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessageList(String command,String description){
		DBAccess  dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		//定义这个message是为了根据command和description进行查询
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);
		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
				//通过Message.queryMessageList访问Message空间中id为queryMessageList的select
			//messageList = sqlSession.selectList("Message.queryMessageList",message);
			//使用接口式编程实现配置文件的调用
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			iMessage.queryMessageList(message);
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
	 * 批量删除记录
	 */
	public void deleteBatch(List<Integer> ids){
		DBAccess dbAccess = new DBAccess();
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
				//通过Message.deleteOne删除ID=id的记录
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
	 * 单条删除记录
	 */
	public void deleteOne(int id){
		DBAccess dbAccess = new DBAccess();
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
				//通过Message.deleteOne删除ID=id的记录
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
	
	/*
	 * 单条记录修改
	 * */
	public void updateOne(String command,String description){
		DBAccess dbAccess = new DBAccess();
		
		SqlSession sqlSession = null;
		UpdateMessage updateMessage = new UpdateMessage();
		updateMessage.setCommand(command);
		updateMessage.setDescription(description);
		
		try {
			sqlSession = dbAccess.getSqlSession();
			//通过sqlSession执行SQL语句
				//通过Message.deleteOne删除ID=id的记录
			sqlSession.update("Message.updateOne",updateMessage);
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
	 * 用于测试
	 * public static void main(String[] args) {
		MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
		messageDaoByMyBatis.queryMessageList("", "");
		}
	 */
	
}
