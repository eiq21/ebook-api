package com.ecommerce.ebookapi.controllers;

import com.ecommerce.ebookapi.models.Book;
import com.ecommerce.ebookapi.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/books")
public class BookController {

 private final BookService service;

 BookController(BookService service){
     this.service = service;
 }

 @GetMapping
 public ResponseEntity<List<Book>> getAll(){
     return ResponseEntity.ok(this.service.getAll());
 }

 @PostMapping
 public ResponseEntity add(@RequestBody Book book){
     service.add(book);
     return ResponseEntity.status(HttpStatus.CREATED).build();
 }


}
