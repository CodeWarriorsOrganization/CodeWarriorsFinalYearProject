package com.codewarriors.services;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.codewarriors.components.GeneralTrendMarketComponent;
import com.codewarriors.components.RandomMarketComponent;
import com.codewarriors.components.SectorTrendMarketComponent;
import com.codewarriors.entities.Analyst;
import com.codewarriors.models.Company;
import com.codewarriors.models.Market;
import com.codewarriors.models.Turn;


public class StockMarketPriceGeneratorService {

	Random random = new Random();	
	int companysStockIncresingPresentages[][]=new int[12][30];	
	int companyRandomStarterPrice[]=new int[30];
	double finalCompanyStockPrice[][]=new double[12][30];
	
	List<String> companyNames = Arrays.asList("JK Computer Services","IFS","MillenniumIT","Cinnamon Air","EAP Holdings","ExpoRail","Nestle Lanka","Bank of Ceylon","Brandix Lanka Limited","Tokyo Cement","DFCC Bank","HNB Bank");
	List<String> sectorNames  = Arrays.asList("Technology","Consumer services","Manufacturing","Financials");
	List<Company> companies= new ArrayList<Company>();
	Market market=new Market();
	
	
	int stockStarterPriceLow=10;
	int stockStarterPriceHigh=30;	
	
	public Market generate() {			
		companysStockIncresingPresentages=computeTrendCoponent(getRandomMarketComponent(),getSectorTrendMarketComponent(),getGeneralTrendMarketComponent(),getEventComponent());
			
		//This is use for all companies's random stock starter price
		for(int i=0;i<12;i++) {
			companyRandomStarterPrice[i]=random.nextInt(stockStarterPriceHigh-stockStarterPriceLow) + stockStarterPriceLow;
			System.out.println("");
			System.out.println("+++"+companyRandomStarterPrice[i]+"   ");
		}
		
		for(int i=0; i<12; i++) {			
			for(int j=0;j<30;j++) {
				
				
				if(j==0) {
					finalCompanyStockPrice[i][j]=finalStockPriceCalculator(companyRandomStarterPrice[i],companysStockIncresingPresentages[i][j]);
					
				}else {
					finalCompanyStockPrice[i][j]=finalStockPriceCalculator(finalCompanyStockPrice[i][j-1],companysStockIncresingPresentages[i][j]);
					
				}				
			}
			
		}
		
		
		
		market.setNoTurns(30);// game time is 0s
		market.setTurnTime(10000);// companies stock price will change after 6s
		
		
		
		
		
		// this is use for calculate all companies final stock price in every turn and add to object
		for(int j=0;j<12;j++) {			
			Company company=new Company();
			List<Turn> turnList= new ArrayList<Turn>();
			
			company.setCompanyName(companyNames.get(j));
			if(j<3) {
				company.setSectorName(sectorNames.get(0));
			}else if(3<=j && j<6) {
				company.setSectorName(sectorNames.get(1));
			}else if(6<=j && j<9) {
				company.setSectorName(sectorNames.get(2));
			}else if(6<=j && j<12) {
				company.setSectorName(sectorNames.get(3));
			}
			
			
		
			
			for(int i=0;i<30;i++) {
				Turn turn=new Turn();
				turn.setTurnId(i);
				turn.setPrice(finalCompanyStockPrice[j][i]);
				turnList.add(turn);			
				
			}
			company.setTurns(turnList);			
			companies.add(company);	
		}
		market.setCompanies(companies);
		Analyst analyst=new Analyst();
		
	market.setAnalysisMessage(analyst.getRecommendations(market));
//		analyst.getStockData(market);
//		AiPlayer.startPlayer(market);
	
	AiPlayerService aiPlayerService = new AiPlayerService(market, "AIplayer1");
	aiPlayerService.play(0);
		
		return market;
	}
	
	private double finalStockPriceCalculator(double stockPrice,double presentage) {		
		DecimalFormat df = new DecimalFormat("#.##");
		double anser=Double.parseDouble(df.format(stockPrice*((presentage+100)/100)));
		return anser;
	}
	
