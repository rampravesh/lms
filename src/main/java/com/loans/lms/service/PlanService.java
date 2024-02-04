package com.loans.lms.service;

import com.loans.lms.dto.BaseInterestRatesDTO;
import com.loans.lms.dto.LoanPlansDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface PlanService {
    List<BaseInterestRatesDTO> getAllInterestRates();

    List<LoanPlansDTO> getLoanPlans();

    LoanPlansDTO getLoanPlan(Integer loanId);

    LoanPlansDTO update(Integer loanId, LoanPlansDTO loanPlansDTO);

    LoanPlansDTO create(LoanPlansDTO loanPlansDTO);
}
