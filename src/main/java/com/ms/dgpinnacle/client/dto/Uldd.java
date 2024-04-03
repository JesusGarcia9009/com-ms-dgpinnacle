package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Uldd{
    public String attachmentType;
    public String coBorrowerCountryCode;
    public String constructionMethodType;
    public String countryCode;
    public String propertyEstateType;
    public int fannieCltv;
    public String fannieFloodSpecialFeatureCode;
    public int fannieHclTv;
    public int fannieInvestorOwnershipPercent;
    public double fannieLenderPaidMiInterestRateAdjustmentPercent;
    public String fannieLoanProgramIdentifier;
    public int fannieLtv;
    public int fanniePoolOwnershipPercent;
    public double fannieRateSpread;
    public int fannieTlTv;
    public String fannieMortgageType;
    public String freddieMortgageType;
    public String notePayToName;
    public String sellerLoanIdentifier;
    public boolean temporaryBuydownIndicator;
    public String firstRateChangePaymentEffectiveDate;
    public int fannieBltv;
    public String ginnieConstructionMethodType;
    public double freddieLtv;
    public double freddieTltv;
    public double freddieHtltv;
}
