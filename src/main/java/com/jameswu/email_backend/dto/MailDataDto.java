package com.jameswu.email_backend.dto;

import java.time.Instant;

import jakarta.validation.Valid;

public record MailDataDto (
    @Valid Contact from,
    @Valid Contact to,
    String subject,
    Instant sent,
    Instant received,
    String content
) {}
