package com.sparta.course.entity.comment;

import com.sparta.course.dto.comment.CommentRegisterRequestDto;
import com.sparta.course.entity.course.Course;
import com.sparta.course.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Comment(CommentRegisterRequestDto requestDto, Course course, User user) {
        this.contents = requestDto.getContents();
        this.course = course;
        this.user = user;
        course.getComments().add(this); // 반대쪽 연관관계 정보도 넣어준다
    }
}
