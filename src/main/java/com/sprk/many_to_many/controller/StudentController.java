package com.sprk.many_to_many.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprk.many_to_many.dto.StudentDto;
import com.sprk.many_to_many.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudent")
    public StudentDto saveStudent(@RequestBody StudentDto studentDto){
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("/getStudent/{rollNo}")
    public StudentDto getStudentByRollNo(@PathVariable int rollNo){
        return studentService.getStudentByRollNo(rollNo);
    }

    @GetMapping("/getAllStudents")
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @DeleteMapping("/deleteStudent/{rollNo}")
    public String deleteStudentByRollNo(@PathVariable int rollNo){
        return studentService.deleteStudentByRollNo(rollNo);
    }
    
    @PutMapping("/updateStudent/{rollNo}")
    public String updateStudentByRollNo(@PathVariable int rollNo){
        return studentService.updateStudentByRollNo(rollNo);
    }
}
