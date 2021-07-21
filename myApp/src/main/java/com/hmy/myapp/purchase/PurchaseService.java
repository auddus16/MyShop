package com.hmy.myapp.purchase;

import java.util.List;

import com.hmy.myapp.member.MemberVO;

public interface PurchaseService {
	void insertPurchase(PurchaseVO vo);

	void updatePurchase(PurchaseVO vo);

	void deletePurchase(PurchaseVO vo);

	PurchaseVO getPurchase(PurchaseVO vo);

	List<PurchaseVO> getPurchaseList(MemberVO vo);
}
