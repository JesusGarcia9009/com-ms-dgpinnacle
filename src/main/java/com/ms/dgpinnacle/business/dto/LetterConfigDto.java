package com.ms.dgpinnacle.business.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LetterConfigDto {
	
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
	
	//Datos fix
	private Long fixDataId;
	private String fixDataConditions;
	private boolean fixDataDeleted;
	private String fixDataFinaltext;
	private String fixDataSubject;
	
	//Operation
	private Long operationId;
    private String operationName;
    
    //LOAN
    private Long   loanId;
    private String loanCellphone;
	private String loanEmail;
	private String loanLastName;
	private String loanMailingAdd;
	private String loanName;
	private String loanNmls;
	
	//CLIENTs
	private List<ClientDto> clients = new ArrayList<ClientDto>();
	
	//Realtors
	private List<RealtorDto> realtors = new ArrayList<RealtorDto>();
	
	public LetterConfigDto(Long id, Boolean active, Boolean deleted, double hoa, double insurance, double interest,
			Double loanAmount, int loanTerm, String loanType, String location, double ltv, double maxPay, Double mi,
			int price, double taxes, String uniqueKey, Long fixDataId,
			String fixDataConditions, boolean fixDataDeleted, String fixDataFinaltext, String fixDataSubject,
			Long operationId, String operationName, Long loanId, String loanCellphone, String loanEmail, String loanLastName,
			String loanMailingAdd, String loanName, String loanNmls) {
		super();
		this.id = id;
		this.active = active;
		this.deleted = deleted;
		this.hoa = hoa;
		this.insurance = insurance;
		this.interest = interest;
		this.loanAmount = loanAmount;
		this.loanTerm = loanTerm;
		this.loanType = loanType;
		this.location = location;
		this.ltv = ltv;
		this.maxPay = maxPay;
		this.mi = mi;
		this.price = price;
		this.taxes = taxes;
		this.uniqueKey = uniqueKey;
		this.fixDataId = fixDataId;
		this.fixDataConditions = fixDataConditions;
		this.fixDataDeleted = fixDataDeleted;
		this.fixDataFinaltext = fixDataFinaltext;
		this.fixDataSubject = fixDataSubject;
		this.operationId = operationId;
		this.operationName = operationName;
		this.loanId = loanId;
		this.loanCellphone = loanCellphone;
		this.loanEmail = loanEmail;
		this.loanLastName = loanLastName;
		this.loanMailingAdd = loanMailingAdd;
		this.loanName = loanName;
		this.loanNmls = loanNmls;
	}
	
	
	
}
