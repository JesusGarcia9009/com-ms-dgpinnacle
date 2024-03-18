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
@Table(schema = "public", name = "letter_fixdata")
public class LetterFixData implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "conditions", nullable = false, length = 500)
    private String conditions;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    @Column(name = "finaltext", nullable = false, length = 500)
    private String finaltext;

    @Column(name = "subject", nullable = false, length = 500)
    private String subject;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "letterFixdata")
    private Set<LetterConfig> letterConfigs = new HashSet<>(0);

}
