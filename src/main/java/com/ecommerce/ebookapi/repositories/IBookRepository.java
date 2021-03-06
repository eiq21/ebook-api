package com.ecommerce.ebookapi.repositories;

import com.ecommerce.ebookapi.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends MongoRepository<Book,String> {
}
