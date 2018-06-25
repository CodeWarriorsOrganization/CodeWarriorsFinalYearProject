package com.codewarriors.db;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.codewarriors.entities.Bank;
import com.codewarriors.entities.HistoricalWinners;
import com.codewarriors.entities.Transaction;
import com.codewarriors.repositories.BankRepo;
import com.codewarriors.repositories.HistoricalWinnersRepo;
import com.codewarriors.repositories.PlayerRepo;
import com.codewarriors.repositories.TransactionRepo;

@Service
@Transactional
public class HistoricalWinnerService {
	
	private final BankRepo bankRepository;
	private final TransactionRepo transactionRepo;
	private final PlayerRepo playerRepo;
	private final HistoricalWinnersRepo historicalWinnersRepo;
	
	public HistoricalWinnerService(BankRepo bankRepository, TransactionRepo transactionRepo,PlayerRepo playerRepo,HistoricalWinnersRepo historicalWinnersRepo) {
		this.bankRepository = bankRepository;
		this.transactionRepo = transactionRepo;
		this.playerRepo = playerRepo;
		this.historicalWinnersRepo = historicalWinnersRepo;

	}
	

	public void deleteAllBankRecords() {
		bankRepository.deleteAllInBatch();
	}

	public void deleteAllTransactionRecords() {
		transactionRepo.deleteAllInBatch();
	}
	public void deleteAllPlayers() {
		playerRepo.deleteAllInBatch();
	}
	
	public void saveWinner(HistoricalWinners HistoricalWinner) {
		
		historicalWinnersRepo.save(HistoricalWinner);
		
	}
	public List<HistoricalWinners> getAllWinners() {
		
		List<HistoricalWinners> winners = new ArrayList<HistoricalWinners>();
		for (HistoricalWinners winner : historicalWinnersRepo.findAll()) {
			winners.add(winner);
		}
		
		return winners;
	}
	
	
}
