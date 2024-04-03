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
public class RateLock{
    public double amountDue;
    public String amountDueTo;
    public String amountPaidTo;
    public int balloonLoanMaturityTermMonths;
    public double baseLoanAmount;
    public double borrowerRequestedLoanAmount;
    public double combinedLtv;
    public String warehousedDate;
    public double diffAmountReceived;
    public double diffImpounds;
    public double diffPrinciple;
    public double expectedAmountReceived;
    public double expectedImpounds;
    public double expectedPrinciple;
    public boolean fhaSecondaryResidence;
    public int financedNumberOfUnits;
    public double firstSubordinateAmount;
    public boolean firstTimeHomebuyersIndicator;
    public String gsePropertyType;
    public double hcltvHtltv;
    public double helocCreditLimit;
    public String subjectPropertyPropertyStreetAddress;
    public String lienPriorityType;
    public int loanAmortizationTermMonths;
    public String loanAmortizationType;
    public String loanDocumentationType;
    public String loanProgram;
    public String loanProgramFile;
    public String loanScheduledClosingDate;
    public ArrayList<LockRequestBorrower> lockRequestBorrowers;
    public String lockRequestLoanPurposeType;
    public double ltv;
    public String mortgageType;
    public int propertyAppraisedValueAmount;
    public int propertyEstimatedValueAmount;
    public String propertyUsageType;
    public double purchasePriceAmount;
    public double reconciledDiff;
    public String requestPrepayPenalty;
    public boolean roundToNearest50;
    public boolean servicingReleaseIndicator;
    public String subjectPropertyCity;
    public String subjectPropertyCounty;
    public String subjectPropertyPostalCode;
    public String subjectPropertyState;
    public String subjectPropertyStreetAddress;
    public int correspondentWarehouseBankId;
    public int daysToExtend;
    public double correspondentFinalCdHomeInsurance;
    public double correspondentFinalCdPropertyTax;
    public double correspondentFinalCdReservesCollectedAtClosing;
    public double correspondentAdditionalEscrowPropertyTax;
    public double correspondentEscrowDisbursementsEsrowFundedByInvestor;
    public String correspondentPaymentHistoryFirstBorrowerPaymentDueDate;
    public String rateRequestStatus;
    public String requestLockType;
    public String isCancelled;
    public String rateStatus;
    public String requestPending;
    public String requestType;
    public String extensionRequestPending;
    public String cancellationRequestPending;
    public String reLockRequestPending;
    public String borrLenderPaid;
    public boolean correspondentRetainUserInputs;
    public boolean condominiumIndicator;
    public boolean pudIndicator;
    public boolean notInProjectIndicator;
}
