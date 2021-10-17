package com.ecommerce.ebookapi.services;

import com.ecommerce.ebookapi.models.Book;
import com.ecommerce.ebookapi.repositories.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {

    private final IBookRepository repository;

    BookService(IBookRepository repository){
        this.repository = repository;
    }

    public List<Book> getAll(){
        return this.repository.findAll();
    }

    public  void add(Book book){
        this.repository.save(book);
    }
}
