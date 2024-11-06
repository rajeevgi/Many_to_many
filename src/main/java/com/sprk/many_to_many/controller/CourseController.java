package com.sprk.many_to_many.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.sprk.many_to_many.repository.CourseRepository;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

     /* Mappings for course */

    @PostMapping("/saveCourse")
    public CourseDto saveCourse(@RequestBody CourseDto courseDto){
        Course course = CourseMapper.mappedCourseDto(courseDto, new Course());

        courseRepository.save(course);
        courseDto.setCourseId(course.getCourseId());

        return courseDto;
    }

    @GetMapping("/getCourseById/{courseId}")
    public CourseDto getCourseById(@PathVariable int courseId){
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

        CourseDto courseDto = CourseMapper.mappedCourse(course, new CourseDto());

        return courseDto;
    }

    @GetMapping("/getAllCourses")
    public List<CourseDto> getAllCourses(){

        List<Course> courses = courseRepository.findAll();
        List<CourseDto> courseDtos = new ArrayList<>();

        for(Course course : courses){
            CourseDto courseDto = CourseMapper.mappedCourse(course, new CourseDto());
            courseDtos.add(courseDto);
        }
        return courseDtos;
    }
}
