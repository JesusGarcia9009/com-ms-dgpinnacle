package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Section32{
    public String loanQualifyAsHighCostMortgage;
    public double maximumPercentageOfLoan;
    public double maximumPointsAndFees;
    public String resultOfPointAndFees;
    public String resultOfSecurityYieldTest;
    public double totalPointsAndFees;
    public String exceed2PercentPrepayPenalty;
}
