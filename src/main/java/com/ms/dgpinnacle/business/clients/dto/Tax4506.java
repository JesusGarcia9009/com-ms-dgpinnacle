package com.ms.dgpinnacle.business.clients.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tax4506{
    public boolean accountTranscript;
    public boolean formsSeriesTranscript;
    public boolean irs4506C;
    public String irs4506CPrintVersion;
    public boolean recordOfAccount;
    public String requestYear1;
    public String requestYear2;
    public boolean returnTranscript;
    public String sendAddress;
    public String sendCity;
    public String sendFirst;
    public String sendLast;
    public String sendState;
    public String sendZip;
    public String taxFormNumber;
    public boolean useWellsFargoRules;
    public boolean verificationOfNonfiling;
    public String sorMailboxId;
    public String clientName;
    public String clientPhone;
    public String clientAddress;
    public String clientCity;
    public String clientState;
    public String clientZip;
}
