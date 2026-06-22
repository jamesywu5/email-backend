package com.jameswu.email_backend.repository;

import org.springframework.stereotype.Repository;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jameswu.email_backend.model.Mail;

@Repository
public interface MailRepository extends JpaRepository<Mail, UUID> {
    
}
