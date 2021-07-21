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
		String sql="insert into purchase (ordernum, num, name, cnt) values((select nvl(max(ordernum),0)+1 from purchase),?,?,?)";
		String sql2="update product set cnt=cnt-? where name=?";
		// nvl( , )
		// null값을 다른값 or 0으로 변경하는 함수
		System.out.println("insertPurchase() 수행중");
		jdbcTemplate.update(sql, vo.getNum(),vo.getName(),vo.getCnt());
		jdbcTemplate.update(sql2, vo.getCnt(),vo.getName());
	}
	
	public void updatePurchase(PurchaseVO vo) {
		String sql="update purchase set cnt=? where ordernum=?";
		System.out.println("updatePurchase() 수행중");
		
		jdbcTemplate.update(sql, vo.getCnt(),vo.getOrdernum());
	}
	
	public void deletePurchase(PurchaseVO vo) {
		String sql="delete from purchase where ordernum=?";
		System.out.println("deletePusrchase() 수행중");
		
		jdbcTemplate.update(sql, vo.getOrdernum());
	}
	
	public PurchaseVO getPurchase(PurchaseVO vo) {
		String sql="select * from purchase where ordernum=?";
		System.out.println("getPurchase() 수행중");
		Object[] args= {vo.getOrdernum()};
		return jdbcTemplate.queryForObject(sql, args,new PurchaseRowMapper());
		
	}
	
	public List<PurchaseVO> getPurchaseList(MemberVO vo) {
		String sql="select * from purchase where num=? order by orderdate desc";
		System.out.println("getPurchaseList() 수행중");
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
		data.setOrderdate(rs.getString("orderdate"));
		data.setCnt(rs.getInt("cnt"));
		return data;
	}
	
}
