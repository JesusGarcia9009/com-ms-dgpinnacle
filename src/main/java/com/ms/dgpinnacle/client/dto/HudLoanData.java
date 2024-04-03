package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HudLoanData{
    public double contractSalesPrice;
    public double lesserOfSalesPrice;
    public String loanPurpose;
    public double supplementalOriginationFee;
    public double totalFixedUnpaidBalance;
    public double financeableMortgageFeesIfCharged;
    public double totalRehabilitationCostsFeesReserves;
    public double purchasePriceLessInducementToPurchase;
    public double step2EPlusStep1E;
    public double appropriateLtvFactor;
    public double initialDrawAtClosingTotal;
    public double rehabilitationEscrowAccount;
    public String criteriaForAppropriateLtvFactor;
}
