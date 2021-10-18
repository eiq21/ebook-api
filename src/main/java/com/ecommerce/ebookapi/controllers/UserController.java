package com.ecommerce.ebookapi.controllers;

import com.ecommerce.ebookapi.models.User;
import com.ecommerce.ebookapi.repositories.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
    private final IUserRepository repository;

    UserController(IUserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @PostMapping("/users")
    public ResponseEntity add(@RequestBody User user) {
        this.repository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<User> update(@PathVariable("id") String id, @RequestBody User user) {
        return this.repository.findById(id)
                .map(data -> {
                    data.setEmail(user.getEmail());
                    data.setFirstName(user.getFirstName());
                    data.setLastName(user.getLastName());
                    data.setMiddleName(user.getMiddleName());
                    data.setPassword(user.getPassword());
                    data.setUpdateAt(LocalDateTime.now());
                    User update = this.repository.save(data);
                    return ResponseEntity.ok().body(update);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        return this.repository.findById(id)
                .map(data -> {
                    this.repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
