package com.example.commentmanagement.service;

import com.example.commentmanagement.dto.ReactionDto;

import java.util.List;

public interface ReactionService {
    ReactionDto addReaction(int commentId, int userId, String type);
    void removeReaction(int commentId, int userId);
    List<ReactionDto> getReactionsForComment(int commentId);
    int countReactions(int commentId, String type);
}