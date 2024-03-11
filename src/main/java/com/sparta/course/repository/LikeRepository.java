package com.sparta.course.repository;

import com.sparta.course.entity.like.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {

    Optional<Like> findByCourseIdAndUserId(Long courseId, Long UserId);

    void deleteByCourseIdAndUserId(Long courseId, Long userId);

    boolean existsByCourseIdAndUserId(Long id, Long id1);
}
