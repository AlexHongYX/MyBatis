package com.fehead.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fehead.bean.Command;
import com.fehead.bean.CommandContent;
import com.fehead.bean.Message;
import com.fehead.dao.CommandDaoByMyBatis;
//import com.fehead.dao.MessageDao;
import com.fehead.dao.MessageDaoByMyBatis;
import com.fehead.util.Iconst;
import com.sun.mail.handlers.message_rfc822;

/**
 * @author xiaoaxiao
 *列表相关功能业务
 */
public class QueryService {

	public List<Message> queryMessageList(String command,String description){
		
		//使用MyBatis
		MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
		return messageDaoByMyBatis.queryMessageList(command, description);
		/*
		 * 使用传统的JDBC
		 * MessageDao messageDao = new MessageDao();
			return messageDao.queryMessageList(command, description);
		 * */
	}

	//调用MessageDaoByMyBatis
//	public String queryByCommand(String command){
//		MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
//		List<Message> messageList;
//		if(Iconst.HELP_COMMAND.equals(command)){
//			messageList = messageDaoByMyBatis.queryMessageList(null, null);
//			StringBuilder result = new StringBuilder();
//			for(int i=0;i<messageList.size();i++){
//				if(i!=0){
//					result.append("<br/>");
//				}
//				result.append("回复["+messageList.get(i).getCommand()+"]可以查看"+messageList.get(i).getDescription());
//			}
//			return result.toString();
//		}
//		
//		messageList = messageDaoByMyBatis.queryMessageList(command, null);
//		if(messageList.size()>0){
//			return messageList.get(0).getContent();
//		}
//		return Iconst.NO_MATCHING_CONTENT;
//	}
	
	public String queryByCommand(String command){
		CommandDaoByMyBatis commandDaoByMyBatis = new CommandDaoByMyBatis();
		List<Command> commandList;
		if(Iconst.HELP_COMMAND.equals(command)){
			commandList = commandDaoByMyBatis.queryCommandList(null, null);
			StringBuilder result = new StringBuilder();
			for(int i=0;i<commandList.size();i++){
				if(i!=0){
					result.append("<br/>");
				}
				result.append("回复["+commandList.get(i).getName()+"]可以查看"+commandList.get(i).getDescription());
			}
			return result.toString();
		}
		
		commandList = commandDaoByMyBatis.queryCommandList(command, null);
		if(commandList.size()>0){
			List<CommandContent> contentList = commandList.get(0).getContentList();
			int i = new Random().nextInt(contentList.size());
			return contentList.get(i).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
