package com.sparta.course.dto.comment;

import com.sparta.course.entity.comment.Comment;
import lombok.Getter;

@Getter
public class CommentUpdateResponseDto {
    private final String contents;

    public CommentUpdateResponseDto(Comment findComment) {
        this.contents = findComment.getContents();
    }
}
