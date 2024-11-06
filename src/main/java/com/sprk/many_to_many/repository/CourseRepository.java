package com.sprk.many_to_many.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprk.many_to_many.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
