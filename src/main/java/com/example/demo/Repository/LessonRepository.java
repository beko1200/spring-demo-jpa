package com.example.demo.Repository;

import com.example.demo.Domain.Lesson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends CrudRepository<Lesson,Long> {

    Lesson findByName(String title);
    Optional<Lesson> findById(Long id);
    List<Lesson> findAll();


}
