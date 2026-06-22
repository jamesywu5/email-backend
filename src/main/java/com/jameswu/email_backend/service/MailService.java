package com.jameswu.email_backend.service;

import org.springframework.stereotype.Service;
import com.jameswu.email_backend.repository.MailRepository;
import com.jameswu.email_backend.repository.MailboxRepository;
import com.jameswu.email_backend.dto.MailboxDataDto;
import com.jameswu.email_backend.dto.MailboxResponseDto;

import java.util.List;
import java.util.UUID;

@Service
public class MailService {
    private final MailRepository mailRepository;
    private final MailboxRepository mailboxRepository;

    public MailService(MailRepository mailRepository, MailboxRepository mailboxRepository) {
        this.mailRepository = mailRepository;
        this.mailboxRepository = mailboxRepository;
    }

    public List<MailboxDataDto> getAllMailboxes() {
        return mailboxRepository.findAll().stream()
                .map(mailbox -> new MailboxDataDto(mailbox.getId(), mailbox.getName()))
                .toList();
    }

    public List<MailboxResponseDto> getMailFromMailbox(UUID mailboxId) {
        return mailRepository.findByMailboxId(mailboxId).stream()
                .map(mail -> new MailboxResponseDto(
                    mail.getId(), 
                    mail.getFrom(), 
                    mail.getTo(), 
                    mail.getSubject(), 
                    mail.getBody(), 
                    mail.getTimestamp()))
                .toList();
    }
}