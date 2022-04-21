package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.model.CommentDTO;
import com.board.model.SBoardDAO;
import com.board.model.SBoardDAOImpl;
import com.google.gson.Gson;
import com.member.model.SMemberDTO;

/**
 * Servlet implementation class CommentListController
 */
@WebServlet("/board/commentlist")
public class CommentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		
		SBoardDAO dao = SBoardDAOImpl.getInstance();
		
		ArrayList<CommentDTO> carr = dao.findAllComment(bnum);
		int count = dao.commentCount(bnum);
	
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("jarr", carr);
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
