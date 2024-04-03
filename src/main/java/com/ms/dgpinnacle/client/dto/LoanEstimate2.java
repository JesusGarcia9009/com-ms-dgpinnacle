package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanEstimate2{
    public int originationChargesSubTotal;
    public int servicesYouNotShopSubTotal;
    public int servicesYouShopSubTotal;
    public int totalLoanCosts;
    public int taxesGovFeesSubTotal;
    public int prepaidsSubTotal;
    public int initialEscrowPaymentClosingSubTotal;
    public int otherSubTotal;
    public int totalOtherCosts;
    public int totalClosingCosts;
    public int totalLoanAndOtherCosts;
    public double closingCostsFinanced;
    public double downPayment;
    public double fundsForBorrower;
    public double adjustmentsOtherCredits;
    public double estimatedCashToCloseSv;
    public double estimatedCashToCloseAv;
    public String fromOrToBorrower;
    public boolean useAlternate;
    public int sellerCreditAmount;
    public double unroundedTotalLoanCosts;
    public double unroundedTotalOtherCosts;
    public double actualStdleTotalClosingCostJ;
    public double actualStdleSellerCredits;
    public double thirdPartyPaymentsNotOtherwiseDisclosed;
    public boolean useActualDownPaymentAndClosingCostsFinancedIndicator;
    public int estimatedTotalPayoffsAndPaymentsAmount;
}
