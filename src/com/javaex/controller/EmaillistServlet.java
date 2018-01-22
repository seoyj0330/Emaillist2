package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.EmaillistDao;
import com.javaex.vo.EmaillistVo;

//controller 임

@WebServlet("/el") 	//웹에서의 이름을정해준것 EmaillistServlet은 너무 길고 오타 가능성이 있으니까 el로   
public class EmaillistServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet 진입");
		
		String actionName = request.getParameter("a");		//a=form 이라는 약속을 하였음		
		
		if("form".equals(actionName)) {		//localhost:8088/emaillist2/el?a=form
			
		System.out.println("form에 진입");
		
		RequestDispatcher rd = request.getRequestDispatcher("form.jsp");	
		rd.forward(request, response);
		
		} else if("insert".equals(actionName)) {		//localhost:8088/emaillist2/el?a=insert
			
			System.out.println("insert 진입");
			
			String lastName = request.getParameter("ln");
			String firstName = request.getParameter("fn");
			String email = request.getParameter("email");
			
			EmaillistVo vo= new EmaillistVo();
			vo.setLastName(lastName);
			vo.setFirstName(firstName);
			vo.setEmail(email);
		
			System.out.println(vo.toString());
			
			EmaillistDao dao = new EmaillistDao();
			dao.insert(vo);
			
			response.sendRedirect("el?a=list");
			
		} else if("list".equals(actionName)) {
				
			System.out.println("list 진입");
			
			EmaillistDao dao = new EmaillistDao();
			List<EmaillistVo> list = dao.getList();
			
			request.setAttribute("list", list);   //1번째는 이름이고 2번째는 부를이름 
			
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
			
		} else {
			
			System.out.println("잘못된 a값으로 누락");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
