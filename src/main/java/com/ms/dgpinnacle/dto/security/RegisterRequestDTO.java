package com.ms.dgpinnacle.dto.security;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequestDTO {

	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String name;
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String lastName;
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String email;
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String cellphone;
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String mailingAdd;
	
	@JsonProperty
	@NotBlank(message = "Es obligatorio")
	private String password;
}
