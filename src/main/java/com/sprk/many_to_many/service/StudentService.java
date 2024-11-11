package com.sprk.many_to_many.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprk.many_to_many.dto.StudentDto;
import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.mapper.StudentMapper;
import com.sprk.many_to_many.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Post mapping to save student
    public StudentDto saveStudent(StudentDto studentDto) {
        
        Student student = StudentMapper.mappedStudentDto(studentDto, new Student());

        studentRepository.save(student);

        studentDto.setRollNo(student.getRollNo());

        return studentDto;
        
    }

    // Get mapping to get student data by rollNo
    public StudentDto getStudentByRollNo(int rollNo) {
        
        Student student = studentRepository.findById(rollNo).orElseThrow(() -> new RuntimeException("Student not found."));

        return StudentMapper.mappedStudent(student, new StudentDto());
        
    }

    // Get mapping to List all the student data
    public List<StudentDto> getAllStudents() {
        
        List<Student> students = studentRepository.findAll();

        List<StudentDto> studentDtos = new ArrayList<>();

        for(Student student : students){
            StudentDto studentDto = StudentMapper.mappedStudent(student, new StudentDto());
            studentDtos.add(studentDto);
        }

        return studentDtos;
    }

    // Delete mapping to delete student data by Id.
    public String deleteStudentByRollNo(int rollNo) {
        
        Student student = studentRepository.findById(rollNo).orElseThrow(() -> new RuntimeException("Student not found."));

        studentRepository.delete(student);

        return "Student Deleted Successfully....";
    }

    // Put mapping to update student info.
    public String updateStudentByRollNo(int rollNo) {
        
        Student student = studentRepository.findById(rollNo).orElseThrow(() -> new RuntimeException("Student not found."));

        StudentDto studentDto = StudentMapper.mappedStudent(student, new StudentDto());

        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setPhone(student.getPhone());

        studentRepository.save(student);

        return "Student updated Successfully...";
    }


}
