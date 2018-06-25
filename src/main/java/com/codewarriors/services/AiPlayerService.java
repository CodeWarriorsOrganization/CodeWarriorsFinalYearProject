package com.codewarriors.services;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.codewarriors.controllers.BrokerController;
import com.codewarriors.db.BrokerService;
import com.codewarriors.db.PlayerService;
import com.codewarriors.entities.Bank;
import com.codewarriors.entities.Player;
import com.codewarriors.models.AiTransactions;
import com.codewarriors.models.AnalysisMessage;
import com.codewarriors.models.Company;
import com.codewarriors.models.Market;
import com.codewarriors.models.Message;
import com.codewarriors.models.TurnMessage;

public class AiPlayerService {
	/*
	 * This is the logical implementation of AI Player In here facilitate to BUY and
	 * SELL shares this logical part interconnects with the h2 database
	 * 
	 */

	private List<Company> companies;
	private static AnalysisMessage analysisMessage;
	private double bankbalance = 1000.00;
	static Random random = new Random();
	static DecimalFormat df = new DecimalFormat("###");
	private static String AiplayerName;
	private List<Company> marketCompanies = new ArrayList<Company>();
	private List<TurnMessage> marketMessages = new ArrayList<TurnMessage>();	
	
	
	@Autowired
	private BrokerService brokerService;
	public AiPlayerService(Market market, String aiPlayerName) {
		marketCompanies = market.getCompanies();
		marketMessages = market.getAnalysisMessage().getTurnMessage();
		AiplayerName = aiPlayerName;
	}

	public AiTransactions play(int turn) {
		
		/*
		 * calculate buying/selling companies and its quantities
		 */
		List<Company> buyingCompanies = new ArrayList<Company>();
		List<Message> predictSellMessages = new ArrayList<Message>();
		List<Message> predictBuyMessages = new ArrayList<Message>();
	    List<Company> buyingFinalizedCompanies = new ArrayList<Company>();
		List<Company> sellingFinalizedCompanies = new ArrayList<Company>();

		predictSellMessages = marketMessages.get(turn).getSellMessages();
		predictBuyMessages = marketMessages.get(turn).getBuyMessages();

		// ===================================================================================Buying==============================
		// Stocks Selection
		int buyCompanyCount = predictBuyMessages.size();
		if (buyCompanyCount >= 5) {

			Collections.shuffle(predictBuyMessages);

			for (int i = 0; i < 5; i++) {

				buyingCompanies.add(predictBuyMessages.get(i).getCompany());// selected for buying but not purchased

			}
		} else if (buyCompanyCount < 5 && buyCompanyCount > 0) {

			int dff = 5 - buyCompanyCount;

			for (int i = 0; i < buyCompanyCount; i++) {

				buyingCompanies.add(predictBuyMessages.get(i).getCompany());
			}
			for (int i = 0; i < dff; i++) {
				// selecting stocks from selling because of we need to fill up to 5
				buyingCompanies.add(predictSellMessages.get(i).getCompany());

			}

		} else {
			int decision = random.ints(1, 3).findAny().getAsInt();
			switch (decision) {
			case 1:
				Collections.shuffle(predictSellMessages);
				for (int i = 0; i < 5; i++) {

					buyingCompanies.add(predictSellMessages.get(i).getCompany());
				}
				break;
			case 2:
				System.out.println("This time I'am not going to buy ;)");

			}
		}
		System.out.println(
				"::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

		// ==========test print
		System.out.println();
		System.out.println(
				"============================  AI  PART BEGIN   =========================================================================");
		for (int i = 0; i < predictBuyMessages.size(); i++) {
			System.out.println(" PRDICT BUY COMPANY NAME : " + predictBuyMessages.get(i).getCompany().getCompanyName());

		}

		// ==========predictSellMessages print
		System.out.println();
		for (int i = 0; i < predictSellMessages.size(); i++) {
			System.out
					.println(" PRDICT SELL COMPANY NAME : " + predictSellMessages.get(i).getCompany().getCompanyName());

		}

		// =========buyingCompanies=====
		System.out.println();
		for (int i = 0; i < buyingCompanies.size(); i++) {
			System.out.println(" BUYING COMPANY NAME : " + buyingCompanies.get(i).getCompanyName());

		}

		// =======================Stocks selecting for the purchase
		int randomBuySelectionCount = random.ints(1, 6).findAny().getAsInt();
		if (!buyingCompanies.isEmpty()) {

			Collections.shuffle(buyingCompanies);
			for (int i = 0; i < randomBuySelectionCount; i++) {

				buyingFinalizedCompanies.add(buyingCompanies.get(i));
			}
		}
		// ========================buyingFinalizedCompanies=====
		System.out.println();
		for (int i = 0; i < buyingFinalizedCompanies.size(); i++) {

			System.out.println(" BUYING FINALIZED COMPANY NAME : " + buyingFinalizedCompanies.get(i).getCompanyName());

		}
		// ==================================print company details

		System.out.println(
				"\n\n=======================================OBJECT PRICE TESTING=============================");
		for (int i = 0; i < buyingFinalizedCompanies.size(); i++) {

			System.out.println(" BUYING FINALIZED COMPANY NAME : " + buyingFinalizedCompanies.get(i).getCompanyName()
					+ "PRICE :" + buyingFinalizedCompanies.get(i).getTurns().get(turn).getPrice());
		}

		for (int i = 0; i < predictSellMessages.size(); i++) {			
			sellingFinalizedCompanies.add(predictSellMessages.get(i).getCompany());
		}
		
		AiTransactions aiTransactions = new AiTransactions();
		aiTransactions.setBuyCompanies(buyingFinalizedCompanies);
		System.out.println("========Ai Class print pasing buying quntity=============================");
		for (int i = 0; i < aiTransactions.getBuyCompanies().size(); i++) {
			
			System.out.println("Company Name= "+aiTransactions.getBuyCompanies().get(i).getCompanyName());
			
		}
		aiTransactions.setSellCompanies(sellingFinalizedCompanies);
		
		System.out.println("========Ai Class print pasing Selling quntity=============================");
		for (int i = 0; i < aiTransactions.getSellCompanies().size(); i++) {
			
			System.out.println("Company Name= "+aiTransactions.getSellCompanies().get(i).getCompanyName());
			
		}
		
		
		
		

		return aiTransactions;
		// ==============================================Select Selling
		// companies==========

	}

}
