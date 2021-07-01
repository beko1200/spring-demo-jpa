package com.example.demo.Controller;

import com.example.demo.Domain.Lesson;
import com.example.demo.Repository.LessonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LessonController {


    private final LessonRepository lessonRepository;

    public LessonController(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

//    HashMap<Long,String> lessons = new HashMap<>(){{
//       put((long) 5.00, "JPA");
//    }};


    @GetMapping("/lessons/5")
    public Lesson create (@RequestBody Lesson lesson) {
        return this.lessonRepository.save(lesson);
    }
}
