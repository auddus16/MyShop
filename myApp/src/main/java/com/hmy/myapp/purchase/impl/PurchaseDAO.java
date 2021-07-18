package com.hmy.myapp.purchase.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hmy.myapp.common.JDBC;
import com.hmy.myapp.member.MemberVO;
import com.hmy.myapp.purchase.PurchaseVO;

@Repository("purchaseDAO")
public class PurchaseDAO {
	private Connection conn=null;
	private PreparedStatement pstmt=null;

	public void insertPurchase(PurchaseVO vo) {
		String sql="insert into purchase (ordernum, num, name, cnt) values((select nvl(max(num),0)+1 from purchase),?,?,?)";
		String sql2="update product set cnt=cnt-? where name=?";
		// nvl( , )
		// null값을 다른값 or 0으로 변경하는 함수
		System.out.println("insertPurchase() 수행중");
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getCnt());
			pstmt.executeUpdate();
			
			pstmt= conn.prepareStatement(sql2);
			pstmt.setInt(1, vo.getCnt());
			pstmt.setString(2, vo.getName());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	
	public void deletePurchase(PurchaseVO vo) {
		String sql="delete purchase where ordernum=?";
		System.out.println("deletePusrchase() 수행중");
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getOrdernum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			JDBC.close(conn, pstmt);
		}
	}
	
	public PurchaseVO getPurchase(PurchaseVO vo) {
		String sql="select * from purchase where ordernum=?";
		System.out.println("getPurchase() 수행중");
		PurchaseVO data=null;
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getOrdernum());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new PurchaseVO();
				
				data.setOrdernum(rs.getInt("ordernum"));
				data.setName(rs.getString("name"));
				data.setNum(rs.getInt("num"));
				data.setOrderdate(rs.getString("orderdate"));
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
	
	public List<PurchaseVO> getPurchaseList(MemberVO vo) {
		String sql="select * from purchase where num=? order by id desc";
		System.out.println("getPurchaseList() 수행중");
		List<PurchaseVO> datas=new ArrayList<PurchaseVO>();
		conn=JDBC.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				PurchaseVO data=new PurchaseVO();
				
				data.setOrdernum(rs.getInt("ordernum"));
				data.setName(rs.getString("name"));
				data.setNum(rs.getInt("num"));
				data.setOrderdate(rs.getString("orderdate"));
				data.setCnt(rs.getInt("cnt"));
				
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
