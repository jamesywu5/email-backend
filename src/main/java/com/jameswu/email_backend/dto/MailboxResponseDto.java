package com.jameswu.email_backend.dto;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.Valid;

public record MailboxResponseDto(
    @NotBlank String name,
    List<@Valid MailboxMailDto> mail
) {}
