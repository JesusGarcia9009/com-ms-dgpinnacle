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
public class RegulationZ{
    public boolean allDateAndNumericalDisclosuresIndicator;
    public double amountFinanced;
    public double aprPercent;
    public String aprPercentUi;
    public String assumptionOnYourProperty;
    public boolean borrowerIntendToContinueIndicator;
    public String borrowerMiTerminationDate;
    public String calculateBasedOnRemainingBalance;
    public boolean demandFeatureIndicator;
    public double financeCharge;
    public boolean gfeChangedCircumstanceIndicator;
    public boolean gfeRateLockRedisclosureRequiredIndicator;
    public boolean hud1ToleranceViolatedIndicator;
    public boolean includeTaxesInsuranceIndicator;
    public String interestInNameOf;
    public boolean interestOnlyIndicator;
    public int lateChargeDays;
    public double lateChargePercent;
    public double lateChargeBasis;
    public String lateChargeType;
    public double maximumPayment;
    public boolean meansAnEstimateIndicator;
    public double minimumPayment;
    public String miScheduledTerminationDate;
    public boolean mmiIndicator;
    public double mortgageInsuranceCancelPercent;
    public String namePreparedBy;
    public int numberOfPayments;
    public String paymentFrequencyType;
    public String phonePreparedBy;
    public String pmiMidpointCancelationDate;
    public double prepaidFinanceCharge;
    public boolean propertyInsuranceIndicator;
    public boolean refundPaymentIndicator;
    public ArrayList<RegulationZInterestRatePeriod> regulationZInterestRatePeriods;
    public ArrayList<RegulationZPayment> regulationZPayments;
    public String regzTableType;
    public double samplePayments;
    public String securityType;
    public double totalLenderFees;
    public double totalOfPayments;
    public String useDaysInYears;
    public String yearOfMaximumPayment;
    public double totalOfPrincipalAndInterest;
    public double lateFee;
    public double totalLatePayment;
    public String zeroPercentPaymentOption;
    public String interestAccrual;
}
