package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommitmentTerms{
    public String mortgageeAddress;
    public String mortgageeCity;
    public String mortgageeName;
    public String mortgageePostalCode;
    public String mortgageeState;
    public double totalMonthlyExpense;
}
