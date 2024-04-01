package com.colak.springjpanplusonetutorial.repository;

import com.colak.springjpanplusonetutorial.jpa.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository3 extends JpaRepository<Author, Long> {


    // See https://medium.com/jpa-java-persistence-api-guide/springdata-n-1-solution-with-namedentitygraph-8b101292261a
    // USe Spring EntityGraph
    @EntityGraph(value = "author[books]")
    Optional<Author> findById(Long authorId);


}
