package com.ms.dgpinnacle.client.dto;




import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MilestoneTask{
    public String id;
    public String addedBy;
    public String addedByUserId;
    public int daysToComplete;
    public int daysToCompleteFromSetting;
    public boolean isRequiredIndicator;
    public String priority;
    public MilestoneRef milestoneRef;
    public String taskDescription;
    public String taskGuid;
    public String taskName;
    public boolean completed;
    public int contactCount;
    public Date addDate;
    public Date milestoneTaskLogDate;
}
