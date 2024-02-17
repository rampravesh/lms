package com.loans.lms.service.impl;

import com.loans.lms.dto.LoanPlansDTO;
import com.loans.lms.entities.BaseInterestRates;
import com.loans.lms.entities.LoanPlans;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {
    public static List<BaseInterestRates> getBaseInterestRates() {
        List<BaseInterestRates> baseInterestRates = new ArrayList<>();
        baseInterestRates.add(getBaseRate(8.5,"Home"));
        baseInterestRates.add(getBaseRate(7.5,"Personal"));
        return baseInterestRates;
    }

    private static BaseInterestRates getBaseRate(double rate, String name) {
        BaseInterestRates baseInterestRates= new BaseInterestRates();
        baseInterestRates.setBaseInterestRate((float) rate);
        baseInterestRates.setLoanType(name);
        return null;
    }

    public static List<BaseInterestRates> getBaseInterestEmptyRates() {
        List<BaseInterestRates> baseInterestRates = new ArrayList<>();
        return baseInterestRates;
    }


    public static List<LoanPlans> getLoanPlans() {
        List<LoanPlans> loanPlans = new ArrayList<>();
        loanPlans.add(getLoanPlan(123,"test"));
        return loanPlans;
    }

    private static LoanPlans getLoanPlan(int id, String planName) {
        LoanPlans plans = new LoanPlans();
        plans.setPlanId(id);
        plans.setPlanName(planName);
        return plans;
    }


    public static List<LoanPlans> getLoanEmptyPlans() {
        List<LoanPlans> o = new ArrayList<>();
        return o;
    }
}
