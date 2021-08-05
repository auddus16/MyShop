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
		System.out.println("insertMember() ������");
		em.merge(vo);
	}

	public MemberVO getMember(MemberVO vo) {
		System.out.println("getMember() ������");
		TypedQuery<MemberVO> query = em.createQuery("SELECT m FROM member as m WHERE ID=m.id AND PW=m.pw", MemberVO.class);
		return query.getResultList().get(0);
	}

	public void updateMember(MemberVO vo) {
		//String sql = "UPDATE MEMBER SET ID=?, PW=?, NAME=?, ADDRESS=? WHERE NUM=?";
		System.out.println("updateMember() ������");
		em.merge(vo);
	}

	public void deleteMember(MemberVO vo) {
		//String sql = "DELETE FROM MEMBER WHERE NUM=?";
		System.out.println("deleteMember() ������");
		//��ƼƼ��ü�� �����Ҷ��� vo�� �ٷ� ����x
		//find()�� ���� ȣ���Ͽ� ��ȯ�޴� ��ü�� ���� ����
		em.remove(vo);
	}
}
