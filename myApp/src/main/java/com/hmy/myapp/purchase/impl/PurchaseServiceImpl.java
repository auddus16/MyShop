package com.hmy.myapp.purchase.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmy.myapp.member.MemberVO;
import com.hmy.myapp.purchase.PurchaseService;
import com.hmy.myapp.purchase.PurchaseVO;

@Service("PurchaseService")
public class PurchaseServiceImpl implements PurchaseService{

	@Autowired
	private PurchaseDAO purchaseDAO;
	
	@Override
	public void insertPurchase(PurchaseVO vo) {
		// TODO Auto-generated method stub
		purchaseDAO.insertPurchase(vo);
	}

	@Override
	public void deleteBoard(PurchaseVO vo) {
		// TODO Auto-generated method stub
		purchaseDAO.deletePurchase(vo);
	}

	@Override
	public PurchaseVO getBoard(PurchaseVO vo) {
		// TODO Auto-generated method stub
		return purchaseDAO.getPurchase(vo);
	}

	@Override
	public List<PurchaseVO> getBoardList(MemberVO vo) {
		// TODO Auto-generated method stub
		return purchaseDAO.getPurchaseList(vo);
	}

}
