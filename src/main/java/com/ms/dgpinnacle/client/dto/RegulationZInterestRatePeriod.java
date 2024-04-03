package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegulationZInterestRatePeriod{
    public String regulationZInterestRatePeriodType;
    public double monthlyPayment;
    public double taxInsuranceAmount;
    public double totalPayment;
}
