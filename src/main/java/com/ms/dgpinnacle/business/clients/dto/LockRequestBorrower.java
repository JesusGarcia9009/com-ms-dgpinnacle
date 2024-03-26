package com.ms.dgpinnacle.business.clients.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LockRequestBorrower{
    public int lrbIndex;
    public String equifaxScore;
    public String experianScore;
    public String firstName;
    public String lastName;
    public String ssn;
    public String transUnionScore;
}
