package com.workintech.library.service;

import com.workintech.library.dao.AuthorDao;
import com.workintech.library.dao.BookDao;
import com.workintech.library.entity.Author;
import com.workintech.library.entity.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;
    private final BookDao bookDao;

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }

    @Override
    public Author findById(Long id) {
        Optional<Author> authorOptional = authorDao.findById(id);
        if (authorOptional.isPresent()) return authorOptional.get();
        throw new RuntimeException("Author with this ID is not found: " + id);
    }

    @Override
    public Author save(Author author) {
        if (authorDao.findAll().contains(author)) throw new RuntimeException("This author with this ID already exists: " + author.getId());
        return authorDao.save(author);
    }

    @Override
    public Author delete(Long id) {
        Author author = findById(id);
        if (author == null) throw new RuntimeException("Author with this ID not found: " + id);
        authorDao.delete(author);
        return author;
    }
}
