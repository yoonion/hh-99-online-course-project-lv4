package com.sparta.course.controller;

import com.sparta.course.dto.teacher.TeacherRegisterResponseDto;
import com.sparta.course.dto.teacher.TeacherRegisterRequestDto;
import com.sparta.course.entity.user.UserRoleEnum;
import com.sparta.course.service.teacher.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @Secured(UserRoleEnum.Authority.ADMIN)
    @PostMapping
    public ResponseEntity<TeacherRegisterResponseDto> registerTeacher(@RequestBody @Valid TeacherRegisterRequestDto requestDto) {
        TeacherRegisterResponseDto responseDto = teacherService.registerTeacher(requestDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }
}
