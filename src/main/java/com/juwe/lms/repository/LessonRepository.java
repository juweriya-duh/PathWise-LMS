package com.juwe.lms.repository;

import com.juwe.lms.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    Optional<Lesson> findByIdAndDeletedIsFalse(Long id);

    List<Lesson> findBySectionIdAndIsDeletedFalse(Long sectionId);
}
