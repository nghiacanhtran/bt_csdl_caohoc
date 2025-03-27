package com.example.commentmanagement.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.commentmanagement.dto.ContentDto;
import com.example.commentmanagement.service.ContentService;

@RestController
@RequestMapping("/api/contents")
public class ContentController {

    private final ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @PostMapping
    public ResponseEntity<ContentDto> createContent(@RequestBody ContentDto contentDto) {
        ContentDto createdContent = contentService.createContent(contentDto);
        return ResponseEntity.status(201).body(createdContent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentDto> getContentById(@PathVariable int id) {
        ContentDto contentDto = contentService.getContentById(id);
        return ResponseEntity.ok(contentDto);
    }

    @GetMapping
    public ResponseEntity<List<ContentDto>> getAllContents() {
        List<ContentDto> contents = contentService.getAllContents();
        return ResponseEntity.ok(contents);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContentDto> updateContent(@PathVariable int id, @RequestBody ContentDto contentDto) {
        ContentDto updatedContent = contentService.updateContent(id, contentDto);
        return ResponseEntity.ok(updatedContent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContent(@PathVariable int id) {
        contentService.deleteContent(id);
        return ResponseEntity.noContent().build();
    }
}