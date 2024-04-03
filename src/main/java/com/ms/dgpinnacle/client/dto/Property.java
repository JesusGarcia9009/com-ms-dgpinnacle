package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Property{
    public String addressLineText;
    public String city;
    public String county;
    public boolean fhaSecondaryResidenceIndicator;
    public int financedNumberOfUnits;
    public double freCashOutAmount;
    public String legalDescriptionText1;
    public String loanPurposeType;
    public String loanPurposeTypeUrla;
    public String nameRecordingJurisdiction;
    public String occupancyDisplayField;
    public String postalCode;
    public String propertyRightsType;
    public String propertyUsageType;
    public String state;
    public String streetAddress;
    public String typeRecordingJurisdiction;
}
