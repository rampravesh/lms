package com.loans.lms.rules;

import com.loans.lms.dto.RuleDTO;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "HomeLoan", description = "principleAmount(5-20 lac) & tenue(5-10 years) then baseRate + 0.2")
public class HomeLoanRule {

    private static final float ADDITINAL_RATE = 0.3f;
    private Integer FIVE_LACS=500000;
    private Integer ONE_CR=10000000;

    @Condition
    public boolean isEligibleRate(@Fact("ruleDTO") RuleDTO ruleDTO) {
        return  amountCheck(ruleDTO) && tenueCheck(ruleDTO);
    }

    @Action
    public void setNewRate(@Fact("ruleDTO") RuleDTO ruleDTO) {
        ruleDTO.setInterestRate(Float.sum(ruleDTO.getInterestRate(),ADDITINAL_RATE));
    }

    private boolean tenueCheck(RuleDTO ruleDTO) {
        return ruleDTO.getTenure() > 5 && ruleDTO.getTenure()<30;
    }

    private boolean amountCheck(RuleDTO ruleDTO) {
        return ruleDTO.getPrincipleAmount()>FIVE_LACS && ruleDTO.getPrincipleAmount() < ONE_CR;
    }
}
