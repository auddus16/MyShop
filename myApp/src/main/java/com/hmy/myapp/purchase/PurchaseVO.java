package com.hmy.myapp.purchase;
//ordernum int primary key,
//num int not null references member(num),
//cnt int not null,
//orderdate date default SYSDATE
public class PurchaseVO {
	private int ordernum;
	private int num;
	private String name;
	private int cnt;
	private String orderdate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	
	
}
