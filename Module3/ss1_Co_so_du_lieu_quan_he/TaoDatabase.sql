-- Tạo cơ sở dữ liệu
create database test_database;
-- Xóa cơ sở dữ liệu
drop database test_database;

create database student_management;

-- Sử dụng cơ sở dữ liệu
use student_management;

-- Tạo bảng student
create table student(
	id int NOT NULL,
    `name` varchar(45),
    age int,
    country varchar(45),
    primary key(id)
);
-- Tạo bảng class
create table class(
	id int auto_increment not null,
    `name` varchar(45),
    primary key(id)
);
-- Tạo bảng teacher
create table teacher(
	id int not null,
	`name` varchar(45),
    age int,
    country varchar(45),
    primary key(id)
);
-- Thêm dữ liệu vào bảng
insert into student values(1, 'Dai Toan', 19, 'Da Nang');
insert into student values(2, 'Dai Toan', 20, 'Da Nang');
insert into student values(3, 'Dai Toan', 21, 'Da Nang');
insert into student values(4, 'Dai Toan', 22, 'Da Nang');

-- Xóa cột name trong bảng
ALTER table student
drop `name`;

-- Cập nhật tên cho học sinh có id = 1
update student
set `name` = 'Toan Nguyen'
where id = 1;

-- Xóa bảng
drop table student;
drop table class;
drop table teacher;





