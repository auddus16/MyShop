package com.hmy.myapp.product.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hmy.myapp.product.ProductVO;

@Repository("productDAO")
public class ProductDAO{
	@PersistenceContext
	private EntityManager em;
	
	public ProductVO getProduct(ProductVO vo) {
		TypedQuery<ProductVO> query = em.createQuery("SELECT p FROM product as p WHERE NUM=p.num", ProductVO.class);
		return query.getResultList().get(0);
	}

	public List<ProductVO> getProductList() {
		TypedQuery<ProductVO> query= em.createQuery("SELECT p FROM product as p ORDER BY p.num DESC", ProductVO.class);
		return query.getResultList();
	}
	
	public List<ProductVO> searchList(String s) {
		String sql="SELECT p FROM product as p WHERE p.name LIKE '%"+s+"%' ORDER BY p.num DESC";
		TypedQuery<ProductVO> query= em.createQuery(sql, ProductVO.class);
		return query.getResultList();
	}
}
