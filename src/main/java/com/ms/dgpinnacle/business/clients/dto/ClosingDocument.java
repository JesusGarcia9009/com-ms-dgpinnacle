package com.ms.dgpinnacle.business.clients.dto;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClosingDocument{
    public ArrayList<AdditionalStateDisclosure> additionalStateDisclosures;
    public String closingProvider;
    public String compliancePropertyIdentifiedDate;
    public String conditionDescription;
    public boolean conflictofInterestCheck1;
    public boolean conflictofInterestCheck6;
    public String disbursementDate;
    public double disbursementsToBorrower;
    public String drawCity;
    public String drawState;
    public String mortgageType;
    public ArrayList<RespaHudDetail> respaHudDetails;
    public ArrayList<StateLicense> stateLicenses;
    public boolean syncInterestDateDisbursementDate;
}
