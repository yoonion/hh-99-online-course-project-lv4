package com.sparta.course.service.user;

import com.sparta.course.dto.user.SignUpRequestDto;
import com.sparta.course.dto.user.SignUpResponseDto;

public interface UserService {

    SignUpResponseDto signUp(SignUpRequestDto requestDto);

}
