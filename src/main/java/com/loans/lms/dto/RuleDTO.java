package com.loans.lms.dto;

import com.loans.lms.enums.LoanType;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class RuleDTO {
    private Integer principleAmount;

    private Integer tenure;

    private Float interestRate;

    private LoanType loanType;
}
