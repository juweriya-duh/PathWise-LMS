package com.juwe.lms.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "progress")
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    private boolean isCompleted = false;

    public Progress(Long id, User user, Lesson lesson, boolean isCompleted) {
        this.id = id;
        this.user = user;
        this.lesson = lesson;
        this.isCompleted = isCompleted;
    }

    public Progress() {

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

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Long setLessonId(Long lessonId) {
        lessonId = getLesson().getId();
        return lessonId;
    }

    public Long setUserId(Long userId) {
        userId = getUser().getId();
        return userId;
    }
}
