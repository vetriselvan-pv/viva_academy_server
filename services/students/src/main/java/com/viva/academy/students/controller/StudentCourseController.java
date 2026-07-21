package com.viva.academy.students.controller;

import com.viva.academy.common.dto.response.ApiResponse;
import com.viva.academy.students.dto.request.StudentCourseRequestDto;
import com.viva.academy.students.dto.response.StudentCourseResponseDto;
import com.viva.academy.students.model.StudentCourseId;
import com.viva.academy.students.service.StudentCourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students/courses")
@RequiredArgsConstructor
public class StudentCourseController {

    private final StudentCourseService studentCourseService;

    @PostMapping
    public ResponseEntity<ApiResponse<StudentCourseResponseDto>> createStudentCourse(@Valid @RequestBody StudentCourseRequestDto requestDto) {
        StudentCourseResponseDto response = studentCourseService.createStudentCourse(requestDto);
        return new ResponseEntity<>(ApiResponse.success(response, "Student course created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<ApiResponse<List<StudentCourseResponseDto>>> getStudentCourses(@PathVariable String studentId) {
        List<StudentCourseResponseDto> response = studentCourseService.getStudentCourses(studentId);
        return ResponseEntity.ok(ApiResponse.success(response, "Student courses fetched successfully"));
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<Void>> deleteStudentCourse(@RequestBody StudentCourseId id) {
        studentCourseService.deleteStudentCourse(id);
        return ResponseEntity.ok(ApiResponse.success(null, "Student course deleted successfully"));
    }
}
