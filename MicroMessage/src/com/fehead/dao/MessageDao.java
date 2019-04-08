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
 *��message����ص����ݿ����
 */
public class MessageDao {
	
	/**
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 */
	/*
	 * ����JDBC�������ݿ�
	 * */
	public List<Message> queryMessageList(String command,String description){
		List<Message> messageList = new ArrayList<Message>();
		//������������
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//������ݿ������
			//Ҫ�����ݿ����ӵ�ʱ������characterEncoding=utf8������鲻������
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/micro_message?serverTimezone=GMT&characterEncoding=utf8","xiaoaxiao","8023hyx1999hyx"
					);
			//ͨ�����ݿ�����Ӳ������ݿ�
			//String sql = "SELECT COMMAND,DESCRIPTION,CONTENT from message";
			
			//ʹ��StringBuilder�������ַ���������ַ� 
			StringBuilder sql = new StringBuilder("SELECT COMMAND,DESCRIPTION,CONTENT from message where 1=1");
			
			List<String> paramList = new ArrayList<String>();
			//Ҫ�����ݿ����ӵ�ʱ������characterEncoding=utf8������鲻������
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
				/*Ϊʲô���ܶ�ȡID
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
