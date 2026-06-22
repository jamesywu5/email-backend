package com.jameswu.email_backend.service;

import org.springframework.stereotype.Service;
import com.jameswu.email_backend.repository.MailRepository;
import com.jameswu.email_backend.repository.MailboxRepository;
import com.jameswu.email_backend.dto.MailboxDataDto;
import com.jameswu.email_backend.dto.MailboxMailDto;
import com.jameswu.email_backend.dto.MailboxResponseDto;
import com.jameswu.email_backend.dto.MailDataDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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

    public MailboxResponseDto getMailFromMailbox(UUID mailboxId) {
        String mailboxname = mailboxRepository.findNameById(mailboxId).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mailbox not found"));
        return new MailboxResponseDto(mailboxname, 
            mailRepository.findByMailboxId(mailboxId).stream()
                .map(mail -> {
                    final MailDataDto data = mail.getData();
                    return new MailboxMailDto(
                            mail.getId(),
                            data.from(),
                            data.to(),
                            data.subject(),
                            data.sent(),
                            data.received()
                    );
                }).toList()
        );
    }

    public List<MailboxResponseDto> getAllMail() {
        List<MailboxDataDto> mailboxes = getAllMailboxes();
        return mailboxes.stream()
                .map(mailbox -> getMailFromMailbox(mailbox.id()))
                .toList();
    }

    public UUID getMailboxIdByName(String mailboxName) {
        return mailboxRepository.findIdByName(mailboxName)
                .orElseThrow(
                    () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Mailbox not found"));
    }
}