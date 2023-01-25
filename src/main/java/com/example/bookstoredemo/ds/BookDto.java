package com.example.bookstoredemo.ds;

import com.example.bookstoredemo.entity.Author;
import com.example.bookstoredemo.entity.Category;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BookDto {
    private int id;

    private String title;

    private LocalDate yearPublished;

    private String publisher;

    private double price;

    private int quantity;

    private String genre;

    private String imgUrl;

    private String description;

    private Category category;

    private Author author;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return id == bookDto.id && title.equals(bookDto.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    public BookDto() {
    }

}
