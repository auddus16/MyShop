package com.hmy.myapp.product.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hmy.myapp.product.ProductVO;

@Repository("productDAO")
public class ProductDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public ProductVO getProduct(ProductVO vo) {
		return (ProductVO)mybatis.selectOne("ProductDAO.getProduct", vo);
	}

	public List<ProductVO> getProductList() {
		return mybatis.selectList("ProductDAO.getProductList");
	}
	
	public List<ProductVO> searchList(String s) {
		return mybatis.selectList("ProductDAO.searchList", s);
	}

}
