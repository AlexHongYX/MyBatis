package com.fehead.service;

import java.util.List;

import com.fehead.dao.MessageDaoByMyBatis;

/**
 * 维护相关的业务功能
 *
 */
public class MaintainService {
	
	/**
	 * 单条记录删除
	 */
	public void deleteOne(String id){
		if(id!=null&&!"".equals(id.trim())){
			MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
			messageDaoByMyBatis.deleteOne(Integer.valueOf(id));
		}
		
	}
	
	/**
	 * 多条记录删除
	 */
	public void deleteBatch(List<Integer> ids){
		
		MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
		messageDaoByMyBatis.deleteBatch(ids);
	}
}
