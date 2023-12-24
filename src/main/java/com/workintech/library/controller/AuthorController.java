package com.workintech.library.controller;

import com.workintech.library.entity.Author;
import com.workintech.library.entity.Book;
import com.workintech.library.service.AuthorService;
import com.workintech.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;
    private final BookService bookService;

    @GetMapping
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @GetMapping("/{id}")
    public Author findById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @PostMapping
    public Author save(@RequestBody Author author) {
        return authorService.save(author);
    }

    @PostMapping("/{bookId}")
    public Author save(@PathVariable Long bookId, @RequestBody Author author) {
        Book existingBook = bookService.findById(bookId);
        author.addBook(existingBook);
        authorService.save(author);
        return author;
    }
}
