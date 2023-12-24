package com.workintech.library.service;

import com.workintech.library.dao.CategoryDao;
import com.workintech.library.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> categoryOptional = categoryDao.findById(id);
        if (categoryOptional.isPresent()) return categoryOptional.get();
        throw new RuntimeException("Category with this ID is not found: " + id);
    }

    @Override
    public Category save(Category category) {
        if (categoryDao.findAll().contains(category)) throw new RuntimeException("Category with this ID already exists: " + category.getId());
        return categoryDao.save(category);
    }

    @Override
    public Category delete(Long id) {
        Category category = findById(id);
        if (category == null) throw new RuntimeException("Category with this ID is not found: " + id);
        categoryDao.delete(category);
        return category;
    }
}
