package com.jameswu.email_backend.dto;
import java.time.Instant;

public record MailboxMailDto(
    String id,
    Contact from,
    Contact to,
    String subject,
    Instant sent,
    Instant received
) {}
