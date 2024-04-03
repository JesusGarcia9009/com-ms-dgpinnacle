package com.ms.dgpinnacle.dto.security;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private Long id;
	
	@NotNull
	@NotBlank
	private String name;
	
	@NotNull
	@NotBlank
	private String lastName;
	
	@NotNull
	@NotBlank
	private String email;
	
	@NotNull
	@NotBlank
	private String cellphone;
	
	private String username;
	
	@NotNull
	@NotBlank
	private String password;
	
	private String mailingAdd;
	
	@NotNull
	private Long profileId;
	
	private String profileCode;
	
	private String profileName;


}
