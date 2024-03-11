package com.sparta.course.controller;

import com.sparta.course.dto.comment.*;
import com.sparta.course.security.UserDetailsImpl;
import com.sparta.course.service.comment.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentRegisterResponseDto> registerComment(
            @RequestBody @Valid CommentRegisterRequestDto requestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
            ) {
        CommentRegisterResponseDto responseDto = commentService.registerComment(requestDto, userDetails.getUser());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<CommentUpdateResponseDto> updateComment(
            @PathVariable Long commentId,
            @RequestBody @Valid CommentUpdateRequestDto requestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {

        CommentUpdateResponseDto responseDto = commentService.updateComment(requestDto, commentId, userDetails.getUser());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<CommentDeleteResponseDto> deleteComment(
            @PathVariable Long commentId,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        CommentDeleteResponseDto responseDto = commentService.deleteComment(commentId, userDetails.getUser());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(responseDto);
    }

}
