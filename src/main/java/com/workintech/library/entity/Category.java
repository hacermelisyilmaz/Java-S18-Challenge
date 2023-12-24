package com.workintech.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "category", schema = "fsweb")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Book> books;

    // metod tanımlamak yerine 26. satırda new Arraylist diyebilirdik. NullPointerException almamak için yapıyoruz
    public void addBook(Book book) {
        if (books == null) {
            books = new ArrayList<>();
        }
        books.add(book);
    }
}
