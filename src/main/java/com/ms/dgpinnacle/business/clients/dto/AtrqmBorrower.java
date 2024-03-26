package com.ms.dgpinnacle.business.clients.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AtrqmBorrower{
    public double totalHousingPayment;
    public double totalMonthlyIncome;
    public double totalMonthlyAssets;
    public double totalMonthlyDebt;
    public double housingRatio;
    public double totalExpenseRatio;
    public String underwritingRiskAssessType;
    public String ausRecommendation;
    public String duCaseIdorLpausKey;
    public String submittedBy;
    public String submissionDate;
    public String submissionTime;
    public String firstSubmissionDate;
    public String firstSubmissionTime;
    public String submissionNumber;
    public String ausVersion;
}
