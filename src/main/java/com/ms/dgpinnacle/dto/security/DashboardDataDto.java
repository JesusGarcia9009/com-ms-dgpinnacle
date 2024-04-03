package com.ms.dgpinnacle.dto.security;

import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DashboardDataDto {
	
	private BigInteger productsGreater;
	private BigInteger productsLess;
	
	private BigInteger billOfBuyNumber;
	
	private BigInteger quotationNumber;
	private BigDecimal quotationAmount;
	
	private BigInteger orderNoteNumber;
	private BigDecimal orderNoteAmount;

}
