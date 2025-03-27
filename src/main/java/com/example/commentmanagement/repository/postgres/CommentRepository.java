package com.example.commentmanagement.repository.postgres;

import com.example.commentmanagement.model.postgres.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByContentId(Long contentId);
    List<Comment> findByUserId(Long userId);
    List<Comment> findByParentId(Long parentId);
}