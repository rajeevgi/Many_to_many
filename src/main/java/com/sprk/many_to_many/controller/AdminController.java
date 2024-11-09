package com.sprk.many_to_many.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprk.many_to_many.dto.StudentWithCourseDto;
import com.sprk.many_to_many.entity.Course;
import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.mapper.StudentMapper;
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

        student.addCourses(course);

        studentRepository.save(student);

        return "Course added successfully.";
    }

    @GetMapping("/get-student-with-course/{rollNo}")
    public StudentWithCourseDto getStudentWithCourses(@PathVariable int rollNo){
        Student student = studentRepository.findStudentWithCourses(rollNo).orElseThrow(() -> new RuntimeException("Student not found"));
        StudentWithCourseDto studentWithCourseDto = StudentMapper.mappedStudentToStudentWithCourseDto(student, new StudentWithCourseDto());

        return studentWithCourseDto;
    }
}
