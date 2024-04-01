package com.colak.springjpanplusonetutorial.repository;

import com.colak.springjpanplusonetutorial.jpa.Author;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * This repository uses EntityManager API to solve N+1 Select Problem
 */
@Repository
@RequiredArgsConstructor
public class AuthorRepository2 {

    private final EntityManager entityManager;

    // See https://medium.com/jpa-java-persistence-api-guide/hibernate-lazyinitializationexception-solutions-7b32bfc0ce98
    // USe JPQL
    public Author findByIdWithBooks(@Param("authorId") Long authorId) {
        TypedQuery<Author> query = entityManager.createQuery(
                "SELECT a FROM Author a LEFT JOIN FETCH a.books WHERE a.id = :authorId", Author.class);
        query.setParameter("authorId", authorId);
        return query.getSingleResult();
    }

    // See https://medium.com/jpa-java-persistence-api-guide/hibernate-lazyinitializationexception-solutions-7b32bfc0ce98
    // USe  Entity Graphs
    public Author findByIdWithBooks2(@Param("authorId") Long authorId) {
        EntityGraph<Author> graph = entityManager.createEntityGraph(Author.class);
        graph.addAttributeNodes("books");
        Map<String, Object> hints = new HashMap<>();
        hints.put("jakarta.persistence.loadgraph", graph);

        return entityManager.find(Author.class, authorId, hints);
    }

}
