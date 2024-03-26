package com.ms.dgpinnacle.business.clients.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FhaVaLoan{
    public double discountPoints;
    public EnergyEfficientMortgage energyEfficientMortgage;
    public String lenderAddress;
    public String lenderCity;
    public String lenderName;
    public String lenderNmls;
    public String lenderPostalCode;
    public String lenderState;
    public String lenderTaxId;
    public double minimumDownPayment;
    public double nonRealtyAndOtherItems;
    public double otherLiabilitiesMonthlyPayment;
    public double otherLiabilitiesUnpaidBalance;
    public double prepaidExpenses;
    public int proposedMaturityYears;
    public double totalClosingCost;
    public boolean useDefaultLenderInfo;
    public double fhaSalesPrice;
    public double fhaMortgageAmount;
    public double fhaMortgageAmountUmip;
    public double fhaClosingCost;
    public double fhaDownPayment;
    public double fhaInterestRate;
    public int fhaLoanTerm;
    public double fhaMonthlyPayment;
    public double fhaLtv;
    public double fhaMmi;
    public int fhaYearsMonthlyInsurance;
    public double fhaUmip;
    public double conventionalSalesPrice;
    public double conventionalMortgageAmount;
    public double conventionalClosingCost;
    public double conventionalDownPayment;
    public double conventionalInterestRate;
    public int conventionalLoanTerm;
    public double conventionalMonthlyPayment;
    public double conventionalLtv;
    public double conventionalMmi;
    public int conventionalMaxYearsMi;
}
