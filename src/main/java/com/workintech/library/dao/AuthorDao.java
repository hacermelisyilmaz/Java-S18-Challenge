package com.workintech.library.dao;

import com.workintech.library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorDao extends JpaRepository<Author, Long> {
}
