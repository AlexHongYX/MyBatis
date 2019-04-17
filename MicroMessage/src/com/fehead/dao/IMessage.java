package com.fehead.dao;

import com.fehead.bean.Message;

import java.util.List;
import java.util.Map;

public interface IMessage {

    /**
     * 根据查询条件查询消息列表
     */
    public List<Message> queryMessageList(Message message);


    /**
     * 根据查询条件查询消息列表的条数
     */
    public int count(Message message);

    /**
     * 根据查询条件分页查询消息列表
     */
    public List<Message> queryMessageListByPage(Map<String,Object> parameter);
}
