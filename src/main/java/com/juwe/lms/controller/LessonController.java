package com.juwe.lms.controller;

import com.juwe.lms.entity.Lesson;
import com.juwe.lms.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonService.createLesson(lesson);
    }

    @GetMapping("/{id}")
    public Lesson getLessonById(@PathVariable Long id) {
        return lessonService.getLesson(id);
    }

    @GetMapping("/section/{sectionId}")
    public List<Lesson> getLessonsBySection(@PathVariable Long sectionId) {
        return lessonService.getLessonsBySection(sectionId);
    }

    @PutMapping("/{id}")
    public Lesson updateLesson(@PathVariable Long id, @RequestBody Lesson updatedLesson) {
        return lessonService.updateLesson(id, updatedLesson);
    }

    @DeleteMapping("/{id}")
    public void softDeleteLesson(@PathVariable Long id) {
        lessonService.deleteLessonSoftly(id);
    }
}