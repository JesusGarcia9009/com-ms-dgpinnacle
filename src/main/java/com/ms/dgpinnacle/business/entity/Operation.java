package com.ms.dgpinnacle.business.entity;
// Generated 19-03-2024 15:48:26 by Hibernate Tools 4.3.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Operation generated by hbm2java
 */
@Entity
@Table(schema = "public", name = "operation")
public class Operation implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private LoanOfficer loanOfficer;
	private String name;
	private String updateUser;
	private Date updateDate;
	private Set<ClientOperation> clientOperations = new HashSet<ClientOperation>(0);
	private Set<LetterConfig> letterConfigs = new HashSet<LetterConfig>(0);
	private Set<RealtorOperation> realtorOperations = new HashSet<RealtorOperation>(0);

	public Operation() {
	}
	
	public Operation(String name, String updateUser, Date updateDate) {
		super();
		this.name = name;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "loan_id", nullable = false)
	public LoanOfficer getLoanOfficer() {
		return this.loanOfficer;
	}

	public void setLoanOfficer(LoanOfficer loanOfficer) {
		this.loanOfficer = loanOfficer;
	}

	@Column(name = "name", nullable = false, length = 36)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "update_user", nullable = false, length = 50)
	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", nullable = false, length = 29)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "operation")
	public Set<ClientOperation> getClientOperations() {
		return this.clientOperations;
	}

	public void setClientOperations(Set<ClientOperation> clientOperations) {
		this.clientOperations = clientOperations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "operation")
	public Set<LetterConfig> getLetterConfigs() {
		return this.letterConfigs;
	}

	public void setLetterConfigs(Set<LetterConfig> letterConfigs) {
		this.letterConfigs = letterConfigs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "operation")
	public Set<RealtorOperation> getRealtorOperations() {
		return this.realtorOperations;
	}

	public void setRealtorOperations(Set<RealtorOperation> realtorOperations) {
		this.realtorOperations = realtorOperations;
	}

}
