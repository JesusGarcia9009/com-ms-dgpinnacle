package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AffiliatedBusinessArrangement{
    public String id;
    public String altId;
    public String lenderName;
    public String affiliateName;
    public String natureOfRelationship;
    public String serviceDescription1;
    public double percentOwnershipInterest;
}
