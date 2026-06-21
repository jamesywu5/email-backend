package com.jameswu.email_backend.dto;
import java.time.Instant;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.UUID;

public record MailboxMailDto(
    @NotBlank 
    @UUID(version = 4)
    String id,

    @Valid Contact from,
    @Valid Contact to,
    String subject,
    Instant sent,
    Instant received
) {}
