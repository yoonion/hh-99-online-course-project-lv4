package com.sparta.course.dto.course;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sparta.course.entity.course.Course;
import com.sparta.course.entity.course.CourseCategoryEnum;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CourseInfoResponseDto {
    private final String title;
    private final int price;
    private final String introduction;
    private final CourseCategoryEnum category;
    private final LocalDateTime createAt;

    private final String teacherName;
    private final int teacherCareer;
    private final String teacherCompany;
    private final String teacherIntroduction;

    public CourseInfoResponseDto(Course course) {
        this.title = course.getTitle();
        this.price = course.getPrice();
        this.introduction = course.getIntroduction();
        this.category = course.getCategory();
        this.createAt = course.getCreatedAt();
        this.teacherName = course.getTeacher().getName();
        this.teacherCareer = course.getTeacher().getCareer();
        this.teacherCompany = course.getTeacher().getCompany();
        this.teacherIntroduction = course.getTeacher().getIntroduction();
    }
}
