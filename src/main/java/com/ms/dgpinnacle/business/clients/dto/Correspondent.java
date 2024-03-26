package com.ms.dgpinnacle.business.clients.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Correspondent{
    public int gracePeriodDays;
    public double lateFeePercentage;
    public double additionalLateFeeCharge;
    public int lfsCalculateAs;
    public int lfsFeeHandledAs;
    public int lfsGracePeriodCalendar;
    public int lfsGracePeriodLaterOf;
    public int lfsGracePeriodStarts;
    public int lfsIncludeDay;
    public int lfsLateFeeBasedOn;
    public int lfsMaxLateDays;
    public int lfsStartOnWeekend;
    public int lfsGracePeriodDays;
    public int lfsDayCleared;
    public String lateDaysEndTrigger;
    public double lfsLateFee;
    public double lfsAmount;
}
