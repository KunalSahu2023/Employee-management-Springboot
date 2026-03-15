package com.indiabulls.employeemangementspringboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "staff")
@RequiredArgsConstructor
@Setter
@Getter
public class Staff {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true, nullable=false)
    private String username;

    @Column(nullable=false)
    private String password;

    @Column(unique=true)
    private String email;

    private String role; // ADMIN, HR, MANAGER

    private String status; // ACTIVE, DISABLED

    private Timestamp createdAt;

    private Timestamp updatedAt;

    @PrePersist
    public void prePersist(){
        createdAt = Timestamp.valueOf(LocalDateTime.now());
        updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }
}
