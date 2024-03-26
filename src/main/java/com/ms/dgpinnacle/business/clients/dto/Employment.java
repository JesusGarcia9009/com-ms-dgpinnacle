package com.ms.dgpinnacle.business.clients.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employment{
    public String id;
    public String addressCity;
    public String addressPostalCode;
    public String addressState;
    public String addressStreetLine1;
    public double basePayAmount;
    public double bonusAmount;
    public String countryCode;
    public boolean currentEmploymentIndicator;
    public String employerName;
    public String employmentStartDate;
    public int jobTermMonths;
    public double monthlyIncomeAmount;
    public boolean noLinkToDocTrackIndicator;
    public String phoneNumber;
    public String positionDescription;
    public boolean printAttachmentIndicator;
    public int timeInLineOfWorkYears;
    public int timeOnJobTermMonths;
    public int timeOnJobTermYears;
    public String title;
    public String titleFax;
    public String titlePhone;
    public String urla2020StreetAddress;
    public boolean militaryEmployer;
    public String country;
    public String sourceOfIncomeData;
    public String altId;
    public String endDate;
}
