package com.loans.lms.controllers;


import com.loans.lms.constants.ControllerConstants;
import com.loans.lms.dto.BaseInterestRatesDTO;
import com.loans.lms.dto.LoanPlansDTO;
import com.loans.lms.service.PlanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ControllerConstants.BASE_URL)
public class PlanController {
    @Autowired
    private PlanService planService;

    @GetMapping("/check")
    public String check(){
        return "hello";
    }

    /***
     * Get all interest rates
     * @return
     */
    @RequestMapping(value = ControllerConstants.INTEREST_RATES,method = RequestMethod.GET)
    public List<BaseInterestRatesDTO> getAllInerestRates(){
        return planService.getAllInterestRates();
    }

    /***
     * Get all loan plan
     * @return
     */
    @RequestMapping(value = ControllerConstants.LOAN_PLANS,method = RequestMethod.GET)
    public List<LoanPlansDTO> getLoanPlans(){
        return planService.getLoanPlans();
    }

    /***
     * Get loanPlan by id
     * @param loanId
     * @return
     */
    @RequestMapping(value = ControllerConstants.GET_LOAN_PLANS_BY_ID,method = RequestMethod.GET)
    public LoanPlansDTO getLoanPlans(@PathVariable(name="loanId") Integer loanId){
        return planService.getLoanPlan(loanId);
    }

    /***
     * Update existing loan plan
     * @param loanId
     * @param loanPlansDTO
     * @return
     */
    @RequestMapping(value = ControllerConstants.GET_LOAN_PLANS_BY_ID,method = RequestMethod.PUT)
    public LoanPlansDTO updateLoanPlan(@PathVariable(name="loanId") Integer loanId,
                                       @Valid @RequestBody(required = true) LoanPlansDTO loanPlansDTO){
        return planService.update(loanId,loanPlansDTO);
    }

    /***
     * Create new loan plan using this dto
     * @param loanPlansDTO
     * @return
     */
    @RequestMapping(value = ControllerConstants.LOAN_PLANS,method = RequestMethod.POST)
    public LoanPlansDTO updateLoanPlan(@Valid @RequestBody(required = true) LoanPlansDTO loanPlansDTO){
        return planService.create(loanPlansDTO);
    }
}
