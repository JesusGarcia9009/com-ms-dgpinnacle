package com.ms.dgpinnacle.business.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnCompassLetterConfigDto {
	
	private Long id;

	private Boolean active;

	private Boolean deleted;

	private double hoa;

	private double insurance;

	private double interest;

	private Double loanAmount;

	private int loanTerm;

	private String loanType;

	private String location;

	private double ltv;

	private double maxPay;

	private Double mi;

	private int price;

	private double taxes;

	private String uniqueKey;
	
	//Operation
	private Long operationId;
    private String operationName;
    
	//servicesID
	private String loanServicesId;
	
	//LOAN
	@NotNull
	private EnCompassLoanOfficerDto loanOfficer;
	
	//CLIENTs
	private List<EnCompassClientDto> clients = new ArrayList<EnCompassClientDto>();
	
	//Realtors
	private List<EnCompassRealtorDto> realtors = new ArrayList<EnCompassRealtorDto>();
	
}
