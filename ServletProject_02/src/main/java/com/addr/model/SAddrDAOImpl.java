package com.addr.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SAddrDAOImpl implements SAddrDAO {
	private static SAddrDAO instance;
	public static SAddrDAO getInstance() {
		if(instance == null) {
			instance = new SAddrDAOImpl();
		}
		return instance;
	}
	
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	@Override
	public void addrInsert(AddrDTO addr) {
		String sql ="insert into address values(address_seq.nextval,?,?,?,?)";
		try(Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				){
			ps.setString(1, addr.getName());
			ps.setString(2, addr.getAddr());
			ps.setString(3, addr.getZipcode());
			ps.setString(4, addr.getTel());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<AddrDTO> addrList() {
		String sql = "select * from address";
		ArrayList<AddrDTO> arr = new ArrayList<>();
		
		try(Connection con = getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)
				){
			while(rs.next()) {
				AddrDTO ad = new AddrDTO();
				ad.setAddr(rs.getString("addr"));
				ad.setName(rs.getString("name"));
				ad.setNum(rs.getInt("num"));
				ad.setTel(rs.getString("tel"));
				ad.setZipcode(rs.getString("zipcode"));
				arr.add(ad);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arr;
	}

	@Override
	public AddrDTO addrDetail(int num) {
		String sql = "select * from address where num="+num;
		AddrDTO address = null;
		
		try(Connection con = getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				){
			if(rs.next()) {
				address = new AddrDTO();
				address.setAddr(rs.getString("addr"));
				address.setName(rs.getString("name"));
				address.setNum(rs.getInt("num"));
				address.setTel(rs.getString("tel"));
				address.setZipcode(rs.getString("zipcode"));
			}
			
		} catch (SQLException e) {
					e.printStackTrace();
		} catch (Exception e) {
					e.printStackTrace();
		}
		
		return address;
	}

	@Override
	public void addrUpdate(AddrDTO addr) {
		String sql = "update address set name=?, addr=?, zipcode=?, tel=? where num=?";
		
		try(Connection con = getConnection(); 
				PreparedStatement ps =con.prepareStatement(sql);
				){
			  ps.setString(1, addr.getName());
			  ps.setString(2, addr.getAddr());
			  ps.setString(3, addr.getZipcode());
			  ps.setString(4, addr.getTel());
			  ps.setInt(5, addr.getNum());
			  ps.execute();
			  ps.setString(1, addr.getName());
		} catch (SQLException e) {
					e.printStackTrace();
		} catch (Exception e) {
					e.printStackTrace();
		}
		
	}

	@Override
	public void addrDelete(int num) {
		String sql = "delete from address where num="+num;
		
		try(Connection con = getConnection(); 
				Statement st = con.createStatement();){
			st.executeUpdate(sql);
		} catch (SQLException e) {
				e.printStackTrace();
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<AddrDTO> addrSearchList(String field, String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addrCount() {
		String sql = "select count(*) from address";
		int count = 0;
		try(Connection con =getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				){
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
					e.printStackTrace();
		} catch (Exception e) {
				e.printStackTrace();
		}
		return count;
	}

	@Override
	public int addrSearchCount(String field, String word) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ZipDTO> addrZipRead(String dong) {
		// TODO Auto-generated method stub
		return null;
	}

}
