package com.workintech.library.service;

import com.workintech.library.dao.BookDao;
import com.workintech.library.entity.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findById(Long id) {
        Optional<Book> bookOptional = bookDao.findById(id);
        if (bookOptional.isPresent()) return bookOptional.get();
        throw new RuntimeException("Book with this ID is not found: " + id);
    }

    @Override
    public Book save(Book book) {
        if (bookDao.findAll().contains(book)) throw new RuntimeException("Book with this ID already exists: " + book.getId());
        return bookDao.save(book);
    }

    @Override
    public Book delete(Long id) {
        Book book = findById(id);
        if (book == null) throw new RuntimeException("Book with this ID not found: " + id);
        bookDao.delete(book);
        return book;
    }
}
