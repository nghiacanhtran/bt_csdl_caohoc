package com.example.commentmanagement.repository.mongo;

import com.example.commentmanagement.model.mongo.CommentDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDetailRepository extends MongoRepository<CommentDetail, String> {
    // Custom query methods can be defined here
}