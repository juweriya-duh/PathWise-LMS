package com.juwe.lms.service;

import com.juwe.lms.entity.Course;
import com.juwe.lms.entity.CourseStatus;
import com.juwe.lms.entity.Section;
import com.juwe.lms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SectionService sectionService;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourseById(Long id) {
        Optional<Course> result = courseRepository.findById(id);

        if (!result.isPresent()) {
            throw new RuntimeException("Course not found");
        }

        Course course = result.get();

        if (course.isDeleted()) {
            throw new RuntimeException("Course not found");
        }

        return course;
    }

    public List<Course> getAllPublishedCourses() {
        return courseRepository.findByStatusAndIsDeletedFalse(CourseStatus.PUBLISHED);
    }

    public List<Course> getCoursesByInstructor(Long instructorId) {
        return courseRepository.findByInstructorIdAndIsDeletedFalse(instructorId);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        Course existing = getCourseById(id);
        existing.setTitle(updatedCourse.getTitle());
        existing.setDescription(updatedCourse.getDescription());
        existing.setStatus(updatedCourse.getStatus());
        return courseRepository.save(existing);
    }

    public void softDeleteCourse(Long id) {
        Course course = getCourseById(id);
        course.setDeleted(true);
        courseRepository.save(course);

        List<Section> sections = sectionService.getSectionsByCourse(id);

        for (int i = 0; i < sections.size(); i++) {
            Section section = sections.get(i);
            sectionService.deleteSectionSoftly(section.getId());
        }

    }
}
