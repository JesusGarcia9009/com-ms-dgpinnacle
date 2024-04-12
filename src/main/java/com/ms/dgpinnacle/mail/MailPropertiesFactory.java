package com.ms.dgpinnacle.mail;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MailPropertiesFactory {

    private final MailLetterProperties mailLetterProperties;
    private final MailRealtorProperties railRealtorProperties;

    public AbstractMailProperties getMailProperties(String type) {
        if ("letter".equalsIgnoreCase(type)) {
            return mailLetterProperties;
        } else if ("realtor".equalsIgnoreCase(type)) {
            return railRealtorProperties;
        } else {
            throw new IllegalArgumentException("Invalid mail type: " + type);
        }
    }
}
