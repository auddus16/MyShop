package com.hmy.myapp.purchase.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hmy.myapp.purchase.PurchaseVO;
import com.hmy.myapp.purchase.impl.PurchaseDAO;

public class PurchaseController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("상품구매중");
		
		HttpSession session= request.getSession();
		
		PurchaseVO vo= new PurchaseVO();
		vo.setName(request.getParameter("name"));
		vo.setNum((Integer)session.getAttribute("num"));
		vo.setCnt(Integer.parseInt(request.getParameter("cnt")));
		
		
		PurchaseDAO dao= new PurchaseDAO();
		
		dao.insertPurchase(vo);
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("productList.do");
		
		return mav;
	}

}
