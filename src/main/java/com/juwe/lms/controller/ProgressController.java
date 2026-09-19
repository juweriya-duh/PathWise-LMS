package com.juwe.lms.controller;

import com.juwe.lms.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @PostMapping("/complete")
    public void markLessonComplete(@RequestParam Long userId, @RequestParam Long lessonId) {
        progressService.markLessonComplete(userId, lessonId);
    }

    @GetMapping("/course-percentage")
    public int calculateCourseProgress(@RequestParam Long userId, @RequestParam Long courseId) {
        return progressService.calculateCourseProgress(userId, courseId);
    }
}