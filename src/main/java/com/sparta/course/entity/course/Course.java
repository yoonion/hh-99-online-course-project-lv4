package com.sparta.course.entity.course;

import com.sparta.course.dto.course.CourseRegisterRequestDto;
import com.sparta.course.entity.comment.Comment;
import com.sparta.course.entity.teacher.Teacher;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.sparta.course.entity.course.CourseCategoryEnum.matchStringWithCategory;

@Entity
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String introduction;

    @Column(nullable = false)
    private CourseCategoryEnum category;

    @ColumnDefault("0")
    @Column(nullable = false)
    private int likeCount;

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    private List<Comment> comments = new ArrayList<>();

    public Course(Teacher teacher, CourseRegisterRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.price = requestDto.getPrice();
        this.introduction = requestDto.getIntroduction();
        this.category = matchStringWithCategory(requestDto.getCategory());
        this.teacher = teacher;
    }

    public void updateLikeCount(boolean isLike) {
        if (!isLike) {
            this.likeCount -= 1; // 좋아요 취소 - count 1 감소
            return;
        }
        this.likeCount += 1; // 좋아요 추가 - count 1 증가
    }
}
