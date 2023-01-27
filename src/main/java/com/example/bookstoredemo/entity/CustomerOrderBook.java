package com.example.bookstoredemo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class CustomerOrderBook extends IdClass{

    private String orderCode;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Book book;

    private LocalDate orderDate;


}
