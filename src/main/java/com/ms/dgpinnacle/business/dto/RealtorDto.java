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

	private Long id;
	
	private String cellphone;
	
	private String email;
	
	private String lastName;
	
	private String licenseNumber;
	
	private String mailingAdd;
	
	private String name;
	
	private String notes;
	
	private Long brokerCompanyId;
	
	private String brokerCompanyName;
	
	private String brokerCompanyPhone;
	
	private String brokerCompanyPhysicalAdd;
	
	private String brokerCompanyWebSite;

}
