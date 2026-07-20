package com.viva.academy.admin.controller;

import com.viva.academy.admin.dto.request.CourseRequestDto;
import com.viva.academy.admin.dto.response.CourseResponseDto;
import com.viva.academy.admin.service.CourseService;
import jakarta.validation.Valid;
import jakarta.ws.rs.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseResponseDto> saveCourse(@Valid @RequestBody CourseRequestDto request){
        CourseResponseDto response = courseService.saveCourse(request);
        URI location = URI.create("/v1/courses/" + response.courseId());
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDto>> fetchCourse(){
        List<CourseResponseDto> response = courseService.fetchAllCourse();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponseDto> fetchCourseById(@RequestParam Long id){
        CourseResponseDto response = courseService.fetchCourseById(id);
        return ResponseEntity.ok(response);
    }
    
}
