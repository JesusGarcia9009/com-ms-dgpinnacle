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
@Table(schema = "public", name = "loan_officer")
public class LoanOfficer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "cellphone", nullable = false, length = 20)
    private String cellphone;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "last_name", nullable = false, length = 36)
    private String lastName;

    @Column(name = "mailing_add", nullable = false, length = 75)
    private String mailingAdd;

    @Column(name = "name", nullable = false, length = 36)
    private String name;

    @Column(name = "nmls", nullable = false, length = 50)
    private String nmls;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loanOfficer")
    private Set<LoanClient> loanClients = new HashSet<LoanClient>(0);

}
