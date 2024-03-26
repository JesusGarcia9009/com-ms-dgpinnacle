package com.ms.dgpinnacle.business.clients.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Gfe2010GfeCharge{
    public boolean chargeBelow10Indicator;
    public int gfe2010GfeChargeIndex;
    public String description;
    public double gfeCharge;
    public double hudCharge;
    public String line;
}
