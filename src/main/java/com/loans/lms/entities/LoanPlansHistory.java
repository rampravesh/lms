package com.loans.lms.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
@Entity
@Table(name = "LoanPlansHistory")
public class LoanPlansHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "UpdateDate")
    private Date updateDate;

    @Column(name = "UpdateReason")
    private String updateReason;

//    @Column(name = "LoanPlanId")
//    private Integer loanPlanId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "LoanPlanId",referencedColumnName = "PlanId")
    private LoanPlans loanPlans;
}
