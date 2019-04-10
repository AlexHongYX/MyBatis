package com.fehead.service;

import java.util.ArrayList;
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
	public void deleteBatch(String[] ids){
		
		MessageDaoByMyBatis messageDaoByMyBatis = new MessageDaoByMyBatis();
		List<Integer> idList = new ArrayList<Integer>();
		for (String id : ids) {
			idList.add(Integer.valueOf(id));
		}
		messageDaoByMyBatis.deleteBatch(idList);
	}
	
	/*记录更新*/
}
