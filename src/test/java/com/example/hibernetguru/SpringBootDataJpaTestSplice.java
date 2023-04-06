package com.example.hibernetguru;

import com.example.hibernetguru.domain.Book;
import com.example.hibernetguru.repositories.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
public class SpringBootDataJpaTestSplice {

    @Autowired
    BookRepository bookRepository;

    @Commit
    @Order(1)
    @Test
    void jpaTestSplice(){
        long countBefore = bookRepository.count();

        bookRepository.save(new Book("My Book","123456","self"));

        long countAfter = bookRepository.count();
        Assertions.assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void jpaTestSpliceTransaction(){
        long countBefore = bookRepository.count();
        Assertions.assertThat(countBefore).isEqualTo(1);
    }
}
