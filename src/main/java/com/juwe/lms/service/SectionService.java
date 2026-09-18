package com.juwe.lms.service;

import com.juwe.lms.entity.Lesson;
import com.juwe.lms.entity.Section;
import com.juwe.lms.repository.SectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionService {

    private SectionRepository sectionRepository;


    private LessonService lessonService;

    public Section createSection(Section section) {
        return sectionRepository.save(section);
    }

    public Section getSectionById(Long id) {
        Optional<Section> section = sectionRepository.findById(id);
        if (section.isPresent()) {
            return section.get();
        }
        return null;
    }


    public List<Section> getSectionsByCourse(Long courseId) {
        List<Section> sectionList = sectionRepository.findByCourseIdAndIsDeletedFalse(courseId);
        return sectionList;
    }

    public Section updateSection(Long id, Section updatedSection) {
        Section existing = getSectionById(id);
        existing.setTitle(updatedSection.getTitle());
        return sectionRepository.save(existing);
    }

    public Boolean deleteSectionSoftly(Long id) {
        Optional<Section> existingSection = SectionRepository.findByIdAndDeletedIsFalse(id);

        if (existingSection.isEmpty()) {
            return false;
        }

        Section sectionToDelete = existingSection.get();
        sectionToDelete.setDeleted(true);
        sectionRepository.save(sectionToDelete);

        List<Lesson> lessons = lessonService.getLessonsBySection(id);
        for (int i = 0; i < lessons.size(); i++) {
            Lesson lesson = lessons.get(i);
            lessonService.deleteLessonSoftly(lesson.getId());
        }

        return true;
    }
}
