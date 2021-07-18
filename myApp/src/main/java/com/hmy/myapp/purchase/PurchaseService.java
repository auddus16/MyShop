package com.hmy.myapp.purchase;

import java.util.List;

import com.hmy.myapp.member.MemberVO;

public interface PurchaseService {
	void insertPurchase(PurchaseVO vo);

	//void updateBoard(PurchaseVO vo);

	void deleteBoard(PurchaseVO vo);

	PurchaseVO getBoard(PurchaseVO vo);

	List<PurchaseVO> getBoardList(MemberVO vo);
}
