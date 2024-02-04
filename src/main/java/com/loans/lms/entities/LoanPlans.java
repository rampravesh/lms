package com.loans.lms.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "LoanPlans")
public class LoanPlans implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PlanId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planId;

    @Column(name = "PlanName")
    private String planName;

    @Column(name = "LoanTypeId")
    private Integer loanTypeId;

    @Column(name = "PrincipleAmount")
    private Integer principleAmount;

    @Column(name = "Tenure")
    private Integer tenure;

    @Column(name = "InterestRate")
    private Float interestRate;

    @Column(name = "InterestAmount")
    private Integer interestAmount;

    @Column(name = "TotalPayable")
    private Integer totalPayable;

    @Column(name = "EMI")
    private Float emi;

    @Column(name = "PlanValidity")
    private Date planValidity;

    @Column(name = "PlanAddedOn")
    private Date planAddedOn;

//    @ManyToOne(
//            fetch = FetchType.LAZY,
//            cascade = {CascadeType.ALL}
//    )
//    @JoinColumn(
//            name = "LoanTypeId",
//            referencedColumnName = "id"
//    )
//    private BaseInterestRates baseInterestRate;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "loanPlans",cascade = {CascadeType.PERSIST})
    private List<LoanPlansHistory> loanPlansHistories = new ArrayList();
}
