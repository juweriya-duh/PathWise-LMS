package com.juwe.lms.entity;

import jakarta.persistence.*;

@Entity
@Table( name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    private LessonType type;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    private boolean isDeleted = false;

    public Lesson(Long id, String title, String content, LessonType type, Section section, boolean isDeleted) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.type = type;
        this.section = section;
        this.isDeleted = isDeleted;
    }

    public Lesson() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LessonType getType() {
        return type;
    }

    public void setType(LessonType type) {
        this.type = type;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
