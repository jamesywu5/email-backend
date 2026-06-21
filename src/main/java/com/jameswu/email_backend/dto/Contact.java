package com.jameswu.email_backend.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record Contact(
    @NotBlank
    String name,
    
    @NotBlank
    @Email
    String email
) {}