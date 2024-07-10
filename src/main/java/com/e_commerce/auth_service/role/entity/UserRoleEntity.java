package com.e_commerce.auth_service.role.entity;

import com.e_commerce.auth_service.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "roles")
@EntityListeners(AuditingEntityListener.class)
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

    public UserRoleEntity(String name, List<UserEntity> users,
                          LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
        this.name = name;
        this.users = users;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }
}
