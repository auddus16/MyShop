package com.hmy.myapp.purchase.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hmy.myapp.member.MemberVO;
import com.hmy.myapp.purchase.PurchaseVO;

@Repository("purchaseDAO")
public class PurchaseDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertPurchase(PurchaseVO vo) {
		String sql="INSERT INTO PURCHASE (ORDERNUM, NUM, NAME, CNT) VALUES((SELECT NVL(max(ORDERNUM),0)+1 FROM PURCHASE),?,?,?)";
		String sql2="UPDATE PRODUCT SET CNT=CNT-? WHERE NAME=?";
		// nvl( , )
		// null���� �ٸ��� or 0���� �����ϴ� �Լ�
		System.out.println("insertPurchase() ������");
		jdbcTemplate.update(sql, vo.getNum(),vo.getName(),vo.getCnt());
		jdbcTemplate.update(sql2, vo.getCnt(),vo.getName());
	}
	
	public void updatePurchase(PurchaseVO vo) {
		String sql="UPDATE PURCHASE SET CNT=? WHERE ORDERNUM=?";
		System.out.println("updatePurchase() ������");
		
		jdbcTemplate.update(sql, vo.getCnt(),vo.getOrdernum());
	}
	
	public void deletePurchase(PurchaseVO vo) {
		String sql="DELETE FROM PURCHASE WHERE ORDERNUM=?";
		String sql2="UPDATE PRODUCT SET CNT=CNT+? WHERE NAME=?";
		System.out.println("deletePusrchase() ������");
		
		jdbcTemplate.update(sql, vo.getOrdernum());
		jdbcTemplate.update(sql2, vo.getCnt(),vo.getName());
	}
	
	public PurchaseVO getPurchase(PurchaseVO vo) {
		String sql="SELECT * FROM PURCHASE WHERE ORDERNUM=?";
		System.out.println("getPurchase() ������");
		Object[] args= {vo.getOrdernum()};
		return jdbcTemplate.queryForObject(sql, args,new PurchaseRowMapper());
		
	}
	
	public List<PurchaseVO> getPurchaseList(MemberVO vo) {
		String sql="SELECT * FROM PURCHASE WHERE NUM=? ORDER BY ORDERDATE DESC";
		System.out.println("getPurchaseList() ������");
		List<PurchaseVO> datas=new ArrayList<PurchaseVO>();
		Object[] args= {vo.getNum()};
		return jdbcTemplate.query(sql, args, new PurchaseRowMapper());
	}
}

class PurchaseRowMapper implements RowMapper{

	@Override
	public PurchaseVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PurchaseVO data=new PurchaseVO();
		data.setOrdernum(rs.getInt("ordernum"));
		data.setName(rs.getString("name"));
		data.setNum(rs.getInt("num"));
		data.setOrderdate(rs.getDate("orderdate"));
		data.setCnt(rs.getInt("cnt"));
		return data;
	}
	
}
