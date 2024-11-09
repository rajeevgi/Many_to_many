package com.sprk.many_to_many.mapper;

import java.util.ArrayList;
import java.util.List;

import com.sprk.many_to_many.dto.CourseDto;
import com.sprk.many_to_many.dto.StudentDto;
import com.sprk.many_to_many.dto.StudentWithCourseDto;
import com.sprk.many_to_many.entity.Course;
import com.sprk.many_to_many.entity.Student;

public class StudentMapper {

    // Convert studentDto to student object
    public static Student mappedStudentDto(StudentDto studentDto, Student student){

        student.setRollNo(studentDto.getRollNo());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setPhone(studentDto.getPhone());

        return student;
    }

    // Convert student to studentDto object
    public static StudentDto mappedStudent(Student student, StudentDto studentDto){

        studentDto.setRollNo(student.getRollNo());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setPhone(student.getPhone());

        return studentDto;
    }

    // Conversion of Student to StudentWithCourseDto object
    public static StudentWithCourseDto mappedStudentToStudentWithCourseDto(Student student, StudentWithCourseDto studentWithCourseDto){

        studentWithCourseDto.setFirstName(student.getFirstName());
        studentWithCourseDto.setLastName(student.getLastName());
        studentWithCourseDto.setPhone(student.getPhone());
        studentWithCourseDto.setRollNo(student.getRollNo());

        List<Course> courses = student.getCourses();
        List<CourseDto> courseDtos = new ArrayList<>();

        for(Course course : courses){
            CourseDto courseDto = CourseMapper.mappedCourse(course, new CourseDto());
            courseDtos.add(courseDto);
        }

        studentWithCourseDto.setCourses(courseDtos);
        return studentWithCourseDto;
    }
}
