use furama_resort;

/* 	Câu 2:
	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là 
	một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự. 
*/
select * from nhan_vien
where SUBSTRING_INDEX(ho_ten, ' ', - 1) regexp '^[HTK]+' AND char_length(ho_ten)<=15;

/* 	Câu 3:
	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị” 
*/
select * from khach_hang
where (year(now()) - year(ngay_sinh) between 18 and 50) and (dia_chi like binary'%Đà Nẵng' or dia_chi like binary'%Quảng Trị');

/*	Câu 4:
	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
	Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
	Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
*/
select kh.ma_khach_hang, kh.ho_ten, kh.ngay_sinh, kh.so_cmnd , count(kh.ma_khach_hang) as so_lan_dat_phong
from loai_khach lk 
join khach_hang kh on lk.ma_loai_khach = kh.ma_loai_khach
join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
where ten_loai_khach = 'Diamond'
group by kh.ma_khach_hang
order by so_lan_dat_phong;

/*	Câu 5
	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
    (Với tổng tiền = Chi Phí Thuê + Số Lượng * Giá. Với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
    cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
*/
select 	kh.ma_khach_hang, ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc,
		(dv.chi_phi_thue + so_luong * gia) as 'tong_tien'
from loai_khach lk
join khach_hang kh on lk.ma_loai_khach = kh.ma_loai_khach
join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem;

/* Câu 6
	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu
    của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
*/
select dv.ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu
from loai_dich_vu ldv 
join dich_vu dv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
where dv.ma_dich_vu not in
(
	select hd.ma_dich_vu from hop_dong hd 
    where month(hd.ngay_lam_hop_dong) in (1,2,3) and year(hd.ngay_lam_hop_dong)=2021
)
group by dv.ma_dich_vu;

/* Câu 7
		Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
        của tất cả các loại dịch vụ 
        đã từng được khách hàng đặt phòng trong năm 2020 nhưng
		chưa từng được khách hàng đặt phòng trong năm 2021.
*/
select dv.ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu
from dich_vu dv join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
where year(ngay_lam_hop_dong) = 2020 and dv.ma_dich_vu not in
(
	select hd.ma_dich_vu from hop_dong hd 
    where year(ngay_lam_hop_dong) = 2021
)
group by dv.ma_dich_vu;

/* Câu 8
	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
*/
-- Cách 1:
select ho_ten from khach_hang
group by ho_ten;
-- Cách 2:
select distinct ho_ten from khach_hang;
-- Cách 3: 
select ho_ten from khach_hang
union 
select ho_ten from khach_hang;
/*	Câu 9
	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 
    thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
*/
select month(ngay_lam_hop_dong) as 'Tháng', count(*) as 'Số khách đặt' 
from hop_dong 
where year(ngay_lam_hop_dong) = 2021
group by month(ngay_lam_hop_dong)
order by month(ngay_lam_hop_dong);

/*	Câu 10
	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
    Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem 
    (so_luong_dich_vu_di_kem = tổng so_luong ở dich_vu_di_kem).
*/
select hd.ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, ifnull(sum(so_luong), 0) as 'Số lượng dịch vụ đi kèm'
from hop_dong hd left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
group by hd.ma_hop_dong;
/*	Câu 11
	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng 
    có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
*/
select dvdk.ma_dich_vu_di_kem, ten_dich_vu_di_kem
from loai_khach lk 
join khach_hang kh on lk.ma_loai_khach = kh.ma_loai_khach
join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
where lk.ten_loai_khach = 'Diamond' and (dia_chi like '%Vinh' or dia_chi like '%Quảng Ngãi')
group by dvdk.ma_dich_vu_di_kem;
/*	Câu 12:
	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu,
	so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng được
	khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
*/
select 	hd.ma_hop_dong, nv.ho_ten as 'Tên nhân viên', kh.ho_ten 'Tên khách hàng',  
			kh.so_dien_thoai as 'Số điện thoại khách hàng', ten_dich_vu, ifnull(sum(so_luong), 0) 'Số lượng dịch vụ đi kèm', tien_dat_coc
