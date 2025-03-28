package com.demo.hvnh.csdl.bt03.comments_demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.hvnh.csdl.bt03.comments_demo.entity.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findByParentId(String parentId);
}