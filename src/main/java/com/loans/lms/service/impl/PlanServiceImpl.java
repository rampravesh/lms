package com.loans.lms.service.impl;

import com.loans.lms.dto.BaseInterestRatesDTO;
import com.loans.lms.dto.LoanPlansDTO;
import com.loans.lms.dto.RuleDTO;
import com.loans.lms.entities.BaseInterestRates;
import com.loans.lms.entities.LoanPlans;
import com.loans.lms.enums.LoanType;
import com.loans.lms.repository.BaseInterestRatesRepository;
import com.loans.lms.repository.LoanPlansRepository;
import com.loans.lms.service.PlanService;
import com.loans.lms.service.RuleService;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PlanServiceImpl implements PlanService {
    @Autowired
    private BaseInterestRatesRepository baseInterestRatesRepository;

    @Autowired
    private LoanPlansRepository loanPlansRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RuleService ruleService;

    @Override
    public List<BaseInterestRatesDTO> getAllInterestRates() {
//        log.info("getAllInterestRates started");
        List<BaseInterestRates> baseInterestRates = baseInterestRatesRepository.findAll();
        List<BaseInterestRatesDTO> baseInterestRatesDTOS = baseInterestRates.stream().map(item -> modelMapper.map(item,
                BaseInterestRatesDTO.class)).collect(Collectors.toList());
//        log.info("getAllInterestRates completed");
        return baseInterestRatesDTOS;
    }

    @Override
    public List<LoanPlansDTO> getLoanPlans() {
        List<LoanPlans> loanPlans = loanPlansRepository.findAll();
        List<LoanPlansDTO> loanPlansDTOS = loanPlans.stream().map(item -> modelMapper.map(item,
                LoanPlansDTO.class)).collect(Collectors.toList());
        return loanPlansDTOS;
    }

    @Override
    public LoanPlansDTO getLoanPlan(Integer loanId) {
        LoanPlansDTO loanPlansDTO = null;
        LoanPlans loanPlan = loanPlansRepository.findById(loanId).get();
        loanPlansDTO = modelMapper.map(loanPlan, LoanPlansDTO.class);
        return loanPlansDTO;
    }

    @Override
    public LoanPlansDTO update(Integer loanId, LoanPlansDTO loanPlansDTO) {
        LoanPlansDTO updatedPlanDto = null;
        LoanPlans loanPlan = loanPlansRepository.findById(loanId).get();
        //TODO update loanPlan other feild
        loanPlan.setPlanName(loanPlansDTO.getPlanName());
        loanPlan = modelMapper.map(loanPlansDTO, LoanPlans.class);
        log.info("update plan rate : {}",loanPlan.getInterestRate());
        float newRate = ruleService.getBaseRate(RuleDTO.builder().interestRate(loanPlansDTO.getInterestRate())
                .principleAmount(loanPlansDTO.getPrincipleAmount()).tenure(loanPlansDTO.getTenure())
                .loanType(LoanType.valueOfLabel(loanPlansDTO.getLoanTypeId())).build());
        log.info("update plan new rate : {}",newRate);
        loanPlan.setInterestRate(newRate);
        loanPlan = loanPlansRepository.save(loanPlan);
        updatedPlanDto = modelMapper.map(loanPlan, LoanPlansDTO.class);
        return loanPlansDTO;
    }

    @Override
    public LoanPlansDTO create(LoanPlansDTO loanPlansDTO) {
        LoanPlansDTO updatedPlanDto = null;
        LoanPlans loanPlan = new LoanPlans();
        loanPlan = modelMapper.map(loanPlansDTO, LoanPlans.class);
        log.info("create plan rate : {}",loanPlan.getInterestRate());
        float newRate = ruleService.getBaseRate(RuleDTO.builder().interestRate(loanPlansDTO.getInterestRate())
                .principleAmount(loanPlansDTO.getPrincipleAmount()).tenure(loanPlansDTO.getTenure())
                .loanType(LoanType.valueOfLabel(loanPlansDTO.getLoanTypeId())).build());
        log.info("create plan new rate : {}",newRate);
        loanPlan.setInterestRate(newRate);
        loanPlan = loanPlansRepository.save(loanPlan);
        updatedPlanDto = modelMapper.map(loanPlan, LoanPlansDTO.class);
        return updatedPlanDto;
    }

}