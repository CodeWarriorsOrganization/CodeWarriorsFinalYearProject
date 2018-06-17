package com.codewarriors.db;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.codewarriors.entities.Bank;
import com.codewarriors.entities.Transaction;
import com.codewarriors.repositories.BankRepo;
import com.codewarriors.repositories.TransactionRepo;

@Service
@Transactional
public class BrokerService {
	
	private final BankRepo bankRepository;
	private final TransactionRepo transactionRepo;

	public BrokerService(BankRepo bankRepository, TransactionRepo transactionRepo) {
		this.bankRepository = bankRepository;
		this.transactionRepo = transactionRepo;

	}

	public void createBankAccount(Bank bank) {
		bankRepository.save(bank);
	}

	public void createTransaction(Transaction transaction) {

		transactionRepo.save(transaction);

	}

	public Bank findByType(String type) {
		return bankRepository.findByType(type);

	}

	public Bank findByPName(String pName) {
		return bankRepository.findByPName(pName);

	}

	public Bank findByPnameAndType(String pName, String type) {

		return bankRepository.findByPNameAndType(pName, type);

	}
}
