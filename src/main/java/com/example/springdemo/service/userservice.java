package com.example.springdemo.service;

import com.example.springdemo.entity.user;
import org.springframework.stereotype.Service;
import com.example.springdemo.repository.userrepository;

import java.util.List;

@Service
public class userservice {

    private final userrepository userrepository;

    public userservice(userrepository userrepository) {
        this.userrepository = userrepository;
    }

    // 1. CREATE
    public user create(user u1) {
        return userrepository.save(u1);
    }

    // 2. READ ALL
    public List<user> getAll() {
        return userrepository.findAll();
    }

    // 3. UPDATE
    public user update(user u1) {
        user existing = userrepository.findById(u1.getId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + u1.getId()));

        existing.setName(u1.getName());
        existing.setAge(u1.getAge());

        return userrepository.save(existing);
    }

    // 4. DELETE
    public void delete(Long id) {
        userrepository.deleteById(id);
    }
}

