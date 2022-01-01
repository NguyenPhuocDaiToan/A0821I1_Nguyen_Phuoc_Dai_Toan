use quanlysinhvien;

-- Lấy dữ liệu toàn bộ bảng student
select * from student;

-- Lấy dữ liệu bảng student có status = true
select * from student
where `status` = true;

-- Lấy dữ liệu bảng subject với điều kiện credit < 10
select * from subject
where credit < 10;

-- Lấy studentID, studentName, className
select s.studentID, s.studentName, c.className
from student s join class c
on s.classID = c.classID;

-- Lấy studentID, studentName, className với className = A1
select s.studentID, s.studentName, c.className
from student s join class c
on s.classID = c.classID
where c.className = 'A1';

-- Hiển thị điểm môn CF của các học viên
SELECT s.studentID, s.studentName, sub.subName, m.mark
FROM student s 
join mark m on s.studentID = m.studentID
join `subject` sub on sub.subID = sub.subID
WHERE sub.subName = 'CF';


