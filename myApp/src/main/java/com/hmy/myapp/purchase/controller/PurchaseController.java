package com.hmy.myapp.purchase.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hmy.myapp.member.MemberVO;
import com.hmy.myapp.purchase.PurchaseListVO;
import com.hmy.myapp.purchase.PurchaseService;
import com.hmy.myapp.purchase.PurchaseVO;

@Controller
public class PurchaseController{
	
	@Autowired
	private PurchaseService purchaseService;
	
	@RequestMapping("/purchase.do")
	public String purchase(PurchaseVO vo, HttpSession session) {
		System.out.println("��ǰ������");
		
		vo.setNum((Integer)session.getAttribute("num"));

		purchaseService.insertPurchase(vo);//����Ͻ� �޼ҵ�
		
		return "redirect:productList.do";
	}
	@RequestMapping("/purchaseList.do")
	public String purchaseList(MemberVO vo, HttpSession session, Model m) {
		System.out.println("��ǰ���Ÿ���Ʈ��ȸ��");
		
		if(session.getAttribute("num")==null) {
			return "login.jsp";
		}
		
		vo.setNum((Integer)session.getAttribute("num"));
		
		m.addAttribute("purchaseList", purchaseService.getPurchaseList(vo));
		
		return "purchaseList.jsp";
	}
	//Xml�����ͷ� ��ȯ
	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public PurchaseListVO dataTransform(MemberVO vo, HttpSession session, Model m) {
		System.out.println("��ǰ���Ÿ���Ʈ��ȸ��");
		
		if(session.getAttribute("num")==null) {
			return null;
		}
		
		vo.setNum((Integer)session.getAttribute("num"));
		List<PurchaseVO> datas= purchaseService.getPurchaseList(vo);
		PurchaseListVO plVO= new PurchaseListVO();
		plVO.setPurchaseList(datas);
		
		return plVO;
	}
	//json�����ͷ� ��ȯ
	@RequestMapping("/dataTransform2.do")
	@ResponseBody
	public List<PurchaseVO> dataTransform2(MemberVO vo, HttpSession session, Model m) {
		System.out.println("��ǰ���Ÿ���Ʈ��ȸ��");
		
		if(session.getAttribute("num")==null) {
			return null;
		}
		
		vo.setNum((Integer)session.getAttribute("num"));
		List<PurchaseVO> datas= purchaseService.getPurchaseList(vo);
		
		return datas;
	}
	@RequestMapping("/deletePurchase.do")
	public String deletePurchase(PurchaseVO vo) {
		System.out.println("��ǰ���������");
		System.out.println(vo.getOrdernum());
		purchaseService.deletePurchase(vo);
		
		return "redirect:purchaseList.do";
	}

}
