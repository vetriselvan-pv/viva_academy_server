package com.viva.academy.admin.repository;

import com.viva.academy.admin.model.CoursesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CoursesEntity, Long> {
}
