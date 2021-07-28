package com.hmy.myapp.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmy.myapp.product.ProductService;
import com.hmy.myapp.product.ProductVO;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public ProductVO getProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		return productDAO.getProduct(vo);
	}

	@Override
	public List<ProductVO> getProductList() {
		// TODO Auto-generated method stub
		return productDAO.getProductList();
	}

	@Override
	public List<ProductVO> searchList(String s) {
		// TODO Auto-generated method stub
		return productDAO.searchList(s);
	}

}
