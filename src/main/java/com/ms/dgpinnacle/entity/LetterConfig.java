package com.ms.dgpinnacle.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", name = "letter_config")
public class LetterConfig implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "letter_fix_data_id")
    private LetterFixData letterFixdata;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_id")
    private Operation operation;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "deleted")
    private Boolean deleted;

    @Column(name = "hoa", nullable = false, precision = 17, scale = 17)
    private double hoa;

    @Column(name = "insurance", nullable = false, precision = 17, scale = 17)
    private double insurance;

    @Column(name = "interest", nullable = false, precision = 17, scale = 17)
    private double interest;

    @Column(name = "loan_amount", precision = 17, scale = 17)
    private Double loanAmount;

    @Column(name = "loan_term", nullable = false)
    private int loanTerm;

    @Column(name = "loan_type", nullable = false, length = 500)
    private String loanType;

    @Column(name = "location", nullable = false, length = 500)
    private String location;

    @Column(name = "ltv", nullable = false, precision = 17, scale = 17)
    private double ltv;

    @Column(name = "max_pay", nullable = false, precision = 17, scale = 17)
    private double maxPay;

    @Column(name = "mi", precision = 17, scale = 17)
    private Double mi;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "taxes", nullable = false, precision = 17, scale = 17)
    private double taxes;

    @Column(name = "unique_key", length = 250)
    private String uniqueKey;

}
