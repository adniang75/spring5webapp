package com.alassaneniang.spring5webapp.controller;

import com.alassaneniang.spring5webapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;
    @Value( "${spring.application.name}" )
    private String appName;

    public BookController ( BookRepository bookRepository ) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping( "/books" )
    public String getBooks ( Model model ) {
        model.addAttribute( "appName", appName );
        model.addAttribute( "books", bookRepository.findAll() );
        return "books";
    }

}
