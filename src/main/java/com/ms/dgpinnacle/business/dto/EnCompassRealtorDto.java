package com.ms.dgpinnacle.business.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnCompassRealtorDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cellphone;
	
	private String email;
	
	private String fullName;
	
	private String mailingAdd;
	
	private String licenseNumber;
	
}
