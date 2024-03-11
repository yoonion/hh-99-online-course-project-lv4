package com.sparta.course.controller;

import com.sparta.course.dto.course.CourseInfoByCategoryResponseDto;
import com.sparta.course.dto.course.CourseInfoResponseDto;
import com.sparta.course.dto.course.CourseRegisterResponseDto;
import com.sparta.course.dto.course.CourseRegisterRequestDto;
import com.sparta.course.entity.user.UserRoleEnum;
import com.sparta.course.service.course.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Secured(UserRoleEnum.Authority.ADMIN)
    @PostMapping
    public ResponseEntity<CourseRegisterResponseDto> registerCourse(@RequestBody @Valid CourseRegisterRequestDto requestDto) {
        CourseRegisterResponseDto responseDto = courseService.registerCourse(requestDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<CourseInfoResponseDto> getCourse(@PathVariable Long courseId) {
        CourseInfoResponseDto responseDto = courseService.getCourse(courseId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<CourseInfoByCategoryResponseDto>> getCourseByCategory(
            @RequestParam(required = false, defaultValue = "spring") String category,
            @RequestParam(required = false, defaultValue = "createdAt") String sort,
            @RequestParam(required = false, defaultValue = "desc") String order
    ) {
        List<CourseInfoByCategoryResponseDto> responseDtos = courseService.getCourseByCategory(category, sort, order);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDtos);
    }
}
