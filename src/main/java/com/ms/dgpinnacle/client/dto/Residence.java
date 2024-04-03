package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Residence{
    public String id;
    public String residencyType;
    public String addressCity;
    public String addressPostalCode;
    public String addressState;
    public String addressStreetLine1;
    public String addressUnitDesignatorType;
    public String addressUnitIdentifier;
    public String countryCode;
    public String county;
    public int durationTermMonths;
    public int durationTermYears;
    public boolean noLinkToDocTrackIndicator;
    public boolean printAttachmentIndicator;
    public double rent;
    public String residencyBasisType;
    public String title;
    public String titleFax;
    public String titlePhone;
    public String urla2020StreetAddress;
    public String country;
    public String altId;
}
