package com.sprk.many_to_many.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprk.many_to_many.dto.CourseDto;
import com.sprk.many_to_many.entity.Course;
import com.sprk.many_to_many.mapper.CourseMapper;
import com.sprk.many_to_many.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Post Mapping to save courses.
    public CourseDto saveCourse(CourseDto courseDto) {
        Course course = CourseMapper.mappedCourseDto(courseDto, new Course());
        courseRepository.save(course);
        courseDto.setCourseId(course.getCourseId());
        return courseDto;
    }

    // Get mapping to get course detail by id.
    public CourseDto getCourseById(int courseId) {
        
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course Not Found."));

        return CourseMapper.mappedCourse(course, new CourseDto());
    }

    // Get mapping to list all the courses.
    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDto> courseDtos = new ArrayList<>();

        for(Course course : courses){
            courseDtos.add(CourseMapper.mappedCourse(course, new CourseDto()));
        }

        return courseDtos;
    }

    // Delete mapping to remove courses by id.
    public String deleteCourseById(int courseId) {
        
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found."));

        courseRepository.delete(course);

        return "Course Deleted Successfully...";
    }

    public String updateCourseById(int courseId) {
        
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

        CourseDto courseDto = CourseMapper.mappedCourse(course, new CourseDto());

        courseDto.setCourseName(course.getCourseName());
        courseDto.setDescription(course.getDescription());
        courseDto.setDuration(course.getDuration());

        courseRepository.save(course);

        return "Course Updated Successfully...";
    }

}
