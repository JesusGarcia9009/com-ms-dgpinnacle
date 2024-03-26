package com.ms.dgpinnacle.business.clients.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Hud1EsItemize{
    public String id;
    public String date;
    public double escrowPaymentBalance;
    public double escrowPaymentTo;
    public String escrowPaymentDescription;
    public double escrowPaymentFrom;
}
