package com.example.customermanager.service;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findById(Integer id);
    void save(T t);
    void remove(Integer id);
}
