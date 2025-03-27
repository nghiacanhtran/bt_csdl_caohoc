package com.example.commentmanagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.commentmanagement.dto.ContentDto;
import com.example.commentmanagement.model.postgres.Content;
import com.example.commentmanagement.repository.postgres.ContentRepository;
import com.example.commentmanagement.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

    private final ContentRepository contentRepository;

    public ContentServiceImpl(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public ContentDto createContent(ContentDto contentDto) {
        Content content = new Content();
        content.setTitle(contentDto.getTitle());
        content.setBody(contentDto.getBody());
        content.setType(contentDto.getType());
        content.setStatus(contentDto.getStatus());
        Content savedContent = contentRepository.save(content);
        return mapToDto(savedContent);
    }

    @Override
    public ContentDto getContentById(int id) {
        return contentRepository.findById(id)
                .map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("Content not found with id: " + id));
    }

    @Override
    public List<ContentDto> getAllContents() {
        return contentRepository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    private ContentDto mapToDto(Content content) {
        ContentDto dto = new ContentDto();
        dto.setId(content.getId());
        dto.setTitle(content.getTitle());
        dto.setBody(content.getBody());
        dto.setType(content.getType());
        dto.setStatus(content.getStatus());
        return dto;
    }

    @Override
    public ContentDto updateContent(int id, ContentDto contentDto) {
        throw new UnsupportedOperationException("Unimplemented method 'updateContent'");
    }

    @Override
    public void deleteContent(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteContent'");
    }

}