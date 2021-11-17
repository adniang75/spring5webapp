package com.alassaneniang.spring5webapp.repository;

import com.alassaneniang.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
