package com.hmy.myapp.product.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hmy.myapp.product.ProductVO;
import com.hmy.myapp.util.SqlSessionFactoryBean;

@Repository("productDAO")
public class ProductDAO {
	
	private SqlSession mybatis;

	public ProductDAO() {
		mybatis= SqlSessionFactoryBean.getSqlSessionInstace();
	}
	
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
