package com.viva.academy.students.repository;

import com.viva.academy.students.model.StudentFeeInstallmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentFeeInstallmentRepository extends JpaRepository<StudentFeeInstallmentEntity, String> {
    List<StudentFeeInstallmentEntity> findByPlanId(String planId);
}
