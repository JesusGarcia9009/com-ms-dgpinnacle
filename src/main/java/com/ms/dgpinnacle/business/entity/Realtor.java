package com.ms.dgpinnacle.business.entity;
// Generated 19-03-2024 15:48:26 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Realtor generated by hbm2java
 */
@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(schema = "public", name = "realtor")
public class Realtor extends Users implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BrokerCompany brokerCompany;
	private String cellphone;
	private String email;
	private String lastName;
	private String licenseNumber;
	private String mailingAdd;
	private String name;
	private String notes;
	private Set<RealtorOperation> realtorOperations = new HashSet<RealtorOperation>(0);

	public Realtor() {
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "broker_company_id")
	public BrokerCompany getBrokerCompany() {
		return this.brokerCompany;
	}

	public void setBrokerCompany(BrokerCompany brokerCompany) {
		this.brokerCompany = brokerCompany;
	}

	@Column(name = "cellphone", nullable = false, length = 20)
	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "last_name", nullable = false, length = 40)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "license_number", nullable = false, length = 20)
	public String getLicenseNumber() {
		return this.licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	@Column(name = "mailing_add", length = 500)
	public String getMailingAdd() {
		return this.mailingAdd;
	}

	public void setMailingAdd(String mailingAdd) {
		this.mailingAdd = mailingAdd;
	}

	@Column(name = "name", nullable = false, length = 40)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "notes", nullable = false, length = 500)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "realtor")
	public Set<RealtorOperation> getRealtorOperations() {
		return this.realtorOperations;
	}

	public void setRealtorOperations(Set<RealtorOperation> realtorOperations) {
		this.realtorOperations = realtorOperations;
	}

}
