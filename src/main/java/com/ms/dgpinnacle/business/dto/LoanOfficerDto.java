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
public class LoanOfficerDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String cellphone;
	
	private String email;
	
	private String lastName;
	
	private String mailingAdd;
	
	private String name;
	
	private String nmls;
	
	//userdata
	private String password;
	
	private Long profileId;
	
	private String profileCode;
	
	private String profileName;

}
