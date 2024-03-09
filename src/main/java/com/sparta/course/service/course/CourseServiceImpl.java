package com.sparta.course.service.course;

import com.sparta.course.dto.course.CourseRegisterRequestDto;
import com.sparta.course.dto.course.CourseRegisterResponseDto;
import com.sparta.course.entity.course.Course;
import com.sparta.course.entity.teacher.Teacher;
import com.sparta.course.repository.CourseRepository;
import com.sparta.course.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    @Override
    @Transactional
    public CourseRegisterResponseDto registerCourse(CourseRegisterRequestDto requestDto) {
        Long teacherId = requestDto.getTeacherId();
        Teacher findTeacher = findTeacherById(teacherId);

        Course course = new Course(findTeacher, requestDto);
        courseRepository.save(course);

        return new CourseRegisterResponseDto(course);
    }

    private Teacher findTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new NoSuchElementException("강사 정보가 존재하지 않습니다."));
    }
}

