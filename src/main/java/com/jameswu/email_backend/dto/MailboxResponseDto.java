package com.jameswu.email_backend.dto;
import java.util.List;

public record MailboxResponseDto(
    String id,
    List<MailboxMailDto> mail
) {}
