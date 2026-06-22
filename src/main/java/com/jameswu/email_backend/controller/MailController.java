package com.jameswu.email_backend.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jameswu.email_backend.dto.MailboxResponseDto;
// import com.jameswu.email_backend.dto.MailboxMailDto;


@RestController
@RequestMapping("mail")
public class MailController {

    @GetMapping
    public MailboxResponseDto getAll() {
        ;
    }

}