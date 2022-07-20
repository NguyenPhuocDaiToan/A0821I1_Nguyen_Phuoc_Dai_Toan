package com.backend.service;

import com.backend.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();
    Page<Student> findAllWithPage(Pageable pageable);
    Student save(Student student);
    Optional<Student> findById(Integer id);
    void deleteById(Integer id);
}
