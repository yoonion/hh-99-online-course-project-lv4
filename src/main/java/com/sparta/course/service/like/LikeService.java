package com.sparta.course.service.like;

import com.sparta.course.dto.like.LikeCourseRequestDto;
import com.sparta.course.dto.like.LikeCourseResponseDto;
import com.sparta.course.entity.user.User;

public interface LikeService {
    LikeCourseResponseDto likeCourse(LikeCourseRequestDto requestDto, User user);
}
