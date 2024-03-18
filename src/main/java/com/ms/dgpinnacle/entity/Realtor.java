package com.ms.dgpinnacle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", name = "realtor")
public class Realtor implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "broker_company_id")
    private BrokerCompany brokerCompany;

    @Column(name = "cellphone", nullable = false, length = 20)
    private String cellphone;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "last_name", nullable = false, length = 40)
    private String lastName;

    @Column(name = "license_number", nullable = false, length = 20)
    private String licenseNumber;

    @Column(name = "mailing_add", length = 500)
    private String mailingAdd;

    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Column(name = "notes", nullable = false, length = 500)
    private String notes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "realtor")
    private Set<CompanyRealtor> companyRealtors = new HashSet<>(0);

}
