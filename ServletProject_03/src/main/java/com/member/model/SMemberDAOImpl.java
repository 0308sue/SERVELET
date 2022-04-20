package com.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConnection;

public class SMemberDAOImpl implements SMemberDAO {

	private static SMemberDAO instance = new SMemberDAOImpl();
	public static SMemberDAO getInstance() {
		return instance;
	}
	@Override
	public void memberJoin(SMemberDTO member) {
		String sql = "insert into memberdb values(?,?,?,?,?,?)";
		try (Connection con =DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, member.getName());
				ps.setString(2, member.getUserid());
				ps.setString(3, member.getPwd());
				ps.setString(4, member.getEmail());
				ps.setString(5, member.getPhone());
				ps.setInt(6, member.getAdmin());
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
	public ArrayList<SMemberDTO> getMember() {
		ArrayList<SMemberDTO> arr = new  ArrayList<SMemberDTO>();
		String sql = "select * from memberdb";
		try (Connection con =DBConnection.getConnection();
			Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)){
			while(rs.next()) {
				SMemberDTO member = new SMemberDTO();
				member.setAdmin(rs.getInt("admin"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setPwd(rs.getString("pwd"));
				member.setUserid(rs.getString("userid"));
				arr.add(member);
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
	public int memberDelete(String userid) {
		int flag = 0;
		String sql="delete from memberdb where userid ='" +userid+"'";
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
	public int memberUpdate(SMemberDTO member) {
		int flag = 0;
		String sql = "update memberdb set name =?,pwd=?,email=?,phone=?,admin=? where userid=?";
		try (Connection con =DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1, member.getName());
			ps.setString(2, member.getPwd());
			ps.setString(3, member.getEmail());
			ps.setString(4, member.getPhone());
			ps.setInt(5, member.getAdmin());
			ps.setString(6, member.getUserid());
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public SMemberDTO findByID(String userid) {
		String sql="select * from memberdb where userid ='" +userid+"'";
		SMemberDTO member = null;
		try(Connection con =DBConnection.getConnection();
			Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)){
			if(rs.next()) {
				member = new SMemberDTO();
				member.setAdmin(rs.getInt("admin"));
				member.setEmail(rs.getString("email"));
				member.setName(rs.getString("name"));
				member.setPhone(rs.getString("phone"));
				member.setPwd(rs.getString("pwd"));
				member.setUserid(rs.getString("userid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public int memberCount() {
		String sql = "select count(*) from memberdb";
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
	public String memberIdCheck(String userid) {
		String flag ="yes";
		String sql="select * from memberdb where userid ='" +userid+"'";
		try(Connection con =DBConnection.getConnection();
			Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql))
		{if(rs.next()) {
			flag = "no";
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public SMemberDTO memberLoginCheck(String userid, String pwd) {
		SMemberDTO member = new SMemberDTO();
		member.setAdmin(-1);
		
		String sql="select * from memberdb where userid='" +userid+"'";
		try(Connection con =DBConnection.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql))
		{
			if(rs.next()) {
				if(rs.getString("pwd").equals(pwd)) {
					member.setAdmin(rs.getInt("admin"));
					member.setEmail(rs.getString("email"));
					member.setName(rs.getString("name"));
					member.setPhone(rs.getString("phone"));
					member.setUserid(rs.getString("userid"));
					
				}else {
					member.setAdmin(2);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
}
