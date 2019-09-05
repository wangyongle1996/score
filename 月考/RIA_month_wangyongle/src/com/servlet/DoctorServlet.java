package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.bean.Doctor;
import com.service.IDoctorService;
import com.service.impl.DoctorServiceImpl;

/**
 * @作者：王永乐
 * 2019年6月3日
 * 
 */
@WebServlet("/doctorServlet")
public class DoctorServlet extends HttpServlet{
	IDoctorService ids = new DoctorServiceImpl();
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
		if (req.getParameter("method").equals("showAll")) {
			showAll(req, resp);
			
		}
		if (req.getParameter("method").equals("add")) {
			add(req, resp);
			
		}
		if (req.getParameter("method").equals("update")) {
			update(req, resp);
			
		}
		if (req.getParameter("method").equals("deleteBatch")) {
			deleteBatch(req, resp);
			
		}
		if (req.getParameter("method").equals("select")) {
			select(req, resp);
			
		}
	}
	private void select(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		String is = req.getParameter("id");
		Integer id = Integer.valueOf(is);
		Doctor d = ids.queryOne(id);
		Object json = JSON.toJSON(d);
		resp.getWriter().print(json);
	}

	protected void showAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Doctor> li = ids.queryAllDoctors();
		req.setAttribute("li", li);
		req.getRequestDispatcher("list.jsp").forward(req, resp);
		
	}
	protected void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String[] hobbys = req.getParameterValues("hobby");
		String str = "";
		for (String s : hobbys) {
			str += s + ",";
		}
		String hobby = str.substring(0,str.length()-1);
		String birth = req.getParameter("birth");
		String deptName = req.getParameter("deptName");
		Doctor d = new Doctor(null, name, gender, hobby, birth, deptName);
//		System.out.println(name+birth);
		Integer i = ids.addDoctor(d);
		resp.getWriter().print(i);
//		req.getRequestDispatcher("doctorServlet?method=showAll").forward(req, resp);
	}
	protected void update(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String is = req.getParameter("id");
		Integer id = Integer.valueOf(is);
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String[] hobbys = req.getParameterValues("hobby");
		String str = "";
		for (String s : hobbys) {
			str += s + ",";
		}
		String hobby = str.substring(0,str.length()-1);
		String birth = req.getParameter("birth");
		String deptName = req.getParameter("deptName");	
		Doctor d = new Doctor(id, name, gender, hobby, birth, deptName);

		Integer i = ids.modifyDoctor(d);
		req.getRequestDispatcher("doctorServlet?method=showAll").forward(req, resp);
	}
	protected void deleteBatch(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id1 = req.getParameter("id");
		String id = id1.substring(0,id1.length()-1);
		Integer i = ids.dropBatchByIds(id);
		
	}
}
