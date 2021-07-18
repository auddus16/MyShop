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
insert into member values(1, 'auddus16', '1234', 'Ȳ��', '����Ư���� ������', 0);
insert into product values(1, '�����е�', 100000, 5, '�����е��');
insert into product values(2, '������13', 200000, 10, '�������̴�');
insert into product values(3, '�ƺ�', 1200000, 2, '�ƺ��̴�');

select * from product;