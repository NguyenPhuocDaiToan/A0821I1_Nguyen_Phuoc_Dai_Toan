package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> getAll(Pageable pageable);
    void save(Blog product);
    void deleteById(Integer id);
    Blog getById(Integer id);
    Page<Blog> search(String val, Pageable pageable);
}
