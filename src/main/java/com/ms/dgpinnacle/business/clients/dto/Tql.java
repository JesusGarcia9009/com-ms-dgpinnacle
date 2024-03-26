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
public class Tql{
    public ArrayList<GseTracker> gseTrackers;
    public String stonegate4506TBaselineReport;
    public int tqlFraudAlertsTotal;
    public int tqlFraudAlertsTotalHigh;
    public int tqlFraudAlertsTotalMedium;
    public int tqlFraudAlertsTotalLow;
    public int tqlFraudAlertsTotalHighUnaddressed;
    public int tqlFraudAlertsTotalMediumUnaddressed;
    public int tqlFraudAlertsTotalLowUnaddressed;
    public int driveScore;
    public int driveIdVerifyScore;
    public int driveAppVerifyScore;
    public int drivePropertyVerifyScore;
    public String lpAssetRepWarrantyMessage;
    public String lpIncomeRepWarrantyMessage;
    public boolean lomaOrLomrIndicator;
    public String acePdrOfferedLoanLevel;
    public String freDesktopAppraisalOfferedComments;
    public String freDesktopAppraisalOffered;
}
