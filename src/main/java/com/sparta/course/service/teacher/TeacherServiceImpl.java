package com.sparta.course.service.teacher;

import com.sparta.course.dto.teacher.TeacherRegisterRequestDto;
import com.sparta.course.dto.teacher.TeacherRegisterResponseDto;
import com.sparta.course.entity.teacher.Teacher;
import com.sparta.course.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    @Transactional
    public TeacherRegisterResponseDto registerTeacher(TeacherRegisterRequestDto requestDto) {
        Teacher teacher = new Teacher(requestDto);
        teacherRepository.save(teacher);

        return new TeacherRegisterResponseDto(teacher);
    }
}
