package com.example.commentmanagement.repository.postgres;

import com.example.commentmanagement.model.postgres.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {
    // Custom query methods can be defined here if needed
}