package com.hmy.myapp.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.hmy.myapp.member.MemberVO;
import com.hmy.myapp.member.impl.MemberDAO;

public class JoinController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("회원가입중");
		
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		String name= request.getParameter("name");
		String address= request.getParameter("address");
		
		MemberVO vo =new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		vo.setAddress(address);
		
		MemberDAO dao= new MemberDAO();
		dao.insertMember(vo);
		
		ModelAndView mav= new ModelAndView();
		mav.setViewName("login.jsp");
		
		return mav;
	}

}
