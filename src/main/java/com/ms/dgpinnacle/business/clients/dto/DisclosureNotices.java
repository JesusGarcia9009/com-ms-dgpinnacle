package com.ms.dgpinnacle.business.clients.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DisclosureNotices{
    public boolean antiCoercionStatementIndicator;
    public String commitmentIssuedByAddress;
    public String commitmentIssuedByCity;
    public String commitmentIssuedByName;
    public String commitmentIssuedByPhone;
    public String commitmentIssuedByPostalCode;
    public String commitmentIssuedByState;
    public String daysToReceiveWrittenRequest;
    public String ecoaAddress;
    public String ecoaCity;
    public String ecoaName;
    public String ecoaPhone;
    public String ecoaPostalCode;
    public String ecoaState;
    public String fairLendingNoticeDescription1;
    public String fairLendingNoticeDescription3;
    public String fairLendingNoticeDescription5;
    public String fairLendingNoticeDescription7;
    public boolean floodInsuranceNotificationIndicator;
    public boolean informationDisclosureAuthorizationIndicator;
    public boolean occupancyStatementIndicator;
    public boolean releaseBankingInformationIndicator;
    public boolean releaseEmploymentInformationIndicator;
    public boolean releaseInformationInConnectionWithCreditReportIndicator;
    public boolean releaseMortgageInformationIndicator;
    public boolean rightToFinancialPrivacyActIndicator;
}
