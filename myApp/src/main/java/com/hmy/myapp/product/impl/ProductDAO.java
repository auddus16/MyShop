package com.hmy.myapp.product.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hmy.myapp.common.JDBC;
import com.hmy.myapp.product.ProductVO;

@Repository("productDAO")
public class ProductDAO {
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	
	public ProductVO getProduct(ProductVO vo) {
	      String sql="select * from product where num=?";
	      System.out.println("getProduct() 수행중");
	      ProductVO data=null;
	      conn=JDBC.getConnection();
	      try {
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setInt(1, vo.getNum());
	         ResultSet rs=pstmt.executeQuery();
	         if(rs.next()) {
	            data=new ProductVO();
	            data.setNum(rs.getInt("num"));
	            data.setName(rs.getString("name"));
	            data.setPrice(rs.getInt("price"));
	            data.setPic(rs.getString("pic"));
	            data.setCnt(rs.getInt("cnt"));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      finally {
	         JDBC.close(conn, pstmt);
	      }
	      return data;
	   }
	
	public List<ProductVO> getProductList() {
		String sql="select * from product order by num desc";
		System.out.println("getProductList() 수행중");
		List<ProductVO> datas= new ArrayList<ProductVO>();
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				ProductVO data=new ProductVO();
				data.setCnt(rs.getInt("cnt"));
				data.setName(rs.getString("name"));
				data.setNum(rs.getInt("num"));
				data.setPic(rs.getString("pic"));
				data.setPrice(rs.getInt("price"));
				
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
		return datas;
	}
	}

