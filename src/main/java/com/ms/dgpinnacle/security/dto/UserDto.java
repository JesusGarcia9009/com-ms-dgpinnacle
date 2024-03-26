package com.ms.dgpinnacle.security.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	@JsonProperty
	private Long id;
	
	@NotNull
	@NotBlank
	@JsonProperty
	private String socialSecurityNumber;
	
	@JsonProperty
	private String fullNames;
	
	@NotNull
	@NotBlank
	@JsonProperty
	private String mail;
	
	@JsonProperty
	private String businessPosition;
	
	@NotNull
	@NotBlank
	@JsonProperty
	private String pass;
	
	@NotNull
	@JsonProperty
	private Long profileId;
	
	@JsonProperty
	private String profileName;


}
