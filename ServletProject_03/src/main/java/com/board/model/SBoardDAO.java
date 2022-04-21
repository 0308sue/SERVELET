package com.board.model;

import java.util.ArrayList;

public interface SBoardDAO {
	public void  boardInsert(BoardDTO board);
	public void  boardUpdate(BoardDTO board);
	public ArrayList<BoardDTO> boarList(String field,String word,int startRow,int endRow);
	public ArrayList<BoardDTO> boarList();
	public int boardDelete(int num);
	public int boardCount(String field,String word);
	public BoardDTO findByNum(int num);
	
	public void commentInsert(CommentDTO comment);
	public ArrayList<CommentDTO> findAllComment(int bnum);
	public int commentCount(int bnum);
}
