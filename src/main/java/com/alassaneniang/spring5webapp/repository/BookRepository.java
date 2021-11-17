package com.alassaneniang.spring5webapp.repository;

import com.alassaneniang.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
