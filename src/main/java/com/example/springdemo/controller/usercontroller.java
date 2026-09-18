package com.example.springdemo.controller;

import com.example.springdemo.entity.user;
import com.example.springdemo.service.userservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class usercontroller {

    private final userservice userservice;

    // Constructor injection so Spring can wire up your service layer
    public usercontroller(userservice userService) {
        this.userservice = userService;
    }

    // 1. CREATE -> POST http://localhost:8080/api/users
    @PostMapping
    public user create(@RequestBody user u) {
        return userservice.create(u);
    }

    // 2. READ ALL -> GET http://localhost:8080/api/users
    @GetMapping
    public List<user> getAll() {
        return userservice.getAll();
    }

    // 3. UPDATE -> PUT http://localhost:8080/api/users
    @PutMapping
    public user update(@RequestBody user u) {
        return userservice.update(u);
    }

    // 4. DELETE -> DELETE http://localhost:8080/api/users/5
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userservice.delete(id);
    }
}
