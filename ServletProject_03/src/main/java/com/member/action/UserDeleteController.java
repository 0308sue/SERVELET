package com.member.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.member.model.SMemberDAO;
import com.member.model.SMemberDAOImpl;
import com.member.model.SMemberDTO;

/**
 * Servlet implementation class UserDeleteController
 */
@WebServlet("/member/userDelete")
public class UserDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		 SMemberDAO dao = SMemberDAOImpl.getInstance();
		 int flag = dao.memberDelete(userid);
		 
		 ArrayList<SMemberDTO> arr = dao.getMember();
		 int count = dao.memberCount();
		 HashMap<String, Object> hm =  new HashMap<String, Object>();
		 hm.put("jarr", arr);
		 hm.put("count", count);
		 
		 Gson gson = new Gson();
		 String jsonStr = gson.toJson(hm);
		 
		 response.setContentType("application/json;charset=utf-8");
		 PrintWriter out = response.getWriter();
		 out.println(jsonStr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
