package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VaLoanData{
    public int creditScore;
    public double discountPercentage;
    public double totalDebtMonthlyPayment;
    public double vaRecoupmentMonthlyDecreaseInPayment;
    public double vaRecoupmentTotalClosingCosts;
    public double totalProposedMonthlyPayment;
    public double proposedHomeEquityRemainingAmount;
    public double cashDisbursedToBorrowerAmount;
    public double disbursementsLessPayoffAmount;
    public double totalClosingCostLessGuaranteeFee;
    public double cdNonShoppableLessFundingFee;
    public boolean includeSectionAIndicator;
    public boolean includeSectionBVaFundingFeeIndicator;
    public boolean includeSectionBOtherIndicator;
    public boolean includeSectionCIndicator;
    public boolean includeSectionEIndicator;
    public boolean includeSectionFIndicator;
    public boolean includeSectionGIndicator;
    public boolean includeSectionHIndicator;
    public boolean includeLenderCreditIndicator;
}
