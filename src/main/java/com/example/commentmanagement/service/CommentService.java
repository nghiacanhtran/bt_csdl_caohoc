package com.example.commentmanagement.service;

import com.example.commentmanagement.dto.CommentDto;
import java.util.List;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto);
    CommentDto getCommentById(Long id);
    List<CommentDto> getAllComments();
    CommentDto updateComment(Long id, CommentDto commentDto);
    void deleteComment(Long id);
    List<CommentDto> getCommentsByContentId(Long contentId);
    List<CommentDto> getNestedComments(Long parentId);
}