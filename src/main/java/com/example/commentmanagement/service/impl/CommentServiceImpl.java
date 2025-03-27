package com.example.commentmanagement.service.impl;

import com.example.commentmanagement.dto.CommentDto;
import com.example.commentmanagement.exception.ResourceNotFoundException;
import com.example.commentmanagement.model.postgres.Comment;
import com.example.commentmanagement.repository.postgres.CommentRepository;
import com.example.commentmanagement.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        comment.setUserId(commentDto.getUserId());
        comment.setContentId(commentDto.getContentId());
        comment.setParentId(commentDto.getParentId());
        comment.setCreatedAt(commentDto.getCreatedAt());
        comment.setStatus("active");
        Comment savedComment = commentRepository.save(comment);
        return mapToDto(savedComment);
    }

    @Override
    public List<CommentDto> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return mapToDtoList(comments);
    }

    @Override
    public CommentDto getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.map(this::mapToDto)
                      .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + id));
    }

    @Override
    public CommentDto updateComment(Long id, CommentDto commentDto) {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + id));
        existingComment.setText(commentDto.getText());
        existingComment.setUpdatedAt(commentDto.getUpdatedAt());
        Comment updatedComment = commentRepository.save(existingComment);
        return mapToDto(updatedComment);
    }

    @Override
    public void deleteComment(Long id) {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + id));
        existingComment.setStatus("deleted");
        commentRepository.save(existingComment);
    }

    private CommentDto mapToDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setText(comment.getText());
        dto.setUserId(comment.getUserId());
        dto.setContentId(comment.getContentId());
        dto.setParentId(comment.getParentId());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setUpdatedAt(comment.getUpdatedAt());
        dto.setStatus(comment.getStatus());
        return dto;
    }

    private List<CommentDto> mapToDtoList(List<Comment> comments) {
        return comments.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public List<CommentDto> getCommentsByContentId(Long contentId) {
        throw new UnsupportedOperationException("Unimplemented method 'getCommentsByContentId'");
    }

    @Override
    public List<CommentDto> getNestedComments(Long parentId) {
        throw new UnsupportedOperationException("Unimplemented method 'getNestedComments'");
    }
}