package com.sprk.many_to_many.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprk.many_to_many.entity.Course;
import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.repository.CourseRepository;
import com.sprk.many_to_many.repository.StudentRepository;

@RestController
public class AdminController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/assign-course-to-student")
    public String addCourseToStudent(@RequestParam int rollNo, @RequestParam int courseId){
        Student student = studentRepository.findById(rollNo).orElseThrow(() -> new RuntimeException("Student not found."));

        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found."));

        List<Course> courses = student.getCourses();

        student.addCourses(course);

        studentRepository.save(student);

        return "Course added successfully.";
    }
}
