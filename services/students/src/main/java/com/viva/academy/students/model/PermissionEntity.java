package com.viva.academy.students.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "PERMISSION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PermissionEntity {

    @Id
    @Column(name = "PERMISSION_ID")
    private String permissionId;

    @Column(name="PERMISSION_NAME")
    private String permissionName;

    @Column(name = "MODULE")
    private String module;
}
