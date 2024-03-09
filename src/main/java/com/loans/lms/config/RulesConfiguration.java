package com.loans.lms.config;

import com.loans.lms.rules.HomeLoanRule;
import com.loans.lms.rules.MedicalLoanRule;
import com.loans.lms.rules.PersonalLoanRule;
import com.loans.lms.rules.VehicleLoanRule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.RulesEngineBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RulesConfiguration {

    @Bean
    public Rules homeLoan() {
        Rules rules = new Rules();
        HomeLoanRule homeLoanRule = new HomeLoanRule();
        rules.register(homeLoanRule);
        return rules;
    }

    @Bean
    public Rules personal() {
        PersonalLoanRule personalLoanRule= new PersonalLoanRule();
        Rules rules = new Rules();
        rules.register(personalLoanRule);
        return rules;
    }

    @Bean
    public Rules medical() {
        MedicalLoanRule medicalLoanRule = new MedicalLoanRule();
        Rules rules = new Rules();
        rules.register(medicalLoanRule);
        return rules;
    }

    @Bean
    public Rules vehicle() {
        VehicleLoanRule vehicleLoanRule = new VehicleLoanRule();
        Rules rules = new Rules();
        rules.register(vehicleLoanRule);
        return rules;
    }

    @Bean
    public RulesEngine rulesEngine() {
        return RulesEngineBuilder.aNewRulesEngine().build();
    }
}
