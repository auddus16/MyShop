package com.hmy.myapp.member.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hmy.myapp.member.MemberVO;

@Repository("memDAO")
@Transactional
public class MemberDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insertMember(MemberVO vo) {
		System.out.println("insertMember() 수행중");
		em.merge(vo);
	}

	public MemberVO getMember(MemberVO vo) {
		System.out.println("getMember() 수행중");
		TypedQuery<MemberVO> query = em.createQuery("SELECT m FROM member as m WHERE ID=m.id AND PW=m.pw", MemberVO.class);
		return query.getResultList().get(0);
	}

	public void updateMember(MemberVO vo) {
		//String sql = "UPDATE MEMBER SET ID=?, PW=?, NAME=?, ADDRESS=? WHERE NUM=?";
		System.out.println("updateMember() 수행중");
		em.merge(vo);
	}

	public void deleteMember(MemberVO vo) {
		//String sql = "DELETE FROM MEMBER WHERE NUM=?";
		System.out.println("deleteMember() 수행중");
		//엔티티객체를 삭제할때는 vo를 바로 삭제x
		//find()를 먼저 호출하여 변환받는 객체를 삭제 진행
		em.remove(vo);
	}
}
