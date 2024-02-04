package com.loans.lms.repository;

import com.loans.lms.entities.BaseInterestRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BaseInterestRatesRepository extends JpaRepository<BaseInterestRates, Integer>, JpaSpecificationExecutor<BaseInterestRates> {

}