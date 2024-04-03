package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StatementCreditDenial{
    public String ecoaAddress;
    public String ecoaCity;
    public String ecoaName;
    public String ecoaPhone;
    public String ecoaPostalCode;
    public String ecoaState;
    public String lenderInvestorName;
    public String lenderInvestorAddress;
    public String lenderInvestorCity;
    public String lenderInvestorState;
    public String lenderInvestorPostalCode;
}
