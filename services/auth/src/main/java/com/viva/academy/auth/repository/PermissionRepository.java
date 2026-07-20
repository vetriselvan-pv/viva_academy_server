package com.viva.academy.auth.repository;

import com.viva.academy.auth.model.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity,String> {

    @Query("SELECT COALESCE(MAX(P.PERMISSION_ID),0) FROM PERMISSION P")
    Long getPermissionId();
}
