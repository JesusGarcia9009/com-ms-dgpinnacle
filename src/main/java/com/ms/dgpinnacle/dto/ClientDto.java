package com.ms.dgpinnacle.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String cellphone;

	@NotBlank
	@NotNull
	private String email;

	private String lastName;

	private String mailingAdd;

	private String name;

	// userdata
	@NotBlank
	@NotNull
	private String password;

	private Long profileId;

	private String profileCode;

	private String profileName;

}
