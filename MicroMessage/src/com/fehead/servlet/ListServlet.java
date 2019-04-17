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
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fehead.bean.Message;
import com.fehead.entity.Page;
import com.fehead.service.QueryService;

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
		
		
		//���ñ����ʽ
		request.setCharacterEncoding("UTF-8");

		//����ҳ���ֵ
		//����command��description
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		//����currentPage
		String currentPage = request.getParameter("currentPage");

		//������ҳ����
		Page page = new Page();
		//��ʱ��֪���ڸ���
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		//�ж��û��ǲ����״δ����ҳ�棬������״δ򿪸�ҳ�棬ֱ������servlet�У�servlet��û�н��յ�ҳ�洫����ֵ
		//servletĬ�Ͻ�����ֵ������Ϊnull����������ʾ��ʱ������״η���ҳ�棬��currentPage����Ϊ1
		if(currentPage==null||!pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			//��Ϊͨ��request����ҳ���currentPageΪ�ַ������ͣ���Page���е�currentPageΪint�ͣ�������Ҫת��
			page.setCurrentPage(Integer.valueOf(currentPage));
		}

		//����service��
		QueryService listService = new QueryService();
		//request.setAttribute("messageList", listService.queryMessageList(command, description));

		//��ѯ��Ϣ�б���ҳ�棨������ҳ���Ԫ�أ�
		request.setAttribute("messageList",listService.queryMessageListByPage(command,description,page));


		//��ҳ�洫ֵ
		//����request�е�command��description����
		request.setAttribute("command", command);
		request.setAttribute("description", description);
		//����request�е�page����
		request.setAttribute("page",page);
			
		//��ҳ����ת
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
