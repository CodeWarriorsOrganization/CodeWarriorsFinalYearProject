package com.codewarriors.entities;

import java.util.ArrayList;
import java.util.List;

import com.codewarriors.models.AnalysisMessage;
import com.codewarriors.models.Company;
import com.codewarriors.models.Market;
import com.codewarriors.models.Message;
import com.codewarriors.models.TurnMessage;

public class Analyst {
	/*
	 * This is the implemented class for Analyst who make predictions for both AI
	 * and Human
	 */

	public AnalysisMessage getRecommendations(Market market) {
		/*
		 * In here there there are two types of prediction 1.) BUY predictions 2.) SELL
		 * predictions this method returns list which contains all BUY and Sell messages
		 * for all companies*turns
		 */

		// declarations for instances, Collections and variables -begin
		AnalysisMessage analysisMessage = new AnalysisMessage();
		Company company;
		List<TurnMessage> turnMesages = new ArrayList<TurnMessage>();
		List<Company> companies = new ArrayList<Company>();
		companies = market.getCompanies();
		int turnSize = market.getNoTurns();
		int companySize = market.getCompanies().size();
		// declarations for instances, Collections and variables -end

		// test print for company values
		System.out.println("company price=");
		for (int t = 0; t < turnSize; t++) {
			for (int c = 0; c < companySize; c++) {
				System.out.print(companies.get(c).getTurns().get(t).getPrice() + "  ");
			}
			System.out.println("");
		}

		// loop iterate no of turns
		for (int t = 0; t < turnSize; t++) {

			List<Company> sellCompanies = new ArrayList<Company>();
			List<Company> buyCompanies = new ArrayList<Company>();
			List<Message> buyMessage = new ArrayList<Message>();
			List<Message> sellMessage = new ArrayList<Message>();
			TurnMessage turnMessage = new TurnMessage();

			for (int c = 0; c < companySize; c++) {

				company = companies.get(c);
				int sizelimit = 0;

				if (t < 21) {
					sizelimit = t + 9;
				} else {
					sizelimit = turnSize - 1;
				}
				// depend variables
				double currentTurnValue = company.getTurns().get(t).getPrice();
				double estimatedValue = currentTurnValue * 110 / 100;
				double turnsEndValue = company.getTurns().get(sizelimit).getPrice();

				if ((estimatedValue < turnsEndValue)) {
					// condition checks for BUY stock and assign them into buyMessage
					Message message = new Message();

					company.setPrediction("BUY");
					message.setCompany(company);
					message.setMessage(" Best Stocks for Buy :" + company.getCompanyName());
					buyMessage.add(message);

				} else if (estimatedValue > turnsEndValue) {
					// condition checks for SELL stock and assign them into buyMessage
					Message message = new Message();

					company.setPrediction("SELL");
					message.setCompany(company);
					message.setMessage(" Best Stocks for Sell :" + company.getCompanyName());
					sellMessage.add(message);
				}

				turnMessage.setSellMessages(sellMessage);
				turnMessage.setBuyMessages(buyMessage);

			}

			turnMesages.add(turnMessage);
			// ============================================TEST PRINTS BEGIN=============

			System.out.println();
			System.out.println("turn=    " + t + "======================");

			// ======================================================================= SELL
			for (int a = 0; a < 12; a++) {
				System.out.print(companies.get(a).getPrediction() + "    ");
			}

			System.out.println("    ");

			System.out.println("Current Turn :::::::::::::::::::" + t);
			for (int i = 0; i < sellCompanies.size(); i++) {

				System.out.println("company name : " + sellCompanies.get(i).getCompanyName() + " Prediction : "
						+ sellCompanies.get(i).getPrediction());
			}

			// ======================================================================= BUY
			for (int a = 0; a < 12; a++) {
				System.out.print(companies.get(a).getPrediction() + "    ");
			}

			System.out.println("    ");

			System.out.println("Current Turn :::::::::::::::::::" + t);
			for (int i = 0; i < buyCompanies.size(); i++) {

				System.out.println("company name : " + buyCompanies.get(i).getCompanyName() + " Prediction : "
						+ buyCompanies.get(i).getPrediction());
			}

		}
		analysisMessage.setTurnMessage(turnMesages);

		for (int i = 0; i < analysisMessage.getTurnMessage().size(); i++) {

			System.out.println("TURN :" + i);
			System.out.println("BUY COMAPNIES PRINTING HERE : ");

			for (int j = 0; j < analysisMessage.getTurnMessage().get(i).getBuyMessages().size(); j++) {
				System.out
						.println(" BUY COMPANY : "
								+ analysisMessage.getTurnMessage().get(i).getBuyMessages().get(j).getCompany()
										.getCompanyName()
								+ " BUY MESSAGE : "
								+ analysisMessage.getTurnMessage().get(i).getBuyMessages().get(j).getMessage());
			}

			System.out.println("\nSELL COMAPNIES PRINTING HERE : ");
			for (int j = 0; j < analysisMessage.getTurnMessage().get(i).getSellMessages().size(); j++) {
				System.out
						.println(" SELL COMPANY : "
								+ analysisMessage.getTurnMessage().get(i).getSellMessages().get(j).getCompany()
										.getCompanyName()
								+ " SELL MESSAGE : "
								+ analysisMessage.getTurnMessage().get(i).getSellMessages().get(j).getMessage());
			}

		}
		// ==========================================================TEST PRINTS
		// BEGIN====================================================
		// returns wrapped list with all predicted BYU's and SELL's
		return analysisMessage;

	}

}
