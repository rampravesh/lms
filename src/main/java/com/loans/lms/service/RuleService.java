package com.loans.lms.service;

import com.loans.lms.dto.RuleDTO;
import com.loans.lms.rules.HomeLoanRule;
import com.loans.lms.rules.MedicalLoanRule;
import com.loans.lms.rules.PersonalLoanRule;
import com.loans.lms.rules.VehicleLoanRule;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RuleService {
    @Autowired
    private RulesEngine rulesEngine;

    @Autowired
    public Rules homeLoan;

    @Autowired
    private Rules personal;

    @Autowired
    public Rules medical;

    @Autowired
    public Rules vehicle;

    public float getBaseRate(RuleDTO ruleDTO) {
        log.info("getBaseRate DTO : {}",ruleDTO);
        Facts facts = new Facts();
        facts.put("ruleDTO", ruleDTO);
        switch (ruleDTO.getLoanType()) {
            case NONE -> {
            }
            case Home -> {
                rulesEngine.fire(homeLoan,facts);
            }
            case PERSONAL -> {
                rulesEngine.fire(personal,facts);
            }
            case MEDICAL -> {
                rulesEngine.fire(medical,facts);
            }
            case VEHICLE -> {
                rulesEngine.fire(vehicle,facts);
            }
        }
        log.info("getBaseRate final DTO : {}",ruleDTO);
        return ruleDTO.getInterestRate();
    }
}
