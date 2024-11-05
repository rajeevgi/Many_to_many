package com.sprk.many_to_many.mapper;

import com.sprk.many_to_many.dto.CourseDto;
import com.sprk.many_to_many.entity.Course;

public class CourseMapper {

    // Conversion of courseDto to course object
    public static Course mappedCourseDto(CourseDto courseDto, Course course){

        course.setCourseId(courseDto.getCourseId());
        course.setCourseName(courseDto.getCourseName());
        course.setDescription(courseDto.getDescription());
        course.setDuration(courseDto.getDuration());

        return course;
    }

    // Conversion of course to courseDto object
    public static CourseDto mappedCourse(Course course, CourseDto courseDto){

        courseDto.setCourseId(course.getCourseId());
        courseDto.setCourseName(course.getCourseName());
        courseDto.setDescription(course.getDescription());
        courseDto.setDuration(course.getDuration());

        return courseDto;
    }
}
