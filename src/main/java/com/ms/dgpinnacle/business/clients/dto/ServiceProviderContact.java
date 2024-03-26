package com.ms.dgpinnacle.business.clients.dto;




import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceProviderContact{
    public String id;
    public String altId;
    public String address;
    public String city;
    public String phone;
    public String postalCode;
    public String providerName;
    public String category;
    public String state;
    public ArrayList<ServiceProviderContactFee> serviceProviderContactFees;
}
