package com.codewarriors.db;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.codewarriors.entities.Bank;
import com.codewarriors.entities.Player;
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
	public Transaction findByPlayerName(String pName) {
		return transactionRepo.findByPlayerName(pName);

	}
	public Bank findByPnameAndType(String pName, String type) {

		return bankRepository.findByPNameAndType(pName, type);

	}
	
	public Bank getLastRecordByPlayer(String pName) {
		
		return bankRepository.findTop1ByPNameOrderByBankIDDesc(pName);
		
	}
	
	public Transaction findAllByPlayerName(String name) {
		
		return transactionRepo.findAllByPlayerName(name);
		}
	
	
	public List<Bank> findAllByPName(String name) {
		
		List<Bank> players = new ArrayList<Bank>();
		for (Bank player : bankRepository.findAll()) {
			players.add(player);
		}
		
		return players;
		
	}
	
	
}
