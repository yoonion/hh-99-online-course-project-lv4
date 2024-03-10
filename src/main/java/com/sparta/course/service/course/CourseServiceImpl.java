package com.sparta.course.service.course;

import com.sparta.course.dto.CourseInfoByCategoryResponseDto;
import com.sparta.course.dto.CourseInfoResponseDto;
import com.sparta.course.dto.course.CourseRegisterRequestDto;
import com.sparta.course.dto.course.CourseRegisterResponseDto;
import com.sparta.course.entity.course.Course;
import com.sparta.course.entity.course.CourseCategoryEnum;
import com.sparta.course.entity.teacher.Teacher;
import com.sparta.course.repository.CourseRepository;
import com.sparta.course.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Override
    public CourseInfoResponseDto getCourse(Long courseId) {
        Course course = findCourseById(courseId);

        return new CourseInfoResponseDto(course);
    }

    @Override
    public List<CourseInfoByCategoryResponseDto> getCourseByCategory(String category, String sort, String order) {
        CourseCategoryEnum courseCategory = CourseCategoryEnum.matchStringWithCategory(category);

        Sort sortBy = Sort.by(Sort.Direction.DESC, sort); // default order by desc
        if (order.equalsIgnoreCase("asc")) {
            sortBy = Sort.by(Sort.Direction.ASC, sort);
        }

        return courseRepository.findAllByCategory(courseCategory, sortBy).stream()
                .map(CourseInfoByCategoryResponseDto::new)
                .toList();
    }

    private Teacher findTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new NoSuchElementException("강사 정보가 존재하지 않습니다."));
    }

    private Course findCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new NoSuchElementException("강의 정보가 존재하지 않습니다."));
    }
}

