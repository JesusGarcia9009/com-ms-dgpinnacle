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
public class Vod{
    public String id;
    public String holderName;
    public boolean includeInAusExport;
    public boolean noLinkToDocTrackIndicator;
    public String owner;
    public boolean printAttachmentIndicator;
    public String titleFax;
    public String titlePhone;
    public double total;
    public ArrayList<Item> items;
    public String altId;
}
