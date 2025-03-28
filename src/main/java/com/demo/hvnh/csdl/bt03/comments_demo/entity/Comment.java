package com.demo.hvnh.csdl.bt03.comments_demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "comments")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Comment {
    @Id
    private String id;
    
    private Long userId;
    private String text;
    private String parentId; // Comment cha (nếu có)
    private List<String> attachments; // Ảnh, video đính kèm
    private Instant createdAt = Instant.now();
}
