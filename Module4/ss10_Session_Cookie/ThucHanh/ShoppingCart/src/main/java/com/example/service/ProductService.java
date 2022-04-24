package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Product getById(Long id);
}
