package com.alassaneniang.spring5webapp.bootstrap;

import com.alassaneniang.spring5webapp.domain.Author;
import com.alassaneniang.spring5webapp.domain.Book;
import com.alassaneniang.spring5webapp.domain.Publisher;
import com.alassaneniang.spring5webapp.repository.AuthorRepository;
import com.alassaneniang.spring5webapp.repository.BookRepository;
import com.alassaneniang.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData ( AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run ( String... args ) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName( "SFG Publishing" );
        publisher.setCity( "St Petersburg" );
        publisher.setState( "FL" );
        publisherRepository.save( publisher );

        Author eric = new Author( "Eric", "Evans" );
        Book ddd = new Book( "Domain Driven Design", "123123" );
        eric.getBooks().add( ddd );
        ddd.getAuthors().add( eric );
        ddd.setPublisher( publisher );
        publisher.getBooks().add( ddd );
        authorRepository.save( eric );
        bookRepository.save( ddd );
        publisherRepository.save( publisher );

        Author rod = new Author( "Rod", "Johnson" );
        Book noEJB = new Book( "J2EE Development without EJB", "132854" );
        rod.getBooks().add( noEJB );
        noEJB.getAuthors().add( rod );
        noEJB.setPublisher( publisher );
        publisher.getBooks().add( noEJB );
        authorRepository.save( rod );
        bookRepository.save( noEJB );
        publisherRepository.save( publisher );

        Publisher adn = new Publisher();
        adn.setName( "ADN Publishing" );
        adn.setCity( "Paris" );
        adn.setState( "FR" );
        publisherRepository.save( adn );

        Author selikoff = new Author( "Scott", "Selikoff" );
        Author boyarsky = new Author( "Jeanne", "Boyarsky" );
        Book ocp1 = new Book( "OCP Study Guide 1", "1z0815" );
        Book ocp2 = new Book( "OCP Study Guide 2", "1z0816" );
        selikoff.getBooks().add( ocp1 );
        selikoff.getBooks().add( ocp2 );
        boyarsky.getBooks().add( ocp1 );
        boyarsky.getBooks().add( ocp2 );
        ocp1.getAuthors().add( selikoff );
        ocp1.getAuthors().add( boyarsky );
        ocp2.getAuthors().add( selikoff );
        ocp2.getAuthors().add( boyarsky );
        ocp1.setPublisher( adn );
        ocp2.setPublisher( adn );
        adn.getBooks().add( ocp1 );
        adn.getBooks().add( ocp2 );
        authorRepository.save( selikoff );
        authorRepository.save( boyarsky );
        bookRepository.save( ocp1 );
        bookRepository.save( ocp2 );
        publisherRepository.save( adn );

        System.out.println( "Started in BootStrap" );
        System.out.println( "Number of Authors: " + authorRepository.count() );
        System.out.println( "Number of Books: " + bookRepository.count() );
        System.out.println( "Number of Publishers: " + publisherRepository.count() );

    }
}
