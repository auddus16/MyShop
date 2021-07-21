package com.hmy.myapp.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hmy.myapp.member.MemberService;
import com.hmy.myapp.member.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/login.do")
	public String login(MemberVO vo, HttpSession session) {
		System.out.println("로그인중");
		
		MemberVO mem= memberService.getMember(vo);
		
		session.setAttribute("num", mem.getNum());
		
		return "redirect:productList.do";
	}
	
	@RequestMapping(value="/join.do")
	public String join(MemberVO vo) {
		System.out.println("회원가입중");
		
		memberService.insertMember(vo);
		
		return "login.jsp";
	}
}
