package com.backend.service.impl;

import com.backend.model.Teacher;
import com.backend.repository.TeacherRepository;
import com.backend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
}
