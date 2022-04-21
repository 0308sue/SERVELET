package com.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.member.model.SMemberDTO;
import com.util.DBConnection;



public class SBoardDAOImpl implements SBoardDAO {
	
	private static SBoardDAO instance = new SBoardDAOImpl();
	public static SBoardDAO getInstance() {
		return instance;
	}
	@Override
	public void boardInsert(BoardDTO board) {
		String sql = "insert into simpleboard values(simpleboard_seq.nextval,?,?,?,0,?,sysdate)";
		try (Connection con =DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, board.getUserid());
				ps.setString(2, board.getSubject());
				ps.setString(3, board.getEmail());
				ps.setString(4, board.getContent());
				
				ps.executeUpdate();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void boardUpdate(BoardDTO board) {
		String sql = "update simpleboard set subject=?,email=?,content=?,regdate=sysdate where num=?";
		try (Connection con =DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, board.getSubject());
			ps.setString(2, board.getEmail());
			ps.setString(3, board.getContent());
			ps.setInt(4, board.getNum());
	
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	

	@Override
	public ArrayList<BoardDTO> boarList() {
		ArrayList<BoardDTO> arr = new  ArrayList<BoardDTO>();
		String sql = "select * from simpleboard";
		try (Connection con =DBConnection.getConnection();
			Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)){
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setContent(rs.getString("content"));
				board.setEmail(rs.getString("email"));
				board.setNum(rs.getInt("num"));
				board.setReadcount(rs.getInt("readcount"));
				board.setSubject(rs.getString("subject"));
				board.setUserid(rs.getString("userid"));
				board.setRegdate(rs.getString("regdate"));
				arr.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public int boardDelete(int num) {
		int flag = 0;
		String sql="delete from simpleboard where num = "+num;
		try(Connection con =DBConnection.getConnection();
			Statement st = con.createStatement();
			){
			flag = st.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return flag;
	}

	@Override
	public int boardCount(String field, String word) {
		String sql = "select count(*) from simpleboard where "+ field +" like '%"+word+"%'";
		int count = 0;
		try(Connection con =DBConnection.getConnection();
			Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)){
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public BoardDTO findByNum(int num) {
		String sql="select * from simpleboard where num ='" +num+"'";
		BoardDTO board = null;
		try(Connection con =DBConnection.getConnection();
			Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)){
			if(rs.next()) {
				board = new BoardDTO();
				board.setContent(rs.getString("content"));
				board.setEmail(rs.getString("email"));
				board.setNum(rs.getInt("num"));
				board.setReadcount(rs.getInt("readcount"));
				board.setSubject(rs.getString("subject"));
				board.setUserid(rs.getString("userid"));
				board.setRegdate(rs.getString("regdate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public void commentInsert(CommentDTO comment) {
		String sql = "insert into comboard values(comboard_seq.nextval,?,?,sysdate,?)";
		try (Connection con =DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, comment.getUserid());
				ps.setString(2, comment.getMsg());
				ps.setInt(3, comment.getBnum());
	
				ps.executeUpdate();
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<CommentDTO> findAllComment(int bnum) {
		ArrayList<CommentDTO> arr = new  ArrayList<CommentDTO>();
		String sql = "select * from comboard where bnum =" +bnum;
		try (Connection con =DBConnection.getConnection();
			Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)){
			while(rs.next()) {
				CommentDTO comment = new CommentDTO();
				comment.setBnum(rs.getInt("bnum"));
				comment.setCnum(rs.getInt("cnum"));
				comment.setMsg(rs.getString("msg"));
				comment.setRegdate(rs.getString("regdate"));
				comment.setUserid(rs.getString("userid"));
				arr.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public int commentCount(int bnum) {
		String sql = "select count(*) from comboard where bnum =" +bnum;
		int count = 0;
		try(Connection con =DBConnection.getConnection();
			Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)){
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public ArrayList<BoardDTO> boarList(String field, String word, int startRow, int endRow) {
		ArrayList<BoardDTO> arr = new ArrayList<BoardDTO>();
		StringBuilder sb = new StringBuilder();
		sb.append("select * from (");
		sb.append(" select rownum rn,aa. * from (");
		sb.append(" select * from simpleboard where "+ field +" like '%"+word+"%'" );
		sb.append(" order by num desc)aa");
		sb.append(" where rownum <=?");
		sb.append(")where rn >=?");
		try(Connection con =DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sb.toString());
				){
			ps.setInt(1, endRow);
			ps.setInt(2,startRow);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				BoardDTO board = new BoardDTO();
				board.setContent(rs.getString("content"));
				board.setEmail(rs.getString("email"));
				board.setNum(rs.getInt("num"));
				board.setReadcount(rs.getInt("readcount"));
				board.setSubject(rs.getString("subject"));
				board.setUserid(rs.getString("userid"));
				board.setRegdate(rs.getString("regdate"));
				arr.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}

}
