package com.sparta.course.dto.like;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class LikeCourseResponseDto {
    private final Long courseId;
    private final boolean like;

    public LikeCourseResponseDto(Long courseId, boolean isLike) {
        this.courseId = courseId;
        this.like = isLike;
    }
}
