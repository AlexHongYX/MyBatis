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
 *�б���ع���ҵ��
 */
public class QueryService {

	//ʹ��������ʵ�ַ�ҳ��ѯ����
	public List<Message> queryMessageListByPage(String command, String description, Page page){

		//��Ϊ�������������Դ���Map���������������
		Map<String,Object> parameter = new HashMap<>();

		//������Ϣ����
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);

		//��message��page��δʵ�ַ�ҳ���ܣ����뵽Map��
		parameter.put("message",message);
		parameter.put("page",page);

		//����Dao��
		MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();

		return messageDaoByMyBatis.queryMessageListByPage(parameter);

	}


//	/**
//	 * ��ѯ��ص�ҵ����
//	 */
//	//ֻ���ݲ�ѯ��������Ϣ����������ҳ����Ϣ
//	public List<Message> queryMessageList(String command,String description){
//
//		//����Dao��
//		MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
//		return messageDaoByMyBatis.queryMessageList(command, description);
//		/*
//		 * ʹ�ô�ͳ��JDBC
//		 * MessageDao messageDao = new MessageDao();
//			return messageDao.queryMessageList(command, description);
//		 * */
//	}

	/*
	* ���ݲ�ѯ������ҳ��ѯ��Ϣ�б�
	* */
	//���ݲ�ѯ��������Ϣ�Լ���ҳ����Ϣ
	//û��ʵ��ʹ��������ʵ�ַ�ҳ���ܵķ���

//	public List<Message> queryMessageListByPage(String command, String description, Page page){
//
//		//��Ϊ��Ҫ��ѯ����Message��Page�������󣬵�xml�ļ�������parameterTypeֻ����һ���������ͣ�������Ҫ��Map�����װ����
//		//��Ϊ����ͬ������ֵ������Ӧ��ΪObject
//		Map<String,Object> parameter = new HashMap<>();
//
//		//Service�Ĺ����ǽ��������ṩ����Ϣ����Service��������Dao��ֻ�����ݿ�ҹ������Spring������MyBatis��Dao����ʧ
//		Message message = new Message();
//		message.setCommand(command);
//		message.setDescription(description);
//
//		//����Dao��
//		MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
//		//���ȸ���������ѯ����
//		int totalNumber = messageDaoByMyBatis.count(message);
//		//��֯��ҳ��ѯ����
//		//��page.setTotalNumber�е���page.count��������Page�����ڲ������ú��˸�������
//		page.setTotalNumber(totalNumber);
//
//		//��Map�����Ԫ��
//		parameter.put("message",message);
//		parameter.put("page",page);
//
//		//��ҳ��ѯ�����ؽ��
//		return messageDaoByMyBatis.queryMessageListByPage(parameter);
//		/*
//		 * ʹ�ô�ͳ��JDBC
//		 * MessageDao messageDao = new MessageDao();
//			return messageDao.queryMessageList(command, description);
//		 * */
//	}

	//����MessageDaoByMyBatis
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
//				result.append("�ظ�["+messageList.get(i).getCommand()+"]���Բ鿴"+messageList.get(i).getDescription());
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

	//ʵ��ǰ���Զ��ظ�
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
				result.append("�ظ�["+commandList.get(i).getName()+"]���Բ鿴"+commandList.get(i).getDescription());
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
