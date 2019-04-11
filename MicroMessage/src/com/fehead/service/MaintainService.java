package com.fehead.service;

import java.util.ArrayList;
import java.util.List;

import com.fehead.dao.MessageDaoByMyBatis;

/**
 * ά����ص�ҵ����
 *
 */
public class MaintainService {
	
	/**
	 * ������¼ɾ��
	 */
	public void deleteBatch(String[] ids){
		
		MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
		List<Integer> idList = new ArrayList<Integer>();
		for (String id : ids) {
			idList.add(Integer.valueOf(id));
		}
		messageDaoByMyBatis.deleteBatch(idList);
	}
	
	/**
	 * ������¼ɾ��
	 */
	public void deleteOne(String id){
		if(id!=null&&!"".equals(id.trim())){
			MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
			messageDaoByMyBatis.deleteOne(Integer.valueOf(id));
		}
		
	}
	
	/*��¼����*/
	public void updateOne(String command,String description){
		if(description!=null&&!"".equals(description.trim())){
			MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
			messageDaoByMyBatis.updateOne(command, description);
		}
	}
}
