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
public class RealtorDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	
	private String cellphone;
	
	private String email;
	
	private String lastName;
	
	private String licenseNumber;
	
	private String mailingAdd;
	
	private String name;
	
	private String notes;

}
