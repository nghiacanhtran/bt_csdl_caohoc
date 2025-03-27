package com.example.commentmanagement.util;

import com.example.commentmanagement.dto.CommentDto;
import com.example.commentmanagement.model.postgres.Comment;

public class CommentMapper {

    public static CommentDto toDto(Comment comment) {
        if (comment == null) {
            return null;
        }
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setContentId(comment.getContentId());
        dto.setUserId(comment.getUserId());
        dto.setParentId(comment.getParentId());
        dto.setText(comment.getText());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setUpdatedAt(comment.getUpdatedAt());
        dto.setStatus(comment.getStatus());
        return dto;
    }

    public static Comment toEntity(CommentDto dto) {
        if (dto == null) {
            return null;
        }
        Comment comment = new Comment();
        comment.setId(dto.getId());
        comment.setContentId(dto.getContentId());
        comment.setUserId(dto.getUserId());
        comment.setParentId(dto.getParentId());
        comment.setText(dto.getText());
        comment.setCreatedAt(dto.getCreatedAt());
        comment.setUpdatedAt(dto.getUpdatedAt());
        comment.setStatus(dto.getStatus());
        return comment;
    }
}