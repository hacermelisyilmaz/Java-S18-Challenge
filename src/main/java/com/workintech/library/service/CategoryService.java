package com.workintech.library.service;

import com.workintech.library.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    Category delete(Long id);
}
