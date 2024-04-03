package com.ms.dgpinnacle.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnCompassLoanOfficerDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String cellphone;
    
	private String email;
	
	private String fullName;
	
}
