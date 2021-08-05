package com.hmy.myapp.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//num int primary key,
//name varchar(50) not null,
//price int not null,
//cnt int,
//pic varchar(50)

@Entity(name="product")
@Table(name="product")
public class ProductVO {
	@Id //엔티티클래스의 필수 요소, 다수의 경우 PK와 매핑
	@GeneratedValue //@Id을 선언한 멤버변수-필드-속성에 PK를 자동으로 할당
	private int num;
	private String name;
	private int price;
	private int cnt;
	private String pic;
	@Transient 
	private String search;
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
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
