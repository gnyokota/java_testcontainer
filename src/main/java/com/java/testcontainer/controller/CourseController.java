package com.java.testcontainer.controller;

import com.java.testcontainer.entity.Course;
import com.java.testcontainer.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CourseController {

    CourseRepository courseRepository;

    @GetMapping("/courses")
    ResponseEntity<List<Course>> getAllCourses(){
        return ResponseEntity.ok(courseRepository.findAll());
    }

    @PostMapping("/course")
    ResponseEntity<Course> createCourse(@RequestBody Course course){
        return ResponseEntity.ok(courseRepository.save(course));
    }
}
