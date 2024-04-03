package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item{
    public int itemNumber;
    public String type;
    public String accountIdentifier;
    public double urla2020CashOrMarketValueAmount;
    public String depositoryAccountName;
}
