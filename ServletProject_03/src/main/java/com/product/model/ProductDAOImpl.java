package com.product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.util.DBConnection;


public class ProductDAOImpl implements ProductDAO {

	private static ProductDAO instance = new ProductDAOImpl();
	public static ProductDAO getInstance() {
		return instance;
	}

	@Override
	public void productInsert(Product product) {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into product");
		sb.append("(p_productid,p_pname,p_unitPrice,p_description,p_category,p_manufacturer,");
		sb.append("p_unitInStock,p_condition,p_fileName)");
		sb.append("values(product_seq.nextval,?,?,?,?,?,?,?,?)");
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sb.toString());
				){
			ps.setString(1, product.getPname());
			ps.setInt(2, product.getUnitPrice());
			ps.setString(3, product.getDescription());
			ps.setString(4, product.getCategory());
			ps.setString(5, product.getManufacturer());
			ps.setLong(6, product.getUnitsInStock());
			ps.setString(7, product.getCondition());
			ps.setString(8, product.getFilename());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Product> productAllfind() {
		ArrayList<Product> arr = new ArrayList<Product>();
		String sql = "select * from product";
		try(Connection con = DBConnection.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql)
				){
			while(rs.next()) {		
				Product product = new Product();
				product.setCategory(rs.getString("p_category"));
				product.setCondition(rs.getString("p_condition"));
				product.setDescription(rs.getString("p_description"));
				product.setFilename(rs.getString("p_filename"));
				product.setManufacturer(rs.getString("p_manufacturer"));
				product.setPname(rs.getString("p_pname"));
				product.setProductId(rs.getLong("p_productid"));
				product.setUnitPrice(rs.getInt("p_unitPrice"));
				product.setUnitsInStock(rs.getLong("P_UNITINSTOCK"));
				arr.add(product);
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
	public Product findById(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
