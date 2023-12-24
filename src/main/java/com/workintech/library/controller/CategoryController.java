package com.workintech.library.controller;

import com.workintech.library.entity.Category;
import com.workintech.library.service.CategoryService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.save(new Category(id, category.getName(), category.getBooks()));
    }

    @DeleteMapping("/{id}")
    public Category remove(@PathVariable Long id) {
        return categoryService.delete(id);
    }
}
