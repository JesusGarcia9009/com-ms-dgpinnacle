package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClosingCost{
    public Double disclosedSalesPrice;
    public ClosingDisclosure5 closingDisclosure5;
    public Gfe2010 gfe2010;
    public Gfe2010Page gfe2010Page;
    public Gfe2010Section gfe2010Section;
    public String impoundType3;
    public String impoundType4;
    public double section1000BorrowerPaidTotalAmount;
    public LoanEstimate1 loanEstimate1;
    public LoanEstimate2 loanEstimate2;
    public LoanEstimate3 loanEstimate3;
    public ClosingDisclosure1 closingDisclosure1;
    public ClosingDisclosure2 closingDisclosure2;
    public ClosingDisclosure3 closingDisclosure3;
    public ClosingDisclosure4 closingDisclosure4;
    public FeeVarianceOther feeVarianceOther;
}
