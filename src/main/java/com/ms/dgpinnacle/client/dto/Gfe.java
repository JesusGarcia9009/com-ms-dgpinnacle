package com.ms.dgpinnacle.client.dto;




import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Gfe{
    public String address;
    public String brokerName;
    public String brokerRepresentative;
    public String city;
    public double estimatedCashToBorrower;
    public ArrayList<GfeFee> gfeFees;
    public boolean hasPrepaymentPenaltyIndicator;
    public double monthlyPaymentAndEscrow;
    public String postalCode;
    public double principalAmount;
    public double purchasePayOff;
    public String state;
    public double totalClosingCostWithDiscount;
    public double totalPrepaidClosingCost;
}
