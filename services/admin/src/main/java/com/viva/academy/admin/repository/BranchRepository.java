package com.viva.academy.admin.repository;

import com.viva.academy.admin.model.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity,String> {

    @Query("SELECT COALESCE(MAX(B.BRANCH_ID),0) FROM BRANCHES B")
    Long getBranchCode();
}
