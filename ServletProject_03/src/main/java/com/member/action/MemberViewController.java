package com.member.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.SMemberDAO;
import com.member.model.SMemberDAOImpl;
import com.member.model.SMemberDTO;
import com.util.SHA256;

/**
 * Servlet implementation class MemberViewController
 */
@WebServlet("/member/update")
public class MemberViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		SMemberDTO suser=(SMemberDTO)session.getAttribute("suser");
		   SMemberDAO dao = SMemberDAOImpl.getInstance();
		   SMemberDTO member = dao.findByID(suser.getUserid());
		   request.setAttribute("member", member);
		   request.getRequestDispatcher("memberView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 SMemberDTO member = new SMemberDTO();
		 member.setAdmin(Integer.parseInt(request.getParameter("admin")));
		 member.setName(request.getParameter("name"));
		 member.setEmail(request.getParameter("email"));
		 member.setPhone(request.getParameter("phone"));
		 String userid = request.getParameter("userid");
		 String pwd = request.getParameter("pwd");
		 member.setUserid(userid);
		
		 String encPwd = SHA256.getEncrypt(pwd,userid);
		 member.setPwd(encPwd);
		 		 
		   SMemberDAO dao = SMemberDAOImpl.getInstance();
		   dao.memberUpdate(member);
		   response.sendRedirect("login");
	}

}
