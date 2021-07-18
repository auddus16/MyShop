package com.hmy.myapp.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hmy.myapp.product.ProductVO;
import com.hmy.myapp.product.impl.ProductDAO;

public class ProductController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("상품상세조회중");
		
		String num= request.getParameter("num");
		ProductVO vo= new ProductVO();
		vo.setNum(Integer.parseInt(num));
		
		ProductDAO dao= new ProductDAO();
		
		ProductVO pro= dao.getProduct(vo); 
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("pro", pro);
		mav.setViewName("product.jsp");
		
		return mav;
	}

}
