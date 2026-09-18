package com.juwe.lms.controller;

import com.juwe.lms.entity.Section;
import com.juwe.lms.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @PostMapping
    public Section createSection(@RequestBody Section section) {
        return sectionService.createSection(section);
    }

    @GetMapping("/{id}")
    public Section getSectionById(@PathVariable Long id) {
        return sectionService.getSectionById(id);
    }

    @GetMapping("/course/{courseId}")
    public List<Section> getSectionsByCourse(@PathVariable Long courseId) {
        return sectionService.getSectionsByCourse(courseId);
    }

    @PutMapping("/{id}")
    public Section updateSection(@PathVariable Long id, @RequestBody Section updatedSection) {
        return sectionService.updateSection(id, updatedSection);
    }

    @DeleteMapping("/{id}")
    public void softDeleteSection(@PathVariable Long id) {
        sectionService.deleteSectionSoftly(id);
    }
}