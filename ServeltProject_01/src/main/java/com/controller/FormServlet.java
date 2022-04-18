package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		String[] hobby = req.getParameterValues("hobby");
		String job = req.getParameter("job");
		
		Form f = new Form(name,age,gender,hobby,job);
		
//		Form f = new Form();
//		f.setAge(age);
//		f.setGender(gender);
//		f.setHobby(hobby);
//		f.setJob(job);
//		f.setName(name);
		
		req.setAttribute("form", f);
		
//		req.setAttribute("name", name);
//		req.setAttribute("age", age);
//		req.setAttribute("gender", gender);
//		req.setAttribute("hobby", hobby);
//		req.setAttribute("job", job);
		
		RequestDispatcher rd = req.getRequestDispatcher("FormResult.jsp");
		rd.forward(req, resp);
	}
}

