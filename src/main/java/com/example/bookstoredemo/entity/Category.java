package com.example.bookstoredemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category extends IdClass{

    private String name;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book){
        book.setCategory(this);
        bookList.add(book);
    }
}