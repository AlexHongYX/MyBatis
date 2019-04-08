package com.fehead.service;

import java.util.List;

import com.fehead.bean.Message;
import com.fehead.dao.MessageDao;
import com.fehead.dao.MessageDaoByMyBatis;

/**
 * @author xiaoaxiao
 *�б���ع���ҵ��
 */
public class ListService {

	public List<Message> queryMessageList(String command,String description){
		
		//ʹ��MyBatis
		MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
		return messageDaoByMyBatis.queryMessageList(command, description);
		/*
		 * ʹ�ô�ͳ��JDBC
		 * MessageDao messageDao = new MessageDao();
			return messageDao.queryMessageList(command, description);
		 * */
		
	}
}
