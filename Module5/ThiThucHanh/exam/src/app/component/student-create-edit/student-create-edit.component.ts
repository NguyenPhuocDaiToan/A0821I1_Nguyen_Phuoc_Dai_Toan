import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {Teacher} from "../../model/Teacher";
import {Group} from "../../model/Group";
import {StudentService} from "../../service/student.service";
import {GroupService} from "../../service/group.service";
import {TeacherService} from "../../service/teacher.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-student-create-edit',
  templateUrl: './student-create-edit.component.html',
  styleUrls: ['./student-create-edit.component.css']
})
export class StudentCreateEditComponent implements OnInit {
  form: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl('', [Validators.required, Validators.pattern('^[A-Z a-z]+')]),
    email: new FormControl('', [Validators.required, Validators.pattern('^[A-Za-z0-9]+@def.com$')]),
    phone: new FormControl('', [Validators.pattern('^\\d{10,12}$')]),
    group: new FormControl('', this.validateTenNhom),
    topicName: new FormControl('', [Validators.required]),
    teacher: new FormControl('', [Validators.required])
  });
  teachers: Teacher[];
  groups: Group[];

  idEdit: number = 0;
  constructor(private studentService: StudentService,
              private groupService: GroupService,
              private teacherService: TeacherService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.idEdit = Number(paramMap.get('id'));
      if(this.idEdit != 0) {
        this.studentService.findById(this.idEdit).subscribe(s => {
          this.form.patchValue(s);
        });
      }
      this.groupService.getAll().subscribe(groups => this.groups = groups);
      this.teacherService.getAll().subscribe(teachers => this.teachers = teachers);
    });
  }

  get phone() {
    return this.form.get('phone');
  }

  get email() {
    return this.form.get('email');
  }

  get name() {
    return this.form.get('name');
  }

  validateTenNhom( c: AbstractControl) {
    const v = c.value;
    return v == 'Nhóm 1' || v == 'Nhóm 2' || v == 'Nhóm 3' ? null : {tenNhomInvalid: true};
  }

  compareGroup(g1: Group, g2: Group) {
    return g1.id === g2.id;
  }

  compareTeacher(t1: Teacher, t2: Teacher) {
    return t1.id === t2.id;
  }

  update() {
    if(this.idEdit == 0) {
      this.studentService.create(this.form.value).subscribe(() => {
        this.router.navigateByUrl("/students")
      });
    }
    else {
      this.studentService.update(this.form.value).subscribe(() => {
        this.router.navigateByUrl("/students")
      });
    }
  }
}
