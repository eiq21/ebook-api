package com.ecommerce.ebookapi.repositories;

import com.ecommerce.ebookapi.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IBookRepository extends MongoRepository<Book,String> {
}
