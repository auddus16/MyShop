package com.hmy.myapp.purchase;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="purchaseList")
@XmlAccessorType(XmlAccessType.FIELD)
public class PurchaseListVO {
	@XmlElement(name="purchase")
	private List<PurchaseVO> purchaseList;

	public List<PurchaseVO> getPurchaseList() {
		return purchaseList;
	}

	public void setPurchaseList(List<PurchaseVO> purchaseList) {
		this.purchaseList = purchaseList;
	}
	
	
}
