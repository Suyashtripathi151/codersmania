package com.jestersClub.codersMania.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@DynamicUpdate // Ensures only changed fields are updated
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Password is required")
    @Length(min = 6, message = "Password must be at least 6 characters long")
    @Column(nullable = false)
    private String password;

    @Transient // This field will not be persisted in the database
    @NotBlank(message = "Confirm Password is required", groups = OnCreate.class) // Use custom validation group for creation
    private String confirmPassword;

    @NotBlank(message = "Phone number is required")
    @Length(min = 10, max = 10, message = "Phone number must be 10 digits")
    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private Boolean isVerified = false;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Define custom validation group for creation actions
    public interface OnCreate {}

    // Define custom validation group for update actions
    public interface OnUpdate {}
}
