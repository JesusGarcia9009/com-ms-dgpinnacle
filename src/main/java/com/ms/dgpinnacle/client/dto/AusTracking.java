package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AusTracking{
    public String underwritingRiskAssessType;
    public String submissionDate;
    public String firstSubmissionDate;
    public String submissionNumber;
    public String ausRecommendation;
    public String duCaseIdorLpausKey;
    public String submittedBy;
    public String ausVersion;
    public double ltv;
    public double cltv;
    public double hlctv;
    public double housingExpenseRatio;
    public double totalExpenseRatio;
    public double totalLoanAmount;
    public double salesPrice;
    public int appraisedValue;
    public double noteRate;
    public String loanType;
    public int loanTerm;
    public String amortizationType;
    public String loanPurpose;
    public double firstPandI;
    public double proposedHazardInsurance;
    public double proposedTaxes;
    public double proposedOtherPayment;
    public double proposedTotalHousingPayment;
    public double proposedTotalMonthlyDebt;
    public double incomeAssetBase;
    public double incomeAssetBonus;
    public double incomeAssetOther;
    public double totalMonthlyIncome;
    public double totalAsset;
    public String propertyAddress;
    public String propertyCity;
    public String propertyState;
    public String propertyZipcode;
    public int noUnits;
    public double loanAmount;
    public String ausTransactionId;
    public String loanProspectorId;
    public String transactionId;
    public String riskClass;
    public String documentationLevel;
    public String mortgageType;
    public String purchaseEligibility;
    public String ausStatus;
    public String loanProcessingStage;
    public String assessmentType;
    public String lpVersion;
    public String indicatorScore;
    public String selectedBorrower;
    public String presentAddress;
    public String presentAddressCity;
    public String presentAddressState;
    public String presentAddressZipCode;
    public String loanApplicationId;
    public int amortizationMonths;
    public double armQualifyingRate;
    public double tltv;
    public double htltv;
    public double housingRatio;
    public double debtRatio;
    public double occupantHousingRatio;
    public double occupantDebtRatio;
    public String negAmortizationType;
    public String temporarySubsidyBuydown;
    public String intendedUseofProperty;
    public double cashOutAmount;
    public double reserves;
    public double proposedHousingPiti;
    public double presentHousingExpense;
    public String originatingCompany;
    public String numberOfSubmissions;
    public String submissionTime;
    public String firstSubmissionTime;
    public String ausTrackingType;
    public String eFolderGuid;
    public String ausLogExtensionId;
    public String ausResponseFileName;
}
