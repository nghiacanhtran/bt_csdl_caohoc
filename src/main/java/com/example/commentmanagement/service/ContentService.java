package com.example.commentmanagement.service;

import java.util.List;

import com.example.commentmanagement.dto.ContentDto;

public interface ContentService {
    ContentDto createContent(ContentDto contentDto);
    ContentDto getContentById(int id);
    List<ContentDto> getAllContents();
    ContentDto updateContent(int id, ContentDto contentDto);
    void deleteContent(int id);
}