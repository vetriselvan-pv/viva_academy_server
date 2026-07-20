package com.viva.academy.admin.service;

import com.viva.academy.admin.dto.request.BatchRequestDto;
import com.viva.academy.admin.dto.response.BatchResponseDto;
import com.viva.academy.admin.model.BatchesEntity;
import com.viva.academy.admin.model.BranchEntity;
import com.viva.academy.admin.model.CoursesEntity;
import com.viva.academy.admin.repository.BatchRepository;
import com.viva.academy.admin.repository.BranchRepository;
import com.viva.academy.admin.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BatchService {
    private final BatchRepository batchRepository;
    private final CourseRepository courseRepository;
    private final BranchRepository branchRepository;

    public BatchResponseDto saveBatch(BatchRequestDto request) {
        CoursesEntity course = courseRepository.findById(request.courseId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + request.courseId()));
        
        BranchEntity branch = branchRepository.findById(request.branchId())
                .orElseThrow(() -> new RuntimeException("Branch not found with id: " + request.branchId()));

        BatchesEntity entity = BatchesEntity.builder()
                .course(course)
                .branch(branch)
                .batchName(request.batchName())
                .startDate(request.startDate())
                .endDate(request.endDate())
                .capacity(request.capacity())
                .build();

        BatchesEntity saved = batchRepository.save(entity);
        return mapToResponse(saved);
    }

    public List<BatchResponseDto> fetchAllBatches() {
        return batchRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public BatchResponseDto fetchBatchById(Long id) {
        BatchesEntity entity = batchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Batch not found with id: " + id));
        return mapToResponse(entity);
    }

    private BatchResponseDto mapToResponse(BatchesEntity entity) {
        return new BatchResponseDto(
                entity.getBatchId(),
                entity.getCourse().getCourseId(),
                entity.getBranch().getBranchId(),
                entity.getBatchName(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getCapacity()
        );
    }
}
