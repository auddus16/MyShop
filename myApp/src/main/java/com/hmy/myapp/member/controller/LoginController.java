package com.hmy.myapp.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hmy.myapp.member.MemberVO;
import com.hmy.myapp.member.impl.MemberDAO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그인중");
		
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		
		MemberVO vo =new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		
		MemberDAO dao= new MemberDAO();
		MemberVO mem= dao.getMember(vo);
		HttpSession session= request.getSession();
		session.setAttribute("num", mem.getNum());
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("productList.do");
		
		return mav;
	}

}
