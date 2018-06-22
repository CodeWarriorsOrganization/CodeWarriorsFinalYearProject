package com.codewarriors.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codewarriors.db.BrokerService;
import com.codewarriors.entities.Bank;
import com.codewarriors.entities.Transaction;
import com.codewarriors.models.Company;
import com.codewarriors.services.CompanyService;

@RestController
public class BrokerController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private BrokerService brokerService;

	
	
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
		 String type2="";
		
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
			type2="Withdraw";
			break;
		case "SELL":
			type2="Deposit";
			break;
			
		}
		
		Bank bank = new Bank(pName, turnNo1, type2, amount1, balance1);
		Transaction transaction = new Transaction(pName, turnNo1, type, cName, unitPrice1, quantity1, amount1);
		brokerService.createBankAccount(bank);
		brokerService.createTransaction(transaction);
		

		return "SUCCESS";

	}
	
	public void createAiTransaction( String pName, String cName, int turnNo, String type, double unitPrice,
			int quantity, double amount, double balance) {
		 String type2="";
		//int turnNo1 = Integer.parseInt(turnNo);
		//double unitPrice1 = Double.parseDouble(unitPrice);
		//int quantity1 = Integer.parseInt(quantity);
		//double amount1 = Double.parseDouble(amount);
		//double balance1 = Double.parseDouble(balance);
		////Company c = new Company();
		//c = companyService.getCompanyDetails(cName);
		
		switch (type) {
		case "BUY":
			type2="Withdraw";
			break;
		case "SELL":
			type2="Deposit";
			break;
			
		}
		
		Bank bank = new Bank(pName, turnNo, type2, amount, balance);
		
		if(bank==null) {
			System.out.println("bank is null=");
		}else {
			System.out.println("bank is not null=");
		}
		//Transaction transaction = new Transaction(pName, turnNo1, type, cName, unitPrice1, quantity1, amount1);
		//brokerService.createBankAccount(bank);
		//brokerService.createTransaction(transaction);
		
	}

}
