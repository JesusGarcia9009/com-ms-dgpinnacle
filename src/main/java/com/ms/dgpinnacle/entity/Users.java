package com.ms.dgpinnacle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", name = "users")
public class Users implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile", nullable = false)
    private Profile profile;

    @Column(name = "social_security_number", length = 50)
    private String socialSecurityNumber;

    @Column(name = "names", nullable = false, length = 50)
    private String names;

    @Column(name = "middle_name", nullable = false, length = 50)
    private String middleName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "mail", nullable = false, length = 50)
    private String mail;

    @Column(name = "business_position", length = 50)
    private String businessPosition;

    @Column(name = "username", nullable = false, length = 200)
    private String username;

    @Column(name = "pass", nullable = false, length = 200)
    private String pass;

}
