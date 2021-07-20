package com.hmy.myapp.product.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmy.myapp.product.ProductVO;
import com.hmy.myapp.product.impl.ProductDAO;

@Controller
public class ProductController{

	@RequestMapping(value="/product.do")
	public String product(ProductVO vo, ProductDAO dao, Model m) {
		System.out.println("��ǰ����ȸ��");
		
		ProductVO pro= dao.getProduct(vo); 
		
		m.addAttribute("pro", pro);
		
		return "product.jsp";
	}
	
	@RequestMapping(value="/checkproduct.do")
	public String checkProduct(ProductVO vo, Model m) {
		System.out.println("��ǰ����Ȯ����");
		
		m.addAttribute("pro", vo);
		
		return "purchase.jsp";
		
	}
	
	@RequestMapping(value="/productList.do")
	public String productList(ProductDAO dao, Model m) {
		System.out.println("��ǰ�����ȸ��");
		
		List<ProductVO> arr= dao.getProductList();
	
		m.addAttribute("proList", arr);
		
		return "productList.jsp";
	}

}
