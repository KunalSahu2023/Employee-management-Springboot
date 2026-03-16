package com.indiabulls.employeemangementspringboot.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

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

    private String status;

    @JsonManagedReference
    @OneToMany(mappedBy="staff",
            cascade=CascadeType.ALL,
            fetch=FetchType.LAZY)
    private List<Employee> employees;

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
