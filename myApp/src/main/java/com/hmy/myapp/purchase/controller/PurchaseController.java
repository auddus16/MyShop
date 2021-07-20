package com.hmy.myapp.purchase.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmy.myapp.member.MemberVO;
import com.hmy.myapp.purchase.PurchaseVO;
import com.hmy.myapp.purchase.impl.PurchaseDAO;

@Controller
public class PurchaseController{

	@RequestMapping("/purchase.do")
	public String purchase(PurchaseVO vo, PurchaseDAO dao, HttpSession session) {
		System.out.println("상품구매중");
		
		vo.setNum((Integer)session.getAttribute("num"));
		System.out.println(vo.getName());
		System.out.println(vo.getNum());
		System.out.println(vo.getCnt());
		dao.insertPurchase(vo);
		
		return "redirect:productList.do";
	}
	@RequestMapping("/purchaseList.do")
	public String purchaseList(MemberVO vo, PurchaseDAO dao, HttpSession session, Model m) {
		System.out.println("상품구매중");
		
		if(session.getAttribute("num")==null) {
			return "login.jsp";
		}
		
		vo.setNum((Integer)session.getAttribute("num"));
		
		m.addAttribute("purchaseList", dao.getPurchaseList(vo));
		
		return "purchaseList.jsp";
	}

}
