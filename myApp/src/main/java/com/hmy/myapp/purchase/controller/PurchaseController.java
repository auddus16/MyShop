package com.hmy.myapp.purchase.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmy.myapp.purchase.PurchaseVO;
import com.hmy.myapp.purchase.impl.PurchaseDAO;

@Controller
public class PurchaseController{

	@RequestMapping("/purchase.do")
	public String purchase(PurchaseVO vo, PurchaseDAO dao, HttpSession session) {
		System.out.println("상품구매중");
		
		vo.setNum((Integer)session.getAttribute("num"));
		
		dao.insertPurchase(vo);
		
		return "redirect:productList.do";
	}

}
