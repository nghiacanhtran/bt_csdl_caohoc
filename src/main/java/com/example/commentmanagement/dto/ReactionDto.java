package com.example.commentmanagement.dto;

import java.time.LocalDateTime;

public class ReactionDto {
    private Long id;
    private Long commentId;
    private Long userId;
    private String type; // e.g., "like", "dislike"
    private LocalDateTime createdAt;

    public ReactionDto() {
    }

    public ReactionDto(Long id, Long commentId, Long userId, String type, LocalDateTime createdAt) {
        this.id = id;
        this.commentId = commentId;
        this.userId = userId;
        this.type = type;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}