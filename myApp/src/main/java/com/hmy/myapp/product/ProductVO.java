package com.hmy.myapp.product;
//num int primary key,
//name varchar(50) not null,
//price int not null,
//cnt int,
//pic varchar(50)
public class ProductVO {
	private int num;
	private String name;
	private int price;
	private int cnt;
	private String pic;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	
}
