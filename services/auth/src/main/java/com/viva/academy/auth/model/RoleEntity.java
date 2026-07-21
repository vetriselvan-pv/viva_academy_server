package com.viva.academy.auth.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;

@Entity
@Table(name = "ROLES")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntity {

    @Id
    @Column(name = "ROLE_ID", nullable = false)
    private String roleId;

    @Column(name = "ROLE_NAME", nullable = false)
    private String roleName;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @CreatedDate
    @Column(name = "CREATED_AT", updatable = false)
    private ZonedDateTime createdAt;

    @LastModifiedDate
    @Column(name = "UPDATED_AT")
    private ZonedDateTime updatedAt;

    @CreatedBy
    @Column(name = "CREATED_BY", updatable = false)
    private String createdBy;

    @LastModifiedBy
    @Column(name = "UPDATED_BY")
    private String updatedBy;
}