	private int[][] getRandomMarketComponent() {
		int randomMarketComponent[][] = new int[30][12];
		randomMarketComponent= RandomMarketComponent.generateRandomMarketStockRandomValue();		
		System.out.println("genarate randomMarketComponent=  ");
		for(int i=0;i<30;i++) {			
			for(int j=0; j<12;j++) {				
				System.out.print(randomMarketComponent[i][j]+"  ");				
			}	
			System.out.println("");
		}		
		return randomMarketComponent;
	}
	
	private int[][] getSectorTrendMarketComponent() {
		int sectorTrendMarketComponent[][] = new int[30][12];
		sectorTrendMarketComponent=SectorTrendMarketComponent.sectorTrendMarketStockRandomValue();		
		System.out.println("");
		System.out.println("genarate sectorTrendMarketComponent=  ");
		for(int i=0;i<30;i++) {			
			for(int j=0; j<12;j++) {				
				System.out.print(sectorTrendMarketComponent[i][j]+"  ");
				
			}	
			System.out.println("");
		}		
		return sectorTrendMarketComponent;
	}
	
	private int[][] getGeneralTrendMarketComponent() {
		int generalTrendMarketComponent[][] = new int[30][12];
		generalTrendMarketComponent=GeneralTrendMarketComponent.generateGeneralTrendMarketStockRandomValue();		
		System.out.println("");
		System.out.println("genarate generalTrendMarketComponent=  ");
		for(int i=0;i<30;i++) {			
			for(int j=0; j<12;j++) {
				System.out.print(generalTrendMarketComponent[i][j]+"  ");				
			}		
			System.out.println("");
		}		
		return generalTrendMarketComponent;
	}
	
	private int[][] getEventComponent() {
		int eventComponent[][] = new int[30][12];
		int eventLow=-3;
		int eventHigh=3;
		System.out.println("");
		System.out.println("genarate eventComponent=  ");
		for(int i=0;i<30;i++) {			
			for(int j=0; j<12;j++) {
				eventComponent[i][j]=random.nextInt(eventHigh-eventLow) + eventLow;
				System.out.print(eventComponent[i][j]+"  ");
				
			}	
			System.out.println("");
		}		
		return eventComponent;
	}
	
	private int[][] computeTrendCoponent(int [][] CSP,int [][] STC,int [][] GTMC,int [][] EC){
		
		int tempCompanysStockIncresingPresentages[][]=new int[30][12];
		int tempTransformedCompanysStockIncresingPresentages[][]=new int[12][30];
		System.out.print(" computeTrendCoponent= ");
		for(int i=0;i<30;i++) {
			for(int j=0;j<12;j++) {	
				int calulatedPresentage= CSP[i][j]+STC[i][j]+GTMC[i][j]+EC[i][j];
				if(calulatedPresentage>=0) {
					tempCompanysStockIncresingPresentages[i][j]=calulatedPresentage;
				}else {
					tempCompanysStockIncresingPresentages[i][j]=0;
				}
				
				System.out.print(tempCompanysStockIncresingPresentages[i][j]+"  ");				
			}
			System.out.println("");
		}
		
		for(int i=0;i<30;i++) {			
			for(int j=0;j<12;j++) {
				tempTransformedCompanysStockIncresingPresentages[j][i]=tempCompanysStockIncresingPresentages[i][j];
			}			
		}
		
		System.out.println("all companies stock Presentages befor transformed=");
		System.out.println("");
		for(int i=0;i<30;i++) {			
			for(int j=0;j<12;j++) {
				//transformedFinalCompanyStockPrice[j][i]=
				System.out.print(tempCompanysStockIncresingPresentages[i][j]+"  ");
			}
			System.out.println("");
		}
		
		System.out.println("all companies stock Presentages after transformed=");
		System.out.println("");
		for(int i=0;i<12;i++) {			
			for(int j=0;j<30;j++) {
				//transformedFinalCompanyStockPrice[j][i]=
				System.out.print(tempTransformedCompanysStockIncresingPresentages[i][j]+"  ");
			}
			System.out.println("");
		}
		
		return tempTransformedCompanysStockIncresingPresentages;
	}
	
	
}
