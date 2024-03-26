package com.ms.dgpinnacle.business.clients.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Vol{
    public String id;
    public String altId;
    public String accountIdentifier;
    public String holderAddressCity;
    public String holderAddressPostalCode;
    public String holderAddressState;
    public String holderAddressStreetLine1;
    public String holderName;
    public String liabilityType;
    public double monthlyPaymentAmount;
    public String nameInAccount;
    public boolean noLinkToDocTrackIndicator;
    public String owner;
    public boolean printAttachmentIndicator;
    public int remainingTermMonths;
    public String requestId;
    public String titleFax;
    public String titlePhone;
    public double unpaidBalanceAmount;
    public boolean payoffIncludedIndicator;
    public boolean exclusionIndicator;
    public String holderComments;
}
