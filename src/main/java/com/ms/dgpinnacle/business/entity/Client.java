package com.ms.dgpinnacle.business.entity;
// Generated 19-03-2024 15:48:26 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Client generated by hbm2java
 */
@Entity
@Table(schema = "public", name = "client")
public class Client implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String cellphone;
	private String email;
	private String lastName;
	private String mailingAdd;
	private String name;
	private Set<ClientOperation> clientOperations = new HashSet<ClientOperation>(0);
	private Set<LoanClient> loanClients = new HashSet<LoanClient>(0);

	public Client() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "cellphone", nullable = false, length = 40)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<ClientOperation> getClientOperations() {
		return this.clientOperations;
	}

	public void setClientOperations(Set<ClientOperation> clientOperations) {
		this.clientOperations = clientOperations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<LoanClient> getLoanClients() {
		return this.loanClients;
	}

	public void setLoanClients(Set<LoanClient> loanClients) {
		this.loanClients = loanClients;
	}

}
