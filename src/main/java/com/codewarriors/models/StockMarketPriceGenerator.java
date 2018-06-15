package com.codewarriors.models;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ch.qos.logback.core.net.SyslogOutputStream;

public class StockMarketPriceGenerator {
	Random random = new Random();	
	int companysStockIncresingPresentages[][]=new int[12][30];	
	int companyRandomStarterPrice[]=new int[30];
	double finalCompanyStockPrice[][]=new double[12][30];
	
	
	List<Company> companies= new ArrayList<Company>();
	Market market=new Market();
	
	
	int stockStarterPriceLow=2;
	int stockStarterPriceHigh=10;	
	
	public Market generate() {			
		companysStockIncresingPresentages=computeTrendCoponent(getRandomMarketComponent(),getSectorTrendMarketComponent(),getGeneralTrendMarketComponent(),getEventComponent());
			
		//This is use for all companies's random stock starter price
		for(int i=0;i<30;i++) {
			companyRandomStarterPrice[i]=random.nextInt(stockStarterPriceHigh-stockStarterPriceLow) + stockStarterPriceLow;
			System.out.println("");
			System.out.println("+++"+companyRandomStarterPrice[i]+"   ");
		}
		
		for(int i=0; i<12; i++) {			
			for(int j=0;j<30;j++) {
				int tmp= j;
				
				if(j==0) {
					finalCompanyStockPrice[i][j]=finalStockPriceCalculator(companyRandomStarterPrice[j],companysStockIncresingPresentages[i][j]);
					
				}else {
					finalCompanyStockPrice[i][j]=finalStockPriceCalculator(finalCompanyStockPrice[i][tmp-1],companysStockIncresingPresentages[i][j]);
					
				}				
			}
			
		}
		
		
		
		market.setNoTurns(30);// game time is 0s
		market.setTurnTime(1000);// companies stock price will change after 6s
		
		
		
		
		
		// this is use for calculate all companies final stock price in every turn and add to object
		for(int j=0;j<12;j++) {			
			Company company=new Company();
			List<Turn> turnList= new ArrayList<Turn>();
			
			company.setCompanyName("company="+j);
			company.setSectorName("sector="+j);
		
			
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
		return market;
	}
	
	private double finalStockPriceCalculator(double stockPrice,double presentage) {		
		DecimalFormat df = new DecimalFormat("#.##");
		double anser=Double.parseDouble(df.format(stockPrice*((presentage+100)/100)));
		return anser;
	}
	
	private int[][] getRandomMarketComponent() {
		int randomMarketComponent[][] = new int[30][12];
		int randomMarketLow=-2;
		int randomMarketHigh=2;
		System.out.println("genarate randomMarketComponent=  ");
		for(int i=0;i<30;i++) {			
			for(int j=0; j<12;j++) {
				randomMarketComponent[i][j]=random.nextInt(randomMarketHigh-randomMarketLow) + randomMarketLow;
				System.out.print(randomMarketComponent[i][j]+"  ");
				
			}	
			System.out.println("");
		}		
		return randomMarketComponent;
	}
	
	private int[][] getSectorTrendMarketComponent() {
		int sectorTrendMarketComponent[][] = new int[30][12];
		int sectorTrendMarketLow=-3;
		int sectorTrendMarketHigh=3;
		System.out.println("");
		System.out.println("genarate sectorTrendMarketComponent=  ");
		for(int i=0;i<30;i++) {			
			for(int j=0; j<12;j++) {
				sectorTrendMarketComponent[i][j]=random.nextInt(sectorTrendMarketHigh-sectorTrendMarketLow) + sectorTrendMarketLow;
				System.out.print(sectorTrendMarketComponent[i][j]+"  ");
				
			}	
			System.out.println("");
		}		
		return sectorTrendMarketComponent;
	}
	
	private int[][] getGeneralTrendMarketComponent() {
		int generalTrendMarketComponent[][] = new int[30][12];
		int generalTrendTrendMarketLow=-3;
		int generalTrendTrendMarketHigh=3;
		System.out.println("");
		System.out.println("genarate generalTrendMarketComponent=  ");
		for(int i=0;i<30;i++) {			
			for(int j=0; j<12;j++) {
				generalTrendMarketComponent[i][j]=random.nextInt(generalTrendTrendMarketHigh-generalTrendTrendMarketLow) + generalTrendTrendMarketLow;
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
