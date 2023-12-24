package com.workintech.library.service;

import com.workintech.library.entity.Author;
import com.workintech.library.entity.Book;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
    Author findById(Long id);
    Author save(Author author);
    Author delete(Long id);
}
