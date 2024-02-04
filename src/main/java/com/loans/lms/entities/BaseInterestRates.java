package com.loans.lms.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "BaseInterestRates")
public class BaseInterestRates implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "LoanType")
    private String loanType;

    @Column(name = "BaseInterestRate")
    private Float baseInterestRate;

}
