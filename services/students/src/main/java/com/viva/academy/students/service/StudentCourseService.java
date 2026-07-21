package com.viva.academy.students.service;

import com.viva.academy.students.dto.request.StudentCourseRequestDto;
import com.viva.academy.students.dto.response.StudentCourseResponseDto;
import com.viva.academy.students.model.StudentCourseId;

import java.util.List;

public interface StudentCourseService {
    StudentCourseResponseDto createStudentCourse(StudentCourseRequestDto requestDto);
    List<StudentCourseResponseDto> getStudentCourses(String studentId);
    void deleteStudentCourse(StudentCourseId id);
}
