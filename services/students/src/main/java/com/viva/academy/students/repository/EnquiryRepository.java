package com.viva.academy.students.repository;

import com.viva.academy.students.model.EnquiryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryRepository extends JpaRepository<EnquiryEntity, Long> {
}
