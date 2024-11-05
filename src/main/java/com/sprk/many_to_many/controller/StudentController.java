package com.sprk.many_to_many.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprk.many_to_many.dto.CourseDto;
import com.sprk.many_to_many.dto.StudentDto;
import com.sprk.many_to_many.entity.Course;
import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.mapper.CourseMapper;
import com.sprk.many_to_many.mapper.StudentMapper;
import com.sprk.many_to_many.repository.StudentRepository;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    /* Mappings for student */

    @PostMapping("/save")
    public StudentDto saveStudent(@RequestBody StudentDto studentDto){

        Student student = StudentMapper.mappedStudentDto(studentDto, new Student());

        studentRepository.save(student);

        return studentDto;
    }

    @GetMapping("/getStudent/{rollNo}")
    public StudentDto getStudentByRollNo(@PathVariable int rollNo){

        Student student = studentRepository.findById(rollNo).orElseThrow(() -> new RuntimeException("Student not found.."));

        StudentDto studentDto = StudentMapper.mappedStudent(student, new StudentDto());

        return studentDto;
        
    }

    /* Mappings for course */

    @PostMapping("/saveCourse")
    public CourseDto saveCourse(@RequestBody CourseDto courseDto){
        Course course = CourseMapper.mappedCourseDto(courseDto, new Course());

        studentRepository.save(course);

        return courseDto;
    }

    @GetMapping("/getCourseById/{courseId}")
    public CourseDto getCourseById(@PathVariable int courseId){
        Course course = studentRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

        CourseDto courseDto = CourseMapper.mappedCourse(course, new CourseDto());

        return courseDto;
    }
}
