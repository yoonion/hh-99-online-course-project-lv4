package com.sparta.course.dto.comment;

import com.sparta.course.entity.comment.Comment;
import lombok.Getter;

@Getter
public class CommentRegisterResponseDto {
    private final String contents;

    public CommentRegisterResponseDto(Comment comment) {
        this.contents = comment.getContents();
    }
}
