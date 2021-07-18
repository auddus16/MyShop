package com.hmy.myapp.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hmy.myapp.product.ProductVO;
import com.hmy.myapp.product.impl.ProductDAO;

public class ProductListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("상품목록조회중");
		
		ProductDAO dao= new ProductDAO();
		List<ProductVO> arr= dao.getProductList();
	
		ModelAndView mav= new ModelAndView();
		mav.addObject("proList", arr);
		mav.setViewName("productList.jsp");
		
		return mav;
	}

}
