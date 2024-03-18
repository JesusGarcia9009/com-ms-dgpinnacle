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
@Table(schema = "public", name = "operation")
public class Operation implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "name", nullable = false, length = 36)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "operation")
    private Set<LoanClientOperation> loanClientOperations = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "operation")
    private Set<LetterConfig> letterConfigs = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "operation")
    private Set<CompanyRealtorOperation> companyRealtorOperations = new HashSet<>(0);

}
