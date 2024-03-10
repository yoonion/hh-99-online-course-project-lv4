package com.sparta.course.service.comment;

import com.sparta.course.dto.comment.CommentRegisterRequestDto;
import com.sparta.course.dto.comment.CommentRegisterResponseDto;
import com.sparta.course.entity.user.User;

public interface CommentService {
    CommentRegisterResponseDto registerComment(CommentRegisterRequestDto requestDto, User user);
}
