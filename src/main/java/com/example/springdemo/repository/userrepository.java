package com.example.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springdemo.entity.user; // Ensure this import is present

public interface userrepository extends JpaRepository<user, Long> {

}
