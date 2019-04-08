package com.fehead.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fehead.bean.Message;

/**
 * @author xiaoaxiao
 *与message表相关的数据库操作
 */
public class MessageDao {
	
	/**
	 * 根据查询条件查询消息列表
	 */
	/*
	 * 增加JDBC链接数据库
	 * */
	public List<Message> queryMessageList(String command,String description){
		List<Message> messageList = new ArrayList<Message>();
		//加载驱动程序
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//获得数据库的连接
			//要在数据库连接的时候设置characterEncoding=utf8，否则查不了中文
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/micro_message?serverTimezone=GMT&characterEncoding=utf8","xiaoaxiao","8023hyx1999hyx"
					);
			//通过数据库的连接操作数据库
			//String sql = "SELECT COMMAND,DESCRIPTION,CONTENT from message";
			
			//使用StringBuilder可以在字符串后添加字符 
			StringBuilder sql = new StringBuilder("SELECT COMMAND,DESCRIPTION,CONTENT from message where 1=1");
			
			List<String> paramList = new ArrayList<String>();
			//要在数据库连接的时候设置characterEncoding=utf8，否则查不了中文
			if(command!=null&&!"".equals(command.trim())){
				sql.append(" and COMMAND=?");
				paramList.add(command);
			}
			if(description!=null&&!"".equals(description.trim())){
				sql.append(" and DESCRIPTION like '%' ? '%'");
				paramList.add(description);
			}
			
			PreparedStatement ppst = conn.prepareStatement(sql.toString());
			
			for(int i=0;i<paramList.size();i++){
				ppst.setString(i+1, paramList.get(i));
			}
			ResultSet rs = ppst.executeQuery();
			
			while(rs.next()){
				Message message = new Message();
				/*为什么不能读取ID
				 * message.setId(rs.getInt("ID"));
				 * */
				
				message.setCommand(rs.getString("COMMAND"));
				message.setDescription(rs.getString("DESCRIPTION"));
				message.setContent(rs.getString("CONTENT"));
				messageList.add(message);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messageList;
	}

}
