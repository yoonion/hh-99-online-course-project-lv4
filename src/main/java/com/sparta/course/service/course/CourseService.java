package com.sparta.course.service.course;

import com.sparta.course.dto.CourseInfoResponseDto;
import com.sparta.course.dto.course.CourseRegisterResponseDto;
import com.sparta.course.dto.course.CourseRegisterRequestDto;

public interface CourseService {
    CourseRegisterResponseDto registerCourse(CourseRegisterRequestDto requestDto);

    CourseInfoResponseDto getCourse(Long courseId);
}
