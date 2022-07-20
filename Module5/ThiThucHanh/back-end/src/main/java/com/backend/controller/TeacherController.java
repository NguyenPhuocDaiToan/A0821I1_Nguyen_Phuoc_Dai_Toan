package com.backend.controller;

import com.backend.model.Teacher;
import com.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@CrossOrigin("*")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping
    public ResponseEntity<List<Teacher>> find() {
        List<Teacher> teachers = teacherService.findAll();
        if(teachers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }
}
