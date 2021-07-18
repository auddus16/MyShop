package com.hmy.myapp.member.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmy.myapp.member.MemberService;
import com.hmy.myapp.member.MemberVO;

@Service("MemberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memDAO;
	
	@Override
	public void insertUsers(MemberVO mem) {
		// TODO Auto-generated method stub
		memDAO.insertMember(mem);
	}

	@Override
	public MemberVO getUsers(MemberVO mem) {
		// TODO Auto-generated method stub
		return memDAO.getMember(mem);
	}

}
