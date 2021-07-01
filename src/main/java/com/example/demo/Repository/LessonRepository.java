package com.example.demo.Repository;

import com.example.demo.Domain.Lesson;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Long> {

    List<Lesson> findByName(String title);

}
