package com.jameswu.email_backend.dto;

import java.time.Instant;

import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record MailDto (
    @NotBlank 
    UUID id,

    @Valid Contact from,
    @Valid Contact to,
    String subject,
    Instant sent,
    Instant received,
    String content
) {}
