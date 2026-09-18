package com.juwe.lms.service;

import com.juwe.lms.entity.Lesson;
import com.juwe.lms.repository.LessonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    private LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Lesson createLesson(Lesson lesson) {
        Lesson newLesson = lessonRepository.save(lesson);
        return newLesson;
    }

    public Lesson getLesson(long id) {
        Optional<Lesson> lesson = lessonRepository.findById(id);

        if (lesson.isPresent()) {
            return lesson.get();
        }
        return null;
    }

    public List<Lesson> getAllLessons() {
        List<Lesson> lessonsList = lessonRepository.findAll();
        return lessonsList;
    }

    public Lesson updateLesson(Long id, Lesson lesson) {
        Optional<Lesson> existingLesson = lessonRepository.findById(id);

        if (existingLesson.isEmpty()) {
            return null;
        }
        Lesson updatedLesson = existingLesson.get();

        updatedLesson.setTitle(lesson.getTitle());
        updatedLesson.setContent(lesson.getContent());
        updatedLesson.setId(lesson.getId());
        updatedLesson.setSection(lesson.getSection());
        updatedLesson.setDeleted(lesson.isDeleted());

        return lessonRepository.save(updatedLesson);
    }

    public Boolean deleteLesson(Long id) {
        Boolean isLesson = lessonRepository.existsById(id);

        if(!isLesson) {
            return false;
        }
        lessonRepository.deleteById(id);
        return true;
    }

    public Boolean deleteLessonSoftly(Long id) {
        Optional<Lesson> existingLesson = lessonRepository.findByIdAndDeletedIsFalse(id);

        if (existingLesson.isEmpty()) {
            return false;
        }

        Lesson lessonToDelete = existingLesson.get();
        lessonToDelete.setDeleted(true);
        lessonRepository.save(lessonToDelete);
        return true;
    }

    public List<Lesson> getLessonsBySection(Long sectionId) {
        return lessonRepository.findBySectionIdAndIsDeletedFalse(sectionId);
    }
}
