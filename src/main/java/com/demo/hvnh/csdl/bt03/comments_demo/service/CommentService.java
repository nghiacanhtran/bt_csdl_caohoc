package com.demo.hvnh.csdl.bt03.comments_demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.hvnh.csdl.bt03.comments_demo.entity.Comment;
import com.demo.hvnh.csdl.bt03.comments_demo.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}