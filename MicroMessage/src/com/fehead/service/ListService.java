package com.fehead.service;

import java.util.List;

import com.fehead.bean.Message;
import com.fehead.dao.MessageDao;
import com.fehead.dao.MessageDaoByMyBatis;

/**
 * @author xiaoaxiao
 *列表相关功能业务
 */
public class ListService {

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
}
