package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClosingDisclosure4{
    public String negativeAmortization;
    public boolean lender;
    public boolean escrowIndicator;
    public double monthlyEscrowPayment;
    public boolean interestOnlyPayments;
    public boolean stepPayments;
    public boolean seasonalPayments;
    public String partialPaymentNone;
    public boolean ignoreArmAdj;
    public double initialEscrowPayment;
    public String escrowedPropertyCostsBasis;
}
