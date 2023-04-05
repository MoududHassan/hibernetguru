package com.example.hibernetguru.repositories;

import com.example.hibernetguru.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
