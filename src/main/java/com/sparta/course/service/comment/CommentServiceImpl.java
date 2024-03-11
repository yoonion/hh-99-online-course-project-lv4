package com.sparta.course.service.comment;

import com.sparta.course.dto.comment.*;
import com.sparta.course.entity.comment.Comment;
import com.sparta.course.entity.course.Course;
import com.sparta.course.entity.user.User;
import com.sparta.course.repository.CommentRepository;
import com.sparta.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CourseRepository courseRepository;

    @Override
    public CommentRegisterResponseDto registerComment(CommentRegisterRequestDto requestDto, User user) {
        Course course = findCourseById(requestDto.getCourseId());

        Comment comment = new Comment(requestDto, course, user);
        commentRepository.save(comment);

        return new CommentRegisterResponseDto(comment);
    }

    @Override
    public CommentUpdateResponseDto updateComment(CommentUpdateRequestDto requestDto, Long commentId, User user) {
        Comment findComment = findCommentById(commentId);
        checkCommentUser(user, findComment);
        findComment.update(requestDto);

        return new CommentUpdateResponseDto(findComment);
    }

    @Override
    public CommentDeleteResponseDto deleteComment(Long commentId, User user) {
        Comment findComment = findCommentById(commentId);
        checkCommentUser(user, findComment);
        commentRepository.deleteById(commentId);

        return new CommentDeleteResponseDto(findComment.getId());
    }

    private void checkCommentUser(User user, Comment findComment) {
        if (!findComment.getUser().getId().equals(user.getId())) {
            throw new AccessDeniedException("댓글을 등록한 회원만 수정 및 삭제가 가능합니다.");
        }
    }

    private Comment findCommentById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new NoSuchElementException("댓글이 존재하지 않습니다."));
    }

    private Course findCourseById(Long CourseId) {
        return courseRepository.findById(CourseId)
                .orElseThrow(() -> new NoSuchElementException("해당하는 강의가 존재하지 않습니다."));
    }
}
