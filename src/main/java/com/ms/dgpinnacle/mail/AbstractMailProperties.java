package com.ms.dgpinnacle.mail;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public abstract class AbstractMailProperties {

	private String url;
	private String subject;
    private String subheading;
    private String subtitle;
    private String text;

}