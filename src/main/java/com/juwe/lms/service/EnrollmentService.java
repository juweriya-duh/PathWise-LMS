package com.juwe.lms.service;

import com.juwe.lms.entity.Enrollment;
import com.juwe.lms.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Enrollment enrollUser(Long userId, Long courseId) {
        Optional<Enrollment> existing = enrollmentRepository.findByUserIdAndCourseId(userId, courseId);

        if (existing.isPresent()) {
            throw new RuntimeException("User is already enrolled in this course");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setUserId(userId);
        enrollment.setCourseId(courseId);

        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getEnrollmentsByUsers(Long userId) {
        List<Enrollment> enrolledList = enrollmentRepository.findByUserId(userId);
        return enrolledList;
    }

    public List<Enrollment> getEnrollmentsByCourse(Long courseId) {
        List<Enrollment> enrolledList = enrollmentRepository.findByCourseId(courseId);
        return enrolledList;
    }

    public Boolean isUserEnrolled(Long userId, Long courseId) {
        Optional<Enrollment> existingUserEnrolled = enrollmentRepository.findByUserIdAndCourseId(userId, courseId);
        if (!existingUserEnrolled.isPresent()) {
            return false;
        }
        return true;
    }


}
