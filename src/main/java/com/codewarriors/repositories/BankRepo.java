package com.codewarriors.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codewarriors.entities.Bank;
import com.codewarriors.entities.Transaction;

@Repository
public interface BankRepo extends JpaRepository<Bank, Integer> {

	Bank findByType(String type);

	Bank findByPName(String pName);

	Bank findByPNameAndType(String pName, String type);
    
//	@Query("SELECT p FROM BANK  WHERE p.pName = :pName ORDER BY BankID DESC LIMIT 1")
//	Bank getLastRecordByPlayer(String pName);
	
	Bank findTop1ByPNameOrderByBankIDDesc(String pName);
	List<Bank> findAllByPName(String pName);
	
	@Query("SELECT t FROM Bank t WHERE t.pName =:pName")
	List<Bank> findBankRecordByPlayer(@Param("pName") String pName);

	
}
