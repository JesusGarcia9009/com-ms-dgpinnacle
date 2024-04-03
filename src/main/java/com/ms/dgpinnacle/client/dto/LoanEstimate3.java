package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanEstimate3{
    public String lenderLicenseId;
    public String lenderEmail;
    public String lenderPhone;
    public String lenderLoanOfficer;
    public String lenderLoanOfficerNmlsId;
    public String assumption;
    public double totalInterestPercentage;
    public String totalInterestPercentageUi;
    public int in5YearsTotalYouWillHavePaid;
    public int in5YearsPrincipalYouWillHavePaidOff;
    public String signatureType;
    public String mortgageLenderLoanOfficerLicenseId;
}
