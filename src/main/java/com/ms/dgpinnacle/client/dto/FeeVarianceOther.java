package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeeVarianceOther{
    public boolean leBaselineUsedCannotDecrease;
    public boolean leBaselineUsedCannotIncrease;
    public boolean leBaselineUsedCannotIncrease10;
}
