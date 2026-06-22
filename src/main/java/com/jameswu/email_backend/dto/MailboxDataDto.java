package com.jameswu.email_backend.dto;

import java.util.UUID;

public record MailboxDataDto(
    UUID id,
    String name
) {}