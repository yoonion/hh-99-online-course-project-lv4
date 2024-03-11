package com.sparta.course.controller;

import com.sparta.course.dto.like.LikeCourseRequestDto;
import com.sparta.course.dto.like.LikeCourseResponseDto;
import com.sparta.course.security.UserDetailsImpl;
import com.sparta.course.service.like.LikeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<LikeCourseResponseDto> likeCourse(
            @RequestBody @Valid LikeCourseRequestDto requestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
            ) {
        LikeCourseResponseDto responseDto = likeService.likeCourse(requestDto, userDetails.getUser());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }
}
