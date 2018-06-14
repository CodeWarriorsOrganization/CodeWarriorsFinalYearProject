package com.codewarriors.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewarriors.entities.Bank;

@Repository
public interface BankRepo extends JpaRepository<Bank, Integer> {

	Bank findByType(String type);

	Bank findByPName(String pName);

	Bank findByPNameAndType(String pName, String type);

}
