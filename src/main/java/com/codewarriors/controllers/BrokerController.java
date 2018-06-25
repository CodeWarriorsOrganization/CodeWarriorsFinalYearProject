package com.codewarriors.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.codewarriors.db.BrokerService;
import com.codewarriors.db.HistoricalWinnerService;
import com.codewarriors.entities.Bank;
import com.codewarriors.entities.HistoricalWinners;
import com.codewarriors.entities.Transaction;
import com.codewarriors.models.Company;
import com.codewarriors.models.TransactionHistory;
import com.codewarriors.services.CompanyService;

@RestController
public class BrokerController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private BrokerService brokerService;
	

	@Autowired
	private HistoricalWinnerService  winnerService;


	@RequestMapping(value = "/displayDetails")
	public Company create(@RequestParam String cName, HttpServletRequest request, HttpServletResponse response,
			Model model) {

		Company c = new Company();
		c = companyService.getCompanyDetails(cName);

		return c;
	}

	@RequestMapping(value = "/saveDetails")
	public String createAccounts(@RequestParam String pName, String cName, String turnNo, String type, String unitPrice,
			String quantity, String amount, String balance, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		String type2 = "";

		int turnNo1 = Integer.parseInt(turnNo);
		double unitPrice1 = Double.parseDouble(unitPrice);
		int quantity1 = Integer.parseInt(quantity);
		double amount1 = Double.parseDouble(amount);
		double balance1 = Double.parseDouble(balance);
		Company c = new Company();
		c = companyService.getCompanyDetails(cName);
		System.out.println(cName);
		System.out.println(c.getCompanyName());

		switch (type) {
		case "BUY":
			type2 = "Withdraw";
			break;
		case "SELL":
			type2 = "Deposit";
			break;

		}

		Bank bank = new Bank(pName, turnNo1, type2, amount1, balance1);
		Transaction transaction = new Transaction(pName, turnNo1, type, cName, unitPrice1, quantity1, amount1);
		brokerService.createBankAccount(bank);
		brokerService.createTransaction(transaction);

		return "SUCCESS";

	}

	@RequestMapping(value = "/getPlayerDetails")
	public List<TransactionHistory> returnPlayerDetails(@RequestParam String pName, String balance, String returns) {

		List<Transaction> transactionRecordsSell = new ArrayList<Transaction>();
		List<Transaction> transactionRecordsBuy = new ArrayList<Transaction>();
		List<String> companyNames = brokerService.findDistinctCompanies(pName);
		List<TransactionHistory> transRecords = new ArrayList<TransactionHistory>();

		for (int i = 0; i < companyNames.size(); i++) {

			transactionRecordsSell = brokerService.findDistinctCompaniesWithType(pName, companyNames.get(i), "SELL");
			transactionRecordsBuy = brokerService.findDistinctCompaniesWithType(pName, companyNames.get(i), "BUY");
			double allBoughtSharePrices = 0;
			double allSoldSharePrices = 0;
			double allBoughtAmount = 0;
			double allSoldAmount = 0;
			int soldQuantity = 0;
			int boughtQuantity = 0;
			for (int k = 0; k < transactionRecordsSell.size(); k++) {

				allSoldSharePrices = allSoldSharePrices + transactionRecordsSell.get(k).getCost();
				soldQuantity = soldQuantity + transactionRecordsSell.get(k).getQuantity();
				allSoldAmount = allSoldAmount + transactionRecordsSell.get(k).getCost();

			}
			for (int j = 0; j < transactionRecordsBuy.size(); j++) {

				allBoughtSharePrices = allBoughtSharePrices + transactionRecordsBuy.get(j).getCost();
				boughtQuantity = boughtQuantity + transactionRecordsBuy.get(j).getQuantity();
				allBoughtAmount = allBoughtAmount + transactionRecordsBuy.get(j).getCost();
			}

			int StockValueInHand = boughtQuantity - soldQuantity;
			double lossOrGain = allSoldAmount - allBoughtAmount;
			TransactionHistory t1 = new TransactionHistory(companyNames.get(i), allBoughtSharePrices,
					allSoldSharePrices, lossOrGain, StockValueInHand, boughtQuantity, soldQuantity);
			transRecords.add(t1);

		}

		return transRecords;

	}

	@RequestMapping(value = "/getPlayerDetailsHeader")
	public String[] DetailsBody(@RequestParam String pName, String balance, String returns, String rank) {

		String[] playerProfile = new String[4];
		playerProfile[0] = pName;
		playerProfile[1] = balance;
		playerProfile[2] = returns;
		playerProfile[3] = rank;
		return playerProfile;

	}

	@RequestMapping(value = "/getTransaction")
	public List<Transaction> TransactionDetails(@RequestParam String pName) {

		List<Transaction> getPlayerRows = new ArrayList<Transaction>();

		getPlayerRows = brokerService.findRecordByPlayer(pName);
		return getPlayerRows;

	}

	@RequestMapping(value = "/getBankDetails")
	public List<Bank> bankDetails(@RequestParam String pName) {

		List<Bank> getPlayerRows = new ArrayList<Bank>();

		getPlayerRows = brokerService.findBankRecordByPlayer(pName);

		for (int i = 0; i < getPlayerRows.size(); i++) {

			System.out.println(getPlayerRows.get(i).getpName());
			System.out.println(getPlayerRows.get(i).getTurnNo());
			System.out.println(getPlayerRows.get(i).getType());
			System.out.println(getPlayerRows.get(i).getBalance());
			System.out.println(getPlayerRows.get(i).getBalance());

		}

		return getPlayerRows;

	}
	
	@RequestMapping(value = "/getWinnerHistory",method = RequestMethod.GET)
	public List<HistoricalWinners> winnerHistoryDetails() {

		List<HistoricalWinners> winnerList = new ArrayList<HistoricalWinners>();

		winnerList = winnerService.getAllWinners();
		
	    return winnerList;
		

	}

}
