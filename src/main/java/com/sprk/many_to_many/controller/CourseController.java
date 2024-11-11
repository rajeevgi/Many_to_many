package com.sprk.many_to_many.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprk.many_to_many.dto.CourseDto;
import com.sprk.many_to_many.service.CourseService;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/saveCourse")
    public CourseDto saveCourse(@RequestBody CourseDto courseDto){
        return courseService.saveCourse(courseDto);
    }

    @GetMapping("/getCourseById/{courseId}")
    public CourseDto getCourseById(@PathVariable int courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("/getAllCourses")
    public List<CourseDto> getAllCourses(){
        return courseService.getAllCourses();
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public String deleteCourse(@PathVariable int courseId){
        return courseService.deleteCourseById(courseId);
    }

    @PutMapping("/updateCourse/{courseId}")
    public String updateStudent(@PathVariable int courseId){
        return courseService.updateCourseById(courseId);
    }

}
