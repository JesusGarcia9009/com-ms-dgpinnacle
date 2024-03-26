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
public class Application{
    public String id;
    public String legacyId;
    public double allOtherPaymentsAmount;
    public ArrayList<Vod> vods;
    public double assetsAvailableAmount;
    public Borrower borrower;
    public double bottomRatioPercent;
    public Coborrower coborrower;
    public String creditReportReferenceIdentifier;
    public String equifaxAddress;
    public String equifaxCity;
    public String equifaxModel;
    public String equifaxName;
    public String equifaxPhone;
    public String equifaxPostalCode;
    public String equifaxScoreRangeFrom;
    public String equifaxScoreRangeTo;
    public String equifaxState;
    public String experianAddress;
    public String experianCity;
    public String experianModel;
    public String experianName;
    public String experianPhone;
    public String experianPostalCode;
    public String experianScoreRangeFrom;
    public String experianScoreRangeTo;
    public String experianState;
    public double fhaVaDebtIncomeRatio;
    public double fhaVaFamilySupportAmount;
    public double fhaVaTotalEstimatedMonthlyShelterExpenseAmount;
    public double fhaVaTotalNetEffectiveIncomeAmount;
    public double fhaVaTotalNetIncomeAmount;
    public double fhaVaTotalNetTakeHomePayAmount;
    public double freddieMacOccupantHousingRatio;
    public double freddieMacOccupantDebtRatio;
    public double grossBaseIncomeAmount;
    public double grossOtherIncomeAmount;
    public ArrayList<Income> income;
    public boolean incomeOtherThanBorrowerUsedIndicator;
    public boolean jointAssetLiabilityReportingIndicator;
    public ArrayList<Vol> vols;
    public double mcawBorrowerOtherMonthlyIncomeAmount;
    public double mcawGrossMonthlyIncomeAmount;
    public double mcawMortgagePaymentToIncome1Amount;
    public double mcawTotalFixedPaymentForPurchaseAmount;
    public double mcawTotalFixedPaymentToIncome1Amount;
    public double mcawTotalMonthlyPaymentsAmount;
    public double mcawTotalMortgagePaymentAmount;
    public double monthlyHousingExpenseAmount;
    public double monthlyInstallmentExpenseAmount;
    public double netWorthAmount;
    public String propertyUsageType;
    public double proposedFirstMortgageAmount;
    public String proposedHazardInsuranceAmount;
    public String proposedRealEstateTaxesAmount;
    public Tax4506 tax4506;
    public double topRatioPercent;
    public double totalAssetsAmount;
    public double totalBaseIncomeAmount;
    public double totalBonusAmount;
    public double totalDeposit;
    public double totalEmploymentAmount;
    public double totalFixedPaymentAmount;
    public double totalGrossMonthlyIncomeAmount;
    public double totalIncomeAmount;
    public double totalMonthlyPaymentAmount;
    public double totalPaymentsAmount;
    public double totalPrimaryHousingExpenseAmount;
    public double totalUrla2020AssetsAmount;
    public String transUnionAddress;
    public String transUnionCity;
    public String transUnionModel;
    public String transUnionName;
    public String transUnionPhone;
    public String transUnionPostalCode;
    public String transUnionScoreRangeFrom;
    public String transUnionScoreRangeTo;
    public String transUnionState;
    public double vaSummarySpouseIncomeAmount;
    public double vaSummaryTotalMonthlyGrossIncomeAmount;
    public AtrqmBorrower atrqmBorrower;
    public AusTracking ausTracking;
    public String borrowerPairId;
}