from dich_vu dv
join hop_dong hd on hd.ma_dich_vu = dv.ma_dich_vu
join nhan_vien nv on nv.ma_nhan_vien = hd.ma_nhan_vien
join khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
where ngay_lam_hop_dong between '2020-10-01' and '2020-12-31'
	and dv.ma_dich_vu not in (
		select dv.ma_dich_vu from dich_vu dv
        join hop_dong hd on hd.ma_dich_vu = dv.ma_dich_vu
		where ngay_lam_hop_dong between '2021-01-01' and '2021-06-30'
	) 
group by hd.ma_hop_dong;

/*	Câu 13:
	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
	(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
*/
select dvdk.ma_dich_vu_di_kem, ten_dich_vu_di_kem, sum(so_luong) from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by dvdk.ma_dich_vu_di_kem
having sum(so_luong) = (
	select sum(so_luong) from dich_vu_di_kem dvdk
	join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
    group by dvdk.ma_dich_vu_di_kem
    order by sum(so_luong) desc
    limit 1
);

/*	Câu 14:
	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
    Thông tin hiển thị bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, 
    so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
*/
select hd.ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, count(*) as so_lan_su_dung
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
group by dvdk.ma_dich_vu_di_kem
having so_lan_su_dung = 1
order by hd.ma_hop_dong;
/*	Câu 15
	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi 
	mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
*/
select nv.ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi
from nhan_vien nv 
join trinh_do td on nv.ma_trinh_do = td.ma_trinh_do
join bo_phan bp on nv.ma_bo_phan = bp.ma_bo_phan
join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where year(ngay_lam_hop_dong) = 2020 or year(ngay_lam_hop_dong) = 2021
group by hd.ma_nhan_vien 
having count(*) <= 3
order by ma_nhan_vien;

/*	Câu 16
	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
*/
-- Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
select nv.ma_nhan_vien, nv.ho_ten from nhan_vien nv left join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
where nv.ma_nhan_vien not in (
	select nv.ma_nhan_vien from nhan_vien nv join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
    where year(ngay_lam_hop_dong) between 2019 and 2021
);
-- Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
delete from nhan_vien 
where nv.ma_nhan_vien not in (
	select nv.ma_nhan_vien from nhan_vien nv join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
    where year(ngay_lam_hop_dong) between 2019 and 2021
);

/*	Câu 17
	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond
    chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
*/
-- Những khách hàng có ten_loai_khach từ Platinum và từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ
select kh.ma_khach_hang, kh.ho_ten, kh.ma_loai_khach
from loai_khach lk
join khach_hang kh on lk.ma_loai_khach = kh.ma_loai_khach
join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
where ten_loai_khach = 'Platinum' and (dv.chi_phi_thue + so_luong * gia) > 10000000;
-- Cập nhật thông tin
update khach_hang kh, (select kh.ma_khach_hang
		from khach_hang kh
		join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach
		join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
		join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
		join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
		join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
		where ten_loai_khach = 'Platinum' and (dv.chi_phi_thue + so_luong * gia) > 10000000) as id_khach_hang
set ma_loai_khach =  (select lk.ma_loai_khach from loai_khach lk where lk.ten_loai_khach = 'Diamond')
where kh.ma_khach_hang = id_khach_hang.ma_khach_hang;
/*	Câu 18
	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
*/
-- những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng)
select kh.ma_khach_hang, ho_ten 
from khach_hang kh join hop_dong hd 
on kh.ma_khach_hang = hd.ma_khach_hang
where year(ngay_lam_hop_dong) < 2021;

/*	Câu 19
	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
*/
-- các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020
select dvdk.ma_dich_vu_di_kem, ten_dich_vu_di_kem from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
where year(ngay_lam_hop_dong) = 2020
group by dvdk.ma_dich_vu_di_kem
having sum(so_luong) > 10;

-- cập nhật
update dich_vu_di_kem, (
			select dvdk.ma_dich_vu_di_kem from dich_vu_di_kem dvdk
			join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
			join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
			where year(ngay_lam_hop_dong) = 2020
			group by dvdk.ma_dich_vu_di_kem
			having sum(so_luong) > 10) as id_dich_vu
set gia = gia * 2
where dich_vu_di_kem.ma_dich_vu_di_kem = id_dich_vu.ma_dich_vu_di_kem;

/*	Câu 20
	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống thông tin 
    hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
*/
select ma_nhan_vien as id, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from nhan_vien
union all
select ma_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi
from khach_hang;