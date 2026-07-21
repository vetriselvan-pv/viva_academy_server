package com.viva.academy.students.repository;

import com.viva.academy.students.model.StudentFeePlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentFeePlanRepository extends JpaRepository<StudentFeePlanEntity, String> {
    List<StudentFeePlanEntity> findByStudentId(String studentId);
}
