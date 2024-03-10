package com.sparta.course.service.comment;

import com.sparta.course.dto.comment.CommentRegisterRequestDto;
import com.sparta.course.dto.comment.CommentRegisterResponseDto;
import com.sparta.course.entity.comment.Comment;
import com.sparta.course.entity.course.Course;
import com.sparta.course.entity.user.User;
import com.sparta.course.repository.CommentRepository;
import com.sparta.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CourseRepository courseRepository;

    @Override
    public CommentRegisterResponseDto registerComment(CommentRegisterRequestDto requestDto, User user) {
        Course course = courseRepository.findById(requestDto.getCourseId())
                .orElseThrow(() -> new NoSuchElementException("해당하는 강의가 존재하지 않습니다."));

        Comment comment = new Comment(requestDto, course, user);
        commentRepository.save(comment);

        return new CommentRegisterResponseDto(comment);
    }
}