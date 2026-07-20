package com.viva.academy.auth.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="ROLES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleEntity {

    @Id
    @Column(name = "ROLE_ID", nullable = false)
    private String roleId;

    @Column(name="ROLE_NAME", nullable = false)
    private String roleName;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
}
