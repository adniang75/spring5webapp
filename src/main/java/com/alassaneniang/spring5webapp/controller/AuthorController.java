package com.alassaneniang.spring5webapp.controller;

import com.alassaneniang.spring5webapp.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;
    @Value( "${spring.application.name}" )
    private String appName;

    public AuthorController ( AuthorRepository authorRepository ) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping( "/authors" )
    public String getAuthors ( Model model ) {
        model.addAttribute( "appName", appName );
        model.addAttribute( "authors", authorRepository.findAll() );
        return "authors/list";
    }

}
