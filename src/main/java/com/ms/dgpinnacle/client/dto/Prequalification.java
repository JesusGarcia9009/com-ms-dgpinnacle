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
public class Prequalification{
    public double afterTaxOwnMoSavings;
    public double avgMoPmtSavings;
    public double beforeTaxOwnMoPmt;
    public double combinedGain;
    public String favorableOption;
    public double homeSellingPriceAfterYears;
    public double investmentGain;
    public double minusDownPmtAndClosingCosts;
    public double minusLoanBalance;
    public int monthlySavings;
    public ArrayList<PrequalificationScenario> prequalificationScenarios;
    public String qualificationStatus;
    public double totalGain;
    public int totalLiabilityPayment;
    public int totalLoanSavings;
    public double totalOtherExpenses;
    public double totalOwnPmtOverYears;
    public double totalPmtSavings;
    public String withinLimits9;
}
