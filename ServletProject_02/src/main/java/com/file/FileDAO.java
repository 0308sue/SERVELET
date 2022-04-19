package com.file;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.addr.model.SAddrDAO;
import com.addr.model.SAddrDAOImpl;

public class FileDAO {
	private static FileDAO instance;
	public static FileDAO getInstance() {
		if(instance == null) {
			instance = new FileDAO();
		}
		return instance;
	}
	
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	
	public void fileInsert(FileDTO file) {
		String sql = "insert into imagetest values(?,?,?)";
		
		try(Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);){
			
			ps.setString(1, file.getName());
			ps.setString(2, file.getTitle());
			ps.setString(3, file.getImage());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<FileDTO> fileList(){
		ArrayList<FileDTO> arr = new ArrayList<FileDTO>();
		String sql = "select * from imagetest";
		try(Connection con = getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)
				){
			while(rs.next()) {
				String name = rs.getString("name");
				String title = rs.getString("title");
				String image = rs.getString("image");
				FileDTO file = new FileDTO(name,title,image);
				arr.add(file);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr ;
	}
}
