package com.example.hibernetguru;


import com.example.hibernetguru.repositories.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HibernetguruApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testBookRepo() {
		long count = bookRepository.count();
		Assertions.assertThat(count).isEqualTo(0);
	}

}
