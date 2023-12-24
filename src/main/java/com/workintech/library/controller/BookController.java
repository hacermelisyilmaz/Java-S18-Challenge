package com.workintech.library.controller;

import com.workintech.library.entity.Author;
import com.workintech.library.entity.Book;
import com.workintech.library.entity.Category;
import com.workintech.library.service.AuthorService;
import com.workintech.library.service.BookService;
import com.workintech.library.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping("/{categoryId}")
    public Book save(@PathVariable Long categoryId, @RequestBody Book book) {
        Category category = categoryService.findById(categoryId);
        book.setCategory(category);
        category.addBook(book);
        return bookService.save(book);
    }

    @PostMapping("saveByAuthor/{categoryId}/{authorId}")
    public Book save(@PathVariable Long categoryId, @PathVariable Long authorId, @RequestBody Book book) {
        Category category = categoryService.findById(categoryId);
        book.setCategory(category);
        category.addBook(book);

        Author author = authorService.findById(authorId);
        book.setAuthor(author);
        author.addBook(book);

        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book) {
        return bookService.save(new Book(id, book.getName(), book.getAuthor(), book.getCategory()));
    }

    @DeleteMapping("/{id}")
    public Book remove(@PathVariable Long id) {
        return bookService.delete(id);
    }
}
