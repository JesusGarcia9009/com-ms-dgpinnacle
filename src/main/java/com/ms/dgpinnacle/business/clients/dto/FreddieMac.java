package com.ms.dgpinnacle.business.clients.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FreddieMac{
    public double allMonthlyPayments;
    public String freddieFiel13;
    public String freddieFiel14;
    public String loanProspectorId;
    public String lpKeyNumber;
    public double netPurchasePrice;
    public double originalIntRate;
    public double reserves;
    public boolean homeOne;
    public double ltv;
    public double tltv;
    public double htltv;
}
