package com.viva.academy.auth.model;

import com.viva.academy.auth.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Entity
@Table(name="USERS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersEntity {

    @Id
    @Column(name="USER_ID", length = 15)
    private String userId;

    @Column(name = "BRANCH_ID", nullable = false)
    private Long branchId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID", nullable = false)
    private RoleEntity role;

    @Column(name = "NAME", nullable = false, length = 40)
    private String name;

    @Column(name = "EMAIL", nullable = false, columnDefinition = "CITEXT")
    private String email;

    @Column(name = "MOBILE", nullable = false, columnDefinition = "TEXT")
    private String mobile;

    @Column(name = "PASSWORD_HASH", nullable = false, length = 255)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    @Builder.Default
    private UserStatus status = UserStatus.ACTIVE;

    @Column(name = "LAST_LOGIN", nullable = false)
    private ZonedDateTime lastLogin;

    @CreationTimestamp
    @Column(name = "CREATED_AT")
    private ZonedDateTime createdAt;
}
