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
public class Hud1Es{
    public double annualHazardInsurance;
    public double annualTax;
    public double biweeklyCountyTaxes;
    public double biweeklyHazardInsurance;
    public double biweeklyPiti;
    public double biweeklyTotalBiweeklyPayment;
    public double biweeklyTotalBiweeklyPaymentToEscrow;
    public double endingBalance;
    public double escrowPayment;
    public int floodInsDisbCushion;
    public int hazInsDisbCushion;
    public ArrayList<Hud1EsDate> hud1EsDates;
    public ArrayList<Hud1EsDueDate> hud1EsDueDates;
    public ArrayList<Hud1EsItemize> hud1EsItemizes;
    public int hud1EsItemizesTotalLines;
    public ArrayList<Hud1EsSetup> hud1EsSetups;
    public int mtgInsDisbCushion;
    public double realEstateTaxAmountNextDue;
    public String realEstateTaxNextDueDate;
    public String realEstateTaxPaymentSchedule;
    public double singleLineAnalysis;
    public double startingBalance;
    public int taxDisbCushion;
    public double totalEscrowReserves;
    public double escrowPaymentYearly;
    public double nonEscrowCostsYearly;
    public String escrowFirstPaymentDate;
    public String escrowFirstPaymentDateType;
}
