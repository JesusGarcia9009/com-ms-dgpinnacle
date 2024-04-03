package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hmda{
    public String balloonIndicator;
    public boolean cdRequired;
    public String countyCode;
    public String hoepaStatus;
    public String hmda2InterestOnlyIndicator;
    public String lienStatus;
    public String loanBalanceRiseIndicator;
    public String loanPurpose;
    public String preapprovals;
    public String stateCode;
    public int reportingYear;
    public String universalLoanId;
    public String loanType;
    public double loanAmount;
    public int income;
    public String discountPoints;
    public String manufacturedSecuredPropertyType;
    public String manufacturedHomeLandPropertyInterest;
    public String aus1;
    public String ausRecommendation1;
    public String businessOrCommercialPurpose;
    public String legalEntityIdentifier;
    public String totalLoanCosts;
    public String totalPointsAndFees;
    public String originationCharges;
    public String prepaymentPenaltyPeriod;
    public String loanTerm;
    public String introRatePeriod;
    public String propertyValue;
    public String nmlsLoanOriginatorId;
    public String hmdaPropertyZipCode;
    public String hmdaPropertyAddress;
    public String hmdaPropertyCity;
    public String hmdaPropertyState;
    public boolean hmdaSyncAddressIndicator;
    public String hmdaProfileId;
    public String hmdaProfileDtiValue;
    public String hmdaProfileCltvValue;
    public String hmdaProfileIncomeValue;
    public String hmdaLoanPurpose;
    public boolean hmdaInterestOnlyIndicator;
    public String hmdaCountyCode;
}
