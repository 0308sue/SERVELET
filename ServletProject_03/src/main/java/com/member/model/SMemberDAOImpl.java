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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int memberDelete(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int memberUpdate(SMemberDTO member) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public SMemberDTO findByID(String usetid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int memberCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String memberIdCheck(String userid) {
		// TODO Auto-generated method stub
		return null;
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
