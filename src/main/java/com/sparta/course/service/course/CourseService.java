package com.sparta.course.service.course;

import com.sparta.course.dto.CourseInfoByCategoryResponseDto;
import com.sparta.course.dto.CourseInfoResponseDto;
import com.sparta.course.dto.course.CourseRegisterResponseDto;
import com.sparta.course.dto.course.CourseRegisterRequestDto;

import java.util.List;

public interface CourseService {
    CourseRegisterResponseDto registerCourse(CourseRegisterRequestDto requestDto);

    CourseInfoResponseDto getCourse(Long courseId);

    List<CourseInfoByCategoryResponseDto> getCourseByCategory(String category, String sort, String order);
}
