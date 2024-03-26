package com.ms.dgpinnacle.business.clients.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Mcaw{
    public double adjustedPurchasePrice;
    public double cashReserves;
    public double contractSalesPrice;
    public double lesserSalesPrice;
    public double mortgageBasisPurchase;
    public double mortgageBasisRefinance;
    public boolean roundTo50Indicator;
    public double sixPercentOfLineA1;
    public double maximumSellerContribution4Percent;
    public double statutoryInvestment;
    public double totalCashToClose;
    public double unadjustedAcquisition;
}
