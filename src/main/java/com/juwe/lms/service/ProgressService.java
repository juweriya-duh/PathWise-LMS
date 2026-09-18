package com.juwe.lms.service;

import com.juwe.lms.entity.Lesson;
import com.juwe.lms.entity.Progress;
import com.juwe.lms.entity.Section;
import com.juwe.lms.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private LessonService lessonService;

    public void markLessonComplete(Long userId, Long lessonId) {

        Optional<Progress> existingProgress =  progressRepository.findByUserIdandLessonId(userId, lessonId);

        Progress progress;

        if (existingProgress.isPresent()) {
            progress = existingProgress.get();
        }
        else {
            progress = new Progress();
            progress.setUserId(userId);
            progress.setLessonId(lessonId);
        }

        progress.setCompleted(true);
        progressRepository.save(progress);
    }


    public int calculateCourseProgress(Long userId, Long courseId) {

        List<Section> sections = sectionService.getSectionsByCourse(courseId);

        int totalLessons =0;
        int completedLessons = 0;

        for (int i = 0; i<sections.size(); i++) {
            Section section = sections.get(i);
            List<Lesson> lessons = lessonService.getLessonsBySection(section.getId());

            for (int j = 0; j<lessons.size(); j++) {
                Lesson lesson = lessons.get(j);
                totalLessons = totalLessons +1;

                Optional<Progress> progress = progressRepository.findByUserIdandLessonId(userId, lesson.getId());
                if (progress.isPresent() && progress.get().isCompleted()) {
                    completedLessons = completedLessons + 1;
                }
            }
        }

        if (totalLessons == 0) return 0;

        return (completedLessons * 100) / totalLessons;
    }
}
