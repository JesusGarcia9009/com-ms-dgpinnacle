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
public class ChangePasswordDto {
	
	@NotNull
	private Long id;
	
	@NotNull
	@NotBlank
	private String password;
	
}
