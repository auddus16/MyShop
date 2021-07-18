package com.hmy.myapp.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hmy.myapp.product.ProductVO;
import com.hmy.myapp.product.impl.ProductDAO;

public class CheckProductController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("상품구매확인중");
		
		int num= Integer.parseInt(request.getParameter("num"));
		int cnt= Integer.parseInt(request.getParameter("cnt"));
		int price= Integer.parseInt(request.getParameter("price"));
		String name= request.getParameter("name");
		
		ProductVO vo= new ProductVO();
		vo.setNum(num);
		vo.setCnt(cnt);
		vo.setName(name);
		vo.setPrice(price);
		
		ModelAndView mav= new ModelAndView();
		mav.addObject("pro", vo);
		mav.setViewName("purchase.jsp");
		
		return mav;
	}

}
