package com.sprk.many_to_many.dto;

import lombok.Data;

@Data
public class CourseDto {

    private int courseId;

    private String courseName;

    private String description;

    private String duration;
}
