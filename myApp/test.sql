create table member(
	num int primary key, 
	id varchar(20) not null,
	pw varchar(20) not null,
	name varchar(30) not null,
	address varchar(1000),
	point int default 0
);
create table product(
	num int primary key,
	name varchar(50) not null unique,
	price int not null,
	cnt int,
	pic varchar(50)
);

create table purchase(
	ordernum int primary key,
	num int not null references member(num),
	name varchar(50) not null references product(name),
	cnt int not null,
	orderdate date default SYSDATE
);
drop table purchase;
insert into member values(1, 'auddus16', '1234', '황명연', '서울특별시 강서구', 0);
insert into product values(1, '아이패드', 100000, 5, '아이패드닷');
insert into product values(2, '아이폰13', 200000, 10, '아이폰이닷');
insert into product values(3, '맥북', 1200000, 2, '맥북이닷');

select * from product;