package com.fehead.servlet;

import com.fehead.bean.Command;
import com.fehead.bean.CommandContent;
import com.fehead.service.MaintainService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertOneServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public InsertOneServlet() {
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
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		CommandContent commandContent1 = new CommandContent();
		CommandContent commandContent2 = new CommandContent();
		commandContent1.setContent(request.getParameter("content1"));
		commandContent2.setContent(request.getParameter("content2"));

		List<CommandContent> commandContentList = new ArrayList<>();
		commandContentList.add(commandContent1);
		commandContentList.add(commandContent2);

		for(CommandContent commandContent:commandContentList){
			System.out.println(commandContent);
		}

		MaintainService maintainService = new MaintainService();
		maintainService.insertOne(name,description,commandContentList);

		request.getRequestDispatcher("/List.action").forward(request,response);
		
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
