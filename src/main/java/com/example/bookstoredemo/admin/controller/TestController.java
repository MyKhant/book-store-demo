package com.example.bookstoredemo.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping(value = {"/","/home"})
    public String layoutTest(){
        return "layout/adminLayout";
    }
}
