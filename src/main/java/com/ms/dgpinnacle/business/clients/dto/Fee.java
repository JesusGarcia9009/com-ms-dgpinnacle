package com.ms.dgpinnacle.business.clients.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Fee{
    public String feeType;
    public double borPaidAmount;
    public String ptb;
    public String newHudBorPaidAmount;
    public String paidToName;
    public int numberOfMonths;
    public double paidToOthers;
    public double percentage;
    public boolean pfc;
    public double amountPerDay;
    public double truncatedAmountPerDay;
    public String fromDate;
    public String toDate;
    public int days;
    public boolean use4Decimals;
    public double monthlyPayment;
    public double deedAmount;
    public String description;
    public double mortgageAmount;
    public double releasesAmount;
}
