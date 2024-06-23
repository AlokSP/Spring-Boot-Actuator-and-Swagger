package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "CRUD REST APIs for Student Resource", description = "CRUD REST APIs - Create Student, Update Student, Get Student, Get All Students, Delete Student")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Create Student REST API", description = "Create Student REST API is used to save user in a database")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    @PostMapping
    public ResponseEntity<StudentDto> createstudent(@Valid @RequestBody StudentDto studentDto) {
        StudentDto createdStudentDto = studentService.createStudent(studentDto);
        return new ResponseEntity<StudentDto>(createdStudentDto, HttpStatus.CREATED);
    }

    @Operation(summary = "Get All students in REST API", description = "Get Students By findAll API is used to get students from the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @GetMapping
    public ResponseEntity<List<StudentDto>> findAllStudents() {
        List<StudentDto> studentDtoes = studentService.findAllStudents();
        return new ResponseEntity<List<StudentDto>>(studentDtoes, HttpStatus.OK);
    }

    @Operation(summary = "Get Student By ID REST API", description = "Get Student By ID REST API is used to get a single student from the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> findStudentByRollNo(@PathVariable("id") int rollNo) {
        StudentDto studentDto = studentService.findByRollNo(rollNo);
        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
    }

    @Operation(summary = "Update Student REST API", description = "Update Student REST API is used to update a particular student in the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")

    @PutMapping("/{rollNo}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable int rollNo,
            @Valid @RequestBody StudentDto studentDto) {
        StudentDto updatedStudentDto = studentService.updateSudent(rollNo, studentDto);
        return new ResponseEntity<StudentDto>(updatedStudentDto, HttpStatus.OK);
    }

    @Operation(summary = "Delete Student REST API", description = "Delete Student REST API is used to delete a particular student in the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @DeleteMapping("/{rollNo}")
    public ResponseEntity<String> deleteStudent(@PathVariable int rollNo) {
        String message = studentService.deleteStudent(rollNo);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

}
