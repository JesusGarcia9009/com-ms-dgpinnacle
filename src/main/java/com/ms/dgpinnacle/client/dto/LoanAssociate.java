package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanAssociate{
    public Role role;
    public boolean writeAccess;
    public String loanAssociateType;
    public User user;
    public String email;
    public String fax;
    public String phone;
    public String title;
}
