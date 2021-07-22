package com.hmy.myapp.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmy.myapp.product.ProductService;
import com.hmy.myapp.product.ProductVO;

@Controller
public class ProductController{
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/product.do")
	public String product(ProductVO vo, Model m) {
		System.out.println("��ǰ����ȸ��");
		
		ProductVO pro= productService.getProduct(vo); 
		
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
	public String productList(Model m) {
		System.out.println("��ǰ�����ȸ��");
		
		List<ProductVO> arr= productService.getProductList();
	
		m.addAttribute("proList", arr);
		
		return "productList.jsp";
	}
	
	@RequestMapping(value="/search.do")
	public String search(@ModelAttribute("p")ProductVO vo, Model m) {
		System.out.println("��ǰ��ȸ��");
		
		List<ProductVO> arr= productService.searchList(vo);
		
		m.addAttribute("proList", arr);
		
		return "productList.jsp";
	}

}
