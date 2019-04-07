package com.fehead.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fehead.bean.Message;

@SuppressWarnings("serial")
public class ListServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public ListServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * ����JDBC�������ݿ�
		 * */
		try {
			request.setCharacterEncoding("UTF-8");
			//����command��description
			String command = request.getParameter("command");
;			String description = request.getParameter("description");
			//������������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//������ݿ������
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/micro_message?serverTimezone=GMT","xiaoaxiao","8023hyx1999hyx"
					);
			//ͨ�����ݿ�����Ӳ������ݿ�
			//String sql = "SELECT COMMAND,DESCRIPTION,CONTENT from message";
			
			//ʹ��StringBuilder�������ַ���������ַ�
			StringBuilder sql = new StringBuilder("SELECT COMMAND,DESCRIPTION,CONTENT from message");
			
			List<String> paramList = new ArrayList<String>();
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
			List<Message> messageList = new ArrayList<Message>();
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
			
			/*��ӡһ����Ϣ����
			 * for (Message message : messageList) {
				System.out.println(message);
			}
			 * */
			
			//����request��message����
			request.setAttribute("messageList", messageList);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("/WEB-INF/jsps/back/list.jsp").forward(request,response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
