package com.sparta.course.dto.comment;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CommentUpdateRequestDto {
    @NotBlank
    private String contents;
}
