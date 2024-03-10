package com.sparta.course.controller;

import com.sparta.course.dto.comment.CommentRegisterRequestDto;
import com.sparta.course.dto.comment.CommentRegisterResponseDto;
import com.sparta.course.security.UserDetailsImpl;
import com.sparta.course.service.comment.CommentService;
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
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentRegisterResponseDto> registerComment(
            @RequestBody CommentRegisterRequestDto requestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
            ) {
        CommentRegisterResponseDto responseDto = commentService.registerComment(requestDto, userDetails.getUser());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }
}
