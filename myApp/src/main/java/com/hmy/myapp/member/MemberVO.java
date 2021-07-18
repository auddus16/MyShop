package com.hmy.myapp.member;

//num int primary key, 
//id varchar(20) not null,
//pw varchar(20) not null,
//name varchar(30) not null,
//address varchar(1000),
//point int default 0

public class MemberVO {
	private int num;
	private String id;
	private String pw;
	private String name;
	private String address;
	private int point;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
