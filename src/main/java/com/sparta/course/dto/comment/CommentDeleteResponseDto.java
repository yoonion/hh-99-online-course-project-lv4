package com.sparta.course.dto.comment;

import lombok.Getter;

@Getter
public class CommentDeleteResponseDto {
    private final Long id;

    public CommentDeleteResponseDto(Long id) {
        this.id = id;
    }
}
