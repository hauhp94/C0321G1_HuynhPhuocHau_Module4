use furama_module4;
insert into `position`(name)
values( 'Lễ tân'),
('Phục vụ'),
('Chuyên viên'),
('Giám sát'),
('Quản lý'),
('Giám đốc');
insert into education_degree(name)
values ('Trung cấp'),
('Cao đẳng'),
('Đại học'),
('Sau đại học');
insert into division(name)
values ('Sale marketing'),
('Hành chính'),
('Phục vụ'),
('Quản lý');
 insert into rent_type(name)
 values ('năm'),('tháng'),('ngày'),('giờ');
 insert into service_type(name)
 values ('villa'),('house'), ('room');
 insert into customer_type(name)
 values ('Diamond'),('Platinium'),('Gold'),('Silver'),('Member');
select * from nhan_vien;
insert into nhan_vien(ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,so_cmnd,luong,sdt,dia_chi)
values('Đặng Văn Lâm', 1,1,1,'1950-03-16', 666555444, 12000.0, 0905123345,'Quảng Trị'),
('Nguyễn Công Phượng', 2,1,2,'1960-03-17', 444333222, 13000.0, 0994222999,'Gia Lai'),
('Nguyễn Văn Toàn', 3,2,3,'1990-03-28', 887766453, 13000.0, 0905123345,'Huế'),
('Nguyễn Minh Vương', 1,3,4,'1994-03-30', 443322343, 15000.0, 0905123345,'Đà Nẵng'),
('Bùi Tiến Dũng', 1,4,4,'2000-06-22', 567345123, 11000.0, 0905123345,'Cà Mau'),
('Bùi Văn Tiến', 1,1,3,'1996-03-02', 432123432, 12000.0, 0905123345,'Hải Châu'),
('Đặng Thành Long', 1,4,4,'1995-03-26', 213456789, 25000.0, 0945231244,'Bình Định'),
('Phan Văn Long', 1,3,1,'1994-03-02', 234468234, 35000.0, 0333222111,'Đà Nẵng'),
('Phan Bình', 2,4,2,'1980-03-02', 234238234, 65000.0, 0333222551,'Hải Châu'),
('Đoàn Văn Hậu', 3,4,3,'1999-12-02', 234238234, 15000.0, 0133222551,'Quảng Trị');

 insert into khach_hang(id_loai_khach ,ho_ten_khach,ngay_sinh ,so_cmnd,sdt ,email,dia_chi)
 values(2,'Nguyễn Quang Hải','1990-02-03',123234123,0905123123,'hai@gmail.com','Hà Nội'),
 (3,'Bùi Tấn Trường','1990-02-03',123234123,0925123376,'truong@gmail.com','Đà Nẵng'),
 (1,'Nguyễn Hoàng Đức','1995-02-03',155234123,0777123345,'duc@gmail.com','Vinh'),
 (2,'Nguyễn Tiến Linh','1940-02-03',123234123,0931948372,'hai@gmail.com','Đà Nẵng'),
 (3,'Nguyễn Thành Chung','1990-02-03',123234123,0888111222,'truong@gmail.com','Quảng Ngãi'),
 (1,'Lê Văn Xuân','1995-02-03',155234123,0123333222,'xuan@gmail.com','Đà Nẵng'),
 (1,'Lê Văn Vip','1995-02-03',155234123,0993123234,'xuan@gmail.com','Quảng Ngãi'),
 (1,'Nguyễn Văn Sang','1995-02-03',155234123,0989231453,'xuan@gmail.com','Vinh'),
 (1,'Võ Huy Toàn','2004-02-03',155234123,0540234121,'xuan@gmail.com','Hải Phòng'),
 (2,'Võ Huy Toàn','2005-02-03',123234123,0444222111,'toan2@gmail.com','Vinh'),
  (5,'Võ Văn Dũng','2001-02-03',123234123,0543123333,'toan2@gmail.com','Trà Vinh'),
   (4,'Bùi Huy Toàn','2000-02-03',123234123,0909202031,'toan2@gmail.com','Quảng Trị');
 insert into dich_vu(ten_dich_vu ,dien_tich,so_tang,so_nguoi_toi_da,chi_phi_thue,id_kieu_thue ,id_loai_dich_vu,trang_thai)
 values( 'villa mua dong', 90, 5,10,2000000,1,1,'trong'),
 ( 'villa mua he', 60, 5,10,2000000,1,1,'trong'),
 ( 'villa mua xuan', 120, 6,6,1000000,2,1,'trong'),
 ( 'house mua dong', 90, 5,4,3500000,2,2,'da co khach dat'),
 ( 'house mua dong', 76, 5,12,4000000,3,2,'trong'),
 ( 'room mua dong', 56, 5,11,900000,3,3,'da co khach dat'),
 ('room mua dong', 78, 5,14,1000000,2,3,'trong');
 insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia ,don_vi,trang_thai_kha_dung)
 values( 'massage', 250000, 1, 'trong'),
 ( 'karaoke', 300000, 1, 'trong'),
 ( 'thức ăn', 100000, 1, 'trong'),
 ( 'nước uống', 50000,1 , 'trong'),
 ( 'thuê xe ', 600000, 1, 'trong');
 insert into hop_dong(id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lap_hop_dong ,ngay_ket_thuc ,tien_dat_coc,tong_tien )
 values(1,1,1,'2020-01-02','2021-03-29',5900000,null),
 (2,2,3,'2020-01-19','2021-03-15',2900000,null),
 (3,3,2,'2019-01-15','2020-03-27',3000000,null),
 (3,1,2,'2018-12-14','2019-02-28',4200000,null),
 (3,6,4,'2019-01-13','2021-03-31',4300000,null),
 (3,7,5,'2019-04-12','2021-01-31',4100000,null),
 (1,8,5,'2019-03-02','2021-05-02',2000000,null),
 (1,8,6,'2019-12-02','2021-12-02',5000000,null),
 (1,8,2,'2019-11-02','2021-11-02',6600000,null),
 (1,5,6,'2017-07-02','2019-03-01',9900000,null),
 (2,4,1,'2016-06-06','2017-03-01',8800000,null),
 (4,3,3,'2018-01-19','2018-03-01',4400000,null),
 (6,3,3,'2019-12-12','2021-03-01',12000000,null),
 (9,3,5,'2019-12-12','2022-03-01',4500000,null);
 insert into hop_dong_chi_tiet(id_hop_dong ,id_dich_vu_di_kem ,so_luong )
 values(2,1,1),(1,2,3),(1,2,3),(1,2,2),(3,2,3),(4,2,5),(5,1,3),(6,4,3),(7,4,3),(8,2,3),(8,3,3),(9,5,1),(10,5,2),(11,2,1),(12,1,1),(13,2,3),(14,3,3);