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
class AuthorRepository2Test {

    @Autowired
    private AuthorRepository2 repository;

    @Test
    @Transactional
    void findByIdWithBooks() {
        Author author = repository.findByIdWithBooks(1L);
        for (Book book : author.getBooks()) {
            log.info("Book title : {}", book.getTitle());
        }
    }

    @Test
    @Transactional
    void findByIdWithBooks2() {
        Author author = repository.findByIdWithBooks2(1L);
        for (Book book : author.getBooks()) {
            log.info("Book title : {}", book.getTitle());
        }
    }
}
