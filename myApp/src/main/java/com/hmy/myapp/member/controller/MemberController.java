package com.hmy.myapp.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmy.myapp.member.MemberVO;
import com.hmy.myapp.member.impl.MemberDAO;

@Controller
public class MemberController {
	
	@RequestMapping(value="/login.do")
	public String login(MemberVO vo, MemberDAO dao, HttpSession session) {
		System.out.println("로그인중");
		
		MemberVO mem= dao.getMember(vo);
		
		session.setAttribute("num", mem.getNum());
		
		return "redirect:productList.do";
	}
	
	@RequestMapping(value="/join.do")
	public String join(MemberVO vo, MemberDAO dao) {
		System.out.println("회원가입중");
		
		dao.insertMember(vo);
		
		return "login.jsp";
	}
}
