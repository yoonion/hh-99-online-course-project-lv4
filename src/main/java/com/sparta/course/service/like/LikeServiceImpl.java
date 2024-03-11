package com.sparta.course.service.like;

import com.sparta.course.dto.like.LikeCourseRequestDto;
import com.sparta.course.dto.like.LikeCourseResponseDto;
import com.sparta.course.entity.course.Course;
import com.sparta.course.entity.like.Like;
import com.sparta.course.entity.user.User;
import com.sparta.course.repository.CourseRepository;
import com.sparta.course.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final CourseRepository courseRepository;

    @Override
    @Transactional
    public LikeCourseResponseDto likeCourse(LikeCourseRequestDto requestDto, User user) {
        // 강의가 존재 하는지 확인
        Course course = courseRepository.findById(requestDto.getCourseId())
                .orElseThrow(() -> new NoSuchElementException("강의가 존재하지 않습니다."));

        // 이미 좋아요 했는지 확인
        Optional<Like> findLike = likeRepository.findByCourseIdAndUserId(course.getId(), user.getId());
        if (findLike.isPresent()) {
            likeRepository.deleteByCourseIdAndUserId(course.getId(), user.getId());
            return new LikeCourseResponseDto(course.getId(), false); // 좋아요 취소
        }

        Like like = new Like(course, user);
        likeRepository.save(like);

        return new LikeCourseResponseDto(course.getId(), true); // 좋아요 추가
    }
}
