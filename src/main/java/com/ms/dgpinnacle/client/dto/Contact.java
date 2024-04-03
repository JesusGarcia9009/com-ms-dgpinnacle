package com.ms.dgpinnacle.client.dto;




import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Contact{
    public String contactType;
    public String contactTitle;
    public String email;
    public String fax;
    public String loginId;
    public String name;
    public String phone;
    public String address;
    public String city;
    public String companyId;
    public String fhaLenderId;
    public String postalCode;
    public String state;
    public String license;
    public String nmlsLicense;
    public String lenderType;
    public String licenseType;
    public boolean licenseExempt;
    public String bizLicenseNumber;
    public String cell;
    public String contactName;
    public String personalLicenseNumber;
    public ContactRef contactRef;
    public String relationship;
    public int customContactIndex;
    public String categoryName;
    public String clause;
}
