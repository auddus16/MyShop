package com.hmy.myapp.product;

import java.util.List;

public interface ProductService {
	ProductVO getProduct(ProductVO vo);
	List<ProductVO> getProductList();
	List<ProductVO> searchList(String s);
}
