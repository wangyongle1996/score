package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.IUserDao;
import com.service.IUserService;
import com.service.impl.UserServiceImpl;

/**
 * @作者：王永乐
 * 2019年6月3日
 * 
 */
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=UTF-8");
		if (req.getParameter("method").equals("login")) {
			login(req, resp);
		}
	}
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String name = req.getParameter("userName");
		String pwd = req.getParameter("userPwd");
		IUserService ius = new UserServiceImpl();
		String user = ius.queryUser(name, pwd);
		System.out.println("qwe");
		if (user != null) {
			req.getSession().setAttribute("name", user);
			resp.sendRedirect("doctorServlet?method=showAll");
			
		}
		
		
	}

}
