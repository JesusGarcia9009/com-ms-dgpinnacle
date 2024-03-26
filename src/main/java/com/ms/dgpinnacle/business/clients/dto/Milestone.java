package com.ms.dgpinnacle.business.clients.dto;




import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Milestone{
    public String id;
    public Date startDate;
    public int days;
    public boolean doneIndicator;
    public int duration;
    public LoanAssociate loanAssociate;
    public boolean reviewedIndicator;
    public String comments;
    public String roleRequired;
    public String name;
    public MilestoneSetting milestoneSetting;
}
