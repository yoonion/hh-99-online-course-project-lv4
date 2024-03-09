package com.sparta.course.entity.course;

import com.sparta.course.dto.course.CourseRegisterRequestDto;
import com.sparta.course.entity.teacher.Teacher;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

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

    @Column(nullable = false)
    private String introduction;

    @Column(nullable = false)
    private CourseCategoryEnum category;

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Course(Teacher teacher, CourseRegisterRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.price = requestDto.getPrice();
        this.introduction = requestDto.getIntroduction();
        this.category = matchStringWithCategory(requestDto.getCategory());
        this.teacher = teacher;
    }
}
