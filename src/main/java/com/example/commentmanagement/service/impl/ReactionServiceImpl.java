package com.example.commentmanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.commentmanagement.dto.ReactionDto;
import com.example.commentmanagement.service.ReactionService;

@Service
public class ReactionServiceImpl implements ReactionService {

    @Override
    public ReactionDto addReaction(int commentId, int userId, String type) {
        throw new UnsupportedOperationException("Unimplemented method 'addReaction'");
    }

    @Override
    public void removeReaction(int commentId, int userId) {
        throw new UnsupportedOperationException("Unimplemented method 'removeReaction'");
    }

    @Override
    public List<ReactionDto> getReactionsForComment(int commentId) {
        throw new UnsupportedOperationException("Unimplemented method 'getReactionsForComment'");
    }

    @Override
    public int countReactions(int commentId, String type) {
        throw new UnsupportedOperationException("Unimplemented method 'countReactions'");
    }

   
}