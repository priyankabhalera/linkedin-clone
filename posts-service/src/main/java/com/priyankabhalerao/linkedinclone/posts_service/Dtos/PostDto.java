package com.priyankabhalerao.linkedinclone.posts_service.Dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {
    private Long postId;
    private String content;
    private Long userId;
    private LocalDateTime createdAt;
}
