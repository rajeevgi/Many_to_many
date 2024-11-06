package com.sprk.many_to_many.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprk.many_to_many.dto.StudentDto;
import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.mapper.StudentMapper;
import com.sprk.many_to_many.repository.StudentRepository;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    /* Mappings for student */

    @PostMapping("/save")
    public StudentDto saveStudent(@RequestBody StudentDto studentDto){

        Student student = StudentMapper.mappedStudentDto(studentDto, new Student());

        studentRepository.save(student);

        studentDto.setRollNo(student.getRollNo());

        return studentDto;
    }

    @GetMapping("/getStudent/{rollNo}")
    public StudentDto getStudentByRollNo(@PathVariable int rollNo){

        Student student = studentRepository.findById(rollNo).orElseThrow(() -> new RuntimeException("Student not found.."));

        StudentDto studentDto = StudentMapper.mappedStudent(student, new StudentDto());

        return studentDto;
        
    }

    @GetMapping("/getAllStudents")
    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();

        for(Student student : students){
            StudentDto studentDto = StudentMapper.mappedStudent(student, new StudentDto());
            studentDtos.add(studentDto);
        }
        return studentDtos;
    }

}
