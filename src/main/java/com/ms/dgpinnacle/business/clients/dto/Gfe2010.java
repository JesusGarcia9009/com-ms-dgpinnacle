package com.ms.dgpinnacle.business.clients.dto;




import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Gfe2010{
    public double adjustedOriginationCharges;
    public double allOtherServiceAmount;
    public boolean borrowerSelectIndicator14;
    public double chargeAmount;
    public double chargeAmountForPrint;
    public String creditChargeType;
    public double creditOrChange;
    public double dailyInterestCharges;
    public boolean escrowChargeAllInsuranceIndicator;
    public boolean escrowChargeAllPropertyTaxesIndicator;
    public boolean escrowChargeOtherIndicator;
    public ArrayList<Gfe2010Fee> gfe2010Fees;
    public double gfeGovernmentRecordingCharges;
    public double hazardInsurance;
    public double homeownerInsurance;
    public String includeOriginationPointsCreditType;
    public double initialLoanAmount;
    public double initialMonthlyAmount;
    public boolean interestRateRiseIndicator;
    public double line1001Fee;
    public double line1002Fee;
    public double line1004Fee;
    public double line808Fee;
    public double line809Fee;
    public boolean loanBalanceRiseIndicator;
    public String maxLifeInterestCapPercentUi;
    public boolean monthlyPaymentRiseIndicator;
    public double originationCharges;
    public double originationPoints;
    public double processingFees;
    public double requiredAppraisalFee;
    public double requiredCreditReportFee;
    public double requiredFloodCertificationFee;
    public double requiredServicesAmount;
    public double requiredTaxServiceFee;
    public double titleServiceAmount;
    public double totalSettlementCharges;
    public double totalTransferTaxes;
    public double transferTaxes;
    public double underwritingFees;
    public double section1400TotalBorrowerPaidAmount;
    public double section800TotalBorrowerPaidAmount;
    public double section800TotalPaidAmount;
    public double section900TotalBorrowerPaidAmount;
    public double section900TotalPaidAmount;
    public double section1000TotalBorrowerPaidAmount;
    public double section1000TotalPaidAmount;
    public double section1100TotalBorrowerPaidAmount;
    public double section1100TotalPaidAmount;
    public double section1200TotalBorrowerPaidAmount;
    public double section1200TotalPaidAmount;
    public double section1400TotalPaidAmount;
    public boolean isCdValidForEarliestClosingDate;
}
