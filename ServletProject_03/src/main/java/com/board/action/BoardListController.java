package com.board.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.model.BoardDTO;
import com.board.model.SBoardDAO;
import com.board.model.SBoardDAOImpl;
import com.util.PageVO;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/board/boardlist")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		SBoardDAO dao = SBoardDAOImpl.getInstance();
		String field = request.getParameter("field")==null?"subject":request.getParameter("field");
		String word = request.getParameter("word")==null?"":request.getParameter("word");
		String pageNum = request.getParameter("pageNum")==null?"1":request.getParameter("pageNum");
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 5;
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = currentPage*pageSize;
		ArrayList<BoardDTO> arr = dao.boarList(field,word,startRow,endRow);
		
		int count = dao.boardCount(field,word);
		
		int totPage = count/pageSize+(count%pageSize ==0?0:1);
		int blockPage = 3;
		int startPage =((currentPage-1)/blockPage)*blockPage+1;
		int endPage = startPage+blockPage-1;
		
		if(endPage > totPage)endPage = totPage;
		
		PageVO page = new PageVO();
		page.setBlockPage(blockPage);
		page.setCurrentPage(currentPage);
		page.setEndPage(endPage);
		page.setField(field);
		page.setStartPage(startPage);
		page.setTotPage(totPage);
		page.setWord(word);
		
		int rowNo = count-(currentPage-1)*pageSize;
		
		request.setAttribute("rowNo", rowNo);
		request.setAttribute("p", page);
		request.setAttribute("boards", arr);
		request.setAttribute("count", count);
		
		request.getRequestDispatcher("boardList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
