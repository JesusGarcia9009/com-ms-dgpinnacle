package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnergyEfficientMortgage{
    public double appraisedValue;
    public double backRatio;
    public double monthlyHousingPayment;
    public double totalMonthlyHousingPayment;
    public double totalMonthlyObligations;
}
