package com.juwe.lms.repository;

import com.juwe.lms.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
    Optional<Progress> findByUserIdandLessonId(Long userId, Long lessonId);

}
