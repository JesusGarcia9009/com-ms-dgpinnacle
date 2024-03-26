package com.ms.dgpinnacle.business.clients.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StateDisclosure{
    public boolean borrowerElectsEstablishEscrowIndicator;
    public String nameOfLicensee;
}