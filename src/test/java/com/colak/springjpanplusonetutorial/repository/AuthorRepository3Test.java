package com.colak.springjpanplusonetutorial.repository;

import com.colak.springjpanplusonetutorial.jpa.Author;
import com.colak.springjpanplusonetutorial.jpa.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Slf4j
class AuthorRepository3Test {

    @Autowired
    private AuthorRepository3 repository;

    @Test
    @Transactional
    void findById() {
        Optional<Author> optional = repository.findById(1L);
        optional.ifPresentOrElse(author -> {
                    for (Book book : author.getBooks()) {
                        log.info("Book title : {}", book.getTitle());
                    }
                },
                () -> Assertions.fail("Test failed")
        );
    }

    @Test
    @Transactional
    void findByIdWithBooks() {
        Optional<Author> optional = repository.findById(1L);
        optional.ifPresentOrElse(author -> {
                    for (Book book : author.getBooks()) {
                        log.info("Book title : {}", book.getTitle());
                    }
                },
                () -> Assertions.fail("Test failed")
        );
    }
}
