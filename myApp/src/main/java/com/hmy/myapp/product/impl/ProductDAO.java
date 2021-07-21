package com.hmy.myapp.product.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hmy.myapp.product.ProductVO;

@Repository("productDAO")
public class ProductDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ProductVO getProduct(ProductVO vo) {
		String sql = "select * from product where num=?";
		System.out.println("getProduct() 수행중");
		Object[] args = { vo.getNum() };
		return jdbcTemplate.queryForObject(sql, args, new ProductRowMapper());
	}

	public List<ProductVO> getProductList() {
		String sql = "select * from product order by num desc";
		System.out.println("getProductList() 수행중");
		return jdbcTemplate.query(sql, new ProductRowMapper());
	}

}
class ProductRowMapper implements RowMapper {

	@Override
	public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductVO data = new ProductVO();
		data.setCnt(rs.getInt("cnt"));
		data.setName(rs.getString("name"));
		data.setNum(rs.getInt("num"));
		data.setPic(rs.getString("pic"));
		data.setPrice(rs.getInt("price"));
		return data;
	}

}
