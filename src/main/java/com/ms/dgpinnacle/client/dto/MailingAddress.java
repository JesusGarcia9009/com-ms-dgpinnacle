package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MailingAddress{
    public String addressCity;
    public String addressPostalCode;
    public String addressState;
    public String addressStreetLine1;
    public String addressUnitDesignatorType;
    public String addressUnitIdentifier;
    public String urla2020StreetAddress;
    public String country;
    public String countryCode;
}
