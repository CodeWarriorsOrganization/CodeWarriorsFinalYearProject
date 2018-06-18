package com.codewarriors.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.codewarriors.models.Company;
import com.codewarriors.models.Market;
import com.codewarriors.models.Turn;

public class Analyst {

	public void getStockData(Market market) {
		Company comp;
		Turn turn;
		double price;
		double currentprice;

		//List<Company> getcompanies = new ArrayList<Company>();
		//List<Turn> getturns = new ArrayList<Turn>();
		//List<Double> pricelist = new ArrayList<>();
		//List<String> BuyList = new ArrayList<>();
		//List<String> SellList = new ArrayList<>();
		//List<String> Predictions = new ArrayList<>();

		
		//Company turns = new Company();

		//getcompanies = market.getCompanies();
		//getturns = turns.getTurns();
		//System.out.println("getttttttttttttttttttttttttttttttttttttt"+market.getCompanies().size());
		int turnSize=market.getNoTurns();
		int companySize=market.getCompanies().size();
		for(int i=0; i<turnSize;i++) {
			
			for(int x=0;x<companySize;x++) {
				
			}
		}
		
		///////////// start pamo part
		/*

		for (int t = 0; t <= getturns.size(); t++) {
			for (int c = 0; c <= getcompanies.size(); c++) {
				comp = getcompanies.get(c);
				turn = getturns.get(t);
				currentprice = turn.getPrice();

				int size = getturns.size();
				int sizelimit = 0;
				if (t <= 21) {
					sizelimit = t + 9;
				} else {
					sizelimit = size;
				}
				for (int currentturn = t; currentturn <= sizelimit; currentturn++) {
					turn = getturns.get(currentturn);
					price = turn.getPrice();
					pricelist.add(price);
				}

				// sorting the array in descending order
				Collections.sort(pricelist, Collections.reverseOrder());
				for (int sp = 0; sp <= pricelist.size(); sp++) {
					double price1 = pricelist.get(sp);

					if ((currentprice * (1 + 110 / 100)) <= (price1)) {

						double priceprecent = price1 - currentprice;

						String buy = comp + String.valueOf(t) + String.valueOf(priceprecent);
						BuyList.add(buy);
					} else {
						double priceprecent = price1 - currentprice;
						String sell = comp + String.valueOf(t) + String.valueOf(priceprecent);
						SellList.add(sell);
					}

				}

				for (int predition = 0; predition < 6; predition++) {
					int spredition = 0;
					// Buy Predictions
					if (predition < 3) {

						Predictions.add(BuyList.get(predition));
					}
					else {
						// Sell Predictions
						Predictions.add(SellList.get(spredition));
						spredition++;
					}

				}

			}
		} */

		
	}

}
