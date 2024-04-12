package com.ms.dgpinnacle.mail;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Component
@ConfigurationProperties("dgpinnacle.mail.letter")
public class MailLetterProperties extends AbstractMailProperties {
	
}
