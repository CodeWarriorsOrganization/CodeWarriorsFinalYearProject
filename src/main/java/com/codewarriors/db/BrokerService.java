package com.codewarriors.db;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.repository.query.Param;
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
	public Transaction findByPlayerName(String pName) {
		return transactionRepo.findByPlayerName(pName);

	}
	public Bank findByPnameAndType(String pName, String type) {

		return bankRepository.findByPNameAndType(pName, type);

	}
	
	public Bank getLastRecordByPlayer(String pName) {
		
		return bankRepository.findTop1ByPNameOrderByBankIDDesc(pName);
		
	}
	
	public List<Transaction> findAllByPlayerName(String name) {
		
		List<Transaction> players = new ArrayList<Transaction>();
		for (Transaction player : transactionRepo.findAll()) {
			players.add(player);
		}
		
		return players;
		}
	
	
	public List<Bank> findAllByPName(String name) {
		
		List<Bank> players = new ArrayList<Bank>();
		for (Bank player : bankRepository.findAll()) {
			players.add(player);
		}
		
		return players;
		
	}
	
	
	public List<String> findDistinctCompanies(String playerName){
		
		
		
		List<String> players = new ArrayList<String>();
		
		for (String player : transactionRepo.findDistinctCompanies(playerName) ) {
			players.add(player);
		}
		
		return players;

		
	}
	 public List<Transaction> findDistinctCompaniesWithType(@Param("playerName") String playerName,@Param("compName") String compName,@Param("type") String type ){
		
		 List<Transaction> trades = new ArrayList<Transaction>();
			
			for (Transaction player : transactionRepo.findDistinctCompaniesWithType(playerName,compName,type) ) {
				trades.add(player);
			}
			
			return trades;

	 }
	
	 public List<Transaction> findRecordByPlayer(@Param("playerName") String playerName){
		 
		 List<Transaction> trades = new ArrayList<Transaction>();
			
			for (Transaction player : transactionRepo.findRecordByPlayer(playerName) ) {
				trades.add(player);
			}
			
			return trades;
		 
	 }
 public List<Bank> findBankRecordByPlayer(@Param("pName") String pName){
		 
		 List<Bank> bankTransactions = new ArrayList<Bank>();
			
			for (Bank record : bankRepository.findBankRecordByPlayer(pName) ) {
				bankTransactions.add(record);
			}
			
			return bankTransactions;
		 
	 }
 public List<Transaction> findRecordByType(@Param("type") String type){
	 
	 List<Transaction> bankTransactions = new ArrayList<Transaction>();
		
		for (Transaction record : transactionRepo.findRecordByType(type) ) {
			bankTransactions.add(record);
		}
		
		return bankTransactions;
	 
	 
	 
	 
 }
	
}
