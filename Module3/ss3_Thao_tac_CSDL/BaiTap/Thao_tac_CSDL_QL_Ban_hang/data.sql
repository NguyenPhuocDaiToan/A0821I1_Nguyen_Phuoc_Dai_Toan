use quanlybanhang;

insert into customer(`name`, age)
values	('Minh Quan', 10),
		('Ngoc Oanh', 20),
		('Hong Ha', 50);
        
insert into `order`(ngay_dat, totalPrice, id_khach_hang)
values	('20060321', 123, 1),
		('20060323', 999, 2),
        ('20060316', 1000, 1);
	
insert into product(`name`, price)
values	('May giat', 3),
		('Tu lanh', 5),
        ('Dieu hoa', 7),
        ('Quat', 1),
        ('Bep dien', 2);

insert into order_detail(order_id, product_id, quantity)
values	(1, 1, 3),
		(1, 3, 7),
        (1, 4, 2),
        (2, 1, 1),
        (3, 1, 8),
        (2, 5, 4),
        (2, 3, 3);
