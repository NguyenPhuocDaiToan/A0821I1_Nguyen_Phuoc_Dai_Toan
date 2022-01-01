create database QuanLyBanHang;
use QuanLyBanHang;

create table customer (
	id int auto_increment primary key,
    `name` varchar(50) not null,
    age int
);

create table `order`(
	id int auto_increment primary key,
	ngay_dat date not null,
    totalPrice int not null,
    id_khach_hang int not null,
    foreign key (id_khach_hang) references customer(id)
);

create table product (
	id int auto_increment primary key,
	`name` varchar(50) not null,
    price int not null
);

create table order_detail (
	order_id int not null,
    product_id int not null,
    quantity int not null,
    foreign key (order_id) references `order`(id),
    foreign key (product_id) references product(id)
);


