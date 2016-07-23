package com.xieth.javaweb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/checkServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String checkCode = request.getParameter("check");
		HttpSession session = request.getSession();
		Object code = session.getAttribute("code");
		
		System.out.println("code = "+code);
		System.out.println("checkCode = " + checkCode);
		
		if (code.toString().equalsIgnoreCase(checkCode)) {
			session.setAttribute("name", name);
			response.sendRedirect(request.getContextPath() + "/check/sucess.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/check/fail.jsp");
		}
		 
		
		
	}

}
