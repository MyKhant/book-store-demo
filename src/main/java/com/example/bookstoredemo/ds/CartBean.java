package com.example.bookstoredemo.ds;

import com.example.bookstoredemo.dao.BookDao;
import com.example.bookstoredemo.entity.Author;
import com.example.bookstoredemo.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SessionScope
@Component
public class CartBean {

    private Set<BookDto> bookDtoList =
            new HashSet<>();

    public void addToCart(BookDto bookDto){
        bookDtoList.add(bookDto);
    }

    public Set<BookDto> listAllCart(){
        return this.bookDtoList;
    }
    public void clearCart(){
        this.bookDtoList.clear();
    }
    public int cartSize(){
        return bookDtoList.size();
    }

    public void removeBook(BookDto bookDto){
        bookDtoList.remove(bookDto);
    }
}
