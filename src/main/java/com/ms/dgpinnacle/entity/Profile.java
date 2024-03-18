package com.ms.dgpinnacle.entity;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", name = "profile")
public class Profile implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "profile_name", nullable = false, length = 100)
    private String profileName;

    @Column(name = "description", length = 200)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profile")
    private Set<Users> userses = new HashSet<>(0);

}
