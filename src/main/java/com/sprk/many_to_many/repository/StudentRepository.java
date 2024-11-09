package com.sprk.many_to_many.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sprk.many_to_many.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

    // Custom Query to fetch a student and their associated courses
    @Query("FROM Student s JOIN FETCH s.courses WHERE s.rollNo = :rollNo")
    Optional<Student> findStudentWithCourses(int rollNo);
}
