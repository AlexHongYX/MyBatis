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
		
		
		//设置编码格式
		request.setCharacterEncoding("UTF-8");

		//接收页面的值
		//接收command和description
		String command = request.getParameter("command");
		String description = request.getParameter("description");
		//接收currentPage
		String currentPage = request.getParameter("currentPage");

		//创建分页对象
		Page page = new Page();
		//暂时不知道在干嘛
		Pattern pattern = Pattern.compile("[0-9]{1,9}");
		//判断用户是不是首次打开这个页面，如果是首次打开该页面，直接跳到servlet中，servlet并没有接收到页面传来的值
		//servlet默认将所有值都设置为null，所以在显示的时候，如果首次访问页面，则将currentPage设置为1
		if(currentPage==null||!pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			//因为通过request接收页面的currentPage为字符串类型，而Page类中的currentPage为int型，所以需要转换
			page.setCurrentPage(Integer.valueOf(currentPage));
		}

		//调用service层
		QueryService listService = new QueryService();
		//request.setAttribute("messageList", listService.queryMessageList(command, description));

		//查询消息列表传给页面（包含分页相关元素）
		request.setAttribute("messageList",listService.queryMessageListByPage(command,description,page));


		//向页面传值
		//设置request中的command和description对象
		request.setAttribute("command", command);
		request.setAttribute("description", description);
		//设置request中的page对象
		request.setAttribute("page",page);
			
		//向页面跳转
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
