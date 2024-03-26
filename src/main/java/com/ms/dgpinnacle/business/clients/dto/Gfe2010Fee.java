package com.ms.dgpinnacle.business.clients.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Gfe2010Fee{
    public String gfe2010FeeParentType;
    public String gfe2010FeeType;
    public int gfe2010FeeIndex;
    public double amount;
    public String description;
    public boolean titleServiceSelectIndicator;
    public boolean pocPtcIndicator;
    public double totalFeeAmount2015;
    public double totalFeePercentage2015;
    public double borrowerPtc2015;
    public double borrowerPac2015;
    public double borrowerAmountPaid2015;
    public boolean sellerCreditIndicator2015;
    public boolean escrowedIndicator2015;
    public boolean aprIndicator;
    public double borPaidAmount;
    public double gfeAmount;
    public String ptbType;
    public boolean borrowerCanShopForIndicator2015;
    public double sec32PointsAndFees2015;
    public boolean borrowerSelectIndicator;
    public boolean borrowerDidShopForIndicator2015;
}
