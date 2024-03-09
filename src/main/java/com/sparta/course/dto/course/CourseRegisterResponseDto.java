package com.sparta.course.dto.course;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sparta.course.entity.course.Course;
import com.sparta.course.entity.course.CourseCategoryEnum;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CourseRegisterResponseDto {

    private final Long teacherId;
    private final String title;
    private final int price;
    private final String introduction;
    private final CourseCategoryEnum category;
    private final LocalDateTime createdAt;

    public CourseRegisterResponseDto(Course course) {
        this.teacherId = course.getTeacher().getId();
        this.title = course.getTitle();
        this.price = course.getPrice();
        this.introduction = course.getIntroduction();
        this.category = course.getCategory();
        this.createdAt = course.getCreatedAt();
    }
}
