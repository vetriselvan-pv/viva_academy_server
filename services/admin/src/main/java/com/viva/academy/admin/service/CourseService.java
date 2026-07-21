package com.viva.academy.admin.service;


import com.viva.academy.admin.dto.request.CourseRequestDto;
import com.viva.academy.admin.dto.response.CourseResponseDto;
import com.viva.academy.admin.model.CoursesEntity;
import com.viva.academy.admin.repository.CourseRepository;
import com.viva.academy.common.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;

    @Transactional
    public CourseResponseDto saveCourse(CourseRequestDto request){
        CoursesEntity entity = CoursesEntity.builder().courseName(request.courseName())
                .feeAmount(request.feeAmount()).duration(request.duration()).build();
        CoursesEntity savedCourseEntity = courseRepository.save(entity);
        return transformToResponse(savedCourseEntity);
    }

    @Transactional(readOnly = true)
    public List<CourseResponseDto> fetchAllCourse(){
        List<CoursesEntity> entity = courseRepository.findAll();
        return entity.stream().map(this::transformToResponse).toList();
    }

    @Transactional(readOnly = true)
    public CourseResponseDto fetchCourseById(Long id){
        return courseRepository.findById(id).map(this::transformToResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + id));
    }


    public CourseResponseDto transformToResponse(CoursesEntity course){
        return new CourseResponseDto(course.getCourseId(),course.getCourseName(),
                course.getFeeAmount(), course.getDuration(), course.getStatus());

    }

}
