package com.juwe.lms.dto;

public class SectionRequestDTO {
    private String title;
    private Long courseId;
    // getters, setters


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}