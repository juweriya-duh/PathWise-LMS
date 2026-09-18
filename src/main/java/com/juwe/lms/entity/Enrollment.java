package com.juwe.lms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    public Enrollment(Long id, User user, Course course) {
        this.id = id;
        this.user = user;
        this.course = course;
    }

    public Enrollment() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long setUserId(Long userId) {

        userId = getUser().getId();
        return userId;
    }

    public Long setCourseId(Long courseId) {
        courseId = getCourse().getId();
        return courseId;
    }
}
