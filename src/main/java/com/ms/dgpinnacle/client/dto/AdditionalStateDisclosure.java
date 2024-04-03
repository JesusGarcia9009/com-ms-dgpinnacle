package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalStateDisclosure{
    public String stateCode;
    public String disclosureName;
    public Object disclosureValue;
}
