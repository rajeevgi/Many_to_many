package com.sprk.many_to_many.dto;

import java.util.List;

import lombok.Data;

@Data
public class StudentWithCourseDto {

    private int rollNo;

    private String firstName;

    private String lastName;

    private String phone;

    private List<CourseDto> courses;
}
