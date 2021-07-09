package com.example.demo.Controller;

import com.example.demo.Domain.Lesson;
import com.example.demo.Repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class LessonController {

    @Autowired
    private  LessonRepository lessonRepository;


    // Constructor injection is implemented in order for the
    //     controller to have methods to access Db
    public LessonController(LessonRepository lessonRepository) {
        this.lessonRepository=lessonRepository;
    }

    @PostMapping("/lessons")
    public Lesson create (@RequestBody Lesson lesson) {

        this.lessonRepository.save(lesson);
        return lesson;
    }

    @GetMapping("/lessons/5")
    public Optional<Lesson> getLessonById(@PathVariable Long id) {

        return this.lessonRepository.findById(id);
    }

    @DeleteMapping("/lessons/5")
    public Optional<Lesson> deleteLessonById(@PathVariable Long id) {

        this.lessonRepository.deleteById(id);
        return this.lessonRepository.findById(id);
    }

    @GetMapping("/lessons")
    public List<Lesson> getAllLessons() {

    return this.lessonRepository.findAll();

    }

    @PutMapping("/lessons/{id}")
    public Lesson updateLessonById(@PathVariable Long id , @RequestBody Lesson lesson) {
        Lesson newLesson = this.lessonRepository.findById(id).get();
        newLesson.setId(lesson.getId());
        newLesson.setTitle(lesson.getTitle());
        return this.lessonRepository.save(newLesson);
    }
}



