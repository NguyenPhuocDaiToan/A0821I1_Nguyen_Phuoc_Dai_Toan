import { Component, OnInit } from '@angular/core';
import {Student} from "../../model/student";
import {StudentService} from "../../service/student.service";
import {Group} from "../../model/Group";

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  indexPagination: number = 1;
  students: Student[];
  totalPages: number;
  studentDelete: Student = {
    id: 0,
    name: '',
    email: '',
    phone: '',
    group: {
      id: 0,
      name: "Nhóm 0"
    },
    topicName: '',
    teacher: {
      id: 0,
      name: "Teacher 0"
    }
  }

  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.getAllNotPagination();
    this.getAllWithPage();
  }

  getAllWithPage() {
    this.studentService.getAllStudentsWithPage(this.indexPagination).subscribe(students => {
      console.log(students);
      this.students = students;
    });
  }

  getAllNotPagination() {
    this.studentService.getAllStudentsNotPagination().subscribe(students => {
      let length: number = students.length;
      this.totalPages = length % 3 === 0 ? length / 3 : Math.floor(length / 3) + 1;
      if(this.indexPagination > this.totalPages) {
        this.indexPagination = this.totalPages;
        this.getAllWithPage();
      }
    })
  }

  findStudentDeleteById(id: number) {
    this.studentService.findById(id).subscribe(s => this.studentDelete = s);
  }

  deleteById(id: number) {
    this.studentService.deleteById(id).subscribe((data) => {
      this.ngOnInit()
    });

  }

  firstPage() {
    this.indexPagination = 1;
    this.getAllWithPage();
  }

  lastPage() {
    this.indexPagination = this.totalPages;
    this.getAllWithPage();
  }

  previousPage() {
    if(this.indexPagination > 1) {
      this.indexPagination = this.indexPagination - 1;
      this.getAllWithPage();
    }
  }

  nextPage() {
    if(this.indexPagination < this.totalPages) {
      this.indexPagination = this.indexPagination + 1;
      this.getAllWithPage();
    }
  }
}
