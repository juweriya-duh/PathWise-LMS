package com.juwe.lms.repository;

import com.juwe.lms.entity.Course;
import com.juwe.lms.entity.CourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByStatusAndIsDeletedFalse(CourseStatus courseStatus);

    List<Course> findByInstructorIdAndIsDeletedFalse(Long instructorId);
}
