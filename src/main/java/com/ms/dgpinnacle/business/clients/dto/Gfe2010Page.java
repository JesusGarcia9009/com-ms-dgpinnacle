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
public class Gfe2010Page{
    public ArrayList<Gfe2010GfeCharge> gfe2010GfeCharges;
    public double gfeTotalTolerance;
    public boolean hasEscrowAccountIndicator;
    public boolean hasEscrowHomeownerInsurancesIndicator;
    public boolean hasEscrowPropertyTaxesIndicator;
    public double hud1GovernmentRecordingCharge;
    public double hud1Pg1TotalSettlementCharges;
    public double hud1Pg2TotalSettlementCharges;
    public double hudTotalTolerance;
    public double hudTotalToleranceIncreasePercent;
    public double line801BorrowerPaidTotal;
    public double line802BorrowerPaidTotal;
    public double line803BorrowerPaidTotal;
    public boolean monthlyAmountIncludeInterestIndicator;
    public boolean monthlyAmountIncludePrincipalIndicator;
    public double monthlyAmountWithEscrow;
    public double monthlyEscrowPayment;
    public double prepaidInterest;
    public double totalToleranceIncreaseAmount;
}
