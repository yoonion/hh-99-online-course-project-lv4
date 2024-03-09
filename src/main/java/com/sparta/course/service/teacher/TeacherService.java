package com.sparta.course.service.teacher;

import com.sparta.course.dto.teacher.TeacherRegisterRequestDto;
import com.sparta.course.dto.teacher.TeacherRegisterResponseDto;

public interface TeacherService {

    TeacherRegisterResponseDto registerTeacher(TeacherRegisterRequestDto requestDto);
}
