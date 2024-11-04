package com.sprk.many_to_many.mapper;

import com.sprk.many_to_many.dto.StudentDto;
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
}
