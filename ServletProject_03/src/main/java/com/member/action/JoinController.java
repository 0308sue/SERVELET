package com.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.SMemberDAO;
import com.member.model.SMemberDAOImpl;
import com.member.model.SMemberDTO;
import com.util.SHA256;


/**
 * Servlet implementation class JoinController
 */
@WebServlet("/member/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher rd = request.getRequestDispatcher("join.jsp");
		   rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
		 SMemberDTO member = new SMemberDTO();
		 member.setName(request.getParameter("name"));
		 String userid = request.getParameter("userid");
		 member.setUserid(userid);
		// member.setPwd(request.getParameter("pwd"));
		 member.setEmail(request.getParameter("email"));
		 member.setPhone(request.getParameter("phone"));
		 member.setAdmin(Integer.parseInt(request.getParameter("admin")));
		 
		 String encPwd = SHA256.getEncrypt(request.getParameter("pwd"),userid);
		 member.setPwd(encPwd);
		 
		 
		   SMemberDAO dao = SMemberDAOImpl.getInstance();
		   dao.memberJoin(member);
		   response.sendRedirect("login");
	}

}
