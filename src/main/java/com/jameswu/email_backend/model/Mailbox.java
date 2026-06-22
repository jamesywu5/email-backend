package com.jameswu.email_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.jameswu.email_backend.dto.MailboxDataDto;

@Entity
@Table(name = "mailbox")
public class Mailbox {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(columnDefinition = "jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    private MailboxDataDto data;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return data.name();
    }
}
