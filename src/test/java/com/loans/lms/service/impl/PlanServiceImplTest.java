package com.loans.lms.service.impl;

import com.loans.lms.dto.BaseInterestRatesDTO;
import com.loans.lms.dto.LoanPlansDTO;
import com.loans.lms.entities.LoanPlans;
import com.loans.lms.repository.BaseInterestRatesRepository;
import com.loans.lms.repository.LoanPlansRepository;
import com.loans.lms.service.RuleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

@ContextConfiguration(classes = {PlanServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PlanServiceImplTest {
    @MockBean
    private BaseInterestRatesRepository baseInterestRatesRepository;

    @MockBean
    private LoanPlansRepository loanPlansRepository;

    @MockBean
    private RuleService ruleService;

    @MockBean
    private ModelMapper modelMapper;

    @Autowired
    private PlanServiceImpl planServiceImpl;



    /**
     * Method under test: {@link PlanServiceImpl#getAllInterestRates()}
     */
    @Test
    void testGetAllInterestRates() {
        Mockito.when(baseInterestRatesRepository.findAll()).thenReturn(DataUtils.getBaseInterestRates());
        List<BaseInterestRatesDTO> allInterestRates = this.planServiceImpl.getAllInterestRates();
        Assertions.assertEquals(2,allInterestRates.size());
    }

    /**
     * Method under test: {@link PlanServiceImpl#getAllInterestRates()}
     */
    @Test
    void testGetAllInterestRates2() {
        Mockito.when(baseInterestRatesRepository.findAll()).thenReturn(DataUtils.getBaseInterestEmptyRates());
        List<BaseInterestRatesDTO> allInterestRates = this.planServiceImpl.getAllInterestRates();
        Assertions.assertEquals(0,allInterestRates.size());
    }

    /**
     * Method under test: {@link PlanServiceImpl#getLoanPlans()}
     */
    @Test
    void testGetLoanPlans() {
        Mockito.when(loanPlansRepository.findAll()).thenReturn(DataUtils.getLoanPlans());
        List<LoanPlansDTO> loanPlans = this.planServiceImpl.getLoanPlans();
        Assertions.assertEquals(1,loanPlans.size());
    }

    /**
     * Method under test: {@link PlanServiceImpl#getLoanPlans()}
     */
    @Test
    void testGetLoanPlans2() {
        Mockito.when(loanPlansRepository.findAll()).thenReturn(DataUtils.getLoanEmptyPlans());
        List<LoanPlansDTO> loanPlans = this.planServiceImpl.getLoanPlans();
        Assertions.assertEquals(0,loanPlans.size());
    }

    /**
     * Method under test: {@link PlanServiceImpl#getLoanPlan(Integer)}
     */
    @Test
    void testGetLoanPlan() {
        Mockito.when(loanPlansRepository.findAll()).thenReturn(DataUtils.getLoanPlans());
        List<LoanPlansDTO> loanPlans = this.planServiceImpl.getLoanPlans();
        Assertions.assertNotNull(loanPlans);
    }

    /**
     * Method under test: {@link PlanServiceImpl#getLoanPlan(Integer)}
     */
    @Test
    void testGetLoanPlan2() {
        Mockito.when(loanPlansRepository.findAll()).thenReturn(DataUtils.getLoanEmptyPlans());
        List<LoanPlansDTO> loanPlans = this.planServiceImpl.getLoanPlans();
        Assertions.assertEquals(0,loanPlans.size());
    }

    /**
     * Method under test: {@link PlanServiceImpl#update(Integer, LoanPlansDTO)}
     */
    @Test
    void testUpdate() {
        LoanPlansDTO loanPlansDTO = new LoanPlansDTO();
        loanPlansDTO.setEmi(10.0f);
        loanPlansDTO.setInterestAmount(1);
        loanPlansDTO.setInterestRate(10.0f);
        loanPlansDTO.setLoanTypeId(123);
        loanPlansDTO.setPlanAddedOn(mock(Date.class));
        loanPlansDTO.setPlanId(123);
        loanPlansDTO.setPlanName("Plan Name");
        loanPlansDTO.setPlanValidity(mock(Date.class));
        loanPlansDTO.setPrincipleAmount(1);
        loanPlansDTO.setTenure(1);
        loanPlansDTO.setTotalPayable(1);
        LoanPlans loanPlans = Optional.ofNullable(DataUtils.getLoanPlans().get(0)).get();
        Mockito.when(loanPlansRepository.save(loanPlans)).thenReturn(loanPlans);
        Mockito.when(modelMapper.map(loanPlansDTO, LoanPlans.class)).thenReturn(loanPlans);
        Mockito.when( modelMapper.map(loanPlans, LoanPlansDTO.class)).thenReturn(loanPlansDTO);
        Mockito.when(loanPlansRepository.findById(123)).thenReturn(java.util.Optional.ofNullable(DataUtils.getLoanPlans().get(0)));
        Mockito.when(ruleService.getBaseRate(any())).thenReturn(5.5f);
        LoanPlansDTO update = this.planServiceImpl.update(123, loanPlansDTO);
        Assertions.assertEquals(loanPlansDTO.getPlanId(),update.getPlanId());
    }



    /**
     * Method under test: {@link PlanServiceImpl#create(LoanPlansDTO)}
     */
    @Test
    void testCreate() {
        LoanPlansDTO loanPlansDTO = new LoanPlansDTO();
        loanPlansDTO.setEmi(10.0f);
        loanPlansDTO.setInterestAmount(1);
        loanPlansDTO.setInterestRate(10.0f);
        loanPlansDTO.setLoanTypeId(123);
        loanPlansDTO.setPlanAddedOn(mock(Date.class));
        loanPlansDTO.setPlanId(123);
        loanPlansDTO.setPlanName("Plan Name");
        loanPlansDTO.setPlanValidity(mock(Date.class));
        loanPlansDTO.setPrincipleAmount(1);
        loanPlansDTO.setTenure(1);
        loanPlansDTO.setTotalPayable(1);
        LoanPlans loanPlans = Optional.ofNullable(DataUtils.getLoanPlans().get(0)).get();
        Mockito.when(loanPlansRepository.save(loanPlans)).thenReturn(loanPlans);
        Mockito.when(modelMapper.map(loanPlansDTO, LoanPlans.class)).thenReturn(loanPlans);
        Mockito.when( modelMapper.map(loanPlans, LoanPlansDTO.class)).thenReturn(loanPlansDTO);
        LoanPlansDTO plansDTO = this.planServiceImpl.create(loanPlansDTO);
        Assertions.assertEquals(loanPlansDTO.getPlanId(),plansDTO.getPlanId());
    }

}

