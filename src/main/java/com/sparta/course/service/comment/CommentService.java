package com.sparta.course.service.comment;

import com.sparta.course.dto.comment.*;
import com.sparta.course.entity.user.User;

public interface CommentService {
    CommentRegisterResponseDto registerComment(CommentRegisterRequestDto requestDto, User user);

    CommentUpdateResponseDto updateComment(CommentUpdateRequestDto requestDto, Long commentId, User user);

    CommentDeleteResponseDto deleteComment(Long commentId, User user);

}
