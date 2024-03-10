package com.sparta.course.repository;

import com.sparta.course.entity.course.Course;
import com.sparta.course.entity.course.CourseCategoryEnum;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByOrderByCreatedAtDesc();

    List<Course> findAllByCategory(CourseCategoryEnum category, Sort sort);
}
