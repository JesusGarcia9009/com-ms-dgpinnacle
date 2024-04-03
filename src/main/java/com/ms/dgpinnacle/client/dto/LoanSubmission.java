package com.ms.dgpinnacle.client.dto;




import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanSubmission{
    public double amountAvailable;
    public double amountRequiredToClose;
    public ArrayList<LoanSubmissionFee> loanSubmissionFees;
    public double total;
    public double totalDiscountPointCharged;
    public double totalForDueLender;
}
