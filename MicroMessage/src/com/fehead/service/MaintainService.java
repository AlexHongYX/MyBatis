package com.fehead.service;

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
	public void deleteOne(String id){
		if(id!=null&&!"".equals(id.trim())){
			MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
			messageDaoByMyBatis.deleteOne(Integer.valueOf(id));
		}
		
	}
	
	/**
	 * ������¼ɾ��
	 */
	public void deleteBatch(List<Integer> ids){
		
		MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
		messageDaoByMyBatis.deleteBatch(ids);
	}
}
