package com.colak.springjpanplusonetutorial.repository;

import com.colak.springjpanplusonetutorial.jpa.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    // USe JPQL
    @Query("SELECT a FROM Author a LEFT JOIN FETCH a.books WHERE a.id = :authorId")
    Optional<Author> findByIdWithBooks(@Param("authorId") Long authorId);

}
