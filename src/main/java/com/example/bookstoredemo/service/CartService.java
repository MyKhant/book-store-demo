package com.example.bookstoredemo.service;

import com.example.bookstoredemo.dao.BookDao;
import com.example.bookstoredemo.dao.CustomerDao;
import com.example.bookstoredemo.dao.CustomerOrderBookDao;
import com.example.bookstoredemo.dao.RoleDao;
import com.example.bookstoredemo.ds.BookDto;
import com.example.bookstoredemo.ds.CartBean;
import com.example.bookstoredemo.entity.Book;
import com.example.bookstoredemo.entity.Customer;
import com.example.bookstoredemo.entity.CustomerOrderBook;
import com.example.bookstoredemo.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CartService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CartBean cartBean;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private CustomerOrderBookDao customerOrderBookDao;

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private BookDao bookDao;

    public void addToCart(int id) {
        cartBean.addToCart(toDto(bookDao.findById(id).get()));
    }

    public void clearCart(){
        cartBean.clearCart();
    }
    public Set<BookDto> listCart(){
        return cartBean.listAllCart();
    }

    public BookDto toDto(Book book){
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getYearPublished(),
                book.getPublisher(),
                book.getPrice(),
                book.getQuantity(),
                book.getGenre(),
                book.getImgUrl(),
                book.getDescription(),
                book.getCategory(),
                book.getAuthor()
        );
    }

    public void removeFromCart(BookDto bookDto) {
        cartBean.removeBook(bookDto);
    }

    public void register(Customer customer, Set<BookDto> carts) {
        Role customerRole = roleDao.findRoleByRoleName("USER_ROLE").get();
        customer.addRole(customerRole);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        Customer managedCustomer = customerDao.saveAndFlush(customer);
        CustomerOrderBook customerOrderBook = new CustomerOrderBook();
        managedCustomer.addCustomerOrderBook(customerOrderBook);
        carts.stream()
    }

    public Book toEntity(BookDto bookDto){

        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getYearPublished(),
                bookDto.getPublisher(),
                bookDto.getPrice(),
                bookDto.getQuantity(),
                bookDto.getGenre(),
                bookDto.getImgUrl(),
                bookDto.getDescription(),
                bookDto.getCategory(),
                bookDto.getAuthor()
        );
    }
}
