package com.example.commentmanagement.repository.postgres;

import com.example.commentmanagement.model.postgres.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
    // Custom query methods can be defined here
}