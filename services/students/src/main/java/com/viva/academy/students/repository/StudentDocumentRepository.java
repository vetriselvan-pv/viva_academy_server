package com.viva.academy.students.repository;

import com.viva.academy.students.model.StudentDocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDocumentRepository extends JpaRepository<StudentDocumentEntity, Long> {
    List<StudentDocumentEntity> findByStudentId(String studentId);
}
