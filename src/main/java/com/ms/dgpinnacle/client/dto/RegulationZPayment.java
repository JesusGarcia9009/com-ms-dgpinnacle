package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegulationZPayment{
    public int regulationZPaymentIndex;
    public double balance;
    public double interestRatePercent;
    public double monthlyPayment;
    public int numberOfPayments;
    public String paymentDate;
}
