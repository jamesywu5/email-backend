package com.jameswu.email_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.jameswu.email_backend.dto.MailDataDto;

@Entity
@Table(name = "mail")
public class Mail {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private UUID mailbox;

    @Column(columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private MailDataDto data;

    public UUID getId() {
        return id;
    }

    public UUID getMailboxId() {
        return mailbox;
    }

    public MailDataDto getData() {
        return data;
    }
}
