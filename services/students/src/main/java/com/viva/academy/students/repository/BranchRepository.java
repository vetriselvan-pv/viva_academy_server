package com.viva.academy.students.repository;

import com.viva.academy.students.model.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity,Long> {

    @Query("SELECT COALESCE(MAX(B.BRANCH_CODE),0) FROM BRANCHES B")
    Long getBranchCode();
}
