package com.ecommerce.ebookapi.controllers;

import com.ecommerce.ebookapi.models.Book;
import com.ecommerce.ebookapi.repositories.IBookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BookController {

    private final IBookRepository repository;

    BookController(IBookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @PostMapping("/books")
    public ResponseEntity add(@RequestBody Book book) {
        this.repository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/books/{id}")
    public ResponseEntity<Book> update(@PathVariable("id") String id, @RequestBody Book book) {
        return this.repository.findById(id)
                .map(data -> {
                    data.setTitle(book.getTitle());
                    data.setPrice(book.getPrice());
                    data.setUpdateAt(LocalDateTime.now());
                    Book update = this.repository.save(data);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        return this.repository.findById(id)
                .map(data -> {
                    this.repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}
