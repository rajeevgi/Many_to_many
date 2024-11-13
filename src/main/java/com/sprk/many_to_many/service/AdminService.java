package com.sprk.many_to_many.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprk.many_to_many.dto.StudentWithCourseDto;
import com.sprk.many_to_many.entity.Course;
import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.mapper.StudentMapper;
import com.sprk.many_to_many.repository.CourseRepository;
import com.sprk.many_to_many.repository.StudentRepository;

@Service
public class AdminService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Post Mapping to assign courses to student
    public String addCourseToStudent(int rollNo, int courseId) {
        
        Student student = studentRepository.findById(rollNo).orElseThrow(() -> new RuntimeException("Student not found."));

        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found."));

        student.addCourses(course);

        studentRepository.save(student);

        return "Course Added Successfully...";
    }

    // Get Mapping to get student with courses
    public StudentWithCourseDto getStudentWithCourses(int rollNo) {
        Student student = studentRepository.findById(rollNo).orElseThrow(() -> new RuntimeException("Student not found."));
        StudentWithCourseDto studentWithCourseDto = StudentMapper.mappedStudentToStudentWithCourseDto(student, new StudentWithCourseDto());

        return studentWithCourseDto;
    }


}
