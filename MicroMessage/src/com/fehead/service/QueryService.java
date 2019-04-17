package com.fehead.service;

import java.util.*;

import com.fehead.bean.Command;
import com.fehead.bean.CommandContent;
import com.fehead.bean.Message;
import com.fehead.dao.CommandDaoByMyBatis;
//import com.fehead.dao.MessageDao;
import com.fehead.dao.MessageDaoByMyBatis;
import com.fehead.entity.Page;
import com.fehead.util.Iconst;


/**
 * @author xiaoaxiao
 *列表相关功能业务
 */
public class QueryService {

	//使用拦截器实现分页查询功能
	public List<Message> queryMessageListByPage(String command, String description, Page page){

		//因为有两个对象，所以创建Map将两个对象存起来
		Map<String,Object> parameter = new HashMap<>();

		//创建消息对象
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);

		//将message和page（未实现分页功能）传入到Map中
		parameter.put("message",message);
		parameter.put("page",page);

		//创建Dao层
		MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();

		return messageDaoByMyBatis.queryMessageListByPage(parameter);

	}


//	/**
//	 * 查询相关的业务功能
//	 */
//	//只传递查询的两个信息，不包含分页的信息
//	public List<Message> queryMessageList(String command,String description){
//
//		//调用Dao层
//		MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
//		return messageDaoByMyBatis.queryMessageList(command, description);
//		/*
//		 * 使用传统的JDBC
//		 * MessageDao messageDao = new MessageDao();
//			return messageDao.queryMessageList(command, description);
//		 * */
//	}

	/*
	* 根据查询条件分页查询消息列表
	* */
	//传递查询的两个信息以及分页的信息
	//没有实现使用拦截器实现分页功能的方法

//	public List<Message> queryMessageListByPage(String command, String description, Page page){
//
//		//因为需要查询的有Message和Page两个对象，但xml文件中语句的parameterType只能是一个参数类型，所以需要用Map将其封装起来
//		//因为对象不同，所以值得类型应该为Object
//		Map<String,Object> parameter = new HashMap<>();
//
//		//Service的功能是将所有能提供的信息都在Service层中做，Dao层只与数据库挂钩，如果Spring集成了MyBatis，Dao层消失
//		Message message = new Message();
//		message.setCommand(command);
//		message.setDescription(description);
//
//		//创建Dao层
//		MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
//		//首先根据条件查询条数
//		int totalNumber = messageDaoByMyBatis.count(message);
//		//组织分页查询参数
//		//在page.setTotalNumber中调用page.count函数，在Page对象内部就配置好了各个属性
//		page.setTotalNumber(totalNumber);
//
//		//给Map中添加元素
//		parameter.put("message",message);
//		parameter.put("page",page);
//
//		//分页查询并返回结果
//		return messageDaoByMyBatis.queryMessageListByPage(parameter);
//		/*
//		 * 使用传统的JDBC
//		 * MessageDao messageDao = new MessageDao();
//			return messageDao.queryMessageList(command, description);
//		 * */
//	}

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

	//实现前端自动回复
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
