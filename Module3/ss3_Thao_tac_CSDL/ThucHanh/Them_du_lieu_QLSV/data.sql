use quanlysinhvien;

-- Thêm dữ liệu class
insert into class
values 	(1, 'A1', '2008-12-20', 1),
		(2, 'A2', '2008-12-22', 1),
		(3, 'B3', current_date, 0);

-- Thêm dữ liệu student
insert into student (studentName, address, phone, `status`, classID)
values ('Hung', 'Ha Noi', '0912113113', 1, 1);
insert into student (studentName, address, `status`, classID)
values ('Hoa', 'Hai phong', 1, 1);
insert into student (studentName, address, phone, `status`, classID)
values ('Manh', 'HCM', '0123123123', 0, 2);

-- Thêm dữ liệu subject
insert into `subject`
values (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       
-- Thêm dữ liệu mark
insert into mark (subID, studentID, mark, examTimes)
values (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);