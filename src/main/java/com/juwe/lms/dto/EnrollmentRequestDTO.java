package com.juwe.lms.dto;

public class EnrollmentRequestDTO {
    private Long userId;
    private Long courseId;
    // getters, setters


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}