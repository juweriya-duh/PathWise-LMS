package com.juwe.lms.repository;

import com.juwe.lms.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SectionRepository extends JpaRepository<Section, Long> {
    static Optional<Section> findByIdAndDeletedIsFalse(Long id) {
    };

    List<Section> findByCourseIdAndIsDeletedFalse(Long courseId);

}
