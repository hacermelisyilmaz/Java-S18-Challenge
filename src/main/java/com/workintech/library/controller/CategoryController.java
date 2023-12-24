package com.workintech.library.controller;

import com.workintech.library.entity.Author;
import com.workintech.library.entity.Category;
import com.workintech.library.entity.Category;
import com.workintech.library.service.AuthorService;
import com.workintech.library.entity.CategoryService;
import com.workintech.library.service.BookService;
import com.workintech.library.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;
    private final BookService bookService;
    private final AuthorService authorService;

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
