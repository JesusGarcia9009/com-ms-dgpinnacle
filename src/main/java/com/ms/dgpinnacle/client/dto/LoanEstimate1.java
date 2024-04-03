package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanEstimate1{
    public boolean rangePaymentIndicatorC1;
    public int loanTermYears;
    public String loanPurpose;
    public String loanProduct;
    public String rateLockExpirationTime;
    public String rateLockExpirationTimeZone;
    public String closingCostEstimateExpirationTime;
    public String closingCostEstimateExpirationTimeZone;
    public double estimatedTaxesInsuranceAssessments;
    public String estimatedTaxesInsuranceAssessmentsUi;
    public String inEscrowPropertyTaxes;
    public String inEscrowHomeownerInsurance;
    public String inEscrowOther;
    public int ppc1Year;
    public double ppc1MinimumPiPayment;
    public String ppc1MinimumPiPaymentUi;
    public double ppc1MaximumPiPayment;
    public String ppc1MaximumPiPaymentUi;
    public boolean ppc1InterestOnly;
    public String ppc1MiAmountUi;
    public int ppc1EstimatedEscrowAmount;
    public String ppc1EstimatedEscrowAmountUi;
    public int ppc1MinimumMonthlyPayment;
    public String ppc1MinimumMonthlyPaymentUi;
    public double ppc1MaximumMonthlyPayment;
    public String ppc1MaximumMonthlyPaymentUi;
    public boolean ppestimatedEscrowIndicator;
    public boolean reasonSettlementCharges;
    public boolean reasonEligibility;
    public boolean reasonRevisions;
    public boolean reasonInterestRate;
    public boolean reasonExpiration;
    public boolean reasonDelayedSettlement;
    public boolean reasonOther;
    public double totalEstimatedCashClose;
    public String closingCostEstimateExpirationTimeUi;
    public String closingCostEstimateExpirationTimeZoneUi;
    public double initialMonthlyPaymentFor10000Loan;
    public double maximumMonthlyPaymentFor10000Loan;
    public int maximumPaymentMonth;
    public double initialMonthlyPaymentFor60000Loan;
    public String interestRateAdjTermLabel;
    public String expirationGenericTimeZone;
}
