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
@Table(schema = "public", name = "company")
public class Company implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "mailing_add", nullable = false, length = 50)
    private String mailingAdd;

    @Column(name = "name", nullable = false, length = 36)
    private String name;

    @Column(name = "nmls", nullable = false, length = 500)
    private String nmls;

    @Column(name = "phisical_add", nullable = false, length = 50)
    private String phisicalAdd;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<CompanyRealtor> companyRealtors = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    private Set<LoanOfficer> loanOfficers = new HashSet<>(0);

}
