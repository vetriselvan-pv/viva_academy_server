package com.viva.academy.admin.repository;

import com.viva.academy.admin.model.BatchesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends JpaRepository<BatchesEntity, Long> {
}
