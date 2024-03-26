package com.ms.dgpinnacle.business.clients.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanProductData{
    public boolean balloonIndicator;
    public int balloonLoanMaturityTermMonthsCount;
    public String floorPercentUi;
    public String gsePropertyType;
    public String indexMarginPercentUi;
    public String lienPriorityType;
    public String loanDocumentationType;
    public String loanRepaymentType;
    public String loanScheduledClosingDate;
    public double maximumMonthlyPayment;
    public double maxLifeInterestCapPercent;
    public String maxLifeInterestCapPercentUi;
    public String nmlsDocumentationType;
    public String nmlsFirstMortgageType;
    public String nmlsLoanType;
    public boolean nmlsOptionArmIndicator;
    public boolean nmlsPiggyBackOrFundedHelocIndicator;
    public String nmlsProductionSoldToType;
    public String nmlsRefinancePurposeType;
    public double netInitialAndFinal;
    public boolean prepaymentPenaltyIndicator;
    public double qualifyingRatePercent;
    public String rateAdjustmentPercentUi;
    public String rateAdjustmentSubsequentCapPercentUi;
    public String scheduledFirstPaymentDate;
    public String helocLienPosition;
    public boolean helocEscrowAccountIndicator;
    public boolean helocDrawPaymentBasis;
    public boolean helocRepaymentBasis;
}
