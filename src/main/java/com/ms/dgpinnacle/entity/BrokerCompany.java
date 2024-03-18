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
@Table(schema = "public", name = "broker_company")
public class BrokerCompany implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @Column(name = "physical_add", nullable = false, length = 50)
    private String physicalAdd;

    @Column(name = "web_site", length = 500)
    private String webSite;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brokerCompany")
    private Set<Realtor> realtors = new HashSet<>(0);

}
