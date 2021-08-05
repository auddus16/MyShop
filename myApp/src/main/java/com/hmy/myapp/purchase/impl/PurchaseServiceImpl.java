package com.hmy.myapp.purchase.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmy.myapp.member.MemberVO;
import com.hmy.myapp.product.impl.ProductDAO;
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
	public void deletePurchase(PurchaseVO vo) {
		// TODO Auto-generated method stub
		purchaseDAO.deletePurchase(vo);
	}

	@Override
	public PurchaseVO getPurchase(PurchaseVO vo) {
		// TODO Auto-generated method stub
		return purchaseDAO.getPurchase(vo);
	}

	@Override
	public List<PurchaseVO> getPurchaseList(MemberVO vo) {
		// TODO Auto-generated method stub
		return purchaseDAO.getPurchaseList(vo);
	}

	@Override
	public void updatePurchase(PurchaseVO vo) {
		// TODO Auto-generated method stub
		purchaseDAO.updatePurchase(vo);
	}

}
