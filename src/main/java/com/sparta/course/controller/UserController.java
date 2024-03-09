package com.sparta.course.controller;

import com.sparta.course.dto.user.SignUpRequestDto;
import com.sparta.course.dto.user.SignUpResponseDto;
import com.sparta.course.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {
        SignUpResponseDto responseDto = userService.signUp(requestDto);

        return ResponseEntity
                .status(HttpStatus.OK.value())
                .body(responseDto);
    }
}
