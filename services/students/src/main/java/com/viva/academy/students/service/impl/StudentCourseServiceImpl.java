package com.viva.academy.students.service.impl;

import com.viva.academy.common.exception.ResourceNotFoundException;
import com.viva.academy.students.dto.request.StudentCourseRequestDto;
import com.viva.academy.students.dto.response.StudentCourseResponseDto;
import com.viva.academy.students.model.StudentCourseEntity;
import com.viva.academy.students.model.StudentCourseId;
import com.viva.academy.students.repository.StudentCourseRepository;
import com.viva.academy.students.service.StudentCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentCourseServiceImpl implements StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;

    @Override
    public StudentCourseResponseDto createStudentCourse(StudentCourseRequestDto requestDto) {
        StudentCourseEntity entity = StudentCourseEntity.builder()
                .studentId(requestDto.getStudentId())
                .branchId(requestDto.getBranchId())
                .courseId(requestDto.getCourseId())
                .batchId(requestDto.getBatchId())
                .admissionDate(requestDto.getAdmissionDate())
                .remarks(requestDto.getRemarks())
                .build();
        StudentCourseEntity saved = studentCourseRepository.save(entity);
        return mapToResponse(saved);
    }

    @Override
    public List<StudentCourseResponseDto> getStudentCourses(String studentId) {
        return studentCourseRepository.findByStudentId(studentId).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStudentCourse(StudentCourseId id) {
        if (!studentCourseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Student course mapping not found");
        }
        studentCourseRepository.deleteById(id);
    }

    private StudentCourseResponseDto mapToResponse(StudentCourseEntity entity) {
        return StudentCourseResponseDto.builder()
                .studentId(entity.getStudentId())
                .branchId(entity.getBranchId())
                .courseId(entity.getCourseId())
                .batchId(entity.getBatchId())
                .admissionDate(entity.getAdmissionDate())
                .remarks(entity.getRemarks())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
