package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClosingDisclosure2{
    public double originationChargesSubTotal;
    public double servicesDidNotShopSubTotal;
    public double servicesDidShopSubTotal;
    public double totalLoanCost;
    public double totalBorrowerPaidAtClosing;
    public double totalBorrowerPaidBeforeClosing;
    public double taxesGovermentFeesSubTotal;
    public double prepaidsSubTotal;
    public double initialEscrowSubTotal;
    public double otherSubTotal;
    public double totalOtherCost;
    public double totalOtherCostAtClosing;
    public double totalOtherCostBeforeClosing;
    public double totalClosingCost;
    public double borrowerClosingCostAtClosing;
    public double borrowerClosingCostBeforeClosing;
    public double sellerClosingCostAtClosing;
    public double sellerClosingCostBeforeClosing;
    public double closingCostPaidByOthers;
}
