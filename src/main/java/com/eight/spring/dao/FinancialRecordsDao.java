package com.eight.spring.dao;

import com.eight.spring.util.FinancialRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialRecordsDao extends JpaRepository<FinancialRecords, Integer> {

}
