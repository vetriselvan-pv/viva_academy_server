package com.viva.academy.students.repository;

import com.viva.academy.students.model.StudentCourseEntity;
import com.viva.academy.students.model.StudentCourseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourseEntity, StudentCourseId> {
    List<StudentCourseEntity> findByStudentId(String studentId);
}
